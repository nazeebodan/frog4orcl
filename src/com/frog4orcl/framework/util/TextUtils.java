/**
 * 
 */
package com.frog4orcl.framework.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @说明: 
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create: Jan 12, 2011 6:19:07 PM
 * @version: 1.0
 */
public class TextUtils {
	// Logger..
	private static final transient Log log = LogFactory.getLog(TextUtils.class);

	public static void main(String[] args) {
	}

	/**
	 * 判断字符串是否 是/包含 html内容..
	 */
	public static boolean isHTMLContent(String content) {
		String[] tags = new String[] { "<html>", "<head>", "<title>",
				"<script", "<meta", "<link", "<body", "<table", "<tr", "<td",
				"<form", "<img", "<input", "<frame", "<iframe", "<frameset",
				"<hr", "<dd", "<dl", "<dt", "<dir", "<ll", "<li", "<ul","<span" };

		content = content.toLowerCase();
		for (String tag : tags) {
			if (content.contains(tag)) {
				log.debug("[" + content + "] isHTML=" + true);
				return true;
			}
		}
		return false;
	}


	/**
	 * 日期解析
	 * @param date
	 * @param formats
	 * @return
	 */
	public static Date parseDate(String date, String... formats) {
		if (formats == null || formats.length == 0) {
			formats = new String[] { "yyyy-MM-dd" };
		}
		try {
			return DateUtils.parseDate(date, formats);
		} catch (ParseException e) {
			String format = Arrays.toString(formats);
			log.error("parseDate出错：" + date + "[" + format);
			return null;
		}
	}


}
