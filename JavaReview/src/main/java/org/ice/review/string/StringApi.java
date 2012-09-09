package org.ice.review.string;

public class StringApi {
	public void demo1() {
		String str = "hello";
		char c = str.charAt(1);
		System.out.println(c);
	}

	public void demo2() {
		String str = "hello world !!!@";
		char c[] = str.toCharArray(); // 将字符串变为字符数组
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i] + "、");
		}
		String str1 = new String(c); // 将全部的字符数组重新变为String
		String str2 = new String(c, 0, 5); // 将0~5的字符数组重新变为String
		System.out.println("\n" + str1);
		System.out.println(str2);
	}

	public void demo3() {
		String str = "hello world !!!@";
		byte b[] = str.getBytes(); // 将字符串变为byte数组
		String str1 = new String(b); // 将全部的字符数组重新变为String
		String str2 = new String(b, 0, 5); // 将0~5的字符数组重新变为String
		System.out.println(str1);
		System.out.println(str2);
	}

	public void demo4() {
		String str = "**hello world ##";
		System.out.println(str.startsWith("**"));
		System.out.println(str.endsWith("##"));
	}

	public void demo5() {
		String str = "hello world";
		String newStr = str.replaceAll("l", "x");
		System.out.println(newStr);
	}

	public void demo6() {
		String str = "hello world";
		String sub1 = str.substring(6);
		String sub2 = str.substring(0, 5);
		System.out.println(sub1);
		System.out.println(sub2);
	}

	public void demo7() {
		String str = "hello world";
		String s[] = str.split(" "); // 按照空格拆分
		for (String st : s) {
			System.out.println(st);
		}
	}

	public void demo8() {
		String str = "hello world";
		System.out.println(str.contains("hello"));
		System.out.println(str.contains("mldn"));
	}

	public void demo9() {
		String str = "hello world";
		System.out.println(str.indexOf("hello"));
		System.out.println(str.indexOf("mldn"));
		if (str.indexOf("world") != -1) {
			System.out.println("查找到了所需要的内容。");
		}
	}

	public void demo10() {
		String str = "hello world";
		System.out.println(str.indexOf("h"));
		System.out.println(str.indexOf("h", 5));
	}

	public void demo11() {
		String str = "    hello world     ";
		System.out.println(str.trim());
		System.out.println(str.trim().toUpperCase());
		System.out.println(str.trim().length());
	}

	public static void main(String[] args) {
		StringApi s = new StringApi();
		s.demo1();
		s.demo2();
		s.demo3();
		s.demo4();
		s.demo5();
		s.demo6();
		s.demo7();
		s.demo8();
		s.demo9();
		s.demo10();
		s.demo11();
	}
}
