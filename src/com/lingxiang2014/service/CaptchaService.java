/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.lingxiang2014.service;

import java.awt.image.BufferedImage;

import com.lingxiang2014.Setting.CaptchaType;

public interface CaptchaService {

	BufferedImage buildImage(String captchaId);

	boolean isValid(CaptchaType captchaType, String captchaId, String captcha);

}