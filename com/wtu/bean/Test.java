package com.wtu.bean;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class classs=Class.forName("com.wtu"
				+ ".bean.Ju");
//		Constructor[] con=classs.getConstructors();
//		Chess chess=(Chess)con[0].newInstance();
		Method method=classs.getMethod("add", int.class,int.class);
		int a=(int)method.invoke(classs.newInstance(), 1,2);
		System.out.println(a);
	}
}
