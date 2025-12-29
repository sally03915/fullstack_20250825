package com.thejoa.boot001.myjpa2;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity  @Getter  @Setter  @NoArgsConstructor
public class Student {
	@Id  @GeneratedValue
	private Long id;
	private String name;
	
	@ManyToMany
	@JoinTable(
		name="stduent_course" , 
		joinColumns = @JoinColumn(name="student_id") , 
		inverseJoinColumns  = @JoinColumn(name="course_id")
	)
	private List<Course> courses = new ArrayList<>();
}
