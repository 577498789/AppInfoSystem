package cn.seventeen.appinfo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AppVersion implements Serializable{
	private Integer id;//����id
	private Integer appId;//appId
	private String versionNo;//�汾��
	private String versionInfo;//�汾����
	private Integer publishStatus;//����״̬id
	private String downloadLink;//apk�ļ���������
	private BigDecimal versionSize;//�汾��С
	private Integer createdBy;//������
	private Date creationDate;//����ʱ��
	private Integer modifyBy;//������
	private Date modifyDate;//����ʱ��
	private String apkLocPath;//apk�ļ��ķ������洢·��
	
	private String appName;//APP�������
	private String publishStatusName;//����״̬����
	private String apkFileName;//�ϴ���apk�ļ�����
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
	public String getApkLocPath() {
		return apkLocPath;
	}
	public void setApkLocPath(String apkLocPath) {
		this.apkLocPath = apkLocPath;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getPublishStatusName() {
		return publishStatusName;
	}
	public void setPublishStatusName(String publishStatusName) {
		this.publishStatusName = publishStatusName;
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
				+ ", createdBy=" + createdBy + ", creationDate=" + creationDate + ", modifyBy=" + modifyBy
				+ ", modifyDate=" + modifyDate + ", apkLocPath=" + apkLocPath + ", appName=" + appName
				+ ", publishStatusName=" + publishStatusName + ", apkFileName=" + apkFileName + "]";
	}
	public AppVersion(Integer id, Integer appId, String versionNo, String versionInfo, Integer publishStatus,
			String downloadLink, BigDecimal versionSize, Integer createdBy, Date creationDate, Integer modifyBy,
			Date modifyDate, String apkLocPath, String appName, String publishStatusName, String apkFileName) {
		super();
		this.id = id;
		this.appId = appId;
		this.versionNo = versionNo;
		this.versionInfo = versionInfo;
		this.publishStatus = publishStatus;
		this.downloadLink = downloadLink;
		this.versionSize = versionSize;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
		this.apkLocPath = apkLocPath;
		this.appName = appName;
		this.publishStatusName = publishStatusName;
		this.apkFileName = apkFileName;
	}
	public AppVersion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
