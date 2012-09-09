package org.ice.review.string;

public class StringDemo {
	public void demo1() {
		String str1 = "hello"; // 使用直接赋值的方式完成
		String str2 = new String("MLDN"); // 通过构造方法完成
		System.out.println(str1 + str2); // 进行字符串的连接操作
	}

	public void demo2() {
		String str1 = "hello"; // 使用直接赋值的方式完成
		String str2 = new String("hello"); // 通过构造方法完成
		String str3 = str2; // 通过构造方法完成
		System.out.println("str1 == str2 --> " + (str1 == str2)); // false
		System.out.println("str1 == str3 --> " + (str1 == str3)); // false
		System.out.println("str2 == str3 --> " + (str2 == str3)); // true
	}

	public void demo3() {
		String str1 = "hello"; // 使用直接赋值的方式完成
		String str2 = new String("hello"); // 通过构造方法完成
		String str3 = str2; // 通过构造方法完成
		System.out.println("str1 equals str2 --> " + str1.equals(str2)); // true
		System.out.println("str1 equals str3 --> " + str1.equals(str3)); // true
		System.out.println("str2 equals str3 --> " + str2.equals(str3)); // true
	}

	public void demo4() {
		String str1 = "hello"; // 使用直接赋值的方式完成
		System.out.println("hello".equals(str1));
	}

	public void demo5() {
		String str1 = "hello"; // 使用直接赋值的方式完成
		String str2 = "hello"; // 使用直接赋值的方式完成
		String str3 = "hello"; // 使用直接赋值的方式完成
		System.out.println("str1 == str2 --> " + (str1 == str2));
		System.out.println("str2 == str3 --> " + (str2 == str3));
		System.out.println("str1 == str3 --> " + (str1 == str3));
	}

	public void demo6() {
		String str = "hello";
		str += " world";
		System.out.println(str);
	}

	public void demo7() {
		String str = "hello";
		for (int i = 0; i < 100; i++) {
			str += i;
		}
		System.out.println(str);
	}

	public static void main(String[] args) {
		StringDemo sd = new StringDemo();
		sd.demo1();
		sd.demo2();
		sd.demo3();
		sd.demo4();
		sd.demo5();
		sd.demo6();
		sd.demo7();
	}
}
