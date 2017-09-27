package com.jfinal.controller;

import com.jfinal.core.Controller;

public class BlogController extends Controller {
	public void index() {
		renderText("BlogController request");
	}
}
