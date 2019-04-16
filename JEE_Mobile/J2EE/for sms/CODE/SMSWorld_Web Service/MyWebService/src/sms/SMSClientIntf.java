package sms;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface SMSClientIntf
{
	@WebMethod
	public int sendMessage (@WebParam(name="recipient") String recipient,@WebParam(name="message") String message);
}
  