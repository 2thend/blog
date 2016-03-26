package com.yonyou.hotusm.module.test.web;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.yonyou.hotusm.module.sys.entity.User;
import com.yonyou.hotusm.module.test.dao.EmployeeDao;
import com.yonyou.hotusm.module.test.entity.Employee;

/**
 * 
 * @author Hotusm
 * @since 2016-02-03
 * ����ʹ�õ�controller
 */
@RequestMapping("/test")
@Controller
public class TestController{
	
	@Autowired
	private EmployeeDao employeeDao;
	
	/**
	 * ͨ������bean������,��������Ӧ����ͼ
	 * 1.�Զ������ͼ�̳�View,���ڲ�ͬ����ͼ���Խ����ض���ҵ���߼�(����execl)
	 * @return
	 */
	@RequestMapping("/testView")
	public String testView(){
		System.out.println("testView...");
		int i=10/0;
		return "helloView";
	}
	
	/**
	 * �����ض���
	 * @return
	 */
	@RequestMapping("/testRedirect")
	public String testRedirect(){
		return "redirect:/f";
	}
	/**
	 * �����Զ���ת����
	 * 1.��ҳ����ֻ��Ҫ�����ַ���,���ܹ�ֱ�ӽ��ַ���ת��Ϊvo
	 * 2.��Ҫ��springmvc.xml�������Զ���ת����,���ҽ������õ�<mvc:annotation-driven />��
	 * 	<bean id="conversionService" class="org.springframework.context.support.ConversionServiceFactoryBean">
			<property name="converters" ref="userConversionService"/>
		</bean>+
		<mvc:annotation-driven conversion-service="conversionService"/>
		�����Ϳ������óɹ�
	 * @param user
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/testConversionService")
	public String testConversionService(@RequestParam("user") User user,HttpServletResponse response) throws IOException{
		response.getWriter().write(user.toString());
		System.out.println(user);
		return null;
	}
	/**
	 * 
	 * @param em
	 * @param response
	 * @param result
	 * @return
	 * @throws IOException
	 * 1.BindResult:��ʽ���������Ϣ����ͨ��BindResult����
	 * 
	 * .ʹ��ע��������ݵ�У��
	 * 
	 * 1).ʹ��JSR 303��֤��׼
	 * 2).����hibernate validator ��֤���
	 * 3).��springMVC �����ļ������<mvc:annotation-driven>ע��
	 * 4).��Ҫ��bean���͵���Ӧ���������Ӧ��ע��
	 * 5).��Ŀ�귽��(������)bean����ǰ�����@Validע��
	 * 6).��֤����ת����һ��ҳ��?
	 * ע��:��У���Bean�������󶨽�����������ǳɶԳ���,����֮ǰ�����������������������
	 * ����������:@Valid Employee em,BindingResult result�����������м䲻�ܳ��ֶ���
	 * �������͵����
	 * 7).������Ϣ?�����ʾ,����Ѵ�����Ϣ���й��ʻ�
	 */
	
	@RequestMapping("/testDefaultConversion")
	public String testDefaultConversion(@Valid Employee em,BindingResult result) throws IOException{
		System.out.println(em);
		List<FieldError> errors = result.getFieldErrors();
		if(errors.size()>0){
			for(FieldError fe:errors){
				System.out.println(fe.getField()+" : "+fe.getDefaultMessage());
			}
		}
		
		//response.getWriter().write(em.toString());
		return null;
	}
	/**
	 * ����ֱ��ʹ��servlet ԭ����API
	 * ������Щ���ǿ���ֱ��ʹ�õ�ԭ����Servlet��API:
	 * HttpServletRequest 
	 * HttpServletResponse 
	 * HttpSession
	 * java.security.Principal 
	 * Locale InputStream 
	 * OutputStream 
	 * Reader 
	 * Writer
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/testNative")
	public String testNativeRequest(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.getWriter().write("ֱ��ʹ��servlet ԭ����API");
		return null;
	}
	/**
	 * ����Json����
	 * 1.��Ҫע��<mvc:annotation-driven/>
	 * 2.��Ŀ�괦����ʹ��@ResponseBodyע��
	 * 3.���뼸��jackson��jar
	 * 
	 */
	@ResponseBody
	@RequestMapping("testJson")
	public List<?> testJson(){
		List<Employee> list= Lists.newArrayList();
		//list.add(new Employee("1", "hotusm1", 23, new Date()));
		//list.add(new Employee("2", "hotusm2", 22, new Date()));
		//list.add(new Employee("3", "hotusm3", 21, new Date()));
		//list.add(new Employee("4", "hotusm4", 20, new Date()));
		return list;
	}
	/**
	 * ����ʹ��MessageConverter
	 * 1.���ڲ�ͬ�ķ�����ʹ�ò�ͬ��MessageConverterʵ�֣�Ĭ����6��ʵ��
	 * @param body
	 * @return
	 */
	@RequestMapping("testMessageConverter")
	@ResponseBody
	public String testMessageConverter(@RequestBody String body){
		System.out.println(body);
		return "hello"+new Date();
	}
	/**
	 * 1.MessageConverter
	 * 	
	 * ResponseEntity<T>,HttpEntity<T>��Ϊ����������λ򷵻�ֵ
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("testResponseEntity")
	public ResponseEntity<byte[]> testResponseEntity() throws IOException{
		byte[] body=null;
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("/i18n.properties");
		body=new byte[in.available()];
		in.read(body);
		HttpHeaders headers=new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=i18n.properties");
		HttpStatus statusCode = HttpStatus.OK;
		ResponseEntity<byte[]> response=new ResponseEntity<byte[]>(body, headers, statusCode);
		return response;
	}
	@RequestMapping("HttpEntity")
	public HttpEntity<byte[]> testHttpEntity() throws IOException{
		byte[] body=null;
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("/i18n.properties");
		body=new byte[in.available()];
		in.read(body);
		HttpHeaders headers=new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=i18n.properties");
		//HttpStatus statusCode = HttpStatus.OK;
		HttpEntity<byte[]> entity=new HttpEntity<byte[]>(body, headers);
		return entity;
	}
	/**
	 * ����freemark
	 * 
	 */
	@RequestMapping("testFreemark")
	public String testFreemark(Model model){
		model.addAttribute("username", "hotusm");
		model.addAttribute("employees", employeeDao.getAll());
		model.addAttribute("flag", true);
		model.addAttribute("num", 18);
		return "/test/testFreemark";
	}
}
