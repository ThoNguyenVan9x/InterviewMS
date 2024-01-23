package thonguyenvan.interviewms.service.interview;

import jakarta.mail.MessagingException;
import thonguyenvan.interviewms.entity.candidates.Candidates;
import thonguyenvan.interviewms.entity.interview.Interview;
import thonguyenvan.interviewms.entity.interview.Interviewer;
import thonguyenvan.interviewms.enums.interview.InterviewResult;
import thonguyenvan.interviewms.util.dto.interview.InterviewCandidateDTO;
import thonguyenvan.interviewms.util.dto.interview.InterviewJobDTO;
import thonguyenvan.interviewms.util.dto.interview.InterviewListDTO;
import thonguyenvan.interviewms.util.dto.interview.InterviewerListDTO;
import thonguyenvan.interviewms.util.page.Page;
import thonguyenvan.interviewms.util.page.PageInterviewer;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface InterviewService {

    Optional<Interview> findById(Integer id);

    void save(Interview interview);

    void updateStatus(Integer id);

    List<Interview> findByInterviewDate(LocalDate interviewDate);

    void sendEmail(String recipientEmail, Interview interview, String link) throws MessagingException, UnsupportedEncodingException;

    Candidates getCandidateByInterviewId(Integer id);

    List<Interview> getInterviewsPass();

    Page<InterviewListDTO> getPageInterview(Integer pageIndex, Integer pageSize, String search, String interviewer, String status);

    InterviewCandidateDTO getPageCandidate(Integer id);

    PageInterviewer<InterviewerListDTO> getPageInterviewer(Integer id);

    InterviewJobDTO getPageJob(Integer id);

    List<Interview> findInterviewByCandidatesAndResult(Integer id, InterviewResult result);

    List<Interview> getListInterviewByCandidateId(Integer id);

    List<Interviewer> findListInterviewerByInterviewId(Integer id);

    List<Interview> findAll();
}
