package dao;


import java.util.ArrayList;
import java.util.Calendar;
import org.hibernate.*;
import pojos.AddressBookPOJO;
import pojos.SaveSMSPOJO;
import pojos.SentSMSPOJO;
import pojos.UserPOJO;
import ws.SMSClientIntf;
import sun.security.mscapi.SunMSCAPI;
import utils.HibernateUtils;
import ws.SMSClientService;
public class UserDAO 
{	
	public void registerUser(UserPOJO u) throws Exception
	{		
		System.out.println("USER :: "+u);
		Session hs = HibernateUtils.getSession();
		Transaction tx = null;
		try {
			tx = hs.beginTransaction();
			String n=u.getName();
		    String pwd=n.substring(0,3)+"123";
			u.setPassword(pwd);
			System.out.println("Password :: "+u.getPassword());
			SMSClientService smsService=new SMSClientService();
			SMSClientIntf clientintf= smsService.getSMSClientPort();
			//SMSClient sms=new SMSClient(1);
			int st=clientintf.sendMessage(u.getMbno(),"Your Password Is ::"+u.getPassword());
			System.out.println("status :: "+st);
			
			//new Sender(u.getMbno(), "Your Password Is ::"+u.getPassword());
			if(u!=null)
			hs.save(u);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (hs != null)
				hs.close();
		}

	}
	
	public UserPOJO validateUser(String nm, String pass) throws Exception {
		Session hs = HibernateUtils.getSession();
		Transaction tx = null;
		try {
			System.out.println("In validate user");
			tx = hs.beginTransaction();
			String hql = "from UserPOJO b where b.mbno = :nm and b.password = :pass";

			UserPOJO u = (UserPOJO) hs.createQuery(hql)
					.setParameter("nm", nm).setParameter("pass", pass)
					.uniqueResult();
			if(u!=null)
			tx.commit();
			return u;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (hs != null)
				hs.close();
		}

	}
	
	public UserPOJO getQuestion(String mbno) throws Exception {
		Session hs = HibernateUtils.getSession();
		Transaction tx = null;
		try {
			tx = hs.beginTransaction();
			String hql = "from UserPOJO b where b.mbno = :nm";

			UserPOJO u = (UserPOJO) hs.createQuery(hql)
					.setParameter("nm", mbno).uniqueResult();
			//String question=u.getQue();
			//session.setAttribute("userinfo",u);
			if(u!=null)
			tx.commit();
			return u;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (hs != null)
				hs.close();
		}

	}
	
	public void sendSMS(SentSMSPOJO sms) throws Exception {
		Session hsession = HibernateUtils.getSession();
		Transaction tx = null;
		System.out.println("SMS Details :: "+ sms);
		try {
			tx = hsession.beginTransaction();
			sms.setSendTime(Calendar.getInstance().getTime());
			sms.setSendDate(Calendar.getInstance().getTime());
			//System.out.println("TIME :: "+sms.getSendTime());
			//sms.setSender("9975751098");
			System.out.println("SMS Details :: "+ sms);
			SMSClientService smsService=new SMSClientService();
			SMSClientIntf clientintf= smsService.getSMSClientPort();
			//SMSClient cl=new SMSClient(1);
			String num=sms.getReceiver();
			int status=clientintf.sendMessage(num,sms.getMessage()+ "\n"+ sms.getSender()+"\n" + "via SmsWorld.com");
			System.out.print("Status :: "+status);
			if(sms!=null)
				hsession.save(sms);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (hsession != null)
				hsession.close();
		}

	}
	
	public ArrayList<SentSMSPOJO> getSentSMS(String sender) throws Exception 
	{
		System.out.println("In getSentSMS Method"+sender);
		Session hs = HibernateUtils.getSession();
		Transaction tx = null;
		try {
			tx = hs.beginTransaction();
			String hql = "from SentSMSPOJO b where b.sender = :send";
			@SuppressWarnings("unchecked")
			ArrayList<SentSMSPOJO> slist = (ArrayList<SentSMSPOJO>) hs.createQuery(hql)
			.setParameter("send", sender).list();	
			if(slist!=null)
				System.out.println("");
			tx.commit();
			return slist;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (hs != null)
				hs.close();
		}

	}
	public void saveSMS(SaveSMSPOJO sms) throws Exception {
		Session hsession = HibernateUtils.getSession();
		Transaction tx = null;
		System.out.println("SMS Details :: "+ sms);
		try {
			tx = hsession.beginTransaction();
			
			//System.out.println("TIME :: "+sms.getSendTime());
			//sms.setSender("9975751098");
			System.out.println("SMS Details :: "+ sms);
			if(sms!=null)
				hsession.save(sms);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (hsession != null)
				hsession.close();
		}
	}
	
