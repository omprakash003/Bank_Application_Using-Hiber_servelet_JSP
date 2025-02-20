package Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import antlr.collections.impl.IntRange;

@Entity
public class customer {
	@Id
	private int userid;
	private String name;
	private String phnumber;
	private Long balance;
	private int tranxid;
	private String DOB;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhnumber() {
		return phnumber;
	}
	public void setPhnumber(String phnumber) {
		this.phnumber = phnumber;
	}
	public Long getBalance() {
		return balance;
	}
	public void setBalance(Long balance) {
		this.balance = balance;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public int getranxid() {
		return tranxid;
	}
	public customer(int userid, String name, String phnumber, Long balance, int tranxid, String dOB) {
		super();
		this.userid = userid;
		this.name = name;
		this.phnumber = phnumber;
		this.balance = balance;
		this.tranxid = tranxid;
		DOB = dOB;
	}
	public customer() {
		super();
	}
	
	
	

}
