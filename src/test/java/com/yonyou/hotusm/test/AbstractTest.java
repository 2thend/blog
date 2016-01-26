package com.yonyou.hotusm.test;

//具有abstract方法的类必须声明成 abstract的类
//在子类中必须实现这个方法 并且这个类不能被直接new 除非实现抽象方法
public abstract class AbstractTest {
	public void say(){
		System.out.println("say");
	}
	public abstract void say2();
}
