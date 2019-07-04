package com.msg.examples.se.annotation;

import java.io.Serializable;
import java.lang.reflect.*;
import java.util.concurrent.TimeUnit;

@Marker
public class Annotated extends AccessibleObject implements Serializable {

  @Full(param1 = "third param", param2 = -1, param3 = TimeUnit.HOURS)
  private int field;

  @SingleValue("annotated constructor")
  public Annotated() {
    field = 1;
  }

  @Marker
  public Annotated addValueToField(@Marker double value) {
    field += value;

    return this;
  }

  public static void main(String args[]) throws ReflectiveOperationException {
    Annotated annotated = Annotated.class.newInstance();
    Class<? extends Annotated> theClass = annotated.getClass();
    System.out.println(theClass.getAnnotations()[0]);
    System.out.println("serializable: " + Serializable.class.isAssignableFrom(theClass));
    System.out.println("accessible: " + theClass.isAssignableFrom(AccessibleObject.class) + " - " + AccessibleObject.class.isAssignableFrom
            (theClass));

    Field field = theClass.getDeclaredField("field");
    field.setAccessible(true);
    System.out.println("name: " + field.getName() + ", type: " + field.getType() + ", value: " + field.get(annotated) + ", annotation: "
            + field.getAnnotations()[0]);
    Full full = field.getAnnotation(Full.class);

    Method method = theClass.getMethod("addValueToField", double.class);
    System.out.println("name: " + method.getName() + ", return type: " + method.getReturnType() + ", annotation present: " + method
            .isAnnotationPresent(Marker.class));

    Parameter parameter = method.getParameters()[0];
    System.out.println("name: " + parameter.getName() + ", type: " + parameter.getType() + ", annotation present: " + parameter
            .isAnnotationPresent(Marker.class));

    method.invoke(annotated, 7);
    System.out.println("name: " + field.getName() + ", type: " + field.getType() + ", value: " + field.get(annotated) + ", annotation " +
            "present: " + field.isAnnotationPresent(Marker.class));

    Constructor<? extends Annotated> constructor = theClass.getConstructor();
    SingleValue annotation = constructor.getAnnotation(SingleValue.class);
    System.out.println("constructor param: " + annotation.value());
  }
}
