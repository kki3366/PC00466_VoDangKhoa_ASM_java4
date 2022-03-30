package com.PC00466_VoDangKhoa_ASM_java4.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Share")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Shares {
	
	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "UserID")
	private String userId;
	
	@Column(name = "VideoID")
	private String videoId;
	
	@Column(name = "Emails")
	private String emails;
	
	@Column(name = "ShareDate")
	private Date sharedate;
}
