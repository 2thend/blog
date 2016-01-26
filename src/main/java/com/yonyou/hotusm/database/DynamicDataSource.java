package com.yonyou.hotusm.database;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource{

	@Override
	protected Object determineCurrentLookupKey() {
		
		return JdbcContextHolder.getJdbcType();
	}

}
