
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/dmitriy/Documents/Tests/playFramework-tests/new/PhoneBook/conf/routes
// @DATE:Fri Oct 02 00:06:22 IRKT 2015

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  Application_1: controllers.Application,
  // @LINE:15
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    Application_1: controllers.Application,
    // @LINE:15
    Assets_0: controllers.Assets
  ) = this(errorHandler, Application_1, Assets_0, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Application_1, Assets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.Application.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """records/""", """controllers.Application.records()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """records/""", """controllers.Application.newrecord()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """records/$id<[^/]+>/delete""", """controllers.Application.deleterecord(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_Application_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Application_index0_invoker = createInvoker(
    Application_1.index(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "index",
      Nil,
      "GET",
      """ Home page""",
      this.prefix + """"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_Application_records1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("records/")))
  )
  private[this] lazy val controllers_Application_records1_invoker = createInvoker(
    Application_1.records(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "records",
      Nil,
      "GET",
      """Tasks""",
      this.prefix + """records/"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_Application_newrecord2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("records/")))
  )
  private[this] lazy val controllers_Application_newrecord2_invoker = createInvoker(
    Application_1.newrecord(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "newrecord",
      Nil,
      "POST",
      """""",
      this.prefix + """records/"""
    )
  )

  // @LINE:11
  private[this] lazy val controllers_Application_deleterecord3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("records/"), DynamicPart("id", """[^/]+""",true), StaticPart("/delete")))
  )
  private[this] lazy val controllers_Application_deleterecord3_invoker = createInvoker(
    Application_1.deleterecord(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "deleterecord",
      Seq(classOf[Long]),
      "POST",
      """""",
      this.prefix + """records/$id<[^/]+>/delete"""
    )
  )

  // @LINE:15
  private[this] lazy val controllers_Assets_at4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at4_invoker = createInvoker(
    Assets_0.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/$file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_Application_index0_route(params) =>
      call { 
        controllers_Application_index0_invoker.call(Application_1.index())
      }
  
    // @LINE:9
    case controllers_Application_records1_route(params) =>
      call { 
        controllers_Application_records1_invoker.call(Application_1.records())
      }
  
    // @LINE:10
    case controllers_Application_newrecord2_route(params) =>
      call { 
        controllers_Application_newrecord2_invoker.call(Application_1.newrecord())
      }
  
    // @LINE:11
    case controllers_Application_deleterecord3_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Application_deleterecord3_invoker.call(Application_1.deleterecord(id))
      }
  
    // @LINE:15
    case controllers_Assets_at4_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at4_invoker.call(Assets_0.at(path, file))
      }
  }
}