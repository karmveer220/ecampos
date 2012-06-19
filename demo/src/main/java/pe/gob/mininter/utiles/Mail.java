package pe.gob.mininter.utiles;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
 
public class Mail {

	private JavaMailSender mailSender;

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void sendMail(String from, String to, String cc, String subject,
			String msg) {
		try {

			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setCc(cc);
			helper.setSubject(subject);
			helper.setText(msg, true);
			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}