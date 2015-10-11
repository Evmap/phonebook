
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object index_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[List[Record],Form[Record],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(records: List[Record], recordForm: Form[Record]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import helper._

Seq[Any](format.raw/*1.51*/("""

"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/main("Record list")/*5.21*/ {_display_(Seq[Any](format.raw/*5.23*/("""
"""),format.raw/*6.1*/("""<center><h2>Телефонная книга</h2>
<h2>"""),_display_(/*7.6*/records/*7.13*/.size()),format.raw/*7.20*/(""" """),format.raw/*7.21*/("""Запись(ей)</h2>

<ul>
    """),_display_(/*10.6*/for(record <- records) yield /*10.28*/ {_display_(Seq[Any](format.raw/*10.30*/("""
    """),format.raw/*11.5*/("""<li>
        """),_display_(/*12.10*/record/*12.16*/.name),format.raw/*12.21*/("""
        """),_display_(/*13.10*/record/*13.16*/.phone),format.raw/*13.22*/("""
        """),_display_(/*14.10*/record/*14.16*/.mobilephone),format.raw/*14.28*/("""

        """),_display_(/*16.10*/form(routes.Application.deleterecord(record.id))/*16.58*/ {_display_(Seq[Any](format.raw/*16.60*/("""
        """),format.raw/*17.9*/("""<input type="submit" value="Удалить">
        """)))}),format.raw/*18.10*/("""
    """),format.raw/*19.5*/("""</li>
    """)))}),format.raw/*20.6*/("""
"""),format.raw/*21.1*/("""</ul>

<h2>Добавить новую запись</h2>

  """),_display_(/*25.4*/form(routes.Application.newrecord())/*25.40*/ {_display_(Seq[Any](format.raw/*25.42*/("""
  """),format.raw/*26.3*/("""<b>ИМЯ</b>
  """),_display_(/*27.4*/inputText(recordForm("name"))),format.raw/*27.33*/("""
  """),format.raw/*28.3*/("""<b>Телефон</b>
  """),_display_(/*29.4*/inputText(recordForm("phone"))),format.raw/*29.34*/("""
  """),format.raw/*30.3*/("""<b>Моб.телефон</b>
  """),_display_(/*31.4*/inputText(recordForm("mobilephone"))),format.raw/*31.40*/("""
"""),format.raw/*32.1*/("""<input type="submit" value="Создать">

""")))}),format.raw/*34.2*/("""
    
""")))}),format.raw/*36.2*/("""
"""),format.raw/*37.1*/("""</center>
"""))
      }
    }
  }

  def render(records:List[Record],recordForm:Form[Record]): play.twirl.api.HtmlFormat.Appendable = apply(records,recordForm)

  def f:((List[Record],Form[Record]) => play.twirl.api.HtmlFormat.Appendable) = (records,recordForm) => apply(records,recordForm)

  def ref: this.type = this

}


}

/**/
object index extends index_Scope0.index
              /*
                  -- GENERATED --
                  DATE: Fri Oct 02 16:15:23 IRKT 2015
                  SOURCE: /Users/dmitriy/Documents/Tests/playFramework-tests/new/PhoneBook/app/views/index.scala.html
                  HASH: 609a07640b9f13ff9195babc949d1b7cf270e719
                  MATRIX: 764->1|923->50|951->69|978->71|1005->90|1044->92|1071->93|1135->132|1150->139|1177->146|1205->147|1258->174|1296->196|1336->198|1368->203|1409->217|1424->223|1450->228|1487->238|1502->244|1529->250|1566->260|1581->266|1614->278|1652->289|1709->337|1749->339|1785->348|1863->395|1895->400|1936->411|1964->412|2032->454|2077->490|2117->492|2147->495|2187->509|2237->538|2267->541|2311->559|2362->589|2392->592|2440->614|2497->650|2525->651|2595->691|2632->698|2660->699
                  LINES: 27->1|32->1|34->4|35->5|35->5|35->5|36->6|37->7|37->7|37->7|37->7|40->10|40->10|40->10|41->11|42->12|42->12|42->12|43->13|43->13|43->13|44->14|44->14|44->14|46->16|46->16|46->16|47->17|48->18|49->19|50->20|51->21|55->25|55->25|55->25|56->26|57->27|57->27|58->28|59->29|59->29|60->30|61->31|61->31|62->32|64->34|66->36|67->37
                  -- GENERATED --
              */
          