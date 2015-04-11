package com.lingxiang2014.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class EncodingConvertFilter extends OncePerRequestFilter {

    private String fromEncoding = "ISO-8859-1";

    private String toEncoding = "UTF-8";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
	if (request.getMethod().equalsIgnoreCase("GET")) {
	    for (Iterator<String[]> iterator = request.getParameterMap().values().iterator(); iterator.hasNext();) {
		String[] parames = iterator.next();
		for (int i = 0; i < parames.length; i++) {
		    try {
			parames[i] = new String(parames[i].getBytes(fromEncoding), toEncoding);
		    } catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		    }
		}
	    }
	}
	filterChain.doFilter(request, response);
    }

    public String getFromEncoding() {
	return fromEncoding;
    }

    public void setFromEncoding(String fromEncoding) {
	this.fromEncoding = fromEncoding;
    }

    public String getToEncoding() {
	return toEncoding;
    }

    public void setToEncoding(String toEncoding) {
	this.toEncoding = toEncoding;
    }

}