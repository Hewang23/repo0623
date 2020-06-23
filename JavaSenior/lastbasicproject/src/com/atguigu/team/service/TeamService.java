package com.atguigu.team.service;

import com.atguigu.team.domain.Architect;
import com.atguigu.team.domain.Designer;
import com.atguigu.team.domain.Employee;
import com.atguigu.team.domain.Programmer;

/**
 * 关于开发团队成员的管理，添加，删除等。
 * 
 * @author Administrator
 *
 */
public class TeamService {
	private static int counter = 1;// 用于为开发团队新增成员自动生成团队中的唯一ID
	private final int MAX_MEMBER = 5;// 限制人数
	private Programmer[] team = new Programmer[MAX_MEMBER];// 团队人员信息
	private int total;// 实际人数

	public TeamService() {
		super();
	}

	/**
	 * 获取开发团队中的所有成员 即返回最终人数的数组 不是原数组
	 * 
	 * @return
	 */
	public Programmer[] getTeam() {
		Programmer[] team = new Programmer[total];
		for (int i = 0; i < team.length; i++) {
			team[i] = this.team[i];
		}
		return team;
	}

	/***
	 * 将指定员工添加到开发团队中 考虑添加不成功的情况 成员满不可添加 不是开发人员不可添加 已在开发团队中 已经是某团队成员即status为busy
	 * 休假不可添加 最多一名架构师 最多两名设计师 最多三名程序员
	 * 
	 * @param e
	 * @throws TeamException
	 */
	public void addMember(Employee e) throws TeamException {
//		成员满不可添加 
		if (total >= MAX_MEMBER) {
			throw new TeamException("成员已满，无法添加");
		}
//		 不是开发人员不可添加
		if (!(e instanceof Programmer)) {
			throw new TeamException("该人员不是程序员，无法添加");
		}
//		已在开发团队中 
		// 因为代码比较繁琐，写为方法
		if (isExist(e)) {
			throw new TeamException("已在开发团队中，无法添加");
		}
//		已经是某团队成员即status为busy
		Programmer p = (Programmer) e;
//		if(p.getStatus().getNAME().equals("BUSY"))
//		if ("BUSY".equals(p.getStatus().getNAME())) {// 避免空指针
//			throw new TeamException("该员工已经是某团队成员，无法添加");
//		} else if ("VOCATION".equals(p.getStatus().getNAME())) {
//			throw new TeamException("该员工正休假，无法添加");
//		}
		switch (p.getStatus()){//可以由String或者枚举类对象作为输入
			case BUSY:
				throw new TeamException("该员工已经是某团队成员，无法添加");
			case VOCATION:
				throw new TeamException("该员工正休假，无法添加");
		}
//		最多一名架构师 
		//获取Team中已有的架构师、设计师、程序员的个数
		int numOfArch=0,numOfDes=0,numOfPro=0;
		for(int i=0;i<total;i++) {
			if(team[i] instanceof Architect) {
				numOfArch+=1;
			}else if(team[i] instanceof Designer) {
				numOfDes+=1;
			}else {
				numOfPro+=1;
			}
		}
		if(p instanceof Architect) {
			if(numOfArch>=1) {
				throw new TeamException("最多有一个架构师，无法添加");
			}
		}else if(p instanceof Designer) {
			if(numOfDes>=2) {
				throw new TeamException("最多有两个设计师，无法添加");
			}
		}else {
			if(numOfPro>=3) {
				throw new TeamException("最多有三个程序员，无法添加");
			}
		}
		team[total++]=p;
		//p的属性做相应改变
		p.setStatus(Status.BUSY);
		p.setMemberId(counter++);
	
	}

	/**
	 * 判断成员是否存在于团队中
	 * 
	 * @param e 也可以通过memberId比较，因为此处输入的e均为programmer
	 */
	private Boolean isExist(Employee e) {
		for (int i = 0; i < total; i++) {
			if (team[i].getId() == e.getId()) {
				return true;
			}
		}
		return false;
	}
/**
 * 从团队中删除成员
 * @param memberId
 * @throws TeamException 
 */
	public void delMember(int memberId) throws TeamException {
		int i;
//		boolean isFind=false;
		for(i=0;i<total;i++) {
			if(team[i].getMemberId()==memberId) {
//				isFind=true;
				team[i].setStatus(Status.FREE);
				break;
			}
		}//此时若是找到了则i<total；若是没有找到则i=total
		if(i==total) {
			throw new TeamException("没有找到该成员，无法删除");
		}
			for(int j=i;j<total-1;j++) {
				team[j]=team[j+1];
			}
			team[--total]=null;
		
	}
}
