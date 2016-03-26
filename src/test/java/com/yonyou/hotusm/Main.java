package com.yonyou.hotusm;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

import com.google.common.collect.Lists;
import com.yonyou.hotusm.common.mapper.JsonMapper;
import com.yonyou.hotusm.module.sys.entity.User;


public class Main {
	private static String url="http://ip.taobao.com/service/getIpInfo.php?ip=";
	public static void main(String[] args) {
		HttpURLConnection connection=null;
		URL urlStr;
		//����json
		String ip="111.206.82.163";
		String jsonString="";
		try {
			urlStr = new URL(url+ip);
			connection = (HttpURLConnection) urlStr.openConnection();
			connection.setDoOutput(true);
			//OutputStream outputStream = connection.getOutputStream();
			InputStream inputStream = connection.getInputStream();
			Reader reader=new InputStreamReader(inputStream,"utf-8");
			char[] a=new char[1024];
			reader.read(a);
			jsonString=new String(a).trim();
			CityInfo entity=(CityInfo) JsonMapper.fromJsonString(jsonString, CityInfo.class);
			System.out.println(entity);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(connection!=null){
				connection.disconnect();
			}
		}
	}
	
	@Test
	public void testCxf(){
		ApplicationContext atx=new ClassPathXmlApplicationContext("spring-soap-server.xml");
		Object object=atx.getBean("cxf");
		System.out.println(object==null?"null":"not nulll");
	}
	
	@Test
	public void testEncryption(){
		
		String password=new Md5Hash("1234","loginName",1024).toString();
		System.out.println(password);
	}
	@Test
	public void testAbstract(){
		//a.isAssignableFrom(b)��ʾ����b�Ƿ���a��ͬ���ͻ������������a�Ƿ���b�̳еĽӿ�
		boolean assignableFrom = Object.class.isAssignableFrom(User.class);
		System.out.println(assignableFrom);
		
		new Runnable() {
			
			@Override
			public void run() {
				
			}
		};
	}
	
	class RunnableImpl implements Runnable{
		
		private List<String> alreadyExist;
		private CountDownLatch downLatch;
		private User user;
		private String schema;

		public RunnableImpl(List<String> alreadyExist,
				CountDownLatch downLatch, User user,String schema) {
			super();
			this.alreadyExist = alreadyExist;
			this.downLatch = downLatch;
			this.user = user;
			this.schema=schema;
		}
		@Override
		public void run() {
			
		}
		
	}
	
	@Test
	public void testMapEntry(){
		
		Map<Integer,User> map=new HashMap<Integer,User>();
		User user=null;
		for(int i=0;i<10;i++){
			user=new User();
			user.setName("user"+i);
			map.put(i, user);
		}
		//��Map.entrySet()��ȡ���ļ�ֵ�Ը�ֵ���ڲ���Entry�����м���key,value�Ƕ�Ӧ��value
		for(Map.Entry<Integer, ? extends User> entry:map.entrySet()){
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
	}
	@Test
	public void testAssert(){
		Assert.notNull(null);
	}
	//����Collections.unmodifiableMap(map);
	//�����̬�������ص�map���ܱ��޸�,����޸ĵĻ� ,��ô�ͻ��׳�
	//UnsupportedOperationException����쳣
	@Test
	public void testunmodifiableMap(){
		
		Map<String,String> map=new HashMap<String,String>();
		for(int i=0;i<10;i++){
			map.put("i"+i, "1"+i);
		}
		Map<String, String> map2 = Collections.unmodifiableMap(map);
		map2.put("212", "22");
	}
	
	@Test
	//��õ�ǰ�̵߳��������
	public void testClassLoader(){
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		int hashCode = contextClassLoader.hashCode();
		System.out.println(hashCode);
	}
	//spring�ṩ�Ĺ����� ObjectUtils
	@Test
	public void testObjectUtil(){
		List list=Lists.newArrayList();
		boolean isArray = ObjectUtils.isArray(list);
		System.out.println(isArray);
		Object[] array = list.toArray();
		boolean isEmpty = ObjectUtils.isEmpty(array);
		System.out.println(isEmpty);
		
	}
	
}



