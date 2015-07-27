package com.bankspring.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ListCommand extends Command {
	private static final Logger logger = LoggerFactory.getLogger(ListCommand.class);
	@Override
	public void execute(String pageNo) {
		setPageNo(pageNo);
		logger.info("리스트 커멘드에서 설정된 페이지 넘버 ={}",getPageNo());
	}
}
