/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.lingxiang2014;

import java.net.URLEncoder;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.util.Assert;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class ExcelView extends AbstractExcelView {

	private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

	private String filename;

	private String sheetName;

	private String[] properties;

	private String[] titles;

	private Integer[] widths;

	private Converter[] converters;

	private Collection<?> data;

	private String[] contents;

	static {
		DateConverter dateConverter = new DateConverter();
		dateConverter.setPattern(DEFAULT_DATE_PATTERN);
		ConvertUtils.register(dateConverter, Date.class);
	}

	public ExcelView(String filename, String sheetName, String[] properties, String[] titles, Integer[] widths, Converter[] converters, Collection<?> data, String[] contents) {
		this.filename = filename;
		this.sheetName = sheetName;
		this.properties = properties;
		this.titles = titles;
		this.widths = widths;
		this.converters = converters;
		this.data = data;
		this.contents = contents;
	}

	public ExcelView(String[] properties, String[] titles, Collection<?> data, String[] contents) {
		this.properties = properties;
		this.titles = titles;
		this.data = data;
		this.contents = contents;
	}

	public ExcelView(String[] properties, String[] titles, Collection<?> data) {
		this.properties = properties;
		this.titles = titles;
		this.data = data;
	}

	public ExcelView(String[] properties, Collection<?> data) {
		this.properties = properties;
		this.data = data;
	}

	public void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Assert.notEmpty(properties);
		HSSFSheet sheet;
		if (StringUtils.isNotEmpty(sheetName)) {
			sheet = workbook.createSheet(sheetName);
		} else {
			sheet = workbook.createSheet();
		}
		int rowNumber = 0;
		if (titles != null && titles.length > 0) {
			HSSFRow header = sheet.createRow(rowNumber);
			header.setHeight((short) 400);
			for (int i = 0; i < properties.length; i++) {
				HSSFCell cell = header.createCell(i);
				HSSFCellStyle cellStyle = workbook.createCellStyle();
				cellStyle.setFillForegroundColor(HSSFColor.LIGHT_CORNFLOWER_BLUE.index);
				cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
				cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
				cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
				HSSFFont font = workbook.createFont();
				font.setFontHeightInPoints((short) 11);
				font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
				cellStyle.setFont(font);
				cell.setCellStyle(cellStyle);
				if (i == 0) {
					HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
					HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0, 0, 0, 0, (short) 1, 1, (short) 4, 4));
					comment.setString(new HSSFRichTextString("P" + "o" + "w" + "e" + "r" + "e" + "d" + " " + "B" + "y" + " " + "S" + "H" + "O" + "P" + "+" + "+"));
					cell.setCellComment(comment);
				}
				if (titles.length > i && titles[i] != null) {
					cell.setCellValue(titles[i]);
				} else {
					cell.setCellValue(properties[i]);
				}
				if (widths != null && widths.length > i && widths[i] != null) {
					sheet.setColumnWidth(i, widths[i]);
				} else {
					sheet.autoSizeColumn(i);
				}
			}
			rowNumber++;
		}
		if (data != null) {
			for (Object item : data) {
				HSSFRow row = sheet.createRow(rowNumber);
				for (int i = 0; i < properties.length; i++) {
					HSSFCell cell = row.createCell(i);
					if (converters != null && converters.length > i && converters[i] != null) {
						Class<?> clazz = PropertyUtils.getPropertyType(item, properties[i]);
						ConvertUtils.register(converters[i], clazz);
						cell.setCellValue(BeanUtils.getProperty(item, properties[i]));
						ConvertUtils.deregister(clazz);
						if (clazz.equals(Date.class)) {
							DateConverter dateConverter = new DateConverter();
							dateConverter.setPattern(DEFAULT_DATE_PATTERN);
							ConvertUtils.register(dateConverter, Date.class);
						}
					} else {
						cell.setCellValue(BeanUtils.getProperty(item, properties[i]));
					}
					if (rowNumber == 0 || rowNumber == 1) {
						if (widths != null && widths.length > i && widths[i] != null) {
							sheet.setColumnWidth(i, widths[i]);
						} else {
							sheet.autoSizeColumn(i);
						}
					}
				}
				rowNumber++;
			}
		}
		if (contents != null && contents.length > 0) {
			rowNumber++;
			for (String content : contents) {
				HSSFRow row = sheet.createRow(rowNumber);
				HSSFCell cell = row.createCell(0);
				HSSFCellStyle cellStyle = workbook.createCellStyle();
				HSSFFont font = workbook.createFont();
				font.setColor(HSSFColor.GREY_50_PERCENT.index);
				cellStyle.setFont(font);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(content);
				rowNumber++;
			}
		}
		response.setContentType("application/force-download");
		if (StringUtils.isNotEmpty(filename)) {
			response.setHeader("Content-disposition", "attachment; filename=" + URLEncoder.encode(filename, "UTF-8"));
		} else {
			response.setHeader("Content-disposition", "attachment");
		}
	}

	public String getFileName() {
		return filename;
	}

	public void setFileName(String filename) {
		this.filename = filename;
	}

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	public String[] getProperties() {
		return properties;
	}

	public void setProperties(String[] properties) {
		this.properties = properties;
	}

	public String[] getTitles() {
		return titles;
	}

	public void setTitles(String[] titles) {
		this.titles = titles;
	}

	public Integer[] getWidths() {
		return widths;
	}

	public void setWidths(Integer[] widths) {
		this.widths = widths;
	}

	public Converter[] getConverters() {
		return converters;
	}

	public void setConverters(Converter[] converters) {
		this.converters = converters;
	}

	public Collection<?> getData() {
		return data;
	}

	public void setData(Collection<?> data) {
		this.data = data;
	}

	public String[] getContents() {
		return contents;
	}

	public void setContents(String[] contents) {
		this.contents = contents;
	}

}