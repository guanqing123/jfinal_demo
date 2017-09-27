package com.jfinal.controller;

import com.jfinal.core.Controller;

public class AdminController extends Controller {
	public void index() {
		renderText("AdminController request...");
	}
}
