package com.jfinal.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.controller.HelloController;
import com.jfinal.controller.UserController;
import com.jfinal.handler.ResourceHandler;
import com.jfinal.interceptor.AuthInterceptor;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.redis.RedisPlugin;
import com.jfinal.route.AdminRoutes;
import com.jfinal.route.FrontRoutes;
import com.jfinal.template.Engine;

public class DemoConfig extends JFinalConfig {

	/***
	 * 此方法用来配置 JFinal 常量值，如开发模式常量 devMode 的配置，默认视图类型 ViewType的配置，如下代码配置了 JFinal 运行在开发模式下且默认视图类型为 JSP
	 * 在开发模式下，JFinal 会对每次请求输出报告，如输出本次请求的 Controller、Method 以 及请求所携带的参数。JFinal 支持 JSP、FreeMarker、Velocity 三种常用视图
	 */
	@Override
	public void configConstant(Constants me) {
		// TODO Auto-generated method stub
		me.setDevMode(true);
		//me.setViewType(ViewType.JSP);	如下代码配置了 JFinal 运行在开发模式下且默认视图类型为 JSP
	}

	
	/***
	 * 此方法用来配置 JFinal 访问路由，如下代码配置了将”/hello”映射到 HelloController 这个控 制器 ， 
	 * 通 过 以 下 的 配 置 ， http://localhost/hello 将 访 问 HelloController.index() 方法，
	 * 而 http://localhost/hello/methodName 将访问到 HelloController.methodName()方法。
	 */
	@Override
	public void configRoute(Routes me) {
		// TODO Auto-generated method stub
		me.add("/hello", HelloController.class);
		me.add("/user", UserController.class);
		
		me.add(new FrontRoutes()); // 前端路由
		me.add(new AdminRoutes()); // 后端路由
		/**
		 * 如果 JFinal 默认路由规则不能满足需求，开发者还可以根据需要使用 Handler 定制更加个 性化的路由，大体思路就是在 Handler 中改变第一个参数 String target 的值。
		 * JFinal 路由还可以进行拆分配置，这对大规模团队开发特别有用.
		 * FrontRoutes 类中配置了系统前端路由，AdminRoutes 配置了系统后端路由， DemoConfig.configRoute(…)方法将拆分后的这两个路由合并起来。
		 * 使用这种拆分配置不仅 可以让 DemoConfig 文件更简洁， 而且有利于大规模团队开发， 避免多人同时修改 DemoConfig 时的版本冲突。
		 */
	}

	@Override
	public void configEngine(Engine me) {
		// TODO Auto-generated method stub

	}

	/***
	 * 此方法用来配置 JFinal 的 Plugin，如下代码配置了 C3p0 数据库连接池插件与 ActiveRecord数据库访问插件。
	 * 通过以下的配置，可以在应用中使用 ActiveRecord 非常方便地操作数据库。
	 */
	@Override
	public void configPlugin(Plugins me) {
		// TODO Auto-generated method stub
		loadPropertyFile("pool.properties");
		C3p0Plugin c3p0Plugin = new C3p0Plugin(getProperty("erp.url"),getProperty("erp.username"),getProperty("erp.password"));
		me.add(c3p0Plugin);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		me.add(arp);
		//arp.addMapping("user",User.class);
		
		// 非第一次使用use加载的配置，需要通过每次使用use来指定配置文件名再来取值
		/*String redisHost = PropKit.use("redis.properties").get("host");
		int redisPort = PropKit.use("redis.properties").getInt("port");
		RedisPlugin rp = new RedisPlugin("myRedis", redisHost, redisPort);
		me.add(rp);*/
		
		// 非第一次使用 use加载的配置，也可以先得到一个Prop对象，再通过该对象来获取值 
		/*Prop prop = PropKit.use("pool.properties");
		DruidPlugin dp = new DruidPlugin(prop.get("jdbcUrl"), prop.get("user"), prop.get("password"));
		me.add(dp);*/
	}

	/***
	 * 此方法用来配置 JFinal的全局拦截器,全局拦截器将拦截所有 action请求,除非使用@Clear在 Controller中清除,如下代码配置了名为 AuthInterceptor的拦截器。
	 * JFinal 的 Interceptor 非常类似于 Struts2,但使用起来更方便,Interceptor 配置粒度分为 Global、Class、Method 三个层次，其中以下代码配置粒度为全局。
	 * Class 与 Method 级的 Interceptor 配置将在后续章节中详细介绍。
	 */
	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub
		//me.add(new AuthInterceptor());
	}

	/***
	 * 此方法用来配置 JFinal 的 Handler，如下代码配置了名为 ResourceHandler 的处理器，Handler 可以接管所有 web 请求，并对应用拥有完全的控制权，可以很方便地实现更高层的功能性扩 展。
	 */
	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub
		//me.add(new ResourceHandler());
	}
	
	/***
	 * JFinalConfig 中的 afterJFinalStart()与 beforeJFinalStop()方法供开发者在 JFinalConfig 继承类中 覆盖 。
	 * JFinal 会在系统启动完成后回调 afterJFinalStart() 方 法 ,会 在 系 统 关 闭 前 回 调 beforeJFinalStop()方法。
	 * 这两个方法可以很方便地在项目启动后与关闭前让开发者有机会进行 额外操作，如在系统启动后创建调度线程或在系统关闭前写回缓存。
	 */
	@Override
	public void afterJFinalStart() {
		// TODO Auto-generated method stub
		super.afterJFinalStart();
		// 第一次使用use加载的配置将成为主配置,可以通过PropKit.get(...)直接取值 
		PropKit.use("other.properties");
		System.out.println("guanqing = "+PropKit.get("name")+"\t age="+PropKit.get("age")+"\t birthday="+PropKit.get("birthday"));
	}
	/***
	 * PropKit 可同时加载多个配置文件,第一个被加载的配置文件可以使用 PorpKit.get(…)方法直接操作,非第一个被加载的配置文件则需要使用 PropKit.use(…).get(…) 来操作。
	 * PropKit 的使用并不限于在 YourJFinalConfig 中,可以在项目的任何地方使用, JFinalConfig 的 getProperty 方法其底层依赖于 PropKit 实现。
	 */
	
	
	@Override
	public void beforeJFinalStop() {
		// TODO Auto-generated method stub
		super.beforeJFinalStop();
		System.out.println("beforeJFinalStop ...");
	}
	
}
