package cn.seventeen.appinfo.entity;

import java.io.Serializable;
import java.util.Date;

public class AdPromotion implements Serializable{
	private Integer id;					//主键
	private Integer appId;				//appId
	private String adPicPath;			//广告图片路径
	private Integer adPV;				//广告点击量
	private Integer carouselPosition;	//轮播位
	private Date startTime;				//起效时间
	private Date endTime;				//失效时间
	private Integer createBy;			//创建者
	private Date creationDate;			//创建时间
	private Integer modifyBy;			//更新者
	private Date modifyDate;			//更新时间
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAppId() {
		return appId;
	}
	public void setAppId(Integer appId) {
		this.appId = appId;
	}
	public String getAdPicPath() {
		return adPicPath;
	}
	public void setAdPicPath(String adPicPath) {
		this.adPicPath = adPicPath;
	}
	public Integer getAdPV() {
		return adPV;
	}
	public void setAdPV(Integer adPV) {
		this.adPV = adPV;
	}
	public Integer getCarouselPosition() {
		return carouselPosition;
	}
	public void setCarouselPosition(Integer carouselPosition) {
		this.carouselPosition = carouselPosition;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Integer getCreateBy() {
		return createBy;
	}
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
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
		return "Ad_Promotion [id=" + id + ", appId=" + appId + ", adPicPath=" + adPicPath + ", adPV=" + adPV
				+ ", carouselPosition=" + carouselPosition + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", createBy=" + createBy + ", creationDate=" + creationDate + ", modifyBy=" + modifyBy
				+ ", modifyDate=" + modifyDate + "]";
	}
	public AdPromotion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdPromotion(Integer id, Integer appId, String adPicPath, Integer adPV, Integer carouselPosition,
			Date startTime, Date endTime, Integer createBy, Date creationDate, Integer modifyBy, Date modifyDate) {
		super();
		this.id = id;
		this.appId = appId;
		this.adPicPath = adPicPath;
		this.adPV = adPV;
		this.carouselPosition = carouselPosition;
		this.startTime = startTime;
		this.endTime = endTime;
		this.createBy = createBy;
		this.creationDate = creationDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
	}
	
}
