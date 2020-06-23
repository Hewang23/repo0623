package com.atguigu.team.service;

import com.atguigu.team.domain.Architect;
import com.atguigu.team.domain.Designer;
import com.atguigu.team.domain.Employee;
import com.atguigu.team.domain.Equipment;
import com.atguigu.team.domain.NoteBook;
import com.atguigu.team.domain.PC;
import com.atguigu.team.domain.Printer;
import com.atguigu.team.domain.Programmer;

import static com.atguigu.team.service.Data.*;

import java.util.Arrays;
/**
 * 负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee的方法
 * @author Administrator
 *
 */
public class NameListService {
	private Employee[] employees;
	/**
	 * 数组和数组元素的初始化
	 * 根据项目提供的Data构建相应大小的employees数组
	 * 根据Data类中的数据构建不同的对象，包括父类以及子类
	 * 将对象存放入数组中
	 * @return Emlpoyee[]
	 */
	public NameListService() {
		super();
		employees=new Employee[EMPLOYEES.length];
		int type;
		for(int i=0;i<employees.length;i++) {
			type=Integer.parseInt(EMPLOYEES[i][0]);
			int id=Integer.parseInt(EMPLOYEES[i][1]);
			String name=EMPLOYEES[i][2];
			int age=Integer.parseInt(EMPLOYEES[i][3]);
			double salary=Double.parseDouble(EMPLOYEES[i][4]);
			Equipment equipment;
			double bonus;
			switch(type) {
			case EMPLOYEE:
				employees[i]=new Employee(id,name,age,salary);
				break;
			case PROGRAMMER:
			    equipment=creatEquipment(i);
				employees[i]=new Programmer(id,name,age,salary,equipment);
				break;
			case DESIGNER:
				equipment=creatEquipment(i);
				bonus=Double.parseDouble(EMPLOYEES[i][5]);
				employees[i]=new Designer(id,name,age,salary,equipment,bonus);
				break;
			case ARCHITECT:
				equipment=creatEquipment(i);
				bonus=Double.parseDouble(EMPLOYEES[i][5]);
				int stock=Integer.parseInt(EMPLOYEES[i][6]);
				employees[i]=new Architect(id,name,age,salary,equipment,bonus,stock);
				break;
			}
		}
	}
	/**
	 * 获取当前所有员工
	 * @return
	 */
	public Employee[] getAllEmployee() {
		return employees;
	}
	/**
	 * 获取当前指定员工
	 * @param id
	 * @return
	 * @throws TeamException 
	 */
	public Employee getEmployee(int id) throws TeamException{
		for(int i=0;i<employees.length;i++) {
			if(employees[i].getId()==id) {
				return employees[i];
			}
		}
		throw new TeamException("未找到指定员工");
		
	}
	private Equipment creatEquipment(int i) {
		int type =Integer.parseInt(EQUIPMENTS[i][0]);
		String model=EQUIPMENTS[i][1];
		switch(type) {
		case PC:
			String display=EQUIPMENTS[i][2];
			return new PC(model,display);
		case NOTEBOOK:
			double price=Double.parseDouble(EQUIPMENTS[i][2]);
			return new NoteBook(model,price);
		case PRINTER:
			String name=EQUIPMENTS[i][1];
			String  type1=EQUIPMENTS[i][2];
			return new Printer(name,type1);
		}
		return null;
	}
	@Override
	public String toString() {
		return "NameListService [employees=" + Arrays.toString(employees) + "]";
	}
	
}
