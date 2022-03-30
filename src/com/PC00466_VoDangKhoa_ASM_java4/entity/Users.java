package com.PC00466_VoDangKhoa_ASM_java4.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {

	@Id
	@Column(name = "ID")
	private String id;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "FullName")
	private String fullname;
	
	@Column(name = "Email")
	private String email;
	@Column(name = "Role")
	private Boolean role = false;
}
