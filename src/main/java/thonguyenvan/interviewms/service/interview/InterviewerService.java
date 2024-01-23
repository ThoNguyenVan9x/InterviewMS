package thonguyenvan.interviewms.service.interview;


import thonguyenvan.interviewms.entity.interview.Interviewer;

import java.util.List;
import java.util.Optional;

public interface InterviewerService {
    List<Interviewer>findAll();
    Interviewer findByInterviewerName(String interviewerName);
    Interviewer save(Interviewer interviewer);

    Optional<Interviewer> findById(Integer id);


}
