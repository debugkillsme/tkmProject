package com.nju.util;

public class PageUtil {
	private int dataCount;//������
	private int pageSize;//ҳ����
	private int pageNo;//ҳ��
	
	private int pageCount;//��ҳ��
	
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
