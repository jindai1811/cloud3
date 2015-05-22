package com.serket.cloud.bean;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.sql.Timestamp;

/**
 * Pharmacy entity. @author MyEclipse Persistence Tools
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Pharmacy implements java.io.Serializable {

    //	default 0  normal,-1 delete ,1 forbidden

    public static final int NORMAL = 0;

    public static final int DELETE = -1;
    public static final int FORBIDDEN = 1;

    private String id;

    private String name;
    private String password;
    private String remarks;
    private Timestamp registerDate;
    private String phone;
    private String address;
    private Integer state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Timestamp getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Timestamp registerDate) {
        this.registerDate = registerDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}