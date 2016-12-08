package com.yonyou.hotusm.common.web.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

/**
 * �Զ�����ͼ,ͨ��
 * @author Hotusm
 * @since 2016-02-03
 */
@Component
public class HelloView implements View{

	public String getContentType() {
		return "text/html;charset=UTF-8";
	}

	public void render(Map<String, ?> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.getWriter().write("�Զ�����ͼ");
	}

}
