package cn.appinfo.entity;

import java.io.Serializable;
import java.util.Date;

public class Der_User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;			//id
	private String decCode;		//�������˺�
	private String devName;		//����������
	private String devPassword;	//����������
	private String devEmail;	//�����ߵ�������
	private String devInfo;		//�����߼��
	private Integer createBy;	//������
	private Date creationDate;	//����ʱ��
	private Integer modifyBy;	//������
	private Date modifyDate;	//���¸���ʱ��
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDecCode() {
		return decCode;
	}
	public void setDecCode(String decCode) {
		this.decCode = decCode;
	}
	public String getDevName() {
		return devName;
	}
	public void setDevName(String devName) {
		this.devName = devName;
	}
	public String getDevPassword() {
		return devPassword;
	}
	public void setDevPassword(String devPassword) {
		this.devPassword = devPassword;
	}
	public String getDevEmail() {
		return devEmail;
	}
	public void setDevEmail(String devEmail) {
		this.devEmail = devEmail;
	}
	public String getDevInfo() {
		return devInfo;
	}
	public void setDevInfo(String devInfo) {
		this.devInfo = devInfo;
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
		return "Der_User [id=" + id + ", decCode=" + decCode + ", devName=" + devName + ", devPassword=" + devPassword
				+ ", devEmail=" + devEmail + ", devInfo=" + devInfo + ", createBy=" + createBy + ", creationDate="
				+ creationDate + ", modifyBy=" + modifyBy + ", modifyDate=" + modifyDate + "]";
	}
	public Der_User(Integer id, String decCode, String devName, String devPassword, String devEmail, String devInfo,
			Integer createBy, Date creationDate, Integer modifyBy, Date modifyDate) {
		super();
		this.id = id;
		this.decCode = decCode;
		this.devName = devName;
		this.devPassword = devPassword;
		this.devEmail = devEmail;
		this.devInfo = devInfo;
		this.createBy = createBy;
		this.creationDate = creationDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
	}
	public Der_User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
