package pojos;

import java.io.Serializable;
import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name="DRAFT_SMS")
public class SaveSMSPOJO implements Serializable{
	@Id
	@Column(name="draft_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int draftId;
	@Column(name="message",length=160)
	private String message;
	@Column(length=12,nullable=false)
	private String sender;
	@Column(length=12)
	private String receiver;
	
	public SaveSMSPOJO() 
	{
		System.out.println("In SaveSMSPOJO constructor...");
	}

	public SaveSMSPOJO(String message, String sender, String receiver) {
		this.message = message;
		this.sender = sender;
		this.receiver = receiver;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public int getDraftId() {
		return draftId;
	}

	@Override
	public String toString()
	{
		return "Draft SMS [draftId=" + draftId + ", message=" + message
				+ ", sender=" + sender + ", receiver=" + receiver + "]";
	}	
}
