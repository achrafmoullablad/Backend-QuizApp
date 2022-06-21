package ma.projet.pfa.models.auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ma.projet.pfa.models.EmailRequest;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender javaMailSender;
	
    public void sendEmail(EmailRequest email)
    {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom(email.getFrom());
	        message.setTo(email.getTo());
	        message.setText("http://localhost:4200/test/"+email.getMessage());
	        message.setSubject(email.getSubject());
	        javaMailSender.send(message);
	        System.out.println("Mail Send...");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
    }
}
