package ma.projet.pfa.repositorie;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ma.projet.pfa.models.EmailRequest;
@Repository
public interface EmailRepository extends CrudRepository<EmailRequest, Long>{

}
