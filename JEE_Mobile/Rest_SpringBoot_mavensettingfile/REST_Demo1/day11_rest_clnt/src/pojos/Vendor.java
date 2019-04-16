package pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.internal.NotNull;

@Entity // mandatory
@Table(name = "dac_hib_vendors")
public class Vendor {
	private Integer id;
	@NotEmpty(message = "Name must supplied")
	private String name;
	@NotEmpty(message = "Email must supplied")
	@Email
	private String email;
	@NotEmpty
	@Length(min = 3, max = 10)
	private String city;
	@NotEmpty
	@Length(min = 10, max = 10, message = "phone no must be 10 digits long")
	private String phoneNo;
	@NotNull
	@Range(min = 500, max = 2500, message = "Reg amount must be in range of 500 to 2500")
	private double regAmount;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regDate = new Date();
	// one-to-many bin dir
	private List<Part> parts = new ArrayList<>();

	public Vendor() {
		// System.out.println("in vendor constr");
	}

	public Vendor(String name, String email, String city, String phoneNo, double regAmount, Date regDate) {
		super();
		this.name = name;
		this.email = email;
		this.city = city;
		this.phoneNo = phoneNo;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}

	@Id // mandatory
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vendor_id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length = 10, unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 10)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "ph_no", length = 10)
	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Column(name = "reg_amt", columnDefinition = "double(6,1)")
	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "reg_date")
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
	public List<Part> getParts() {
		return parts;
	}

	public void setParts(List<Part> parts) {
		this.parts = parts;
	}

	public void addPart(Part p) {
		parts.add(p);
		p.setSupplier(this);
	}

	public void removePart(Part p) {
		parts.remove(p);
		p.setSupplier(null);
	}

	@Override
	public String toString() {
		return "Vendor [id=" + id + ", name=" + name + ", email=" + email + ", city=" + city + ", phoneNo=" + phoneNo
				+ ", regAmount=" + regAmount + ", regDate=" + regDate + "]";
	}

}
