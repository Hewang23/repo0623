package com.atguigu.team.view;

import java.util.Scanner;

/**
 * 工具包
 *
 * @author Administrator
 *
 */
public class TSUtility {
	private static Scanner scanner =new Scanner(System.in);
	public static char  readMenuSelection() {
		char c;
		for(;;) {
			String str=readKeyBoard(1,false);
			c=str.charAt(0);
			if(c!='1'&&c!='2'&&c!='3'&&c!='4') {
				System.out.println("输入有误，请重新输入：");
			}else break;
		}
		return c;
	}
	public static char readConfirmSelection() {
		char c;
		for(;;) {
			String str=readKeyBoard(1,false).toUpperCase();
			c=str.charAt(0);
			if(c=='Y'||c=='N') {
				break;
			}else {
				System.out.println("选择错误，请重新输入：");
			}
		}
		return c;
	}
	public static void readReturn() {
		System.out.println("按回车继续");
		readKeyBoard(100,true);
	}
	public static int readInt() {
		int n;
		for(;;) {
			String str=readKeyBoard(2,false);
			try {
				n=Integer.parseInt(str);
				break;
			}catch(NumberFormatException e) {
				System.out.println("数字输入错误，请重新输入：");
			}
		}
		return n;
		
	}
	private static String readKeyBoard(int limit,boolean blankReturn) {
		String line=" ";
		while(scanner.hasNextLine()) {
			line=scanner.nextLine();
			if(line.length()==0) {
				if(blankReturn) return line;
				else continue;
			}
			if(line.length()<0||line.length()>limit){
				System.out.println("输入长度不大于："+limit+"，请重新输入：");
				continue;
			}
			break;
		}
		return line;
	}
}
