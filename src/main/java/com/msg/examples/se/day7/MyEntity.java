package com.msg.examples.se.day7;

import com.sun.istack.internal.Interned;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
@Inherited
public @interface MyEntity { }
