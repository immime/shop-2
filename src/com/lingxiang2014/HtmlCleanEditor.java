/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.lingxiang2014;

import java.beans.PropertyEditorSupport;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

public class HtmlCleanEditor extends PropertyEditorSupport {

	private boolean trim;

	private boolean emptyAsNull;

	private Whitelist whitelist = Whitelist.none();

	public HtmlCleanEditor(boolean trim, boolean emptyAsNull) {
		this.trim = trim;
		this.emptyAsNull = emptyAsNull;
	}

	public HtmlCleanEditor(boolean trim, boolean emptyAsNull, Whitelist whitelist) {
		this.trim = trim;
		this.emptyAsNull = emptyAsNull;
		this.whitelist = whitelist;
	}

	@Override
	public String getAsText() {
		Object value = getValue();
		return value != null ? value.toString() : "";
	}

	@Override
	public void setAsText(String text) {
		if (text != null) {
			String value = trim ? text.trim() : text;
			value = Jsoup.clean(value, whitelist);
			if (emptyAsNull && "".equals(value)) {
				value = null;
			}
			setValue(value);
		} else {
			setValue(null);
		}
	}

}