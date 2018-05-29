package com.three.zteoa.util;

public class PageUtil {
	
	public static final int pageSize = 3;
	
	/**
	 * 拼接like
	 * @param value
	 * @return
	 */
	public static String getLike(String value) {
		return "%" + value + "%";
	}
	
	/**
	 * 获取总页数
	 * @param count
	 * @return
	 */
	public static long getPage(long count) {
		return count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
	}
	
}
