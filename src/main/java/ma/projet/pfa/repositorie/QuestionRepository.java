package ma.projet.pfa.repositorie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ma.projet.pfa.models.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question,Long>{

}
