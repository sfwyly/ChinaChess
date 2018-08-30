package com.wtu.bean.chesspiece;

import com.wtu.bean.Chess;
import com.wtu.bean.Chesspiece;

public class Bi extends Chess{
	
	public Bi() {
		this.name="兵";
		this.flag="Bi";
	}

	@Override
	public boolean move(Chesspiece[][] scope, int start_x, int start_y, int end_x, int end_y) {
		
		if(scope[start_x][start_y]!=null&&scope[end_x][end_y]!=null&&scope[start_x][start_y].getCompetitor()!=null&&scope[start_x][start_y].getCompetitor().equals(scope[end_x][end_y].getCompetitor())) {
			return false;
		}
		//两种情况，
		if("R".equals(scope[start_x][start_y].getCompetitor())) {//红方
			if(start_x-end_x==1&&start_y==end_y) {//朝前走
				
			}else if(start_x<=4&&start_x==end_x&&Math.abs(start_y - end_y)==1) {//左右走
				
			}else {
				return false;
			}
		}else if("B".equals(scope[start_x][start_y].getCompetitor())) {//黑方
			if(end_x-start_x==1&&start_y==end_y) {//朝前走
				
			}else if(start_x>=5&&start_x==end_x&&Math.abs(start_y - end_y)==1) {//左右走
				
			}else {
				return false;
			}
		}else {
			return false;
		}
		
		if(scope[end_x][end_y]!=null&&scope[end_x][end_y].getCompetitor()!=null) {
			scope[end_x][end_y].setCompetitor(scope[start_x][start_y].getCompetitor());//覆盖对方棋子
			scope[end_x][end_y].setChess(scope[start_x][start_y].getChess());
			scope[start_x][start_y].setCompetitor(null);
			scope[start_x][start_y].setChess(null);//
			
		}else {
			scope[end_x][end_y]=new Chesspiece(end_x,end_y,scope[start_x][start_y].getCompetitor());
			scope[end_x][end_y].setChess(scope[start_x][start_y].getChess());
			scope[start_x][start_y].setCompetitor(null);
			scope[start_x][start_y].setChess(null);//
		}
		return true;
	}

	@Override
	public int add(int a, int b) {
		// TODO 自动生成的方法存根
		return 0;
	}

}
