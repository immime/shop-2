
package com.lingxiang2014.service;

import java.util.List;

import com.lingxiang2014.Template;
import com.lingxiang2014.Template.Type;

public interface TemplateService {

	List<Template> getAll();

	List<Template> getList(Type type);

	Template get(String id);

	String read(String id);

	String read(Template template);

	void write(String id, String content);

	void write(Template template, String content);

}