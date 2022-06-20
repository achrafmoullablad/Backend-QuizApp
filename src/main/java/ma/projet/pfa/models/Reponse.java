package ma.projet.pfa.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class Reponse {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String choix;
	private boolean correcte;
	@ManyToOne
	@JsonBackReference
	private Question question;
	public Reponse() {}
	public Reponse(String choix, boolean correcte) {
		this.choix = choix;
		this.correcte = correcte;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getChoix() {
		return choix;
	}
	public void setChoix(String choix) {
		this.choix = choix;
	}
	public boolean isCorrecte() {
		return correcte;
	}
	public void setCorrecte(boolean correcte) {
		this.correcte = correcte;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	@Override
	public String toString() {
		return "Reponse [id=" + id + ", choix=" + choix + ", correcte=" + correcte + ", question=" + question + "]";
	}
}
