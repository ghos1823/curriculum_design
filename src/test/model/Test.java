package test.model;

import java.sql.Date;

public class Test {
	//属性
	private int idtest;
	private String name;
	private Date time;
	//生成方法
	public int getIdtest() {
		return idtest;
	}
	public void setIdtest(int idtest) {
		this.idtest = idtest;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
}
