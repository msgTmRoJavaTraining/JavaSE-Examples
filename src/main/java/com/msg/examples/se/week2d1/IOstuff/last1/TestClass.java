package com.msg.examples.se.week2d1.IOstuff.last1;

import com.sun.tools.corba.se.idl.ExceptionEntry;
import com.sun.tools.corba.se.idl.toJavaPortable.ExceptionGen;
import org.omg.CORBA.ExceptionList;

import java.io.FileNotFoundException;

public class TestClass {
    int someNum;

    public void exceptOne() throws FileNotFoundException {
        throw new FileNotFoundException("exception1");
    }
    public void exceptTwo()  {
        throw new NumberFormatException("exception2");
    }
    public void exceptThree() throws Exception {
        throw new Exception("exception3");
    }

}
