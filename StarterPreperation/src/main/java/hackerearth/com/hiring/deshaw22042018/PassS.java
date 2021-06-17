package com.hiring.deshaw22042018;

class Test {
	public synchronized void foo(int i, String msg){
       log.writeln(Integer.toString(i));
       log.writeln(msg);
    }
    public void bar(int i, String msg){
       synchronized(this){
          log.writeln(Integer.toString(i));
          log.writeln(msg);
       }
    }
}