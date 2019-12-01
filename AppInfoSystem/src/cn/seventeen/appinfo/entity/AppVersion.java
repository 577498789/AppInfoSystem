package cn.seventeen.appinfo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AppVersion implements Serializable{
	private Integer id;				//id
	private Integer appId;			//appId
	private String versionNo;		//�汾��
	private String versionInfo;		//�汾����
	private Integer publishStatus;	//����״̬
	private String downloadLink;	//��������	
	private BigDecimal versionSize;		//�汾��С	
	private Integer createBy;		//������
	private Date creationDate;		//����ʱ��
	private Integer modifyBy;		//������
	private Date modifyDate;		//����ʱ��
	private String apkLocPath;		//apk�ķ���������·��
	private String apkFileName;		//�ϴ���apk����
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
