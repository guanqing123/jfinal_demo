package com.jfinal.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.interceptor.BFInterceptor;
import com.jfinal.interceptor.BSInterceptor;
import com.jfinal.interceptor.BTInterceptor;

/***
 * @author information
 *	
 *	如下代码所示,Before可以将拦截器配置为 Class 级别与 Method 级别,前者将拦截本类 中所有方法,后者仅拦截本方法.
 *	此外 Before 可以同时配置多个拦截器,只需用在大括号内 用逗号将多个拦截器进行分隔即可.
 *
 */

// 配置一个Class级别的拦截器,她将拦截本类中的所有方法
@Before(BFInterceptor.class)
public class BeforeController extends Controller {
	
	// 配置多个Method级别的拦截器,仅拦截本方法
	@Before({BSInterceptor.class,BTInterceptor.class})
	public void index() {
		System.out.println("BeforeController index...");
		renderText("BeforeController...");
	}
	
	// 未配置Method级别的拦截器,但会被Class级别拦截器 BFInterceptor 所拦截
	public void show(){
		renderText("BeforeController show...");
	}
}
