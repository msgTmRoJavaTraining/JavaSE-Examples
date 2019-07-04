package com.msg.examples.se.annotation;

import java.lang.annotation.*;

@Target({ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface SingleValue {

  String value() default "single value annotation";
}
