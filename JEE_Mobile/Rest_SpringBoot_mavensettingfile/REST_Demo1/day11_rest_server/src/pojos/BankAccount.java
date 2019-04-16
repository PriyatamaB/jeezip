package pojos;
import javax.persistence.*;
@Entity
@Table(name="accounts")
public class BankAccount {
	private Integer acctId;
	private String name;
	private int pin;
	private String type;
	private double balance;
	
	public BankAccount() {
		System.out.println("bank acct cnstr");
	}
	public BankAccount(int pin,String type, double balance) {
		super();
		this.pin=pin;
		this.type = type;
		this.balance = balance;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public Integer getAcctId() {
		return acctId;
	}
	public void setAcctId(Integer acctId) {
		this.acctId = acctId;
	}
	
	
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Column(name="bal")
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "BankAccount [acctId=" + acctId + ", type=" + type + ", balance=" + balance + "]";
	}
	

}
