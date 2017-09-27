package com.jfinal.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class AuthInterceptor implements Interceptor {

	@Override
	public void intercept(Invocation inv) {
		// TODO Auto-generated method stub
		System.out.println("Before method invoking...");
		
		//获取 Action 调用的 Controller对象(仅用于控制层拦截)
		System.out.println("inv.getController()    = "+inv.getController());
		//获取 Action 调用的 action key 值(仅用于控制层拦截)
		System.out.println("inv.getActionKey() 	   = "+inv.getActionKey());
		//获取 Action 调用的 controller key 值(仅用于控制层拦截)
		System.out.println("inv.getControllerKey() = "+inv.getControllerKey());
		//获取 Action 调用的视图路径(仅用于控制层拦截)
		System.out.println("inv.getViewPath() 	   = "+inv.getViewPath());
		//获取被拦截方法所属的对象
		System.out.println("inv.getTarget()		   = "+inv.getTarget());
		//获取被拦截方法的 Method对象
		System.out.println("inv.getMethod()		   = "+inv.getMethod());
		//获取被拦截方法的方法名
		System.out.println("inv.getMethodName()	   = "+inv.getMethodName());
		//获取被拦截方法的所有参数值
		System.out.println("inv.getArgs()		   = "+inv.getArgs());
		//获取被拦截方法指定序号的参数值
		//System.out.println("inv.getArg(0)	   	   = "+inv.getArg(0));
		//获取被拦截方法的返回值
		System.out.println("inv.getReturnValue()   = "+inv.getReturnValue());
		//设置被拦截方法指定序号的参数值	inv.setArg(index, value);
		//设置被拦截方法的返回值			inv.setReturnValue(Object);
		//判断是否为 Action 调用,也即是否为控制层拦截
		System.out.println("inv.isActionInvocation() = "+inv.isActionInvocation());
		
		// url http://localhost/hello/tianxia
		/***
		 * inv.getController()    = com.jfinal.controller.HelloController@51782747
		 * inv.getActionKey() 	   = /hello/tianxia
		 * inv.getControllerKey() = /hello
		 * inv.getViewPath() 	   = /hello/
		 * inv.getTarget()		   = com.jfinal.controller.HelloController@51782747
		 * inv.getMethod()		   = public void com.jfinal.controller.HelloController.tianxia()
		 * inv.getMethodName()	   = tianxia
		 * inv.getArgs()		   = [Ljava.lang.Object;@3d5f151f
		 * inv.getReturnValue()   = null
		 * inv.isActionInvocation() = true
		 */
		inv.invoke(); // 传递本次调用,调用剩下的拦截器与目标方法
		
		System.out.println("After method invoking...");
	}

}
