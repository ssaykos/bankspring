package com.bankspring.factory;

public class Command implements Orderable{
	public final int PAGESIZE = 10;
	private int pageNo, start, end;
	String command,searchKey,searchVal;
		
	
	public int getPageNo() {
		return pageNo;
	}


	public int getStart() {
		return start;
	}


	public int getEnd() {
		return end;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getSearchVal() {
		return searchVal;
	}

	public void setSearchVal(String searchVal) {
		this.searchVal = searchVal;
	}

	public int getPAGESIZE() {
		return PAGESIZE;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = Integer.parseInt(pageNo);
		this.start = (Integer.parseInt(pageNo)-1)*PAGESIZE+1;
		this.end= Integer.parseInt(pageNo)*PAGESIZE;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute(String pageNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute(String searchKey, String searchVal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute(String pageNo, String searchKey, String searchVal) {
		// TODO Auto-generated method stub
		
	}

}
