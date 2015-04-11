/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.lingxiang2014.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.lingxiang2014.FileInfo;
import com.lingxiang2014.FileInfo.FileType;
import com.lingxiang2014.FileInfo.OrderType;

public interface FileService {

	boolean isValid(FileType fileType, MultipartFile multipartFile);

	String upload(FileType fileType, MultipartFile multipartFile, boolean async);

	String upload(FileType fileType, MultipartFile multipartFile);

	String uploadLocal(FileType fileType, MultipartFile multipartFile);

	List<FileInfo> browser(String path, FileType fileType, OrderType orderType);

}