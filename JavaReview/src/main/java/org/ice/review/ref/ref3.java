package org.ice.review.ref;

public class ref3 {
	class Demo {
		String x = "mldn";
	};

	public static void main(String args[]) {
		ref3 ref = new ref3();
		Demo d = ref.new Demo();
		d.x = "hello";
		fun(d);
		System.out.println(d.x);
	}

	public static void fun(Demo temp) {
		temp.x = "world";
	}
}
