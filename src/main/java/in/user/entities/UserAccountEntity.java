package in.user.entities;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name="USER_ACCOUNT")
@Data
public class UserAccountEntity {
	@Id
	@GeneratedValue
	@Column(name="USER_ID")
	private Integer userId;
	
	
	@Column(name="FIRST_NAME")
	private String fname;

	@Column(name="LAST_NAME")
	private String lname;
	
	@Column(name="USER_EMAIL",unique=true)
	private String email ;
	
	@Column(name="USER_PWD")
	private String password;
	
	@Column(name="USER_MOBILE")
	private Long phno;
	
	@Column(name="DBO")
	private LocalDate dob;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="CITY_ID")
	private Integer cityId;
	
	@Column(name="STATE_ID")
	private Integer stateId;
	
	@Column(name="COUNTRY_ID")
	private Integer countryId;
	
	@Column(name="ACC_STATUS")
	private String accStatus;
	
	@Column(name="CREATED_DATE",updatable=false)
	@CreationTimestamp
	private LocalDate createdDate;
	
	@UpdateTimestamp
	@Column(name="UPDATED_NAME",insertable=false)
	private LocalDate updatedDate;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPhno() {
		return phno;
	}

	public void setPhno(Long phno) {
		this.phno = phno;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getAccStatus() {
		return accStatus;
	}

	public void setAccStatus(String accStatus) {
		this.accStatus = accStatus;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
	
}
