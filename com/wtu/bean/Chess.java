package com.wtu.bean;

public abstract class Chess {
	protected String name;//名称
	protected String flag;//字符代表
//	protected String figure;//人物
	public abstract boolean move(Chesspiece scope[][],int start_x,int start_y,int end_x,int end_y) ;
	public abstract int add(int a,int b);
}
