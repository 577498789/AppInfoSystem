package cn.seventeen.appinfo.entity;

import java.util.Date;

public class AppVersion {
	private Integer id;				//id
	private Integer appId;			//appId
	private String versionNo;		//版本号
	private String versionInfo;		//版本介绍
	private Integer publishStatus;	//发布状态
	private String downloadLink;	//下载链接	
	private double versionSize;		//版本大小	
	private Integer createBy;		//创建者
	private Date creationDate;		//创建时间
	private Integer modifyBy;		//更新者
	private Date modifyDate;		//更新时间
	private String apkLocPath;		//apk的服务器储存路径
	private String apkFileName;		//上传的apk名称
}
