package thonguyenvan.interviewms.repository.interview;


import thonguyenvan.interviewms.entity.candidates.Candidates;
import thonguyenvan.interviewms.entity.interview.Interview;
import thonguyenvan.interviewms.entity.interview.Interviewer;
import thonguyenvan.interviewms.util.dto.interview.InterviewCandidateDTO;
import thonguyenvan.interviewms.util.dto.interview.InterviewJobDTO;
import thonguyenvan.interviewms.util.dto.interview.InterviewListDTO;
import thonguyenvan.interviewms.util.dto.interview.InterviewerListDTO;

import java.util.List;

public interface InterviewRepositoryCustom {

    void updateStatus(Integer id);

    Candidates getCandidateByInterviewId(Integer id);

    List<Interview> getInterviewsPass();

    List<InterviewListDTO> getAllInterview(String search, String interviewer, String status);

    List<InterviewListDTO> getInterviewPaging(Integer pageIndex, Integer pageSize, String search, String interviewer, String status);

    List<InterviewerListDTO> getInterviewerById(Integer id);

    InterviewCandidateDTO getCandidateById(Integer id);

    InterviewJobDTO getJobById(Integer id);

    List<Interview> getListInterviewByCandidateId(Integer id);

    List<Interviewer> findListInterviewerByInterviewId(Integer id);

}
