package com.jfinal.model;

import com.jfinal.plugin.activerecord.Model;

public class Blog extends Model<Blog> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//声明一个全局操作的变量
	public final static Blog blog = new Blog();
}
