package com.quaqua.sms.student;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.quaqua.sms.department.Department;

@Entity
@Table(name = "Student")
public class StudentDetails implements Serializable{
	
	@Override
	public String toString() {
		return "StudentDetails [id=" + id + ", fname=" + fname + ", lname=" + lname + ", phone_no=" + phone_no
				+ ", email=" + email + ", gender=" + gender + ", department=" + department + "]";
	}

	private static final long serialVersionUID = -1798070786993154676L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="f_name",nullable=false)
	private String fname;
	
	@Column(name="l_name")
	private String lname;
	
	@Column(name="phone_no",nullable=false)
	private Long phone_no;
	
	@Column(name="email",nullable=false)
	private String email;
	
	@Column(name="sex",nullable=false)
	private String gender;
	
	@ManyToOne
	@JoinColumn(name = "fk_department")
	private Department department;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Long getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(Long phone_no) {
		this.phone_no = phone_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	
	
	
//	@ManyToOne(cascade=CascadeType.ALL)
//	@JoinColumn(n)
//	private Address address; 
//	
//	
//	 @ManyToMany(cascade=CascadeType.PERSIST)
//	    @JoinTable(name="StudentDetails_Department", joinColumns={@JoinColumn(referencedColumnName="stu_id")}
//	                                        , inverseJoinColumns={@JoinColumn(referencedColumnName="dept_id")}) 
//	private List <Department> dept;
     
	
}