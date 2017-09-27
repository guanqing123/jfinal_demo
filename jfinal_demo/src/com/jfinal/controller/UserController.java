package com.jfinal.controller;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;


public class UserController extends Controller {
	
	/***
	 * http://localhost/user/
	 */
	public void index(){
		renderText("UserController index");
	}
	
	/***
	 * 在使用了@ActionKey("/login")注解以 后，actionKey 由原来的"/user/login"变为了"/login"
	 * 完整访问地址: http://localhost/login
	 * 这个请求去哪了呢? http://localhost/user/login 其实,它访问了上面 index 方法了,login成了参数了
	 */
	@ActionKey("/login")
	public void login(){
		render("login.html");
	}
}
