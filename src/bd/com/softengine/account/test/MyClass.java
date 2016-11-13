package bd.com.softengine.account.test;

/**
 * Copyright &copy; Soft Engine Inc.
 * Created on 24/06/16
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 24/06/16
 * Version : 1.0
 */

public class MyClass implements MyInterface {
    @Override
    public String getName() {
        return "Motin";
    }

    @Override
    public Integer run() {
        return null;
    }

    private static void abc(){

    }

    public static void main(String[] args) {
        MyClass obj = new MyClass();

        String name =  obj.getName();
        obj.abc();
        System.out.println("name = " + name);
    }

    public void xyz() {
        MyClass obj = new MyClass();
        obj.abc();
    }
}
