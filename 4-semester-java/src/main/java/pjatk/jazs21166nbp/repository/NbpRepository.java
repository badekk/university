package pjatk.jazs21166nbp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pjatk.jazs21166nbp.model.Nbp;

@Repository
public interface NbpRepository extends JpaRepository<Nbp, Long> {

}
