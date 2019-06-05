package com.interview.Student;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="course")
public class Course {
	
	
	@Id
	@GeneratedValue
	private Integer id;
	private String course;

	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="student_course", inverseJoinColumns={@JoinColumn(name="cid")},
								joinColumns= {@JoinColumn(name="sid")})
	private List<Student> std;
	
	public List<Student> getStd() {
		return std;
	}
	public void setStd(List<Student> std) {
		this.std = std;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
	

}
