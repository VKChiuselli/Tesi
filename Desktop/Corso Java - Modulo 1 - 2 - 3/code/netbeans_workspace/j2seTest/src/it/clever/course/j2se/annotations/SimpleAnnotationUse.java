package it.clever.course.j2se.annotations;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


//Qui la usiamo a livello di classe
@MyAnnotation(value="class", author="Pippo")
public class SimpleAnnotationUse {
  
	//qui, a livello di attributo
  @MyAnnotation(value="attribute", author="Pippo")
  public String saluto;

  //qui, a livello di costruttore
  @MyAnnotation(value="costruttore",author="Pippo")
  public SimpleAnnotationUse(){
    this.saluto="Hello World!";
  }

  //qui, a livello di metodo
  @MyAnnotation(value="method",author="Zio Paperone",company="Google")
  public String getSaluto(){
    return saluto;
  }

  
  public static void main(String args[]) throws NoSuchMethodException, NoSuchFieldException{
	  System.out.println("Working Annotations");

	  //Accesso alla classe
	  Class<SimpleAnnotationUse> c = SimpleAnnotationUse.class;

	  //Mostra annotazioni
	  System.out.println("Annotazione di classe: ");
	  System.out.println(c.getAnnotation( MyAnnotation.class ));

	  //Metodo costruttore
	  Constructor<SimpleAnnotationUse> constructor = c.getConstructor((Class[]) null);
	  System.out.println("Annotazione costruttore: ");
	  System.out.println(constructor.getAnnotation(MyAnnotation.class));

	  //Metodo getSaluto
	  Method method = c.getMethod( "getSaluto" );
	  System.out.println("Annotazione metodo getSaluto(): ");
	  System.out.println(method.getAnnotation(MyAnnotation.class));

	  //Campo saluto
	  Field field = c.getField("saluto");
	  System.out.println("Annotazione attributo saluto: ");
	  System.out.println(field.getAnnotation(MyAnnotation.class));
	} 
} 
