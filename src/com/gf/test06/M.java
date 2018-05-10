package com.gf.test06;


class A {
	  A() { i = (j++ != 0) ? ++j : --j; }
	  public int i;
	  public static int j = 0;
	}


public class M {
  public static void main(String[] args) {
    A a1 = new A();

    System.out.println(a1.i);
    System.out.println(a2.i);
  }
  
  static A a2 = new A();
}

