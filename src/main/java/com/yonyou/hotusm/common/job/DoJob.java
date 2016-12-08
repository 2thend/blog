package com.yonyou.hotusm.common.job;

import java.util.Date;

import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
//@Lazy(false)
public class DoJob {
	
	//@Scheduled(cron="0 * * * * ?")
	public void doJob(){
		System.out.println("定时执行任务"+new Date().toLocaleString());
	}
}
