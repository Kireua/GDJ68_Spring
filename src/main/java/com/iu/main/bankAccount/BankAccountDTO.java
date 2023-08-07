package com.iu.main.bankAccount;

import java.sql.Date;

public class BankAccountDTO {
	
	private Long accountNum;
	private String id;
	private Long bookNum;
	private Long account;
	private String accountPw;
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
	public String getAccountPw() {
		return accountPw;
	}
	public void setAccountPw(String accountPw) {
		this.accountPw = accountPw;
	}
	public Long getBalance() {
		if(this.balance==null) {
			this.balance=0L;
		}
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
