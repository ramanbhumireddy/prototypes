package com.example.demo.model;

public class Member {
	
	private long memberId;
	private String name;
	private String address;
	private MemberType memberType;
	private long memberDate;
	private long expiryDate;
	
	public long getMemberId() {
		return memberId;
	}
	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public MemberType getMemberType() {
		return memberType;
	}
	public void setMemberType(MemberType memberType) {
		this.memberType = memberType;
	}
	public long getMemberDate() {
		return memberDate;
	}
	public void setMemberDate(long memberDate) {
		this.memberDate = memberDate;
	}
	public long getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(long expiryDate) {
		this.expiryDate = expiryDate;
	}
		
	
	

}
