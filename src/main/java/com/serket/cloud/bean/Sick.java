package com.serket.cloud.bean;

/**
 * Sick entity. @author MyEclipse Persistence Tools
 */

public class Sick implements java.io.Serializable
{

	// Fields

	private String id;
	private String firstName;
	private String lastName;
	private String remarks;

	// Constructors

	/** default constructor */
	public Sick()
	{
	}

	/** minimal constructor */
	public Sick(String id, String lastName)
	{
		this.id = id;
		this.lastName = lastName;
	}

	/** full constructor */
	public Sick(String id, String firstName, String lastName, String remarks)
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.remarks = remarks;
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

	public String getFirstName()
	{
		return this.firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return this.lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getRemarks()
	{
		return this.remarks;
	}

	public void setRemarks(String remarks)
	{
		this.remarks = remarks;
	}

}