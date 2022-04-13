package com.PC00466_VoDangKhoa_ASM_java4.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ShareUser implements Serializable{

	
	@Id
	Serializable fullname1;
	
	String toEmail;
//	
	Date dateShare1;


	public ShareUser() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ShareUser(Serializable fullname1, String toEmail, Date dateShare1) {
		super();
		this.fullname1 = fullname1;
		this.toEmail = toEmail;
		this.dateShare1 = dateShare1;
	}


	
	
}
