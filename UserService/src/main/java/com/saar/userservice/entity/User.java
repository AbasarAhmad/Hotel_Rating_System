package com.saar.userservice.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

	@Id
	@Column(name="id")
	private String userId;
	@Column(length=20)
	private String name;
	private String email;
	private String about;
	
	@Transient   // Transient ki vjah se ratings ko database mai store nhi krega 
	private List<Rating> ratings=new ArrayList<>();
}
