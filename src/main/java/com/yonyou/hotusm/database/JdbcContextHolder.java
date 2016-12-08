package com.yonyou.hotusm.database;

public class JdbcContextHolder {
	
	private static final ThreadLocal<String> contextHodler=new ThreadLocal<String>();
	
	public static void setJdbcType(String jdbcType){
		contextHodler.set(jdbcType);
	}
	
	public static void setSlave(){
		setJdbcType("d1");
	}
	
	public static String  getJdbcType(){
		return contextHodler.get();
	}

	public static void clearJdbcType(){
		contextHodler.remove();
	}
}
