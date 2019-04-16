package pojos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name="SENT_SMS")
public class SentSMSPOJO implements Serializable{
	@Id
	@Column(name="msg_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int msgId;
	@Column(name="message",length=160)
	private String message;
	@Column(length=12,nullable=false)
	private String sender;
	@Column(length=12,nullable=false)
	private String receiver;
	@Temporal(TemporalType.TIME)
	private Date sendTime;	
	@Temporal(TemporalType.DATE)
	private Date sendDate;
	
	public SentSMSPOJO() 
	{
		System.out.println("In SentSMSPOJO constructor...");
	}

	public SentSMSPOJO(String message, String sender, String receiver,
			Date sendTime, Date sendDate) 
	{
		this.message = message;
		this.sender = sender;
		this.receiver = receiver;
		this.sendTime = sendTime;
		this.sendDate = sendDate;
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

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public int getMsgId() {
		return msgId;
	}

	@Override
	public String toString() {
		return "SentSMS Details [msgId=" + msgId + ", message=" + message
				+ ", sender=" + sender + ", receiver=" + receiver
				+ ", sendTime=" + sendTime + ", sendDate=" + sendDate + "]";
	}
	
}
