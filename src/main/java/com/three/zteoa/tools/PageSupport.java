package com.three.zteoa.tools;

public class PageSupport {
<<<<<<< HEAD
	private int currentPageNo = 1;
	private int totalCount = 0;
	private int pageSize = 0;
	private int totalPageCount = 1;
	public int getCurrentPageNo() {
		return currentPageNo;
	}
	public void setCurrentPageNo(int currentPageNo) {
		if(currentPageNo>0) {
			this.currentPageNo = currentPageNo;
		}
		
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		if(totalCount >0) {
			this.totalCount = totalCount;
			this.setTotal();
		}
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		if(pageSize>0) {
			this.pageSize = pageSize;
		}
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		if(totalPageCount > 0){
			this.totalPageCount = totalPageCount;
		}
		
	}
	
	public void setTotal() {
		if(this.totalCount % this.pageSize == 0) {
			this.totalPageCount = this.totalCount / this.pageSize;
		}else if(this.totalCount % this.pageSize>0){
			this.totalPageCount = this.totalCount / this.pageSize + 1;
		}else {
=======
	// ��ǰҳ�����������û�������
	private int currentPageNo = 1;
	// ������
	private int totalCount = 0;
	// ҳ������
	private int pageSize = 0;
	// ��ҳ��
	private int totalPageCount = 1;

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		if (currentPageNo > 0) {
			this.currentPageNo = currentPageNo;
		}
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		if (totalCount > 0) {
			this.totalCount = totalCount;
			// ������ҳ��
			this.setTotal();
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if (pageSize > 0) {
			this.pageSize = pageSize;
		}
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {

		this.totalPageCount = totalPageCount;
	}

	// ������ҳ��
	public void setTotal() {
		if (this.totalCount % this.pageSize == 0) {
			this.totalPageCount = this.totalCount / this.pageSize;
		} else if (this.totalCount % this.pageSize > 0) {
			this.totalPageCount = this.totalCount / this.pageSize + 1;
		} else {
>>>>>>> branch 'master' of https://github.com/chsm1998/team_zteoa.git
			this.totalPageCount = 0;
		}
	}
}
