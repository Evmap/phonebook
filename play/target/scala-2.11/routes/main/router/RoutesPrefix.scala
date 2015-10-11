
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/dmitriy/Documents/Tests/playFramework-tests/new/PhoneBook/conf/routes
// @DATE:Fri Oct 02 00:06:22 IRKT 2015


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
