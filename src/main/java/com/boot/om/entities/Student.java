package com.boot.om.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "student")
public class Student {

	@Id 
	@GeneratedValue
	@Column(name = "id")
	private Long Id;	
	
	@Column(name = "s_name",length = 48,unique = true)
	@NonNull
	private String sname;
	
	@Column(name = "course",length = 56)
	@NonNull
	private String course;
	
	@Column(name = "fee")
	@NonNull
	private Double fee;
	
	
}
