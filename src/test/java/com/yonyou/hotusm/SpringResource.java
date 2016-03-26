package com.yonyou.hotusm;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class SpringResource {
	
	//spring提供了一系列的Resource
	//比如下面的几个：
//	 * @see ContextResource
//	 * @see FileSystemResource
//	 * @see ClassPathResource
//	 * @see UrlResource
//	 * @see ByteArrayResource
//	 * @see InputStreamResource
//	 * @see PathResource
	@Test
	public void test1() throws IOException{
		
		Resource resource=new FileSystemResource("pom.xml");
		String filename = resource.getFilename();
		InputStream inputStream = resource.getInputStream();
		byte[] b=new byte[1024];
		int len=-1;
		while((len=inputStream.read(b))!=-1){
			System.out.println(new String(b));
		}
		String description = resource.getDescription();
		System.out.println("name:"+filename);
		System.out.println("description:"+description);
	}
}	
