package com.yonyou.hotusm.module.sys.web;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yonyou.hotusm.common.servlet.ValidateCodeServlet;
import com.yonyou.hotusm.common.utils.CutImageUtil;
import com.yonyou.hotusm.common.utils.IdGen;
import com.yonyou.hotusm.common.utils.OSSStore;
import com.yonyou.hotusm.common.utils.SpringContextHolder;
import com.yonyou.hotusm.common.web.BaseController;
import com.yonyou.hotusm.database.DynamicDataSource;
import com.yonyou.hotusm.module.cms.service.ArticleService;
import com.yonyou.hotusm.module.sys.entity.User;
import com.yonyou.hotusm.module.sys.service.UserService;
import com.yonyou.hotusm.module.sys.util.UserUtils;
/**
 * 
 * �û�Controller
 * @author Hotusm
 *
 */

@Controller
public class UserContorller extends BaseController{
	
	@Autowired
	protected UserService userService;
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	DynamicDataSource dynamicDataSource;
	
	@RequestMapping(method=RequestMethod.GET,value="${adminPath}/login")
	public String login(Model model){
		User user=UserUtils.getUser();
		if(user.getLoginName()!=null){
			return "sys/index";
		}
		return "sys/login";
	}
	
	
	@RequestMapping(value = "${adminPath}/login", method = RequestMethod.POST)
	public String loginFail(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "sys/login";
	}
	//-------test-------
	@RequestMapping(value = "${adminPath}/dataSource")
	public String change(Model model){
		User user=new User();
		user.setLoginName("superadmin");
		User user2 = userService.getUser(user);
		model.addAttribute("user", user2);
		return "sys/dataSource";
	}
	@RequestMapping(value = "${adminPath}/changeSource")
	public String changeDatasource(Model model){
		User user=new User();
		user.setLoginName("superadmin");
		com.mchange.v2.c3p0.ComboPooledDataSource datasource = SpringContextHolder.getBean("dataSource1");
		Object o=SpringContextHolder.getBean("sqlSessionFactory");
		String name = o.getClass().getName();
		System.out.println(name);
		User user2 = userService.getUser(user);
		model.addAttribute("user", user2);
		return "sys/dataSource";
	}
	//��½�ɹ�
	@RequiresPermissions("user")
	@RequestMapping(value="${adminPath}")
	public String index(User user,Model model){
		if(user.getLoginFlag()==null){
			String loginName=UserUtils.getUser().getLoginName();
			user.setLoginName(loginName);
		}
		userService.getUser(user);
		model.addAttribute("user", user);
//		Article article=new Article();
//		article.setTitle("111");
//		article.setType("222");
//		Category c=new Category();
//		c.preInsert();
//		article.setCategory(c);
//		articleService.save(article);
		
		return "sys/main";
	}
	
	@RequestMapping("${adminPath}/register")
	public String register(User user,Model model,HttpServletRequest request){
		String password=user.getPassword();
		String loginName=user.getLoginName();
		if(!StringUtils.isBlank(password)&user!=null&!StringUtils.isBlank(loginName)){
			String pwd=userService.encryptionPassword(password);
			System.out.println(pwd);
			user.setPassword(pwd);
			userService.save(user);
			return "sys/login";
		}
		String method=request.getMethod();
		if(method.equals("POST")){
			model.addAttribute("errMsg", "������Ϣ����");
		}
		
		return "sys/reg";
	}
	@RequestMapping(value="${adminPath}/saveInfo",method=RequestMethod.POST)
	public String saveInfo(User user,Model model){
		userService.update(user);
		User temp=UserUtils.getUser();
		model.addAttribute("user", temp);
		return "sys/fixUserinfo";
	}
	@RequestMapping("fixUserinfo")
	public String fixUserinfo(Model model){
		User user=UserUtils.getUser();
		model.addAttribute("user", user);
		return "sys/fixUserinfo";
	}
	@RequestMapping("choosePhoto")
	public String choosePhoto(){
		return "sys/choosePhoto";
	}
	@RequestMapping(value="${adminPath}/upload",method=RequestMethod.POST)
    public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, Model model) throws MalformedURLException {  
        String path= request.getRealPath("/")+"upload\\";
        String fileName =file.getOriginalFilename();
        //��ȡͼƬ�ĺ�׺��
        int photoIndex=fileName.lastIndexOf(".");
        String photoName=fileName.substring(photoIndex, fileName.length());
        //�ж��ǲ���ͼƬ
        String suffixs[]={"JPG","GIF","JPEG","PNG"};
		boolean flag=false;
		for(String temp:suffixs){
			if(temp.equals(photoName.replace(".", "").toUpperCase())){
				flag=true;
			}
		}
		if(!flag){
			model.addAttribute("error", "�ϴ���ʽ�д�");
			 return "sys/choosePhoto";
		}
        fileName=IdGen.uuid()+photoName;
        File targetFile = new File(path, fileName);  
        if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }  
        //����  
        try {  
            file.transferTo(targetFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }

        String imagePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
        String url= imagePath+"upload/"+fileName;
        model.addAttribute("url", url);  
  
        return "sys/choosePhoto";  
    }
	@ResponseBody
	@RequestMapping(value = "${adminPath}/saveImg")
	public String saveImg(HttpServletRequest request,Integer x,Integer y,Integer width,Integer height,String src){
		String suffixs[]={"JPG","GIF","JPEG","PNG"};
		User user=UserUtils.getUser();
		//��ȡ�ļ��е�·��
		String uploadPath =request.getRealPath("/")+"upload/";
		
		//��ȡԭ��ͼƬ������
		int photoIndex=src.lastIndexOf("/");
		String photoName=src.substring(photoIndex, src.length());
		//ͼƬ��׺
		int lastIndex=src.lastIndexOf(".");
		String suffix=src.substring(lastIndex+1, src.length());
		//�ж��ǲ�������ļ��ָ�ʽ
		boolean flag=false;
		for(String temp:suffixs){
			if(temp.equals(suffix.toUpperCase())){
				flag=true;
			}
		}
		if(!flag){
			return user.getPhoto();
		}
		//ԭ��û�н�ȡͼƬ��λ��
		String realPath=request.getRealPath("/")+"upload\\"+photoName;
		//���ý�ȡ��ͼƬ������
		String fileName=IdGen.uuid()+"."+suffix;
		//��Ž�ȡͼƬ�ĵ�ַ
		String targetFile=uploadPath+"images/"+fileName;
		//��ȡ��ͼƬ�������ַ
		String imgUrl=src.substring(0,photoIndex)+"/images/"+fileName;
		
		CutImageUtil.cutImg(realPath,targetFile, x, y, width, height,suffix);
		String bucketName="hotusm";
		String path="";
		try {
			OSSStore.putObject(bucketName, "userfile/"+fileName, targetFile);
			path="http://hotusm.oss-cn-beijing.aliyuncs.com/userfile/"+fileName;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		File temp=new File(targetFile);
		if(temp.exists()){
			temp.delete();
		}
		//ɾ��ԭ��������ͼƬ
		temp=new File(realPath);
		if(temp.exists()){
			temp.delete();
		}
		
		//�������ͼƬ����,��ô���¸�����Ϣ
		user.setPhoto(path);
		
		userService.update(user);
		return path;
	}
	@ResponseBody
	@RequestMapping("${adminPath}/validate")
	public boolean validate(HttpServletRequest request,String code){
		boolean flag=ValidateCodeServlet.validate(request, code);
		return flag;
	}

}
