package ma.projet.pfa.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ma.projet.pfa.models.Categorie;
import ma.projet.pfa.models.Question;
import ma.projet.pfa.models.Questionnaire;
import ma.projet.pfa.models.Reponse;
import ma.projet.pfa.repositorie.CategorieRepository;
import ma.projet.pfa.repositorie.QuestionRepository;
import ma.projet.pfa.repositorie.QuestionnaireRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class QuestionController {
	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private CategorieRepository categorieRepository;
	@Autowired
	private QuestionnaireRepository questionnaireRepository;
	@GetMapping("getquestion/{id}")
	public ResponseEntity<Question> findOne(@PathVariable(value = "id") Long id) {
		Question question=questionRepository.findById(id).get();
		return new ResponseEntity<Question>(question, HttpStatus.OK);
	}
	@GetMapping("getallquestion")
	public ResponseEntity<List<Question>> getallquestion() {
		List<Question> questions =(List<Question>) questionRepository.findAll();
		return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
	}
	@GetMapping("getquestionbycategorie/{id}")
	public ResponseEntity<List<Question>> getquestionbycategorie(@PathVariable(value = "id") Long id) {
		List<Question> questions=new ArrayList<Question>();
		Iterable<Question> list = questionRepository.findAll();
		for(Question q:list) {
			if(q.getCategorie().getId()==id) {
				questions.add(q);
			}
		}
		return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
	}
	@PostMapping("addquestion/{id}")
	public ResponseEntity<Question> addquestion(@RequestBody Question question,@PathVariable(value = "id") Long id){
		Categorie categorie=categorieRepository.findById(id).get();
		List<Reponse> reponses=new ArrayList<Reponse>();
		question.setCategorie(categorie);
		question.setReponses(reponses);
		questionRepository.save(question);
		return new ResponseEntity<Question>(question,HttpStatus.OK);
	}
	@PostMapping("affection/{id}/{idq}")
	public ResponseEntity<Question> affectionToQuestionnaire(@PathVariable(value = "id") Long id,@PathVariable(value = "idq") Long idq){
		Questionnaire questionnaire=questionnaireRepository.findById(id).get();
		Question question=questionRepository.findById(idq).get();
		question.setQuestionnaire(questionnaire);
		questionRepository.save(question);
		return new ResponseEntity<Question>(question,HttpStatus.OK);
	}
	@PutMapping("updatequestion/{id}/{idcat}")
	public ResponseEntity<Question> updatequestion(@RequestBody Question question,@PathVariable(value = "id") Long id,@PathVariable(value = "idcat") Long idcat){
		Question q=questionRepository.findById(id).get();
		Categorie c=categorieRepository.findById(idcat).get();
		if(q!=null) {
			q.setType(question.getType());
			q.setText(question.getText());
			q.setDuree(question.getDuree());
			q.setCategorie(c);
			questionRepository.save(q);
		}
		return new ResponseEntity<Question>(question,HttpStatus.OK);
	}
	@DeleteMapping("deletequestion/{id}")
	public @ResponseBody HttpEntity<Question> deletequestion(@PathVariable(value = "id") Long id) {
		Question q=questionRepository.findById(id).get();
		questionRepository.delete(q);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}