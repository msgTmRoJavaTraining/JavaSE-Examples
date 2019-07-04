package com.msg.examples.se.annotation;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Full {

  String param1() default "first param";

  int param2() default 2;

  TimeUnit param3() default TimeUnit.SECONDS;
}
