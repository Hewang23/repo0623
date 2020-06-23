package com.atguigu.team.service;

//public class Status {
//	private final String NAME;
//
//	private Status(String name) {
//		this.NAME=name;
//	}
//	public static final Status FREE=new Status("FREE");
//	public static final Status BUSY=new Status("BUSY");
//	public static final Status VOCATION=new Status("VOCATION");
//
//	public String getNAME() {
//		return NAME;
//	}
//
//	@Override
//	public String toString() {
//		return NAME;
//	}
//
//
//}
public enum Status{
	//不用定义变量的情况下也可以输出
	FREE("FREE"),
	BUSY("BUSY"),
	VOCATION("VOCATION");
	private final String NAME;
	private Status(String NAME){
		this.NAME=NAME;
	}
	public void show(){
		System.out.println(FREE);
	}




}
