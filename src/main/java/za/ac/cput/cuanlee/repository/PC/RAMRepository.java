package za.ac.cput.cuanlee.repository.PC;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.cuanlee.domain.PC.RAM;

/**
 * Created by User on 2016/07/26.
 */
@Repository
public interface RAMRepository extends CrudRepository<RAM, Long> {
}
