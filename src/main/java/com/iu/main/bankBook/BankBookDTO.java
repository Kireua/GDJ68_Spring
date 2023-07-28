package com.iu.main.bankBook;

import java.util.List;

public class BankBookDTO {
	
	//컬럼명과 변수명은 동일하게
	
	private Long bookNum;
	private String bookName;
	private Double bookRate;
	private Integer bookSale;
	private String bookContents;
	private List<BankFileDTO> bankFileDTOs;
	
	
	public List<BankFileDTO> getBankFileDTOs() {
		return bankFileDTOs;
	}
	public void setBankFileDTOs(List<BankFileDTO> bankFileDTOs) {
		this.bankFileDTOs = bankFileDTOs;
	}
	public Long getBookNum() {
		return bookNum;
	}
	public void setBookNum(Long bookNum) {
		this.bookNum = bookNum;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Double getBookRate() {
		return bookRate;
	}
	public void setBookRate(Double bookRate) {
		this.bookRate = bookRate;
	}
	public Integer getBookSale() {
		return bookSale;
	}
	public void setBookSale(Integer bookSale) {
		this.bookSale = bookSale;
	}
	public String getBookContents() {
		return bookContents;
	}
	public void setBookContents(String bookContents) {
		this.bookContents = bookContents;
	}
	
	
}
