package entities;

import javax.persistence.*;

@Entity
public class Address {
	@Id
	private int id;
	private String address;
	private String address2;
	private String city;
	@Column(name = "state_province")
	private String stateProvince;
	@Column(name = "postal_code")
	private String postalCode;
	private String phone;
	@ManyToOne
	@JoinColumn(name = "country_code")
	private Country country;
	
	public Address(){}

	public int getId() {
		return id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateProvince() {
		return stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", address=" + address + ", address2=" + address2 + ", city=" + city
				+ ", stateProvince=" + stateProvince + ", postalCode=" + postalCode + ", phone=" + phone + ", country="
				+ country + "]";
	}
	
	
}
