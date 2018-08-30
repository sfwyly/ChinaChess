package com.wtu.bean.chesspiece;

import com.wtu.bean.Chess;
import com.wtu.bean.Chesspiece;

public class Po extends Chess{
	
	public Po() {
		this.name="炮";
		this.flag="Po";
	}

	@Override
	public boolean move(Chesspiece[][] scope, int start_x, int start_y, int end_x, int end_y) {
		if(scope[start_x][start_y]!=null&&scope[end_x][end_y]!=null&&scope[start_x][start_y].getCompetitor()!=null&&scope[start_x][start_y].getCompetitor().equals(scope[end_x][end_y].getCompetitor())) {
			return false;
		}
		
		if(start_x==end_x) {
			int min,max;
			if(start_y<=end_y) {
				min=start_y;
				max=end_y;
			}else {
				max=start_y;
				min=end_y;
			}
			int flag=0;
			for(int i=min+1;i<max;i++) {
				if(scope[start_x][i]!=null&&scope[start_x][i].getCompetitor()!=null) {
					flag+=1;
				}
			}
			if(flag>1) {
				return false;
			}else if(flag==0&&scope[end_x][end_y]!=null&&scope[end_x][end_y].getCompetitor()!=null&&!scope[start_x][start_y].getCompetitor().equals(scope[end_x][end_y].getCompetitor())) {
				return false;
			}
		}else if(start_y==end_y) {
			int min,max;
			if(start_x<=end_x) {
				min=start_x;
				max=end_x;
			}else {
				max=start_x;
				min=end_x;
			}
			int flag=0;
			for(int i=min+1;i<max;i++) {
				if(scope[i][start_y]!=null&&scope[i][start_y].getCompetitor()!=null) {
					flag+=1;
				}
			}
			if(flag>1) {
				return false;
			}else if(flag==0&&scope[end_x][end_y]!=null&&scope[end_x][end_y].getCompetitor()!=null&&!scope[start_x][start_y].getCompetitor().equals(scope[end_x][end_y].getCompetitor())) {
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
