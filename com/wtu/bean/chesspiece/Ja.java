package com.wtu.bean.chesspiece;

import com.wtu.bean.Chess;
import com.wtu.bean.Chesspiece;

public class Ja extends Chess{
	
	public Ja() {
		this.name="将";
		this.flag="Ja";
	}

	@Override
	public boolean move(Chesspiece[][] scope, int start_x, int start_y, int end_x, int end_y) {
		if(scope[start_x][start_y]!=null&&scope[end_x][end_y]!=null&&scope[start_x][start_y].getCompetitor()!=null&&scope[start_x][start_y].getCompetitor().equals(scope[end_x][end_y].getCompetitor())) {
			return false;
		}
		//两种情况，
		if("R".equals(scope[start_x][start_y].getCompetitor())) {//红方
			if(end_x>=7&&end_x<=9&&end_y>=3&&end_y<=5){
				if((Math.abs(start_y - end_y)==1&&Math.abs(start_x - end_x)==0)||(Math.abs(start_y - end_y)==0&&Math.abs(start_x - end_x)==1)) {
					
				}else {
					return false;
				}
			}else {
				return false;
			}
		}else if("B".equals(scope[start_x][start_y].getCompetitor())) {//黑方
			if(end_x>=0&&end_x<=2&&end_y>=3&&end_y<=5){
				if((Math.abs(start_y - end_y)==1&&Math.abs(start_x - end_x)==0)||(Math.abs(start_y - end_y)==0&&Math.abs(start_x - end_x)==1)) {
					
				}else {
					return false;
				}
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
