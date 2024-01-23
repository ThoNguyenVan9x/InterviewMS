package thonguyenvan.interviewms.repository.candidates;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import thonguyenvan.interviewms.entity.candidates.Recruiters;


public interface RecruiterRepository extends CrudRepository<Recruiters,Integer> {
    Recruiters findByRecruiterName(String recruiterName);

    @Query("select r.id from Recruiters r where r.recruiterUserName=:userName")
    Integer findIdByUserName(String userName);
}
