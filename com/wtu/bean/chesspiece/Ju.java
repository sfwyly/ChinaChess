package com.wtu.bean.chesspiece;

import com.wtu.bean.Chess;
import com.wtu.bean.Chesspiece;

/*
 * 车
 */
public class Ju extends Chess{
//	private String name="车";//名称
//	private String flag="Ju";//字符代表
//	private String figure="";//人物
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getFlag() {
//		return flag;
//	}
//	public void setFlag(String flag) {
//		this.flag = flag;
//	}
//	public String getFigure() {
//		return figure;
//	}
//	public void setFigure(String figure) {
//		this.figure = figure;
//	}
	public Ju() {//构造器
//		this.figure=figure;
		this.name="车";
		this.flag="Ju";
	}
	/**
	 * 
	 * @param start_x 开始的x,y
	 * @param start_y
	 * @param end_x 要到的x,y
	 * @param end_y
	 * @return
	 */
	@Override
	public boolean move(Chesspiece scope[][],int start_x,int start_y,int end_x,int end_y) {
		boolean blockFlag=true;//要移动到的格子是不是空白
		if(scope[end_x][end_y]!=null&&scope[end_x][end_y].getCompetitor()!=null) {
			blockFlag=false;
		}
		
		if(start_x==end_x) {//同一行
			int max_y=-1,min_y=-1;//获取最小值和最大值
			if(start_y>=end_y) {
				max_y=start_y;
				min_y=end_y;
			}else {
				max_y=end_y;
				min_y=start_y;
			}
			boolean isolateFlag=true;//
			for(int i=min_y+1;i<max_y;i++) {
				if(scope[start_x][i]!=null&&scope[start_x][i].getCompetitor()!=null) {//如果中间有其他的棋子
					isolateFlag=false;
					break;
				}
			}
			if(isolateFlag==true) {//能移动到末端
				if(blockFlag==true) {//是空白格
					scope[end_x][end_y]=new Chesspiece(end_x,end_y,scope[start_x][start_y].getCompetitor());
					scope[end_x][end_y].setChess(scope[start_x][start_y].getChess());
					scope[start_x][start_y].setCompetitor(null);
					scope[start_x][start_y].setChess(null);//
					return true;
				}else {//末端有棋子
					if(scope[end_x][end_y].getCompetitor()!=null&&scope[end_x][end_y].getCompetitor().equals(scope[start_x][start_y].getCompetitor())) {//同一方棋子
						return false;
					}else {//吃子
						scope[end_x][end_y].setCompetitor(scope[start_x][start_y].getCompetitor());//覆盖对方棋子
						scope[end_x][end_y].setChess(scope[start_x][start_y].getChess());
						scope[start_x][start_y].setCompetitor(null);
						scope[start_x][start_y].setChess(null);//
						return true;
					}
				}
			}
			return false;
		}else if(start_y==end_y){
			int max_x=-1,min_x=-1;
			if(start_x>=end_x) {
				max_x=start_x;
				min_x=end_x;
			}else {
				max_x=end_x;
				min_x=start_x;
			}
			boolean isolateFlag=true;//
			for(int i=min_x+1;i<max_x;i++) {
				if(scope[i][start_y]!=null&&scope[i][start_y].getCompetitor()!=null) {//如果中间有其他的棋子
					isolateFlag=false;
					break;
				}
			}
			if(isolateFlag==true) {//中间没有其他棋子
				if(blockFlag==true) {//要移到的是空格
					scope[end_x][end_y]=new Chesspiece(end_x,end_y,scope[start_x][start_y].getCompetitor());
					scope[end_x][end_y].setChess(scope[start_x][start_y].getChess());
					scope[start_x][start_y].setCompetitor(null);
					scope[start_x][start_y].setChess(null);//
					return true;
				}else {
					
					if(scope[end_x][end_y].getCompetitor()!=null&&scope[end_x][end_y].getCompetitor().equals(scope[start_x][start_y].getCompetitor())) {//同一方棋子
						return false;
					}else {//吃子
						scope[end_x][end_y].setCompetitor(scope[start_x][start_y].getCompetitor());//覆盖对方棋子
						scope[end_x][end_y].setChess(scope[start_x][start_y].getChess());
						scope[start_x][start_y].setCompetitor(null);
						scope[start_x][start_y].setChess(null);//
						return true;
					}
				}
			}
			return false;
		}else {//不在一条直线
			return false;
		}
//		return false;
	}
	@Override
	public int add(int a, int b) {
		// TODO 自动生成的方法存根
		return a+b;
	}
	
}
