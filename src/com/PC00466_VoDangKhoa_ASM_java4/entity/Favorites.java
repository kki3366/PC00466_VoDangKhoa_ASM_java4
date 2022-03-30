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
@Table(name = "Favorite")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Favorites {
	
	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "UserID")
	private String userId;
	
	@Column(name = "VideoID")
	private String videoId;
	
	@Column(name = "LikeDate")
	private Date likedate;
}
