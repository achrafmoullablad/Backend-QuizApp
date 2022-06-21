package ma.projet.pfa.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ma.projet.pfa.models.EmailRequest;
import ma.projet.pfa.models.auth.EmailService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class EmailController {
	 @Autowired
	 private EmailService emailService;
	 @PostMapping(value = "/sendemail")
	 public ResponseEntity<EmailRequest> enviarEmail(@RequestBody EmailRequest email){
	    try {
	      emailService.sendEmail(email);
	      return new ResponseEntity<>(email,  HttpStatus.OK);
	    } catch( MailException e){
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	 }
}
