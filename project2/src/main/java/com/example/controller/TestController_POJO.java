package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class TestController_POJO implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("������� ������ Ȯ��~!");
		
		ModelAndView mv1 = new ModelAndView("test");
		mv1.addObject("data1","������ mvc�� ���̿���~!");
//		mv1.setViewName("/WEB-INF/view/test.jsp");
		InternalResourceViewResolver resolver1;
		return mv1;
	}

}