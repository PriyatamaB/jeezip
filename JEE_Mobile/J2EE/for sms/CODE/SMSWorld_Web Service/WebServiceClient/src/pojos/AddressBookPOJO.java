package pojos;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name= "ADDRESS_BOOK")
public class AddressBookPOJO implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cid;
	@Column(name="CONTACT_NAME", length=20)
	private String contactName;
	@Column(name="MOBILE_NO", length=12)
	private String mobileNo;
	@Column(name="USER", length=12)
	private String user;
	
	public AddressBookPOJO() 
	{
		System.out.println("In AddressBookPOJO constructor");
	}

	public AddressBookPOJO(String contactName, String mobileNo, String user) 
	{
		this.contactName = contactName;
		this.mobileNo = mobileNo;
		this.user = user;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return contactName + "	 : 	" + mobileNo;
	}
	
}
