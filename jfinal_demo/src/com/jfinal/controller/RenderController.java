package com.jfinal.controller;

import com.jfinal.core.Controller;

public class RenderController extends Controller {

	/***
	 * 除 renderError方法以外,在调用 render系列的方法后程序并不会立即返回,如果需要立即 返回需要使用 return 语句.
	 * 在一个 action 中多次调用 render 方法只有最后一次有效.
	 */
	public void index() {
		render("render.html");
	}
	
	public void render(){
		render("/views/jsp/render.jsp");
	}
}
