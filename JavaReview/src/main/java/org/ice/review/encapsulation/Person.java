package org.ice.review.encapsulation;

public class Person {
	private String name; // 表示人的姓名
	private int age; // 表示人的年龄

	public void tell() { // 定义说话的方法
		System.out.println("姓名：" + this.getName() + "，年龄：" + this.getAge());
	}

	public void setName(String n) {
		name = n;
	}

	public void setAge(int a) {
		if (a >= 0 && a <= 200) {
			age = a;
		}
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
}
