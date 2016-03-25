package com.wenhuaju.po;

/***
 * 分页对象
 * @author ccf
 * @date 2016年3月25日
 *
 */
public class Pager {
	/*
	 * 默认每页记录数
	 */
	public static final int DEFAULT_PAGE_SIZE = 20;

	/**
	 * 当前页，从1开始
	 */
	private int pageNo;
	
	/**
	 * 每页记录数
	 */
	private int pageSize;
	
	/**
	 * 记录总数
	 */
	private int totalCount;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	@Override
	public String toString() {
		return "Pager [pageNo=" + pageNo + ", pageSize=" + pageSize
				+ ", totalCount=" + totalCount + "]";
	}
	
}
