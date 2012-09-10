package org.ice.review.ref;

public class ref2 {

	public static void main(String args[]) {
		String str = "hello";
		fun(str);
		System.out.println(str);
	}

	public static void fun(String temp) {
		temp = "world";
	}
}
