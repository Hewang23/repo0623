package com.atguigu.team.service;
/**
 * 数据库的缩写
 * @author Administrator
 *
 */
public class Data {
	public static final int EMPLOYEE=10;
	public static final int PROGRAMMER=11;
	public static final int DESIGNER=12;
	public static final int ARCHITECT=13;
	
	public static final int PC=21;
	public static final int NOTEBOOK=22;
	public static final int PRINTER=23;
	//Employee：10，id，name，age，salary
	//Programmer：11，id，name，age，salary
	//Designer：12，id，name，age，salary，bonus
	//Architect：13，id，name，age，salary，bonus，stock
	public static final String[][] EMPLOYEES= {
			{"10","1","马云","22","3000"},
			{"13","2","马化腾","32","18000","15000","2000"},
			{"11","3","李彦宏","23","7000"},
			{"11","4","刘强东","25","8000"},
			{"12","5","雷军","28","8000","5000"},
			{"11","6","任志强","26","6800"},
			{"12","7","柳传志","29","10800","5000"},
			{"13","8","杨元庆","30","19800","15000","2500"},
			{"12","9","史玉柱","26","9800","5500"},
			{"11","10","丁磊","21","6600"}	
	};
	//设备和上面的员工一一对应
	//PC:21,model,display
	//NoteBook:22,model,price
	//Printer:23,name,type
	public static final String[][] EQUIPMENTS= {
			{},
			{"22","联想","6000"},
			{"22","联想","6000"},
			{"22","联想","6000"},
			{"22","联想","6000"},
			{"22","联想","6000"},
			{"22","联想","6000"},
			{"22","联想","6000"},
			{"22","联想","6000"},
			{"22","联想","6000"}
	};
}
