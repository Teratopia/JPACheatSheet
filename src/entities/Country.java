package entities;

import javax.persistence.*;

@Entity
public class Country {
	@Id
	@Column(name = "country_code")
	private String countryCode;
	@Column(name = "country")
	private String name;
	
	public Country(){}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country [countryCode=" + countryCode + ", name=" + name + "]";
	}
	
	
	

}
