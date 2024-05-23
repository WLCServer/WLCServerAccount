package cc.wlcs.wlcserveraccount.config

import space.arim.dazzleconf.annote.ConfDefault.DefaultString
import space.arim.dazzleconf.annote.ConfKey
import space.arim.dazzleconf.sorter.AnnotationBasedSorter.Order

interface MainConfig {

    @ConfKey("mysql.url")
    @DefaultString("jdbc:mysql://localhost:3306/wlcserveraccount")
    @Order(10)
    fun mysqlUrl(): String

    @ConfKey("mysql.user")
    @DefaultString("wlcserveraccount")
    @Order(20)
    fun mysqlUser(): String

    @ConfKey("mysql.password")
    @DefaultString("password")
    @Order(30)
    fun mysqlPassword(): String
}