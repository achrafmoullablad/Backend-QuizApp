package ma.projet.pfa.repositorie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ma.projet.pfa.models.Categorie;

@Repository
public interface CategorieRepository extends CrudRepository<Categorie, Long>{
	
}
