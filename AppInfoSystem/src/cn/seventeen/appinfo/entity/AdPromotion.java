package cn.seventeen.appinfo.entity;

import java.io.Serializable;
import java.util.Date;

public class AdPromotion implements Serializable{
	private Integer id;					//����
	private Integer appId;				//appId
	private String adPicPath;			//���ͼƬ·��
	private Integer adPV;				//�������
	private Integer carouselPosition;	//�ֲ�λ
	private Date startTime;				//��Чʱ��
	private Date endTime;				//ʧЧʱ��
	private Integer createdBy;			//������
	private Date creationDate;			//����ʱ��
	private Integer modifyBy;			//������
	private Date modifyDate;			//����ʱ��
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
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
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
		return "AdPromotion [id=" + id + ", appId=" + appId + ", adPicPath=" + adPicPath + ", adPV=" + adPV
				+ ", carouselPosition=" + carouselPosition + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", createdBy=" + createdBy + ", creationDate=" + creationDate + ", modifyBy=" + modifyBy
				+ ", modifyDate=" + modifyDate + "]";
	}
	public AdPromotion(Integer id, Integer appId, String adPicPath, Integer adPV, Integer carouselPosition,
			Date startTime, Date endTime, Integer createdBy, Date creationDate, Integer modifyBy, Date modifyDate) {
		super();
		this.id = id;
		this.appId = appId;
		this.adPicPath = adPicPath;
		this.adPV = adPV;
		this.carouselPosition = carouselPosition;
		this.startTime = startTime;
		this.endTime = endTime;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
	}
	public AdPromotion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
