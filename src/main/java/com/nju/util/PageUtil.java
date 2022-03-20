package com.nju.util;

public class PageUtil {
	private int dataCount;//总条数
	private int pageSize;//页容量
	private int pageNo;//页码
	
	private int pageCount;//总页数
	
	public int getPageCount() {
		if(dataCount%pageSize==0) {
			this.pageCount=dataCount/pageSize;
		}else {
			this.pageCount=dataCount/pageSize+1;
		}
		return pageCount;
	}

	public int getDataCount() {
		return dataCount;
	}

	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

}
