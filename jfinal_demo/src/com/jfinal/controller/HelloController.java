package com.jfinal.controller;

import com.jfinal.core.Controller;


public class HelloController extends Controller {
	
	
	/***
	 * Controller 以及在其中定义的 public 无参方法称为一个 Action。Action 是请求的最小单位。
	 * Action 方法必须在 Controller 中声明,该方法必须是 public 可见性且没有形参。
	 */
	
	/***
	 * 方法调用				返回值
	 * getPara("title")		返回页面表单域名为"title"参数值
	 * getParaToInt("age")	返回页面表单域名为"age"的参数值并转为 int 型
	 * getPara(0)			返回 url请求中的 urlPara 参数的第一个值,如 http://localhost/controllerKey/method/v0-v1-v2 这个请求将 返回"v0"
	 * getParaToInt(1)		返回 url请求中的 urlPara 参数的第二个值并转换成 int 型,如 http://localhost/controllerKey/method/2-5-9 这个请求将返回 5
	 * getParaToInt(2)		如 http://localhost/controllerKey/method/2-5-N8 这个 请求将返回 -8。注意：约定字母 N 与 n 可以表示负 号,这对 urlParaSeparator 为  "-" 时非常有用。
	 * getPara()			返回 url 请求中的 urlPara 参数的整体值,如 http://localhost/controllerKey/method/v0-v1-v2 这个 请求将返回"v0-v1-v2"
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
