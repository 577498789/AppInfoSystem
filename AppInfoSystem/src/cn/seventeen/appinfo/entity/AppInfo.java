package cn.seventeen.appinfo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AppInfo implements Serializable {
	private Integer id;// ����id
	private String softwareName;// �������
	private String APKName;// APK����
	private String supportROM;// ֧��ROM
	private String interfaceLanguage;// ��������
	private Date updateDate;// ��������
	private BigDecimal softwareSize;// �����С����λ��M��
	private Integer devId;// ������id
	private String appInfo;// Ӧ�ü��
	private Integer status;// app״̬id
	private Date onSaleDate;// �ϼ�ʱ��
	private Date offSaleDate;// �¼�ʱ��
	private Integer categoryLevel3;// ������������id
	private Integer downloads;// ����������λ���Σ�
	private Integer flatformId;// app����ƽ̨id
	private Integer createdBy;// ������
	private Date creationDate;// ����ʱ��
	private Integer modifyBy;// ������
	private Date modifyDate;// ����ʱ��

	private String statusName;// app״̬����
	private String flatformName;// app����ƽ̨����
	private String categoryLevel3Name;// ����������������
	private String devName;// ����������

	private Integer categoryLevel1;// ����һ������id
	private Integer categoryLevel2;// ������������id

	private String categoryLevel1Name;// ����һ����������
	private String categoryLevel2Name;// ����������������

	private String logoPicPath;// LOGOͼƬURL·��
	private String logoLocPath;// LOGOͼƬ�ķ������洢·��

	private Integer versionId;// ���µİ汾id
	private String versionNo;// ���µİ汾��

	public String getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}

	public Integer getVersionId() {
		return versionId;
	}

	public void setVersionId(Integer versionId) {
		this.versionId = versionId;
	}

	public String getLogoLocPath() {
		return logoLocPath;
	}

	public void setLogoLocPath(String logoLocPath) {
		this.logoLocPath = logoLocPath;
	}

	public String getLogoPicPath() {
		return logoPicPath;
	}

	public void setLogoPicPath(String logoPicPath) {
		this.logoPicPath = logoPicPath;
	}

	public Integer getCategoryLevel3() {
		return categoryLevel3;
	}

	public void setCategoryLevel3(Integer categoryLevel3) {
		this.categoryLevel3 = categoryLevel3;
	}

	public String getCategoryLevel3Name() {
		return categoryLevel3Name;
	}

	public void setCategoryLevel3Name(String categoryLevel3Name) {
		this.categoryLevel3Name = categoryLevel3Name;
	}

	public String getCategoryLevel1Name() {
		return categoryLevel1Name;
	}

	public void setCategoryLevel1Name(String categoryLevel1Name) {
		this.categoryLevel1Name = categoryLevel1Name;
	}

	public String getCategoryLevel2Name() {
		return categoryLevel2Name;
	}

	public void setCategoryLevel2Name(String categoryLevel2Name) {
		this.categoryLevel2Name = categoryLevel2Name;
	}

	public Integer getCategoryLevel1() {
		return categoryLevel1;
	}

	public void setCategoryLevel1(Integer categoryLevel1) {
		this.categoryLevel1 = categoryLevel1;
	}

	public Integer getCategoryLevel2() {
		return categoryLevel2;
	}

	public void setCategoryLevel2(Integer categoryLevel2) {
		this.categoryLevel2 = categoryLevel2;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getFlatformName() {
		return flatformName;
	}

	public void setFlatformName(String flatformName) {
		this.flatformName = flatformName;
	}

	public String getDevName() {
		return devName;
	}

	public void setDevName(String devName) {
		this.devName = devName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSoftwareName() {
		return softwareName;
	}

	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
	}

	public String getAPKName() {
		return APKName;
	}

	public void setAPKName(String aPKName) {
		APKName = aPKName;
	}

	public String getSupportROM() {
		return supportROM;
	}

	public void setSupportROM(String supportROM) {
		this.supportROM = supportROM;
	}

	public String getInterfaceLanguage() {
		return interfaceLanguage;
	}

	public void setInterfaceLanguage(String interfaceLanguage) {
		this.interfaceLanguage = interfaceLanguage;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public BigDecimal getSoftwareSize() {
		return softwareSize;
	}

	public void setSoftwareSize(BigDecimal softwareSize) {
		this.softwareSize = softwareSize;
	}

	public Integer getDevId() {
		return devId;
	}

	public void setDevId(Integer devId) {
		this.devId = devId;
	}

	public String getAppInfo() {
		return appInfo;
	}

	public void setAppInfo(String appInfo) {
		this.appInfo = appInfo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getOnSaleDate() {
		return onSaleDate;
	}

	public void setOnSaleDate(Date onSaleDate) {
		this.onSaleDate = onSaleDate;
	}

	public Date getOffSaleDate() {
		return offSaleDate;
	}

	public void setOffSaleDate(Date offSaleDate) {
		this.offSaleDate = offSaleDate;
	}

	public Integer getDownloads() {
		return downloads;
	}

	public void setDownloads(Integer downloads) {
		this.downloads = downloads;
	}

	public Integer getFlatformId() {
		return flatformId;
	}

	public void setFlatformId(Integer flatformId) {
		this.flatformId = flatformId;
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
		return "AppInfo [id=" + id + ", softwareName=" + softwareName + ", APKName=" + APKName + ", supportROM="
				+ supportROM + ", interfaceLanguage=" + interfaceLanguage + ", updateDate=" + updateDate
				+ ", softwareSize=" + softwareSize + ", devId=" + devId + ", appInfo=" + appInfo + ", status=" + status
				+ ", onSaleDate=" + onSaleDate + ", offSaleDate=" + offSaleDate + ", categoryLevel3=" + categoryLevel3
				+ ", downloads=" + downloads + ", flatformId=" + flatformId + ", createdBy=" + createdBy
				+ ", creationDate=" + creationDate + ", modifyBy=" + modifyBy + ", modifyDate=" + modifyDate
				+ ", statusName=" + statusName + ", flatformName=" + flatformName + ", categoryLevel3Name="
				+ categoryLevel3Name + ", devName=" + devName + ", categoryLevel1=" + categoryLevel1
				+ ", categoryLevel2=" + categoryLevel2 + ", categoryLevel1Name=" + categoryLevel1Name
				+ ", categoryLevel2Name=" + categoryLevel2Name + ", logoPicPath=" + logoPicPath + ", logoLocPath="
				+ logoLocPath + ", versionId=" + versionId + ", versionNo=" + versionNo + "]";
	}

	public AppInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AppInfo(Integer id, String softwareName, String aPKName, String supportROM, String interfaceLanguage,
			Date updateDate, BigDecimal softwareSize, Integer devId, String appInfo, Integer status, Date onSaleDate,
			Date offSaleDate, Integer categoryLevel3, Integer downloads, Integer flatformId, Integer createdBy,
			Date creationDate, Integer modifyBy, Date modifyDate, String statusName, String flatformName,
			String categoryLevel3Name, String devName, Integer categoryLevel1, Integer categoryLevel2,
			String categoryLevel1Name, String categoryLevel2Name, String logoPicPath, String logoLocPath,
			Integer versionId, String versionNo) {
		super();
		this.id = id;
		this.softwareName = softwareName;
		APKName = aPKName;
		this.supportROM = supportROM;
		this.interfaceLanguage = interfaceLanguage;
		this.updateDate = updateDate;
		this.softwareSize = softwareSize;
		this.devId = devId;
		this.appInfo = appInfo;
		this.status = status;
		this.onSaleDate = onSaleDate;
		this.offSaleDate = offSaleDate;
		this.categoryLevel3 = categoryLevel3;
		this.downloads = downloads;
		this.flatformId = flatformId;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
		this.statusName = statusName;
		this.flatformName = flatformName;
		this.categoryLevel3Name = categoryLevel3Name;
		this.devName = devName;
		this.categoryLevel1 = categoryLevel1;
		this.categoryLevel2 = categoryLevel2;
		this.categoryLevel1Name = categoryLevel1Name;
		this.categoryLevel2Name = categoryLevel2Name;
		this.logoPicPath = logoPicPath;
		this.logoLocPath = logoLocPath;
		this.versionId = versionId;
		this.versionNo = versionNo;
	}

}
