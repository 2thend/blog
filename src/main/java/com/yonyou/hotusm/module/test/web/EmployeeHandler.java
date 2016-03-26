package com.yonyou.hotusm.module.test.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yonyou.hotusm.module.test.dao.DepartmentDao;
import com.yonyou.hotusm.module.test.dao.EmployeeDao;
import com.yonyou.hotusm.module.test.entity.Employee;

/**
 * ����REST GET PUT PUT DELETE��ʽ
 * 
 * @author Hotusm
 *
 */
@Controller
public class EmployeeHandler {
	
	@Autowired
	protected EmployeeDao employeeDao;
	
	@Autowired
	protected DepartmentDao departmentDao;
	
	@ModelAttribute
	public Employee getEmployee(@RequestParam(value="id",required=false) Integer id){
		if(id!=null){
			return employeeDao.get(id);
		}
		return new Employee();
	}
	
	/**
	 * GET ��ʽ,��ʾȫ��Ա������Ϣ
	 * @param model
	 * @return
	 */
	@RequestMapping(value="emps",method=RequestMethod.GET)
	public String list(Model model){
		model.addAttribute("emps", employeeDao.getAll());
		return "/test/list";
	}
	/**
	 * GET ��ʾ��
	 * @return
	 */
	@RequestMapping(value="emp",method=RequestMethod.GET)
	public String input(Model model){
		/*��ʾ�Ա�ѡ��*/
		Map<String,String> map=new HashMap<String, String>();
		map.put("1", "��");
		map.put("0", "Ů");
		model.addAttribute("genders", map);
		/*��ʾ����*/
		model.addAttribute("departments", departmentDao.getDepartments());
		return "/test/input";
	}
	/**
	 * �������ݵı���
	 * @param employee
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value="emp",method=RequestMethod.POST)
	public String save(Employee employee,RedirectAttributes redirectAttributes){
		employeeDao.save(employee);
		redirectAttributes.addFlashAttribute("msg", "����ɹ�");
		return "redirect:emps";
	}
	/**
	 * DELETE
	 * @param id
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public String delete(Integer id,RedirectAttributes redirectAttributes){
		if(employeeDao.get(id)!=null){
			employeeDao.delete(id);
			redirectAttributes.addFlashAttribute("msg", "�����ɹ�");
		};
		return "redirect:emps";
	}
}
