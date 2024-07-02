package org.zerock.domain;

public class Criteria {
	
	private int page;
	private int perPageNum;
	private int ps;
//	private int pageStart;
	
	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
		this.ps=0;
//		this.pageStart = 0;
	}
	public void setPage(int page) {
		if(page<=0) {
			this.page=1;
			return;
		}
		this.page = page;
	}
	
	public void setPerPageNum(int perPageNum) {
		if(perPageNum<=0 || perPageNum>100) {
			this.perPageNum = 10;
			return;
		}
		this.perPageNum=perPageNum;
	}
	public int getPage() {
		return page;
	}
	
	public int getPageStart() {
		return ps = (this.page-1) * perPageNum;
//		return (this.page-1) * perPageNum;
	}

	public int getPerPageNum() {
		return perPageNum;
	}
	
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}
	
	

		
}
