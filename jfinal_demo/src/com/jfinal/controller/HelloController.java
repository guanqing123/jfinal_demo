package com.jfinal.controller;

import com.jfinal.core.Controller;


public class HelloController extends Controller {
	
	
	/***
	 * Controller 以及在其中定义的 public 无参方法称为一个 Action。Action 是请求的最小单位。
	 * Action 方法必须在 Controller 中声明,该方法必须是 public 可见性且没有形参。
	 */
	
	/***
	 * http://localhost/hello
	 * http://localhost/hello/22-88
	 */
	public void index(){
		renderText("Hello JFinal World...[para(0) = "+getPara(0)+"] [para(1) = "+getPara(1)+"]");
	}
	
	/***
	 * http://localhost/hello/tianxia
	 */
	public void tianxia(){
		renderText("xin huai tian xia...");
	}
	
	/***
	 * 以上代码中定义了两个 Action：HelloController.index()、HelloController.test()。
	 * 在 Controller中提供了 getPara、getModel 系列方法 setAttr 方法以及 render 系列方法供 Action 使用。
	 */
}
