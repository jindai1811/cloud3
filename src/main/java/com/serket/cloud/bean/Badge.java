package com.serket.cloud.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Badge entity. @author MyEclipse Persistence Tools
 */

public class Badge implements java.io.Serializable
{

	// Fields

	private String id;
	private Pharmacy pharmacy;
	private String content;
	private Timestamp createDate;
	private String qrcoide;
	private String userid;
	private String medicineid;
	private Integer state;
	private Set badgehistories = new HashSet(0);

	// Constructors

	/** default constructor */
	public Badge()
	{
	}

	/** minimal constructor */
	public Badge(String id)
	{
		this.id = id;
	}

	/** full constructor */
	public Badge(String id, Pharmacy pharmacy, String content, Timestamp createDate, String qrcoide, String userid, String medicineid, Integer state, Set badgehistories)
	{
		this.id = id;
		this.pharmacy = pharmacy;
		this.content = content;
		this.createDate = createDate;
		this.qrcoide = qrcoide;
		this.userid = userid;
		this.medicineid = medicineid;
		this.state = state;
		this.badgehistories = badgehistories;
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

	public Pharmacy getPharmacy()
	{
		return this.pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy)
	{
		this.pharmacy = pharmacy;
	}

	public String getContent()
	{
		return this.content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public Timestamp getCreateDate()
	{
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate)
	{
		this.createDate = createDate;
	}

	public String getQrcoide()
	{
		return this.qrcoide;
	}

	public void setQrcoide(String qrcoide)
	{
		this.qrcoide = qrcoide;
	}

	public String getUserid()
	{
		return this.userid;
	}

	public void setUserid(String userid)
	{
		this.userid = userid;
	}

	public String getMedicineid()
	{
		return this.medicineid;
	}

	public void setMedicineid(String medicineid)
	{
		this.medicineid = medicineid;
	}

	public Integer getState()
	{
		return this.state;
	}

	public void setState(Integer state)
	{
		this.state = state;
	}

	public Set getBadgehistories()
	{
		return this.badgehistories;
	}

	public void setBadgehistories(Set badgehistories)
	{
		this.badgehistories = badgehistories;
	}

}