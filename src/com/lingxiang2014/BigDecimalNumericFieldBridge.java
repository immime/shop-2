/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.lingxiang2014;

import java.math.BigDecimal;

import org.apache.lucene.document.Document;
import org.hibernate.search.bridge.LuceneOptions;
import org.hibernate.search.bridge.builtin.NumericFieldBridge;

public class BigDecimalNumericFieldBridge extends NumericFieldBridge {

	public Object get(String name, Document document) {
		return new BigDecimal(document.getFieldable(name).stringValue());
	}

	@Override
	public void set(String name, Object value, Document document, LuceneOptions luceneOptions) {
		if (value != null) {
			BigDecimal decimalValue = (BigDecimal) value;
			luceneOptions.addNumericFieldToDocument(name, decimalValue.doubleValue(), document);
		}
	}

}