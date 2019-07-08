package com.msg.examples.se.annotation;

//import com.sun.tools.javac.Main;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
//import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic.Kind;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes({"com.msg.examples.se.annotation.*"})
@SupportedOptions({"debug", "verify"})
public class CustomProcessor extends AbstractProcessor {

  private boolean debug;

  private boolean generated;

  @Override
  public synchronized void init(ProcessingEnvironment processingEnv) {
    super.init(processingEnv);
    debug = Boolean.parseBoolean(processingEnv.getOptions().get("debug"));
    generated = false;
  }

  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    log("Start processing annotations for round " + roundEnv);

    if (roundEnv.processingOver()) {
      return true;
    }

    if (annotations.isEmpty()) {
      return false;
    }

    for(TypeElement annotation : annotations) {
      for (Element annotated : roundEnv.getElementsAnnotatedWith(annotation)) {
        log("Found element " + annotated.getKind() + " annotated with " + annotation.getSimpleName()+ ": " + annotated.getSimpleName());
        if (!generated) {
          generateSourceFile();
        }
      }
    }

    return true;
  }

  private void generateSourceFile() {
    try {
      String packageName = "com.msg.examples.se.annotation";
      JavaFileObject generatedSourceFile = processingEnv.getFiler().createSourceFile(packageName + ".GeneratedSourceFile");
      try (PrintWriter out = new PrintWriter(generatedSourceFile.openWriter())) {
        out.print("package ");
        out.print(packageName);
        out.println(";");
        out.println();

        out.print("public class ");
        out.print("GeneratedSourceFile");
        out.println(" {");
        out.println();

        out.println("}");
      }

      generated = true;
    } catch (IOException e) {
      fatalError("Unable to create com.msg.examples.se.annotation.GeneratedSourceFile, " + e);
    }
  }

  private void log(String msg) {
    if (debug) {
      processingEnv.getMessager().printMessage(Kind.NOTE, msg);
    }
  }

  private void fatalError(String msg) {
    processingEnv.getMessager().printMessage(Kind.ERROR, "FATAL ERROR: " + msg);
  }

  public static void main(String args[]) throws Exception {
    String arguments[] = {"-proc:only", "-Adebug=true", "-processor", "com.msg.examples.se.annotation.CustomProcessor",
            "com.msg.examples.se.annotation.Annotated"};
    //Main.main(arguments);
  }
}
