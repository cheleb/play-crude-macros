package play.crude

import language.experimental.macros
import reflect.macros.Context
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.JsResult
import play.api.mvc.SimpleResult

trait Cruded[A] {
  def insert(a: A) : Long
}

object CrudeMacro {

  
  
  def insert[A](json: JsValue, v: JsValue => JsResult[A], cruded: Cruded[A], j: A => SimpleResult[JsValue]) = macro insert_impl[A]

  def insert_impl[A](c: Context)(json: c.Expr[JsValue], v: c.Expr[JsValue => JsResult[A]] , cruded: c.Expr[Cruded[A]], j: c.Expr[A => SimpleResult[JsValue]]) = {
    import c.universe._
    val str = json.tree
    reify { v.splice(json.splice).map {o => cruded.splice.insert( o ); j.splice(o)} }
  }
}