package thonguyenvan.interviewms.repository.interview;


import thonguyenvan.interviewms.entity.interview.Interviewer;

public interface InterviewerRepositoryCustom {
    Interviewer findByInterviewerName(String interviewerName);

}
