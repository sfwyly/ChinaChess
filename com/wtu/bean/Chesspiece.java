package com.wtu.bean;

public class Chesspiece {
	private String competitor;//如果有棋子黑红方
	private int x;//坐标
	private int y;
	private Chess chess;//和competitor同时存在同时消亡
	
	
	public Chesspiece(int x,int y,String competitor) {
		this.x=x;
		this.y=y;
		this.competitor=competitor;
	}
	public Chesspiece() {
	}
	
	public String getCompetitor() {
		return competitor;
	}
	public void setCompetitor(String competitor) {
		this.competitor = competitor;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Chess getChess() {
		return chess;
	}
	public void setChess(Chess chess) {
		this.chess = chess;
	}
	
}
