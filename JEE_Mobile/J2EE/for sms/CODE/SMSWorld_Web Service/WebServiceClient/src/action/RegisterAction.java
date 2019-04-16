package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import pojos.UserPOJO;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.UserDAO;

public class RegisterAction extends ActionSupport implements ModelDriven<UserPOJO>,SessionAware 
{
	private static final long serialVersionUID = 1L;
	
	private UserPOJO user;
	private UserDAO dao;
	Map<String ,Object> sessionMap;
	
	public RegisterAction() 
	{
		System.out.println("In RegisterAction");
		user=new UserPOJO();
		dao=new UserDAO();
	}	
	
	public UserPOJO getUser() 
	{
		return user;
	}

	public void setUser(UserPOJO user)
	{
		this.user = user;
	}

	@Override
	public void setSession(Map<String, Object> arg0) 
	{
		sessionMap=arg0;
	}
	@Override
	public UserPOJO getModel()
	{
		return user;
	}
	
	public String registerUser() throws Exception
	{
	    dao.registerUser(user);
		return SUCCESS;
	}

	@Override
	public void validate()
	{
		/*if (user.getName() == null || user.getName().length() == 0)
			addFieldError("name","Name can't be blank");
		if (user.getMbno() == null || user.getMbno().length() == 0)
			addFieldError("mbno","Mobile number can't be blank");
		if (user.getBdate() == null)
			addFieldError("bdate","Birth Date can't be blank");
		if (user.getAns() == null || user.getAns().length() == 0)
			addFieldError("ans","Answer can't be blank");*/
		if(user.getState().equalsIgnoreCase("<-- State -->"))
			addFieldError("state","Select the appropriate State");
		if(user.getCity().equalsIgnoreCase("<-- City -->"))
			addFieldError("city","Select the appropriate City");
		if(user.getQue().equalsIgnoreCase("<-- Question -->"))
			addFieldError("que","Select the appropriate Question");
	}
}
