package ma.projet.pfa.controller;
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
import ma.projet.pfa.repositorie.CategorieRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class CategorieController {
	@Autowired
	private CategorieRepository categorieRepository;
	
	@PostMapping("/addcategorie")
	public ResponseEntity<Categorie> addcategorie(@RequestBody Categorie categorie){
		categorieRepository.save(categorie);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@GetMapping("getcategorie/{id}")
	public ResponseEntity<Categorie> findOne(@PathVariable(value = "id") Long id) {
		Categorie categorie=categorieRepository.findById(id).get();
		return new ResponseEntity<Categorie>(categorie, HttpStatus.OK);
	}
	@GetMapping("getallcategorie")
	public ResponseEntity<List<Categorie>> getallquestion() {
		List<Categorie> Categories =(List<Categorie>) categorieRepository.findAll();
		return new ResponseEntity<List<Categorie>>(Categories, HttpStatus.OK);
	}
	@PutMapping("updatecategorie/{id}")
	public ResponseEntity<Categorie> updatequestion(@RequestBody Categorie categorie,@PathVariable(value = "id") Long id){
		Categorie c=categorieRepository.findById(id).get();
		if(c!=null) {
			c.setNom(categorie.getNom());
			categorieRepository.save(c);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@DeleteMapping("deletecategorie/{id}")
	public @ResponseBody HttpEntity<Question> deletequestion(@PathVariable(value = "id") Long id) {
		Categorie c=categorieRepository.findById(id).get();
		categorieRepository.delete(c);
		return new ResponseEntity<Question>(HttpStatus.NO_CONTENT);
	}
}
