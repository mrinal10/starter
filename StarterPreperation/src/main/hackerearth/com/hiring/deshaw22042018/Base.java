package com.hiring.deshaw22042018;

class Base
{
    static int x = 10;
}

class Derived extends Base
{
    public static void fun()
    {
        System.out.println(super.x);
    }
}
