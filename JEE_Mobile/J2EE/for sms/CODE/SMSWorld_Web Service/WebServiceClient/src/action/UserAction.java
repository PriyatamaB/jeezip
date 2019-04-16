package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import pojos.UserPOJO;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.UserDAO;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport implements ModelDriven<UserPOJO>,SessionAware
{
	private UserPOJO user;
	private UserDAO dao;
	Map<String ,Object> sessionMap;
	public UserAction() {
		System.out.println("in validate user action constr");
		user=new UserPOJO();
		dao=new UserDAO();
	}
	@Override
	public UserPOJO getModel() 
	{
		return user;
	}
	public UserPOJO getUser() {
		return user;
	}
	public void setUser(UserPOJO user) {
		this.user = user;
	}
	
	public String validateUser() throws Exception
	{
		System.out.println("------->"+user.getMbno()+"    "+user.getPassword());
		user=dao.validateUser(user.getMbno(),user.getPassword());
		if (user != null)
		{
			sessionMap.put("userInfo", user);
			return SUCCESS;
		}
		return ERROR;
	}

	/*public String registerUser() throws Exception
	{
	    dao.registerUser(user);
		return SUCCESS;
	}*/
	@Override
	public void setSession(Map<String, Object> arg0) 
	{
		sessionMap=arg0;
	}
	public String getQuestion() throws Exception
	{
		user=dao.getQuestion(user.getMbno());
		if (user != null)
		{
			sessionMap.put("userInfo", user);
			return SUCCESS;
		}
		return ERROR;
		
	}
	public String changePassword() throws Exception
	{
	   System.out.println("password  ::"+user.getPassword());
	  // user.setPassword(password)
		dao.changePassword(user);
		return SUCCESS;
	}
	/*@Override
	public void validate()
	{
		if (user.getName() == null || user.getName().length() == 0)
			addFieldError("name","Name can't be blank");
		if (user.getAns() == null || user.getAns().length() == 0)
			addFieldError("ans","Answer can't be blank");
		
	}*/
	
	
}
