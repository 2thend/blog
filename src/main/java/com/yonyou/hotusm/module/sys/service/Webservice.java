package com.yonyou.hotusm.module.sys.service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yonyou.hotusm.common.mapper.JsonMapper;
import com.yonyou.hotusm.module.sys.entity.CityInfo;
import com.yonyou.hotusm.module.sys.entity.Weather;

import cn.com.WebXml.WeatherWebServiceLocator;
import cn.com.WebXml.WeatherWebServiceSoap;

/**
 * 
 * @author Hotusm
 *
 */
@Service
public class Webservice {
	
	private String url="http://ip.taobao.com/service/getIpInfo.php?ip=";
	/**
	 * ���ݳ������ƻ�ȡ����
	 * @param cityName
	 * @return
	 * @throws Exception
	 */
	public Weather getWeather(String cityName) throws Exception{
		Weather w=new Weather();
		w.setCityName(cityName);
		WeatherWebServiceLocator wwl=new WeatherWebServiceLocator();
		WeatherWebServiceSoap weatherWebService = wwl.getWeatherWebServiceSoap();
		String[] weatherInfo = weatherWebService.getWeatherbyCityName(cityName);
		if(weatherInfo!=null){
			String tem=weatherInfo[5];
			w.setTem(tem);
			w.setData(weatherInfo[6]);
		}
		return w;
	}
	/**
	 * ����ip��ȡ���ڵصĳ�����
	 * @return
	 */
	
	public String getCity(String ip){
		HttpURLConnection connection=null;
		URL urlStr;
		//��Ϊ���Ե�ʱ�� ���ص�ip����ʾ0.0.0...1 ������д���ص�
		if(ip==null){
			return "����";
		}
		//����json
		String jsonString="";
		String city="";
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
			city=entity.getData().getRegion();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(connection!=null){
				connection.disconnect();
			}
		}
		
		return city;
	}
}

