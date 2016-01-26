package com.yonyou.hotusm.common.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

public class ValidateCodeServlet extends HttpServlet{
	
	private static final String VALIDATE_CODE="vaildateCode";
	
	private int h=30;
	private int w=70;

	/**
	 * 
	 */
	private static final long serialVersionUID = -6432197944091004247L;
	
	public static boolean validate(HttpServletRequest request,String validateCode){
		if(StringUtils.isBlank(validateCode)){
			return false;
		}
		String code=(String) request.getSession().getAttribute(VALIDATE_CODE);
		return validateCode.toUpperCase().equals(code);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String vaildateCode=req.getParameter(VALIDATE_CODE);
		if(!StringUtils.isBlank(vaildateCode)){
			resp.getOutputStream().print(validate(req,vaildateCode)?true:false);
		}else{
			doPost(req, resp);
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		createImage(req, resp);
		
	}
	
	public void createImage(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpg");
		
		/**
		 * 取得高度和宽度
		 * 
		 */
		String width=request.getParameter("width");
		String height=request.getParameter("height");
		
		if(StringUtils.isNumeric(width)&&StringUtils.isNumeric(height)){
			
			w=NumberUtils.toInt(width);
			h=NumberUtils.toInt(height);
		}
		/**
		 * 
		 * 
		 */
		BufferedImage image=new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
		Graphics g=image.getGraphics();
		createBackground(g);
		/**
		 * 
		 */
		String s=createCharacter(g);
		request.getSession().setAttribute(VALIDATE_CODE, s);
		g.dispose();
		OutputStream out=response.getOutputStream();
		ImageIO.write(image, "JPEG", out);
		out.close();
		
		
		
	}
	
	public void createBackground(Graphics g){
		g.setColor(getRandColor(220,250));
		g.fillRect(0, 0, w, h);
		for(int i=0;i<8;i++){
			g.setColor(getRandColor(40,150));
			Random random=new Random();
			int x=random.nextInt(w);
			int y=random.nextInt(h);
			int x1=random.nextInt(w);
			int y1=random.nextInt(h);
			g.drawLine(x, y, x1, y1);
			
		}
		
	}
	
	private String createCharacter(Graphics g){
		
		char[] codeSeq = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J',
				'K', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
				'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7', '8', '9' };
		String[] fontType={"Arial","Arial Black","AvantGarde Bk BT","Calibri"};
		Random random=new Random();
		StringBuffer s=new StringBuffer();
		for(int i=0;i<4;i++){
			String r=String.valueOf(codeSeq[random.nextInt(codeSeq.length)]);
			g.setColor(new Color(50+random.nextInt(100),50+random.nextInt(100),50+random.nextInt(100)));
			g.setFont(new Font(fontType[random.nextInt(fontType.length)],Font.BOLD,26));
			g.drawString(r, 15*i+5, 19+random.nextInt(8));
			s.append(r);
		}
		
		return s.toString();
	}
	
	private Color getRandColor(int fc,int bc){
		int f=fc;
		int b=bc;
		Random random=new Random();
		if(f>255){
			f=255;
		}
		if(b>255){
			b=255;
		}
		return new Color(f+random.nextInt(b-f),f+random.nextInt(b-f),f+random.nextInt(b-f));
	}
	
	
}
