package p1;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@SuppressWarnings("serial")
public class SendMail extends HttpServlet 
{
	MailForm form ;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		form =new MailForm();
		form.setFrom(req.getParameter("from"));
		form.setMessage(req.getParameter("message"));
		form.setTo(req.getParameter("to"));
		form.setSubject(req.getParameter("subject"));
		form.setSmtpServ("smtp.gmail.com");
		sendMail();
	}



public int sendMail(){
    try
    {
        Properties props = System.getProperties();
          // -- Attaching to default Session, or we could start a new one --
          props.put("mail.transport.protocol", "smtp" );
          props.put("mail.smtp.starttls.enable","true" );
          props.put("mail.smtp.host","smtp.gmail.com");
          props.put("mail.smtp.auth", "true" );
          props.put("mail.smtp.port", "587");
          props.put("mail.smtp.auth", "true");
  		 props.put("mail.smtp.starttls.enable", "true");
  		 
  		 Authenticator auth = new SMTPAuthenticator();
          Session session = Session.getInstance(props, auth);
          // -- Create a new message --
          Message msg = new MimeMessage(session);
          // -- Set the FROM and TO fields --
          System.out.println(msg);
          msg.setFrom(new InternetAddress("smita@sunbeaminfo.com"));
          msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(form.getTo(), false));
          msg.setSubject(form.getSubject());
          msg.setText(form.getMessage());
          // -- Set some other header information --
          msg.setHeader("MyMail", "Mr. XYZ" );
          msg.setSentDate(new Date());
          // -- Send the message --
          Transport.send(msg);
          System.out.println("Message sent to"+ form.getTo()+" OK." );
          return 0;
    }
     catch (Exception ex)
    {
      ex.printStackTrace();
      System.out.println("Exception "+ex);
      return -1;
    }
}
private class SMTPAuthenticator extends javax.mail.Authenticator {
    @Override
    public PasswordAuthentication getPasswordAuthentication() {
        String username =  "smita@......com";           // specify your email id here (sender's email id)
        String password = "...";                                      // specify your password here
        return new PasswordAuthentication(username, password);
    }
}
}

