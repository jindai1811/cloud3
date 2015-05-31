package com.serket.cloud.bean;

import java.sql.Timestamp;

/**
 * Log entity. @author MyEclipse Persistence Tools
 */

public class Log implements java.io.Serializable
{

	// Fields

	private String id;
	private String ip;
	private Timestamp accessDate;
	private String pharmacyid;
	private String userid;
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	// Constructors

	/** default constructor */
	public Log()
	{
	}

	/** minimal constructor */
	public Log(String id)
	{
		this.id = id;
	}

	/** full constructor */
	public Log(String id, String ip, Timestamp accessDate, String pharmacyid, String userid)
	{
		this.id = id;
		this.ip = ip;
		this.accessDate = accessDate;
		this.pharmacyid = pharmacyid;
		this.userid = userid;
	}

	// Property accessors

	public String getId()
	{
		return this.id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getIp()
	{
		return this.ip;
	}

	public void setIp(String ip)
	{
		this.ip = ip;
	}

	public Timestamp getAccessDate()
	{
		return this.accessDate;
	}

	public void setAccessDate(Timestamp accessDate)
	{
		this.accessDate = accessDate;
	}

	public String getPharmacyid()
	{
		return this.pharmacyid;
	}

	public void setPharmacyid(String pharmacyid)
	{
		this.pharmacyid = pharmacyid;
	}

	public String getUserid()
	{
		return this.userid;
	}

	public void setUserid(String userid)
	{
		this.userid = userid;
	}

}