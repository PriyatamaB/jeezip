package action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import pojos.SaveSMSPOJO;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.UserDAO;

@SuppressWarnings("serial")
public class SaveSMSAction extends ActionSupport implements ModelDriven<SaveSMSPOJO>,SessionAware
{
	SaveSMSPOJO saved;
	UserDAO dao; 
	ArrayList<SaveSMSPOJO> draftList;
	Map<String,Object> sessionMap;
	
	public SaveSMSAction() 
	{
		saved = new SaveSMSPOJO();
		dao = new UserDAO();
	}
	
	@Override
	public SaveSMSPOJO getModel() {
		return saved;
	}
		
	public String saveSMS() throws Exception
	{
		saved.setSender(sessionMap.get("mobileNo").toString());
		System.out.println("Draft SMS ACTION :: "+ saved);
		dao.saveSMS(saved);
		return SUCCESS;
	}
	
	public String draftSMSList() throws Exception
	{
		System.out.println("User "+sessionMap.get("mobileNo"));
		
		draftList=dao.getDraftSMS(sessionMap.get("mobileNo").toString());		
		if(!draftList.isEmpty())
		{
			System.out.println("SAVED SMS LIST :: " );
			for(SaveSMSPOJO s : draftList)
			{
				System.out.println(s);
			}
			sessionMap.put("draftList", draftList);
		}
			return SUCCESS;
	}
	
	@Override
	public void setSession(Map<String, Object> arg0)
	{
		sessionMap=arg0;
	}
}


