package com.PC00466_VoDangKhoa_ASM_java4.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Report implements Serializable{
	
	@Id
	Serializable group;
	Long likes;
	Date newest;
	Date oldest;
	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Report(Serializable group, Long likes, Date newest, Date oldest) {
		super();
		this.group = group;
		this.likes = likes;
		this.newest = newest;
		this.oldest = oldest;
	}
	 	
	
	
	
}
