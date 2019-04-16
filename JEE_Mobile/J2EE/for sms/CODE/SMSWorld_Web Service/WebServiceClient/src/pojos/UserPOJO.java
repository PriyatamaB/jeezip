package pojos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name="REGISTRATION")
public class UserPOJO implements Serializable
{
	@Id
	@Column(length=12)
	String mbno;
	@Column(length=20)
	String name; 
	@Column(length=12)
	String password;
	@Temporal(TemporalType.DATE)
	@Column(length=15)
	Date bdate;
	@Column(length=10)
	String gender;
	@Column(length=20)
	String state;
	@Column(length=15)
	String city;
	@Column(length=30)
	String que;
	@Column(length=20)
	String ans;
	
	public UserPOJO() 
	{
		System.out.println("In UserPOJO constructor");
	}

	public UserPOJO(String mbno, String name, String password, Date bdate,
			String gender, String state, String city, String que, String ans) {
		this.mbno = mbno;
		this.name = name;
		this.password = password;
		this.bdate = bdate;
		this.gender = gender;
		this.state = state;
		this.city = city;
		this.que = que;
		this.ans = ans;
	}

	public String getMbno() {
		return mbno;
	}

	public void setMbno(String mbno) {
		this.mbno = mbno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBdate() {
		return bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getQue() {
		return que;
	}

	public void setQue(String que) {
		this.que = que;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	@Override
	public String toString() {
		return "User Details [mbno=" + mbno + ", name=" + name + ", password="
				+ password + ", bdate=" + bdate + ", gender=" + gender
				+ ", state=" + state + ", city=" + city + ", que=" + que
				+ ", ans=" + ans + "]";
	}	
	
}