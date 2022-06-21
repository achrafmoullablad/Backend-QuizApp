package ma.projet.pfa.models;

public class EmailRequest {
	private Long id;
    private  String to;
	private String from;
    private String subject;
    private String message;
	public EmailRequest() {}
	public EmailRequest(String to,String from, String subject, String message) {
		this.to = to;
		this.from = from;
		this.subject = subject;
		this.message = message;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
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
	@Override
	public String toString() {
		return "EmailRequest [id=" + id + ", to=" + to + ", from=" + from + ", subject=" + subject + ", message="
				+ message + "]";
	}
}
