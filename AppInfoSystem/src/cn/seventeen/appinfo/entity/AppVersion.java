package cn.seventeen.appinfo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AppVersion implements Serializable{
	private Integer id;				//id
	private Integer appId;			//appId
	private String versionNo;		//版本号
	private String versionInfo;		//版本介绍
	private Integer publishStatus;	//发布状态
	private String downloadLink;	//下载链接	
	private BigDecimal versionSize;		//版本大小	
	private Integer createBy;		//创建者
	private Date creationDate;		//创建时间
	private Integer modifyBy;		//更新者
	private Date modifyDate;		//更新时间
	private String apkLocPath;		//apk的服务器储存路径
	private String apkFileName;		//上传的apk名称
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
	public String getVersionNo() {
		return versionNo;
	}
	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}
	public String getVersionInfo() {
		return versionInfo;
	}
	public void setVersionInfo(String versionInfo) {
		this.versionInfo = versionInfo;
	}
	public Integer getPublishStatus() {
		return publishStatus;
	}
	public void setPublishStatus(Integer publishStatus) {
		this.publishStatus = publishStatus;
	}
	public String getDownloadLink() {
		return downloadLink;
	}
	public void setDownloadLink(String downloadLink) {
		this.downloadLink = downloadLink;
	}
	public BigDecimal getVersionSize() {
		return versionSize;
	}
	public void setVersionSize(BigDecimal versionSize) {
		this.versionSize = versionSize;
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
	public String getApkLocPath() {
		return apkLocPath;
	}
	public void setApkLocPath(String apkLocPath) {
		this.apkLocPath = apkLocPath;
	}
	public String getApkFileName() {
		return apkFileName;
	}
	public void setApkFileName(String apkFileName) {
		this.apkFileName = apkFileName;
	}
	@Override
	public String toString() {
		return "AppVersion [id=" + id + ", appId=" + appId + ", versionNo=" + versionNo + ", versionInfo=" + versionInfo
				+ ", publishStatus=" + publishStatus + ", downloadLink=" + downloadLink + ", versionSize=" + versionSize
				+ ", createBy=" + createBy + ", creationDate=" + creationDate + ", modifyBy=" + modifyBy
				+ ", modifyDate=" + modifyDate + ", apkLocPath=" + apkLocPath + ", apkFileName=" + apkFileName + "]";
	}
	public AppVersion(Integer id, Integer appId, String versionNo, String versionInfo, Integer publishStatus,
			String downloadLink, BigDecimal versionSize, Integer createBy, Date creationDate, Integer modifyBy,
			Date modifyDate, String apkLocPath, String apkFileName) {
		super();
		this.id = id;
		this.appId = appId;
		this.versionNo = versionNo;
		this.versionInfo = versionInfo;
		this.publishStatus = publishStatus;
		this.downloadLink = downloadLink;
		this.versionSize = versionSize;
		this.createBy = createBy;
		this.creationDate = creationDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
		this.apkLocPath = apkLocPath;
		this.apkFileName = apkFileName;
	}
	public AppVersion() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
