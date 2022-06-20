package ma.projet.pfa.models;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class Categorie {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	@OneToMany(mappedBy = "categorie")
	@JsonIgnore
	private List<Question> questions=new ArrayList<Question>();
	@OneToMany(mappedBy = "categories")
	@JsonIgnore
	private List<Questionnaire> questionnaire=new ArrayList<Questionnaire>();
	public Categorie() {}
	public Categorie(String nom) {
		this.nom = nom;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	public List<Questionnaire> getQuestionnaire() {
		return questionnaire;
	}
	public void setQuestionnaire(List<Questionnaire> questionnaire) {
		this.questionnaire = questionnaire;
	}
	@Override
	public String toString() {
		return "Categorie [id=" + id + ", nom=" + nom + ", questions=" + questions + ", questionnaire=" + questionnaire
				+ "]";
	}
}
