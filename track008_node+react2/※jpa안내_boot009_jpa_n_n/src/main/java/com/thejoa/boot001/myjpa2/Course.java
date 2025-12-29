package com.thejoa.boot001.myjpa2;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity  @Getter  @Setter  @NoArgsConstructor
public class Course {
	@Id  @GeneratedValue
	private Long id;
	private String content;
	private String title;
	
	@ManyToMany(mappedBy="courses")
	private List<Student> students = new ArrayList<>();

}
 
