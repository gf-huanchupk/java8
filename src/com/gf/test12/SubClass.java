package com.gf.test12;

public class SubClass /*extends MyClass*/ implements MyFun,MyInterface{

	@Override
	public String getName() {
		//return MyFun.super.getName();
		return MyInterface.super.getName();
	}

}
