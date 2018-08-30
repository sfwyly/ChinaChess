package com.wtu.bean.chesspiece;

import com.wtu.bean.Chess;
import com.wtu.bean.Chesspiece;

public class Ma extends Chess{
	
	public Ma() {
		this.name="马";
		this.flag="Ma";
	}

	@Override
	public boolean move(Chesspiece[][] scope, int start_x, int start_y, int end_x, int end_y) {
		
		if(scope[start_x][start_y]!=null&&scope[end_x][end_y]!=null&&scope[start_x][start_y].getCompetitor()!=null&&scope[start_x][start_y].getCompetitor().equals(scope[end_x][end_y].getCompetitor())) {
			return false;
		}
		//分上下左右两种情况
		if(Math.abs(end_x - start_x)==2&&Math.abs(end_y - start_y)==1) {//上下
			if(end_x-start_x==2) {//下方
				if(scope[start_x+1][start_y]!=null&&scope[start_x+1][start_y].getCompetitor()!=null) {//别马脚
					return false;
				}else {
					
				}
			}else {
				if(scope[start_x-1][start_y]!=null&&scope[start_x-1][start_y].getCompetitor()!=null) {//别马脚
					return false;
				}else {
					
				}
			}
		}else if(Math.abs(end_x - start_x)==1&&Math.abs(end_y - start_y)==2) {//左右
			if(end_y - start_y ==2) {
				if(scope[start_x][start_y+1]!=null&&scope[start_x][start_y+1].getCompetitor()!=null) {//别马脚
					return false;
				}else {
					
				}
			}else {
				if(scope[start_x][start_y-1]!=null&&scope[start_x][start_y-1].getCompetitor()!=null) {//别马脚
					return false;
				}else {
					
				}
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
//		return false;
	}

	@Override
	public int add(int a, int b) {
		// TODO 自动生成的方法存根
		return 0;
	}

}
