package com.wenhuaju.dao;

import java.util.List;

public class Pager<T> {
	/**
	 * 当前分页
	 * 从1开始
	 */
	private int pageNo;
	
	/**
	 * 分页大小
	 * pageSize > 0
	 */
	private int pageSize;
	
	/**
	 * 记录总数
	 */
	private long totalCount;
	
	/**
	 * 分页总数
	 */
	private long totalPage;
	
	/**
	 * 分页记录
	 */
	private List<T> list;
	
	public Pager() {}
	
	public Pager(int pageNo, int pageSize, long totalCount, List<T> list) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
		this.list = list;
	}

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

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Pager [pageNo=" + pageNo + ", pageSize=" + pageSize + ", totalCount=" + totalCount + ", totalPage="
				+ totalPage + ", list=" + list + "]";
	}
	
}
