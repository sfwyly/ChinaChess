package com.wtu.init;

import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.wtu.bean.Chesspiece;
import com.wtu.bean.chesspiece.Bi;
import com.wtu.bean.chesspiece.Ja;
import com.wtu.bean.chesspiece.Ju;
import com.wtu.bean.chesspiece.Ma;
import com.wtu.bean.chesspiece.Po;
import com.wtu.bean.chesspiece.Si;
import com.wtu.bean.chesspiece.Xa;

public class InitialBlock extends ActionSupport implements SessionAware{
	
	private Map<String,Object> session;
	/**
	 * 初始化棋盘
	 * @return 棋盘布局
	 */
	@Override
	public String execute() throws Exception {
		Chesspiece chesspiece[][]=new Chesspiece[10][9];
		//黑方棋子
		for(int i=0;i<9;i++) {
			chesspiece[0][i]=new Chesspiece(0,i,"B");//黑方
		}
		chesspiece[0][0].setChess(new Ju());
		chesspiece[0][1].setChess(new Ma());
		chesspiece[0][2].setChess(new Xa());
		chesspiece[0][3].setChess(new Si());
		chesspiece[0][4].setChess(new Ja());
		chesspiece[0][8].setChess(new Ju());
		chesspiece[0][7].setChess(new Ma());
		chesspiece[0][6].setChess(new Xa());
		chesspiece[0][5].setChess(new Si());
		chesspiece[2][1]=new Chesspiece(2,1,"B");//黑方
		chesspiece[2][1].setChess(new Po());
		chesspiece[2][7]=new Chesspiece(2,7,"B");//黑方
		chesspiece[2][7].setChess(new Po());
		for(int i=0;i<=8;i+=2) {
			chesspiece[3][i]=new Chesspiece(3,i,"B");//黑方
			chesspiece[3][i].setChess(new Bi());
		}
		//红方棋子
		for(int i=0;i<9;i++) {
			chesspiece[9][i]=new Chesspiece(9,i,"R");
		}
		chesspiece[9][0].setChess(new Ju());
		chesspiece[9][1].setChess(new Ma());
		chesspiece[9][2].setChess(new Xa());
		chesspiece[9][3].setChess(new Si());
		chesspiece[9][4].setChess(new Ja());
		chesspiece[9][8].setChess(new Ju());
		chesspiece[9][7].setChess(new Ma());
		chesspiece[9][6].setChess(new Xa());
		chesspiece[9][5].setChess(new Si());
		
		chesspiece[7][1]=new Chesspiece(2,1,"R");
		chesspiece[7][1].setChess(new Po());
		chesspiece[7][7]=new Chesspiece(2,7,"R");
		chesspiece[7][7].setChess(new Po());
		for(int i=0;i<=8;i+=2) {
			chesspiece[6][i]=new Chesspiece(3,i,"R");
			chesspiece[6][i].setChess(new Bi());
		}
//		ServletActionContext.getRequest().getSession().setAttribute("chessboard", chesspiece);
		session.put("chessboard", chesspiece);
		return null;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		session=arg0;
	}
}
