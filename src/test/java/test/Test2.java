package test;

class A {
	int i = 10;

	void m1() {
		this.i=20;
		System.out.println("Parent");
		System.out.println(i);
	}
}

class B extends A {
	int i = 30;

	void m1() {
		this.i=40;
		System.out.println("Child");
		System.out.println(i);
	}
}

public class Test2 {
	public static void main(String[] args) {
		A a = new B();

		a.m1();
		System.out.println(a.i);
	}
}