package cn.seventeen.appinfo.entity;

import java.util.Date;

public class AppVersion {
	private Integer id;				//id
	private Integer appId;			//appId
	private String versionNo;		//�汾��
	private String versionInfo;		//�汾����
	private Integer publishStatus;	//����״̬
	private String downloadLink;	//��������	
	private double versionSize;		//�汾��С	
	private Integer createBy;		//������
	private Date creationDate;		//����ʱ��
	private Integer modifyBy;		//������
	private Date modifyDate;		//����ʱ��
	private String apkLocPath;		//apk�ķ���������·��
	private String apkFileName;		//�ϴ���apk����
}
