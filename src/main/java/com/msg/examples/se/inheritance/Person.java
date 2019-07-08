package com.msg.examples.se.inheritance;

public abstract class Person {
    String name;

    public abstract void dance();
    public boolean equals(Object otherObject)
    {
        // a quick test to see if the objects are identical
        if (this == otherObject) return true;
        // must return false if the explicit parameter is null
        if (otherObject == null) return false;
        // if the classes don't match, they can't be equal
        if (getClass() != otherObject.getClass())
            return false;
            Person other = (Person) otherObject;
            return name.equals(other.name);
    }


}
