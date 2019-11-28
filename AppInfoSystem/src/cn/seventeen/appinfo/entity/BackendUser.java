package cn.seventeen.appinfo.entity;

import java.util.Date;

public class BackendUser {
	private Integer id;			//id
	private String userCode;	//�û�����			
	private String userName;	//�û�����	
	private Integer userType;	//�û���ɫ����
	private Integer createBy;	//������
	private Date creationDate;	//����ʱ��
	private Integer modifyBy;	//������
	private Date modifyDate;	//����ʱ��
	private String userPassword;//�û�����
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
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
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	@Override
	public String toString() {
		return "BackendUser [id=" + id + ", userCode=" + userCode + ", userName=" + userName + ", userType=" + userType
				+ ", createBy=" + createBy + ", creationDate=" + creationDate + ", modifyBy=" + modifyBy
				+ ", modifyDate=" + modifyDate + ", userPassword=" + userPassword + "]";
	}
	public BackendUser(Integer id, String userCode, String userName, Integer userType, Integer createBy,
			Date creationDate, Integer modifyBy, Date modifyDate, String userPassword) {
		super();
		this.id = id;
		this.userCode = userCode;
		this.userName = userName;
		this.userType = userType;
		this.createBy = createBy;
		this.creationDate = creationDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
		this.userPassword = userPassword;
	}
	public BackendUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}