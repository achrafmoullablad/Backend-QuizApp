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
import ma.projet.pfa.models.Questionnaire;
import ma.projet.pfa.repositorie.CategorieRepository;
import ma.projet.pfa.repositorie.QuestionnaireRepository;
@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class QuestionnaireContoller {
	@Autowired
	private QuestionnaireRepository questionnaireRepository;
	@Autowired
	private CategorieRepository categorieRepository;
	
	@GetMapping("getquestionnaire/{id}")
	public ResponseEntity<Questionnaire> getquestionnaire(@PathVariable(value = "id") Long id) {
		Questionnaire questionnaire=questionnaireRepository.findById(id).get();
		return new ResponseEntity<Questionnaire>(questionnaire, HttpStatus.OK);
	}
	
	@PostMapping("addquestionnaire/{id}")
	public ResponseEntity<Questionnaire> addquestionnaire(@RequestBody Questionnaire questionnaire,@PathVariable(value = "id") Long id){
		Categorie categorie = categorieRepository.findById(id).get();
		List<Questionnaire> list=new ArrayList<Questionnaire>();
		list.add(questionnaire);
		categorie.setQuestionnaire(list);
		questionnaire.setCategories(categorie);
		questionnaireRepository.save(questionnaire);
		return new ResponseEntity<Questionnaire>(questionnaire, HttpStatus.OK);
	}
	@PutMapping("updatequestionnaire/{id}")
	public ResponseEntity<Questionnaire> updatequestion(@RequestBody Questionnaire questionnaire,@PathVariable(value = "id") Long id){
		Questionnaire qt=questionnaireRepository.findById(id).get();
		if(qt!=null) {
			qt.setTitre(questionnaire.getTitre());
			qt.setCategories(questionnaire.getCategories());
			questionnaireRepository.save(qt);
		}
		return new ResponseEntity<Questionnaire>(qt,HttpStatus.OK);
	}
	@DeleteMapping("deletequestionnaire/{id}")
	public @ResponseBody HttpEntity<Questionnaire> deletequestion(@PathVariable(value = "id") Long id) {
		Questionnaire qt=questionnaireRepository.findById(id).get();
		questionnaireRepository.delete(qt);
		return new ResponseEntity<Questionnaire>(HttpStatus.NO_CONTENT);
	}
	@GetMapping("getallquestionnaire")
	public ResponseEntity<List<Questionnaire>> getAllQuestionnaire() {
		List<Questionnaire> list=(List<Questionnaire>) questionnaireRepository.findAll();
		return new ResponseEntity<List<Questionnaire>>(list, HttpStatus.OK);
	}
	
}