	public ArrayList<SaveSMSPOJO> getDraftSMS(String sender) throws Exception 
	{
		System.out.println("In getSentSMS Method"+sender);
		Session hs = HibernateUtils.getSession();
		Transaction tx = null;
		try {
			tx = hs.beginTransaction();
			String hql = "from SaveSMSPOJO b where b.sender = :send";
			@SuppressWarnings("unchecked")
			ArrayList<SaveSMSPOJO> slist = (ArrayList<SaveSMSPOJO>) hs.createQuery(hql)
			.setParameter("send", sender).list();	
			if(slist!=null)
				System.out.println("");
			tx.commit();
			return slist;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (hs != null)
				hs.close();
		}

	}
	
	
	
	
	
	public boolean saveContact(AddressBookPOJO addr) throws Exception 
	{	
		Session hs = HibernateUtils.getSession();
		Transaction tx = null;
		try {
			tx = hs.beginTransaction();
			System.out.println("Contact Details :: "+ addr);
			
			String hql="from AddressBookPOJO b where b.user = :u and b.mobileNo = :m";
			AddressBookPOJO a=(AddressBookPOJO)hs.createQuery(hql).setParameter("u",addr.getUser()).setParameter("m", addr.getMobileNo()).uniqueResult();
			
			if(a==null)
			{
				if(addr!=null)
				{
					hs.save(addr);
					return true;
				}
			}			
			tx.commit();
			return false;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (hs != null)
				hs.close();
		}

	}
	
	public ArrayList<AddressBookPOJO> getContactList(String user) throws Exception 
	{
		System.out.println("In getContactList Method"+user);
		Session hs = HibernateUtils.getSession();
		Transaction tx = null;
		try {
			tx = hs.beginTransaction();
			String hql = "from AddressBookPOJO b where b.user = :u";
			@SuppressWarnings("unchecked")
			ArrayList<AddressBookPOJO> ulist = (ArrayList<AddressBookPOJO>) hs.createQuery(hql)
			.setParameter("u", user).list();	
			
			tx.commit();
			return ulist;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (hs != null)
				hs.close();
		}
	}
	
	public void updateContact(AddressBookPOJO addr) throws Exception 
	{	
		Session hs = HibernateUtils.getSession();
		Transaction tx = null;
		try {
			tx = hs.beginTransaction();
			String hql="from AddressBookPOJO b where b.user = :u and b.mobileNo = :m";
			AddressBookPOJO a=(AddressBookPOJO)hs.createQuery(hql).setParameter("u",addr.getUser()).setParameter("m", addr.getMobileNo()).uniqueResult();
			if(a!=null)
			{
				a.setContactName(addr.getContactName());
				System.out.println("In update contact in dao: "+a);
			}
			tx.commit();
			
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (hs != null)
				hs.close();
		}
	}
	
	public void deleteContact(AddressBookPOJO addr) throws Exception 
	{	
		Session hs = HibernateUtils.getSession();
		Transaction tx = null;
		try {
			tx = hs.beginTransaction();
			String hql="from AddressBookPOJO b where b.user = :u and b.mobileNo = :m";
			AddressBookPOJO a=(AddressBookPOJO)hs.createQuery(hql).setParameter("u",addr.getUser()).setParameter("m", addr.getMobileNo()).uniqueResult();
			if(a!=null)
			{
				System.out.println("In delete contact in dao: "+a);
				hs.delete(a);				
			}
			tx.commit();
			
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (hs != null)
				hs.close();
		}

	}
	
	public void changePassword(UserPOJO u) throws Exception 
	{	
		Session hs = HibernateUtils.getSession();
		Transaction tx = null;
		try {
			tx = hs.beginTransaction();
			String hql="from UserPOJO b where b.mbno =:m";
			System.out.println("Mobile no  ::"+u.getMbno());
			UserPOJO a=(UserPOJO)hs.createQuery(hql).setParameter("m", u.getMbno()).uniqueResult();
			if(a!=null)
			{
				a.setPassword(u.getPassword());
				
				System.out.println("In Changed contact in dao: "+u.getPassword());
			}
			tx.commit();
			
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (hs != null)
				hs.close();
		}
	}
}
