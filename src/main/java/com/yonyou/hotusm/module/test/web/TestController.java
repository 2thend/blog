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
 * 测试使用的controller
 */
@RequestMapping("/test")
@Controller
public class TestController{
	
	@Autowired
	private EmployeeDao employeeDao;
	
	/**
	 * 通过返回bean的名字,来解析相应的视图
	 * 1.自定义的视图继承View,对于不同的视图可以进行特定的业务逻辑(比如execl)
	 * @return
	 */
	@RequestMapping("/testView")
	public String testView(){
		System.out.println("testView...");
		int i=10/0;
		return "helloView";
	}
	
	/**
	 * 测试重定向
	 * @return
	 */
	@RequestMapping("/testRedirect")
	public String testRedirect(){
		return "redirect:/f";
	}
	/**
	 * 测试自定义转化器
	 * 1.在页面中只需要输入字符串,就能够直接将字符串转化为vo
	 * 2.需要在springmvc.xml中配置自定义转换器,并且将其设置到<mvc:annotation-driven />中
	 * 	<bean id="conversionService" class="org.springframework.context.support.ConversionServiceFactoryBean">
			<property name="converters" ref="userConversionService"/>
		</bean>+
		<mvc:annotation-driven conversion-service="conversionService"/>
		这样就可以配置成功
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
	 * 1.BindResult:格式化错误的信息可以通过BindResult传递
	 * 
	 * .使用注解进行数据的校验
	 * 
	 * 1).使用JSR 303验证标准
	 * 2).加入hibernate validator 验证框架
	 * 3).在springMVC 配置文件中添加<mvc:annotation-driven>注解
	 * 4).需要在bean类型的相应属性添加相应的注解
	 * 5).在目标方法(处理器)bean类型前面加上@Valid注解
	 * 6).验证出错转向哪一个页面?
	 * 注意:需校验的Bean对象和其绑定结果或错误对象是成对出现,他们之前不允许出现声明其他的类型
	 * 下面例子中:@Valid Employee em,BindingResult result这两个对象中间不能出现定义
	 * 其他类型的入参
	 * 7).错误消息?如何显示,如果把错误消息进行国际化
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
	 * 可以直接使用servlet 原生的API
	 * 下面这些都是可以直接使用的原生的Servlet的API:
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
		response.getWriter().write("直接使用servlet 原生的API");
		return null;
	}
	/**
	 * 测试Json数据
	 * 1.需要注解<mvc:annotation-driven/>
	 * 2.在目标处理器使用@ResponseBody注解
	 * 3.加入几个jackson的jar
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
	 * 测试使用MessageConverter
	 * 1.对于不同的返回体使用不同的MessageConverter实现，默认有6个实现
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
	 * ResponseEntity<T>,HttpEntity<T>做为处理方法的入参或返回值
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
	 * 测试freemark
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
