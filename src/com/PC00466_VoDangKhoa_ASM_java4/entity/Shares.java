package com.PC00466_VoDangKhoa_ASM_java4.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Share",
			uniqueConstraints = {
					@UniqueConstraint(columnNames = {
							"UserID","VideoID"
					})
			})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Shares {

	
	@Id
	Long id;
	
	@Column(name = "Emails")
	String emailshare;
	
	@Temporal(TemporalType.DATE)
	Date shareDate= new Date();
	
	
	@ManyToOne(targetEntity = Users.class, fetch = FetchType.LAZY) @JoinColumn(name = "UserID")
	Users user_share;
	
	@ManyToOne(targetEntity = Videos.class, fetch =  FetchType.LAZY) @JoinColumn(name = "VideoID")
	Videos video_share;
}
