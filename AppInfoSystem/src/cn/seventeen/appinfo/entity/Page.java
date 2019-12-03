package cn.seventeen.appinfo.entity;

import java.util.List;

public class Page {
	private Integer pageNo=1;
	private Integer pages;
	private Integer pageSize=5;
	private Integer records;
	private List list;
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages() {
		if(records!=null&&pageSize!=null) {
			if(records%pageSize==0) {
				pages=records/pageSize;
			}else {
				pages=records/pageSize+1;
			}
		}
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
		setPages();
	}
	public Integer getRecords() {
		return records;
	}
	public void setRecords(Integer records) {
		this.records = records;
		setPages();
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", pages=" + pages + ", pageSize=" + pageSize + ", records=" + records
				+ ", list=" + list + "]";
	}
	public Page(Integer pageNo, Integer pages, Integer pageSize, Integer records, List list) {
		super();
		this.pageNo = pageNo;
		this.pages = pages;
		this.pageSize = pageSize;
		this.records = records;
		this.list = list;
	}
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getStartIndex() {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(pageNo);
		System.out.println(pageSize);
		System.out.println((pageNo-1)*pageSize);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		return (pageNo-1)*pageSize;
	}
	
	public Integer getPerv() {
		if(pageNo>1)
		return pageNo-1;
		return pageNo;
	}
	public Integer getNext() {
		if(pageNo<pages)
			return pageNo+1;
			return pageNo;
	}
	public String pageInfo() {
		return"¹²11Ìõ¼ÇÂ¼&nbsp;1/3Ò³";
	}
	
}
