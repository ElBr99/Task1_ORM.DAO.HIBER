package netology.orm.repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import netology.orm.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@AllArgsConstructor
@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        return (List<Person>) entityManager
                .createNamedQuery("findPersonByCity")
                .setParameter("city", city)
                .getResultList();
    }


}
