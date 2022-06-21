package ma.projet.pfa.models.auth;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ma.projet.pfa.models.EmailRequest;
import ma.projet.pfa.repositorie.EmailRepository;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private EmailRepository emailRepository;
    public void sendEmail(EmailRequest email)
    {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom(email.getFromuser());
	        message.setTo(email.getTouser());
	        message.setText("http://localhost:4200/test/"+email.getMessage());
	        message.setSubject(email.getSubject());
	        emailRepository.save(email);
	        javaMailSender.send(message);
	        System.out.println("Mail Send...");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
    }
    public List<EmailRequest> getAllEmail(){
    	return (List<EmailRequest>) emailRepository.findAll();
    }
}
