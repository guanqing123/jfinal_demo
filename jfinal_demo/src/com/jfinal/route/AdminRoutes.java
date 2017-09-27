package com.jfinal.route;

import com.jfinal.config.Routes;
import com.jfinal.controller.AdminController;
import com.jfinal.controller.RoleController;

public class AdminRoutes extends Routes {

	@Override
	public void config() {
		// TODO Auto-generated method stub
		add("/admin", AdminController.class);
		add("/admin/role", RoleController.class);
	}
}
