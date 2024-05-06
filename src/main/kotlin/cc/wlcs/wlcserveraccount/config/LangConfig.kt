package cc.wlcs.wlcserveraccount.config

import space.arim.dazzleconf.annote.ConfDefault.DefaultString
import space.arim.dazzleconf.annote.ConfKey
import space.arim.dazzleconf.sorter.AnnotationBasedSorter.Order

interface LangConfig {

    @ConfKey("prefix")
    @DefaultString("<#42E2B8>未来城 <#2D82B7>> <#F3DFBF>")
    @Order(10)
    fun prefix(): String

    @ConfKey("text.first-join-tip")
    @DefaultString("欢迎来到未来城, 这是您第一次进入服务器, 已为您自动创建账号, 您的WAOID为 %id%, 使用 /account 查看账号信息")
    @Order(20)
    fun firstJoinTip(): String

    @ConfKey("command.help")
    @DefaultString("")
    @Order(30)
    fun helpCommand(): String

    @ConfKey("command.info")
    @DefaultString(
        "WID: %wid%\n" +
                "用户名: %name%\n" +
                "UUID: %uuid%\n" +
                "性别: %gender%\n" +
                "QQ: %qq%\n" +
                "邮箱: %email%\n" +
                "手机号: %phone%\n" +
                "生日: %birthday%\n" +
                "注册时间: %register_time%"
    )
    @Order(40)
    fun infoCommand(): String

    @ConfKey("gui.title")
    @DefaultString("<#42E2B8>👤 未来城账号系统 👤")
    fun guiTitle(): String

    @ConfKey("gui.wid")
    @DefaultString("<#42E2B8>WID <#2D82B7>> <#F3DFBF>%wid%")
    @Order(50)
    fun guiWidItemName(): String

    @ConfKey("gui.name")
    @DefaultString("<#42E2B8>用户名 <#2D82B7>> <#F3DFBF>%name%")
    @Order(60)
    fun guiNameItemName(): String

    @ConfKey("gui.uuid")
    @DefaultString("<#42E2B8>UUID <#2D82B7>> <#F3DFBF>%uuid%")
    @Order(70)
    fun guiUuidItemName(): String

    @ConfKey("gui.gender")
    @DefaultString("<#42E2B8>性别 <#2D82B7>> <#F3DFBF>%gender%")
    @Order(80)
    fun guiGenderItemName(): String

    @ConfKey("gui.qq")
    @DefaultString("<#42E2B8>QQ <#2D82B7>> <#F3DFBF>%qq%")
    @Order(90)
    fun guiQQItemName(): String

    @ConfKey("gui.email")
    @DefaultString("<#42E2B8>邮箱 <#2D82B7>> <#F3DFBF>%email%")
    @Order(100)
    fun guiEmailItemName(): String

    @ConfKey("gui.phone")
    @DefaultString("<#42E2B8>手机号 <#2D82B7>> <#F3DFBF>%phone%")
    @Order(110)
    fun guiPhoneItemName(): String

    @ConfKey("gui.birthday")
    @DefaultString("<#42E2B8>生日 <#2D82B7>> <#F3DFBF>%birthday%")
    @Order(120)
    fun guiBirthdayItemName(): String

    @ConfKey("gui.register_time")
    @DefaultString("<#42E2B8>注册时间 <#2D82B7>> <#F3DFBF>%register_time%")
    @Order(130)
    fun guiRegisterTimeItemName(): String

}