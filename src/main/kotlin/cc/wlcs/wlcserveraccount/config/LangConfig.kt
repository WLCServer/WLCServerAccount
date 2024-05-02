package cc.wlcs.wlcserveraccount.config

import space.arim.dazzleconf.annote.ConfDefault.DefaultString
import space.arim.dazzleconf.annote.ConfKey
import space.arim.dazzleconf.sorter.AnnotationBasedSorter.Order

interface LangConfig {

    @ConfKey("prefix")
    @DefaultString("<#42E2B8>未来城 <#2D82B7>> <#F3DFBF>")
    @Order(10)
    fun prefix(): String

    @ConfKey("first-join-tip")
    @DefaultString("欢迎来到未来城, 这是您第一次进入服务器, 已为您自动创建账号, 您的WAOID为 %id%, 使用 /account 查看账号信息")
    @Order(20)
    fun firstJoinTip(): String

}