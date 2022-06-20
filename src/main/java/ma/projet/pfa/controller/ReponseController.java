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
import ma.projet.pfa.models.Question;
import ma.projet.pfa.models.Reponse;
import ma.projet.pfa.repositorie.QuestionRepository;
import ma.projet.pfa.repositorie.ReponseRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class ReponseController {
	@Autowired
	private ReponseRepository reponseRepository;
	@Autowired
	private QuestionRepository questionRepository;
	
	@GetMapping("getreponse/{id}")
	public ResponseEntity<Reponse> findOne(@PathVariable(value = "id") Long id) {
		Reponse reponse=reponseRepository.findById(id).get();
		return new ResponseEntity<Reponse>(reponse, HttpStatus.OK);
	}
	@GetMapping("getallreponsebyquestion/{id}")
	public ResponseEntity<List<Reponse>> getallReponseByQuestion(@PathVariable(value = "id") Long id) {
		List<Reponse> reponses=new ArrayList<Reponse>();
		Iterable<Reponse> list = reponseRepository.findAll();
		for(Reponse r:list) {
			if(r.getQuestion().getId()==id) {
				reponses.add(r);
			}
		}
		return new ResponseEntity<List<Reponse>>(reponses, HttpStatus.OK);
	}
	@PostMapping("addreponse/{id}")
	public ResponseEntity<Reponse> addquestion(@RequestBody Reponse reponse,@PathVariable(value = "id") Long id){
		Question question=questionRepository.findById(id).get();
		List<Reponse> reponses=new ArrayList<Reponse>();
		reponses.add(reponse);
		question.setReponses(reponses);
		reponse.setQuestion(question);
		reponseRepository.save(reponse);
		return new ResponseEntity<Reponse>(reponse,HttpStatus.OK);
	}
	@PutMapping("updatereponse/{id}/{idq}")
	public ResponseEntity<Reponse> updatereponse(@RequestBody Reponse reponse,@PathVariable(value = "id") Long id,@PathVariable(value = "idq") Long idq){
		Reponse r=reponseRepository.findById(id).get();
		Question question=questionRepository.findById(idq).get();
		if(r!=null) {
			r.setChoix(reponse.getChoix());
			r.setCorrecte(reponse.isCorrecte());
			r.setQuestion(question);
			reponseRepository.save(r);
		}
		return new ResponseEntity<Reponse>(reponse,HttpStatus.OK);
	}
	@DeleteMapping("deletereponse/{id}")
	public @ResponseBody HttpEntity<Reponse> deleteReponse(@PathVariable(value = "id") Long id) {
		Reponse reponse=reponseRepository.findById(id).get();
		reponseRepository.delete(reponse);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
