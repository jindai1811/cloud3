package com.serket.cloud.bean;

/**
 * Medicine entity. @author MyEclipse Persistence Tools
 */

public class Medicine implements java.io.Serializable
{

	// Fields

	private String id;
	private String name;
	private String comment;
	private String effect;

	// Constructors

	/** default constructor */
	public Medicine()
	{
	}

	/** full constructor */
	public Medicine(String id, String name, String comment, String effect)
	{
		this.id = id;
		this.name = name;
		this.comment = comment;
		this.effect = effect;
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

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getComment()
	{
		return this.comment;
	}

	public void setComment(String comment)
	{
		this.comment = comment;
	}

	public String getEffect()
	{
		return this.effect;
	}

	public void setEffect(String effect)
	{
		this.effect = effect;
	}

	public boolean equals(Object other)
	{
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Medicine))
			return false;
		Medicine castOther = (Medicine) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId())))
				&& ((this.getName() == castOther.getName()) || (this.getName() != null && castOther.getName() != null && this.getName().equals(castOther.getName())))
				&& ((this.getComment() == castOther.getComment()) || (this.getComment() != null && castOther.getComment() != null && this.getComment().equals(
						castOther.getComment())))
				&& ((this.getEffect() == castOther.getEffect()) || (this.getEffect() != null && castOther.getEffect() != null && this.getEffect().equals(castOther.getEffect())));
	}

	public int hashCode()
	{
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result + (getName() == null ? 0 : this.getName().hashCode());
		result = 37 * result + (getComment() == null ? 0 : this.getComment().hashCode());
		result = 37 * result + (getEffect() == null ? 0 : this.getEffect().hashCode());
		return result;
	}

}