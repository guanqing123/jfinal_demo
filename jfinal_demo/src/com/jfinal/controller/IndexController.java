package com.jfinal.controller;

import com.jfinal.core.Controller;

public class IndexController extends Controller {
	/***
	 * 
	 */
	public void index() {
		render("index.html");
	}
	
	public void show() {
		setAttr("attr", "setAttr(String, Object)转调了 HttpServletRequest.setAttribute(String, Object),该方法可以将 各种数据传递给 View 并在 View 中显示出来.");
		renderJsp("index.jsp");
	}
}
