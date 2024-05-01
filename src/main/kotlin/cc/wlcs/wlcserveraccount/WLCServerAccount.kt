package cc.wlcs.wlcserveraccount

import cc.wlcs.wlcserveraccount.config.MainConfig
import cc.wlcs.wlcserveraccount.listener.PlayerListener
import cc.wlcs.wlcserveraccount.manager.ConfigManager
import com.google.inject.Inject
import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent
import com.velocitypowered.api.plugin.Plugin
import com.velocitypowered.api.plugin.annotation.DataDirectory
import com.velocitypowered.api.proxy.ProxyServer
import org.ktorm.database.Database
import org.ktorm.logging.ConsoleLogger
import org.ktorm.logging.LogLevel
import org.slf4j.Logger
import java.nio.file.Path

@Plugin(
    id = "wlcserveraccount",
    name = "WLCServerAccount",
    version = "1.0-SNAPSHOT",
    url = "https://wlcs.cc/",
    authors = ["DongShaoNB"]
)
class WLCServerAccount {

    companion object {
        lateinit var instance: WLCServerAccount
    }

    lateinit var logger: Logger
    lateinit var proxyServer: ProxyServer
    lateinit var dataDirectory: Path
    lateinit var mainConfig: ConfigManager<MainConfig>
    private val dataSource = MysqlConnectionPoolDataSource()
    lateinit var database: Database

    @Inject
    fun WLCServerAccount(
        logger: Logger,
        proxyServer: ProxyServer,
        @DataDirectory dataDirectory: Path
    ) {
        this.logger = logger
        this.proxyServer = proxyServer
        this.dataDirectory = dataDirectory
    }

    @Subscribe
    fun onProxyInitialization(event: ProxyInitializeEvent) {
        instance = this
        mainConfig = ConfigManager.create(dataDirectory, "config.yml", MainConfig::class.java)
        mainConfig.reloadConfig()
        dataSource.setURL(mainConfig.getConfigData().MysqlUrl())
        dataSource.user = mainConfig.getConfigData().MysqlUser()
        dataSource.password = mainConfig.getConfigData().MysqlPassword()
        database = Database.connect(dataSource, logger = ConsoleLogger(threshold = LogLevel.WARN))
        proxyServer.eventManager.register(this, PlayerListener())
    }

}