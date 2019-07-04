package com.msg.examples.se.exceptions;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.logging.Logger;

@SuppressWarnings({"ThrowFromFinallyBlock", "ConstantConditions", "TryFinallyCanBeTryWithResources"})
public class AvoidExceptionMasking {
    private static final Logger LOGGER = Logger.getLogger(AvoidExceptionMasking.class.getPackage().getName());

    //exception inside try block is masked if close throws an exception
    public void readFileWithoutMaskingAvoidance() throws Exception {
        InputStream in = null;
        try {
            in = new FileInputStream("file.txt");
        } finally {
            in.close();
        }
    }

    //exception inside try block is rethrown by the catch clause of the close method
    public void readFileWithMaskingAvoidance() throws Exception {
        InputStream in = null;
        Exception ex = null;
        try {
            try {
                // code that might throw exceptions
                LOGGER.severe("I'm logging severe stuff");
                LOGGER.warning("I'm logging warn stuff");
                LOGGER.info("I'm logging info stuff");

                in = new FileInputStream("file.txt");
            } catch (Exception e) {
                ex = e;
                throw e;
            }
        } finally {
            try {
                in.close();
            } catch (Exception e) {
                if (ex == null) throw e;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        AvoidExceptionMasking avoidExceptionMasking = new AvoidExceptionMasking();

//        avoidExceptionMasking.readFileWithoutMaskingAvoidance();
        avoidExceptionMasking.readFileWithMaskingAvoidance();
    }
}
