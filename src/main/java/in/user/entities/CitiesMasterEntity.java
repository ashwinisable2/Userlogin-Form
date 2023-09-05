package in.user.entities;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name="CITIES_MASTER")
@Data
public class CitiesMasterEntity {
	@Id
	@GeneratedValue
	@Column(name="CITY_ID")
	private Integer cityId;
	
	
	@Column(name="CITY_NAME")
	private String cityName;
	
	
	@Column(name="STATE_ID")
	private Integer stateId;


	public Integer getCityId() {
		return cityId;
	}


	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}


	public String getCityName() {
		return cityName;
	}


	public void setCityName(String cityName) {
		this.cityName = cityName;
	}


	public Integer getStateId() {
		return stateId;
	}


	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	
	
}
