package com.bankspring.factory;

public class CommandFactory {
	
	private static Command instance;
	private CommandFactory(){}
	public static Command list(String pageNo) {
		instance = new ListCommand();
		instance.execute(pageNo);
		return instance;
	}
	public static Command search(String pageNo, String searchKey, String searchVal) {
		instance = new SearchCommand();
		instance.execute(pageNo, searchKey, searchVal);
		return instance;
	}
	public static Command search(String searchKey, String searchVal) {
		instance = new SearchCommand();
		instance.execute(searchKey, searchVal);
		return instance;
	}
	public static Command count() {
		instance = new CountCommand();
		return instance;
	}
	public static Command countSome(String searchKey, String searchVal) {
		instance = new CountSomeCommand();
		instance.execute(searchKey, searchVal);
		return instance;
	}
	
}
