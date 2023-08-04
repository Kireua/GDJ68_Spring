package com.iu.main.BankAccount;

import java.sql.Date;

public class BankAccountDTO {
	
	private Long accountNum;
	private String id;
	private Long bookNum;
	private Long account;
	private Long accountPw;
	private Long balance;
	private Date accountDate;
	public Long getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(Long accountNum) {
		this.accountNum = accountNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getBookNum() {
		return bookNum;
	}
	public void setBookNum(Long bookNum) {
		this.bookNum = bookNum;
	}
	public Long getAccount() {
		return account;
	}
	public void setAccount(Long account) {
		this.account = account;
	}
	public Long getAccountPw() {
		return accountPw;
	}
	public void setAccountPw(Long accountPw) {
		this.accountPw = accountPw;
	}
	public Long getBalance() {
		return balance;
	}
	public void setBalance(Long balance) {
		this.balance = balance;
	}
	public Date getAccountDate() {
		return accountDate;
	}
	public void setAccountDate(Date accountDate) {
		this.accountDate = accountDate;
	}

}
