package com.bankspring.factory;

public interface Orderable {
	//메소드 오버로딩
	public void execute();
	public void execute(String pageNo);
	public void execute(String searchKey, String searchVal);
	public void execute(String pageNo, String searchKey, String searchVal);
}
