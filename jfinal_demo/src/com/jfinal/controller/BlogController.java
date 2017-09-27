package com.jfinal.controller;

import com.jfinal.core.Controller;
import com.jfinal.model.Blog;

public class BlogController extends Controller {
	public void index() {
		renderText("BlogController request");
	}
	
	/***
	 * 下面代码中，表单域采用了"blog.title"、"blog.content"作为表单域的 name属性,"blog"是类 文件名称"Blog"的首字母变小写,
	 * "title"是 blog数据库表的 title字段,如果希望表单域使用任 意的 modelName,只 需 要 在 getModel时 多 添 加 一 个 参 数 来 指 定, 
	 * 例 如 :getModel(Blog.class, "otherName").
	 */
	public void saveFirst() {
		Blog blog = getModel(Blog.class);
		
		System.out.println("blog 1>"+blog);
		
		blog = getModel(Blog.class, "test");
	
		System.out.println("blog 2>"+blog);
		
		renderText("BlogController request saveFirst...");
	}
	
	/***
	 * 如果希望传参时避免使用 modelName前缀,可以使用空串作为 modelName来实现:
	 * getModel(Blog.class, ""); 这对开发纯 API项目非常有用.
	 */
	public void saveSecond() {
		Blog blog = getModel(Blog.class, "");
		
		System.out.println("blog 1>"+blog);
		
		renderText("BlogController request saveSecond...");
	}
}
