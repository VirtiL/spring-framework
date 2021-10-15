package com.tuling;

/**
 * @author 周瑜
 */
public class UserService implements UserInterface {

	public void test() {
		System.out.println("test...");
	}

	public void test(String s) {
		System.out.println("test args...");
		throw new NullPointerException();
	}


}
