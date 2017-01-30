/**
 * MyAnnotation.java
 * 
 * <br>
 * Esempio di Annotation customizzata.
 * 
 */
package it.clever.course.j2se.annotations;

/**
 * @author 2Clever
 *
 */
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
/**
* Una semplice annotation, usata per segnare gli elementi
* (classe, attributo, metodo), l'�autore di quell'elemento e
* l'�azienda.
*/

@Retention(RUNTIME)
public @interface MyAnnotation {
  public String value();
  public String author();
  public String company() default"2Clever.it";
} 
