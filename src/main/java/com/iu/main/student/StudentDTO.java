package com.iu.main.student;

public class StudentDTO {


	private Long studNum;
	
	private String name;
	
	private Integer korean;
	
	private Integer english;
	
	private Integer math;
	
	private Integer total;
	
	private Double average;
	
	public Double getAverage() {
		return average;
	}

	public void setAverage(Double average) {
		this.average = average;
	}

	public void cal() {
		this.total = this.korean+this.english+this.math;
		this.average = (this.total)/3.0;
				
	}

	public Long getStudNum() {
		return studNum;
	}

	public void setStudNum(Long studNum) {
		this.studNum = studNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getKorean() {
		return korean;
	}

	public void setKorean(Integer korean) {
		this.korean = korean;
	}

	public Integer getEnglish() {
		return english;
	}

	public void setEnglish(Integer english) {
		this.english = english;
	}

	public Integer getMath() {
		return math;
	}

	public void setMath(Integer math) {
		this.math = math;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}


}
