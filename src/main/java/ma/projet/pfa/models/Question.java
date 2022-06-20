package ma.projet.pfa.models;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class Question {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String type;
	private String text;
	private int duree;
	@ManyToOne
	private Categorie categorie;
	@OneToMany(mappedBy = "question")
	@JsonManagedReference
	private List<Reponse> reponses=new ArrayList<Reponse>();
	@ManyToOne
	@JsonBackReference
	private Questionnaire questionnaire;
	public Question() {}
	public Question(String type, String text, int duree, Categorie categorie) {
		this.type = type;
		this.text = text;
		this.duree = duree;
		this.categorie = categorie;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public List<Reponse> getReponses() {
		return reponses;
	}
	public void setReponses(List<Reponse> reponses) {
		this.reponses = reponses;
	}
	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}
	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", type=" + type + ", text=" + text + ", duree=" + duree + ", categorie="
				+ categorie + ", reponses=" + reponses + ", questionnaire=" + questionnaire + "]";
	}
}
