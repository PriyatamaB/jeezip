package action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import pojos.SentSMSPOJO;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.UserDAO;

@SuppressWarnings("serial")
public class SentSMSAction extends ActionSupport implements ModelDriven<SentSMSPOJO>,SessionAware
{
	SentSMSPOJO sent;
	UserDAO dao; 
	ArrayList<SentSMSPOJO> smsList;
	Map<String,Object> sessionMap;
	
	public SentSMSAction() 
	{
		sent = new SentSMSPOJO();
		dao = new UserDAO();
	}
	
	@Override
	public SentSMSPOJO getModel() {
		return sent;
	}
		
	public String sentSMS() throws Exception
	{
		sent.setSender(sessionMap.get("mobileNo").toString());
		System.out.println("SENT SMS ACTION :: "+ sent);
		dao.sendSMS(sent);
		return SUCCESS;
	}
	
	public String sentSMSList() throws Exception
	{
		System.out.println("User "+sessionMap.get("mobileNo"));
		
		smsList=dao.getSentSMS(sessionMap.get("mobileNo").toString());		
		if(!smsList.isEmpty())
		{
			//System.out.println("SENT SMS LIST :: ");
			for(SentSMSPOJO s : smsList)
			{
				System.out.println(s);
			}
			sessionMap.put("smslist", smsList);
		}
			return SUCCESS;
	}
	

	@Override
	public void setSession(Map<String, Object> arg0)
	{
		sessionMap=arg0;
	}

	/*@Override
	public void validate()
	{
		System.out.println("send validate..");
		if(sent.getReceiver()==null || sent.getReceiver().length()==0)
		{
			addFieldError("receiver", "Please Enter Mobile Number..");
		}
		if(sent.getMessage()==null || sent.getMessage().length()==0)
		{
			addFieldError("message", "Please Enter message..");
		}
		
	}*/
	
	
}


