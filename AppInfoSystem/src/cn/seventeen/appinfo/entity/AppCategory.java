package cn.seventeen.appinfo.entity;

import java.util.Date;

public class AppCategory {
	private Integer id;
	private String categoryCode;
	private String categoryName;
	private Integer parentId;
	private	Integer createBy;
	private Date creationTime;
	private Integer modifyBy;
	private Date modifyDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getCreateBy() {
		return createBy;
	}
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public Integer getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	@Override
	public String toString() {
		return "AppCategory [id=" + id + ", categoryCode=" + categoryCode + ", categoryName=" + categoryName
				+ ", parentId=" + parentId + ", createBy=" + createBy + ", creationTime=" + creationTime + ", modifyBy="
				+ modifyBy + ", modifyDate=" + modifyDate + "]";
	}
	public AppCategory(Integer id, String categoryCode, String categoryName, Integer parentId, Integer createBy,
			Date creationTime, Integer modifyBy, Date modifyDate) {
		super();
		this.id = id;
		this.categoryCode = categoryCode;
		this.categoryName = categoryName;
		this.parentId = parentId;
		this.createBy = createBy;
		this.creationTime = creationTime;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
	}
	public AppCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}