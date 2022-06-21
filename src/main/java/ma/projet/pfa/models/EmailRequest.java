package ma.projet.pfa.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmailRequest {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private  String touser;
	private String fromuser;
    private String subject;
    private String message;
    private int score;
	public EmailRequest() {}
	public EmailRequest(String touser, String fromuser, String subject, String message) {
		this.touser = touser;
		this.fromuser = fromuser;
		this.subject = subject;
		this.message = message;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getFromuser() {
		return fromuser;
	}
	public void setFromuser(String fromuser) {
		this.fromuser = fromuser;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "EmailRequest [id=" + id + ", touser=" + touser + ", fromuser=" + fromuser + ", subject=" + subject
				+ ", message=" + message + ", score=" + score + "]";
	}
}
