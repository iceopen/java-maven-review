package org.ice.review.ref;

public class ref1 {
	class Demo {
		int x = 10;
	};

	public static void main(String args[]) {
		ref1 ref = new ref1();
		Demo d = ref.new Demo();
		d.x = 30;
		System.out.println(d.x);
		fun(d);
		System.out.println(d.x);
	}

	public static void fun(Demo temp) {
		temp.x = 100;
	}

}
