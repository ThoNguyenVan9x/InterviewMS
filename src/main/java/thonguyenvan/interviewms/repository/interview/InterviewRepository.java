package thonguyenvan.interviewms.repository.interview;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import thonguyenvan.interviewms.entity.interview.Interview;
import thonguyenvan.interviewms.enums.interview.InterviewResult;

import java.time.LocalDate;
import java.util.List;

public interface InterviewRepository extends CrudRepository<Interview, Integer>, InterviewRepositoryCustom {

    List<Interview> findByInterviewDate(LocalDate interviewDate);

    @Query("select i from Interview i join i.candidates c where c.id=:id")
    List<Interview> findByCandidatesId(Integer id);

    @Query("select i from Interview i join i.candidates c where c.id=:id and i.result=:result")
    List<Interview> findInterviewByCandidatesAndResult(Integer id, InterviewResult result);

    @Query("select it from Interview it join it.jobs j where j.id=:id")
    List<Interview> findByJobId(Integer id);
}
