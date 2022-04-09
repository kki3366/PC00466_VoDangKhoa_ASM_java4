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
@Table(name = "Video")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Videos {
	
	@Id
	@Column(name = "ID")
	private String id;
	
	@Column(name = "Title")
	private String title;
	
	@Column(name = "Poster")
	private String poster;
	
	@Column(name = "Views")
	private int views;
	
	@Column(name = "Description")
	private String description;
	
	@Column(name = "Active")
	private boolean active;
}
