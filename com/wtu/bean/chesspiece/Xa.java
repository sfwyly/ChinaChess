package com.wtu.bean.chesspiece;

import com.wtu.bean.Chess;
import com.wtu.bean.Chesspiece;

public class Xa extends Chess{
	
	public Xa() {
		this.name="象";
		this.flag="Xa";
	}

	@Override
	public boolean move(Chesspiece[][] scope, int start_x, int start_y, int end_x, int end_y) {
		if(scope[start_x][start_y]!=null&&scope[end_x][end_y]!=null&&scope[start_x][start_y].getCompetitor()!=null&&scope[start_x][start_y].getCompetitor().equals(scope[end_x][end_y].getCompetitor())) {
			return false;
		}
		//两种情况，
		if("R".equals(scope[start_x][start_y].getCompetitor())) {//红方
			if(end_x>=5&&start_x>=5&&Math.abs(start_x- end_x)==2&&Math.abs(start_y-end_y)==2){
				if(scope[(start_x+end_x)/2][(start_y+end_y)/2]!=null&&scope[(start_x+end_x)/2][(start_y+end_y)/2].getCompetitor()!=null) {//别脚
					return false;
				}
			}else {
				return false;
			}
		}else if("B".equals(scope[start_x][start_y].getCompetitor())) {//黑方
			if(end_x<=4&&start_x<=4&&Math.abs(start_x- end_x)==2&&Math.abs(start_y-end_y)==2){
				if(scope[(start_x+end_x)/2][(start_y+end_y)/2]!=null&&scope[(start_x+end_x)/2][(start_y+end_y)/2].getCompetitor()!=null) {//别脚
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
