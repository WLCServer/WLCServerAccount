package cc.wlcs.wlcserveraccount.manager

import space.arim.dazzleconf.ConfigurationOptions
import space.arim.dazzleconf.error.ConfigFormatSyntaxException
import space.arim.dazzleconf.error.InvalidConfigException
import space.arim.dazzleconf.ext.snakeyaml.CommentMode
import space.arim.dazzleconf.ext.snakeyaml.SnakeYamlConfigurationFactory
import space.arim.dazzleconf.ext.snakeyaml.SnakeYamlOptions
import space.arim.dazzleconf.helper.ConfigurationHelper
import java.io.IOException
import java.io.UncheckedIOException
import java.nio.file.Path
import kotlin.concurrent.Volatile


class ConfigManager<C> private constructor(private val configHelper: ConfigurationHelper<C>) {
    @Volatile
    private var configData: C? = null

    fun reloadConfig() {
        try {
            configData = configHelper.reloadConfigData()
        } catch (ex: IOException) {
            throw UncheckedIOException(ex)
        } catch (ex: ConfigFormatSyntaxException) {
            configData = configHelper.factory.loadDefaults()
            System.err.println(
                "The yaml syntax in your configuration is invalid. "
                        + "Check your YAML syntax with a tool such as https://yaml-online-parser.appspot.com/"
            )
            ex.printStackTrace()
        } catch (ex: InvalidConfigException) {
            configData = configHelper.factory.loadDefaults()
            System.err.println(
                ("One of the values in your configuration is not valid. "
                        + "Check to make sure you have specified the right data types.")
            )
            ex.printStackTrace()
        }
    }

    fun getConfigData(): C {
        val configData = this.configData
            ?: throw IllegalStateException("Configuration has not been loaded yet")
        return configData
    }

    companion object {
        fun <C> create(
            configFolder: Path?,
            fileName: String?,
            configClass: Class<C>?
        ): ConfigManager<C> {
            // SnakeYaml example
            val yamlOptions = SnakeYamlOptions.Builder()
                .commentMode(CommentMode.alternativeWriter()) // Enables writing YAML comments
                .build()
            val configFactory = SnakeYamlConfigurationFactory.create(
                configClass,
                ConfigurationOptions.defaults(),  // change this if desired
                yamlOptions
            )
            return ConfigManager(ConfigurationHelper(configFolder, fileName, configFactory))
        }
    }
}