package pe.gob.mininter.utiles;

import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
 
public class Mail{
	
 private static final Logger logger = Logger.getLogger(Mail.class);
 
	
	private JavaMailSender mailSender;
	
	
 
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void sendMail(String from, String to, String subject, String msg) {
 try {
	 
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setTo(to);
		helper.setFrom(from);
		helper.setSubject(subject);
		helper.setText(msg, true);
		mailSender.send(message);
		logger.debug("enviado");
	
		
} catch (Exception e) { e.printStackTrace(); }
	
	}
}