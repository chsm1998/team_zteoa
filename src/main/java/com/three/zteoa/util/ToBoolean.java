package com.three.zteoa.util;

public abstract class ToBoolean {
	
	public static boolean intToBool(int num, int eqNum) {
		return num == eqNum;
	}
	
	public static boolean isNotNull(Object obj) {
		return obj != null;
	}
	
}
