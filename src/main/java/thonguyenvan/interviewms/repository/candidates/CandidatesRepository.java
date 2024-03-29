package thonguyenvan.interviewms.repository.candidates;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import thonguyenvan.interviewms.entity.candidates.Candidates;

@Repository
public interface CandidatesRepository extends CrudRepository<Candidates,Integer>, CandidatesRepositoryCustom{
    Candidates findCandidatesById(Integer id);
    Boolean existsByPhone(String phoneNumber);
    Boolean existsByEmail(String email);
    Boolean existsByPhoneAndId(String phoneNumber,Integer id);
    Boolean existsByEmailAndId(String email,Integer id);

    boolean existsByPhoneOrEmail(String phone, String email);

    @Query("select c from Candidates c where c.fullName = :fullName")
    Candidates findCandidatesByFullName(String fullName);

    @Query("SELECT c from Candidates c JOIN c.offers o where o.id=:id")
    Candidates findCandidatesByOfferId(Integer id);

}
