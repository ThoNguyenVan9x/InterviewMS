package thonguyenvan.interviewms.repository.interview;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import thonguyenvan.interviewms.entity.interview.Interviewer;

@Repository
public interface InterviewerRepository extends CrudRepository<Interviewer,Integer> {
    Interviewer findByInterviewerName(String interviewerName);


}
