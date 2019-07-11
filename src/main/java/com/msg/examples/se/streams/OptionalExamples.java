package com.msg.examples.se.streams;

import java.util.Optional;

@SuppressWarnings({"ConstantConditions", "ResultOfMethodCallIgnored"})
public class OptionalExamples {
    public static void main(String[] args) throws Exception {
        Optional<String> opt = Optional.of("mere");
        opt.ifPresent(name -> System.out.println(name.length()));

        String name = Optional.<String>empty().orElse("John");
        System.out.println(name);

        String anotherName = Optional.<String>empty().orElseGet(() -> "Jena");
        System.out.println(anotherName);
        try {
            Optional.<String>empty().orElseThrow(() -> new Exception("I'm failing"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
