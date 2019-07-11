package com.msg.examples.se.fourthday.ExceptionAplication;

public class InvalidLineFormatException extends Exception {
    public InvalidLineFormatException(String str,int cont){
        super("Not enough sentences on line:"+cont+"\nCurrent: "+str);
    }


}
