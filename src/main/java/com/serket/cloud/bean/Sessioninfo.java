package com.serket.cloud.bean;

/**
 * Sessioninfo entity. @author MyEclipse Persistence Tools
 */

public class Sessioninfo implements java.io.Serializable
{

	// Fields

	private String id;
	private String pharmacyId;
	private String accessToken;
	private String verification;


	// Constructors

	/** default constructor */
	public Sessioninfo()
	{
	}

	/** minimal constructor */
	public Sessioninfo(String id)
	{
		this.id = id;
	}

	/** full constructor */
	public Sessioninfo(String id, String pharmacyId, String accessToken, String verification)
	{
		this.id = id;
		this.pharmacyId = pharmacyId;
		this.accessToken = accessToken;
		this.verification = verification;
	}

	// Property 	accessors

	public String getId()
	{
		return this.id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getPharmacyId()
	{
		return this.pharmacyId;
	}

	public void setPharmacyId(String pharmacyId)
	{
		this.pharmacyId = pharmacyId;
	}

	public String getAccessToken()
	{
		return this.accessToken;
	}

	public void setAccessToken(String accessToken)
	{
		this.accessToken = accessToken;
	}

	public String getVerification()
	{
		return this.verification;
	}

	public void setVerification(String verification)
	{
		this.verification = verification;
	}

}