package com.wtu.action.util;

import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wtu.bean.Chess;
import com.wtu.bean.Chesspiece;
import com.wtu.bean.DeliverParameter;

public class JudgeMoveAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,SessionAware,ModelDriven<DeliverParameter>{
	private HttpServletRequest request;
	private HttpServletResponse response;
	private DeliverParameter deliverParameter = new DeliverParameter();
	private Map<String, Object> session;
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request=arg0;
	}
	
	@Override
	public String execute() throws Exception {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		Chesspiece[][] chesspiece=(Chesspiece[][]) session.get("chessboard");//
		PrintWriter pw=response.getWriter();
		String className="com.wtu.bean.chesspiece."+deliverParameter.getFlag();//拼凑全类名
		Class cla=Class.forName(className);
//		Constructor[] con=cla.getConstructors();
//		Chess chess=(Chess)con[0].newInstance();
		Method method=cla.getMethod("move",Chesspiece[][].class,int.class,int.class,int.class,int.class);
		method.setAccessible(true);
		boolean flag=(boolean) method.invoke(cla.newInstance(),chesspiece,deliverParameter.getStart_x(),deliverParameter.getStart_y(),deliverParameter.getEnd_x(),deliverParameter.getEnd_y() );

		JSONObject json=new JSONObject();
		if(flag==true) {
//			if(chesspiece[deliverParameter.getEnd_x()][deliverParameter.getEnd_y()]==null) {
//				chesspiece[deliverParameter.getEnd_x()][deliverParameter.getEnd_y()]=new Chesspiece(deliverParameter.getEnd_x(),deliverParameter.getEnd_y(),chesspiece[deliverParameter.getStart_x()][deliverParameter.getStart_y()].getCompetitor());
//				chesspiece[deliverParameter.getEnd_x()][deliverParameter.getEnd_y()].setChess(chesspiece[deliverParameter.getStart_x()][deliverParameter.getStart_y()].getChess());
//				chesspiece[deliverParameter.getStart_x()][deliverParameter.getStart_y()].setCompetitor(null);
//				chesspiece[deliverParameter.getStart_x()][deliverParameter.getStart_y()].setChess(null);//
//			}else {
//				chesspiece[deliverParameter.getEnd_x()][deliverParameter.getEnd_y()].setCompetitor(chesspiece[deliverParameter.getStart_x()][deliverParameter.getStart_y()].getCompetitor());//
//				chesspiece[deliverParameter.getEnd_x()][deliverParameter.getEnd_y()].setChess(chesspiece[deliverParameter.getStart_x()][deliverParameter.getStart_y()].getChess());
//				chesspiece[deliverParameter.getStart_x()][deliverParameter.getStart_y()].setCompetitor(null);
//				chesspiece[deliverParameter.getStart_x()][deliverParameter.getStart_y()].setChess(null);//
//			}
			
			ServletActionContext.getRequest().getSession().setAttribute("chessboard", chesspiece);
			json.put("result", "success");
		}else {
			json.put("result", "failure");
		}
		pw.write(json.toString());
		pw.flush();
		pw.close();
		return null;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		response=arg0;
	}

	@Override
	public DeliverParameter getModel() {
		// TODO 自动生成的方法存根
		return deliverParameter;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		session=arg0;
	}

	public DeliverParameter getDeliverParameter() {
		return deliverParameter;
	}

	public void setDeliverParameter(DeliverParameter deliverParameter) {
		this.deliverParameter = deliverParameter;
	}

}
