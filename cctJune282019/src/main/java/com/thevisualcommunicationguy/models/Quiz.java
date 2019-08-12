package com.thevisualcommunicationguy.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "quiz")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
	@Column(name = "dateTaken")	
	private Date dateTaken;
	
	private Integer question01;
	private Integer question02;
	private Integer question03;
	private Integer question04;
	private Integer question05;
	private Integer question06;
	private Integer question07;
	private Integer question08;
	private Integer question09;
	private Integer question10;
	
	private String username;	
	
	private String nameofpaper;	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public String getNameofpaper() {
		return nameofpaper;
	}

	public void setNameofpaper(String nameofpaper) {
		this.nameofpaper = nameofpaper;
	}
	
	public Integer getQuestion01() {
		return question01;
	}

	public void setQuestion01(Integer question01) {
		this.question01 = question01;
	}

	public Integer getQuestion02() {
		return question02;
	}

	public void setQuestion02(Integer question02) {
		this.question02 = question02;
	}

	public Integer getQuestion03() {
		return question03;
	}

	public void setQuestion03(Integer question03) {
		this.question03 = question03;
	}

	public Integer getQuestion04() {
		return question04;
	}

	public void setQuestion04(Integer question04) {
		this.question04 = question04;
	}

	public Integer getQuestion05() {
		return question05;
	}

	public void setQuestion05(Integer question05) {
		this.question05 = question05;
	}

	public Integer getQuestion06() {
		return question06;
	}

	public void setQuestion06(Integer question06) {
		this.question06 = question06;
	}

	public Integer getQuestion07() {
		return question07;
	}

	public void setQuestion07(Integer question07) {
		this.question07 = question07;
	}

	public Integer getQuestion08() {
		return question08;
	}

	public void setQuestion08(Integer question08) {
		this.question08 = question08;
	}

	public Integer getQuestion09() {
		return question09;
	}

	public void setQuestion09(Integer question09) {
		this.question09 = question09;
	}

	public Integer getQuestion10() {
		return question10;
	}

	public void setQuestion10(Integer question10) {
		this.question10 = question10;
	}	

	public Date getDateTaken() {
		return dateTaken;
	}

	public void setDateTaken(Date dateTaken) {
		this.dateTaken = dateTaken;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
