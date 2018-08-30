package com.wtu.bean;

//传过来的参数
public class DeliverParameter {
	private int start_x;
	private int start_y;
	private int end_x;
	private int end_y;
	private String flag;//字符代表
	public int getStart_x() {
		return start_x;
	}
	public void setStart_x(int start_x) {
		this.start_x = start_x;
	}
	public int getStart_y() {
		return start_y;
	}
	public void setStart_y(int start_y) {
		this.start_y = start_y;
	}
	public int getEnd_x() {
		return end_x;
	}
	public void setEnd_x(int end_x) {
		this.end_x = end_x;
	}
	public int getEnd_y() {
		return end_y;
	}
	public void setEnd_y(int end_y) {
		this.end_y = end_y;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
}
