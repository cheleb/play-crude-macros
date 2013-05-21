package play.crude

import language.experimental.macros

import reflect.macros.Context

object CrudeMacro {

  def insert[A](o: A) = macro insert_impl[A]
  
  def insert_impl[A](c: Context)(o: c.Expr[A])  = {
   import c.universe._
    val str = o.tree
    reify { println( " zoz "+  o.splice) }
  }
}