package com.yonyou.hotusm.common.persistence.interceptor;

import java.util.Properties;
import java.util.concurrent.Executor;

import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

@Intercepts({  
    @Signature(type = Executor.class, method = "update", args = {  
            MappedStatement.class, Object.class }),  
    @Signature(type = Executor.class, method = "query", args = {  
            MappedStatement.class, Object.class, RowBounds.class,  
            ResultHandler.class }) })
public class BaseInterceptor implements Interceptor{

	public Object intercept(Invocation invocation) throws Throwable {
		
		Object[] args = invocation.getArgs();
		for(Object o:args){
			System.out.println(o.toString());
		}
		System.out.println("BaseInterceptor...");
		return invocation.proceed();
	}

	public Object plugin(Object arg0) {
		return null;
	}

	public void setProperties(Properties arg0) {
		
	}
	
}
