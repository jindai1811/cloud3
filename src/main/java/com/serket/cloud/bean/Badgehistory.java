package com.serket.cloud.bean;

import java.sql.Timestamp;

/**
 * Badgehistory entity. @author MyEclipse Persistence Tools
 */

public class Badgehistory implements java.io.Serializable
{

	// Fields

	private String id;
	private Badge badge;
	private Timestamp confirmTime;

	// Constructors

	/** default constructor */
	public Badgehistory()
	{
	}

	/** minimal constructor */
	public Badgehistory(String id)
	{
		this.id = id;
	}

	/** full constructor */
	public Badgehistory(String id, Badge badge, Timestamp confirmTime)
	{
		this.id = id;
		this.badge = badge;
		this.confirmTime = confirmTime;
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

	public Badge getBadge()
	{
		return this.badge;
	}

	public void setBadge(Badge badge)
	{
		this.badge = badge;
	}

	public Timestamp getConfirmTime()
	{
		return this.confirmTime;
	}

	public void setConfirmTime(Timestamp confirmTime)
	{
		this.confirmTime = confirmTime;
	}

}