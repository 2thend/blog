package com.yonyou.hotusm.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.aliyun.openservices.oss.OSSClient;
import com.aliyun.openservices.oss.model.ObjectMetadata;
import com.aliyun.openservices.oss.model.PutObjectResult;


public class OSSStore {
	
	
	private static String accessKeyId="1uZphMnXDWHt7zz7";
	private static String accessKeySecret="0tUBFSr2RpNBRpsQdWB0RuJzfLLF4q";
	private static String endpoint="http://oss-cn-beijing.aliyuncs.com";
	/**
	 * 
	 * @param bucketName 
	 * @param key  �ļ�����
	 * @param filePath	Ŀ���ļ���λ�ã�ֵ���ǽ��Ѹ��ļ����ļ��ϴ���
	 * @throws FileNotFoundException 
	 */
	public  static void putObject(String bucketName,String key,String filePath) throws FileNotFoundException{
		OSSClient client=new OSSClient(endpoint,accessKeyId,accessKeySecret);
		File file=new File(filePath);
		InputStream input=new FileInputStream(file);
		ObjectMetadata meta=new ObjectMetadata();
		meta.setContentLength(file.length());
		PutObjectResult result=client.putObject(bucketName, key, input, meta);
	}
}
