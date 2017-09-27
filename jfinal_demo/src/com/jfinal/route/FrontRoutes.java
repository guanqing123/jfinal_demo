package com.jfinal.route;

import com.jfinal.config.Routes;
import com.jfinal.controller.BlogController;
import com.jfinal.controller.IndexController;

public class FrontRoutes extends Routes {

	@Override
	public void config() {
		// TODO Auto-generated method stub
		add("/", IndexController.class);
		add("/blog", BlogController.class);
	}
}
