package com.PC00466_VoDangKhoa_ASM_java4.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter

public class FavoriteUser implements Serializable {
	
	@Id
	String group;
	
	String email;
	
	String fullname;
	
	Date favoriteDate;


	public FavoriteUser() {
		super();
		// TODO Auto-generated constructor stub
	}


	public FavoriteUser(String group, String email, String fullname, Date favoriteDate) {
		super();
		this.group = group;
		this.email = email;
		this.fullname = fullname;
		this.favoriteDate = favoriteDate;
	}

}
