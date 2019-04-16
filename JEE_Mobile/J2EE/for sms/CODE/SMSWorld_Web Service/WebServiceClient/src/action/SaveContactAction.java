package action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import pojos.AddressBookPOJO;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.UserDAO;

@SuppressWarnings("serial")
public class SaveContactAction extends ActionSupport implements ModelDriven<AddressBookPOJO>,SessionAware
{
	AddressBookPOJO contact;
	UserDAO dao;
	Map<String, Object> sessionMap;

	public SaveContactAction()
	{
		System.out.println("In SaveContactAction constructor");
		contact = new AddressBookPOJO();
		dao = new UserDAO();
		
	}
	public SaveContactAction(AddressBookPOJO contact, UserDAO dao)
	{
		
		contact = new AddressBookPOJO();
		dao = new UserDAO();
	}

	@Override
	public AddressBookPOJO getModel() 
	{		
		return contact;
	}
	
	public String saveContact() throws Exception
	{
		contact.setUser(sessionMap.get("mobileNo").toString());
		System.out.println("contact number"+ contact.getMobileNo());
		System.out.println("contact name"+ contact.getContactName());
		if(dao.saveContact(contact))
			return SUCCESS;
		else
			return ERROR;
	}
	@Override
	public void setSession(Map<String, Object> arg0) 
	{
		sessionMap=arg0;
	}
	
	public String getContactList() throws Exception
	{
		ArrayList<AddressBookPOJO> list=dao.getContactList(sessionMap.get("mobileNo").toString());
		//if(!list.isEmpty())
		//{
			sessionMap.put("contactList", list);
		//}
		return SUCCESS;
	}
	
	public String updateContact() throws Exception
	{
		System.out.println("In updateContact");
		System.out.println("User : "+sessionMap.get("mobileNo").toString());
		System.out.println("contact number : "+ contact.getMobileNo());
		System.out.println("contact name : "+ contact.getContactName());
		
		contact.setUser(sessionMap.get("mobileNo").toString());		
		dao.updateContact(contact);
		return SUCCESS;
	}
	
	public String deleteContact() throws Exception
	{
		System.out.println("In deleteContact");
		System.out.println("User : "+sessionMap.get("mobileNo").toString());
		System.out.println("contact number : "+ contact.getMobileNo());
		System.out.println("contact name : "+ contact.getContactName());
		
		contact.setUser(sessionMap.get("mobileNo").toString());		
		dao.deleteContact(contact);
		return SUCCESS;
	}

}
