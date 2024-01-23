package thonguyenvan.interviewms.service.interview.impl;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import thonguyenvan.interviewms.config.security.SecurityUtils;
import thonguyenvan.interviewms.entity.candidates.Candidates;
import thonguyenvan.interviewms.entity.interview.Interview;
import thonguyenvan.interviewms.entity.interview.Interviewer;
import thonguyenvan.interviewms.enums.interview.InterviewResult;
import thonguyenvan.interviewms.enums.interview.ScheduleStatus;
import thonguyenvan.interviewms.repository.interview.InterviewRepository;
import thonguyenvan.interviewms.repository.interview.impl.InterviewRepositoryCustomImpl;
import thonguyenvan.interviewms.service.file.FileStorageService;
import thonguyenvan.interviewms.service.interview.InterviewService;
import thonguyenvan.interviewms.util.dto.interview.InterviewCandidateDTO;
import thonguyenvan.interviewms.util.dto.interview.InterviewJobDTO;
import thonguyenvan.interviewms.util.dto.interview.InterviewListDTO;
import thonguyenvan.interviewms.util.dto.interview.InterviewerListDTO;
import thonguyenvan.interviewms.util.page.Page;
import thonguyenvan.interviewms.util.page.PageInterviewer;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class InterviewServiceImpl implements InterviewService {

    private final InterviewRepository interviewRepository;
    private final JavaMailSender javaMailSender;
    private final FileStorageService fileLocalCandidateService;
    private final InterviewRepositoryCustomImpl interviewRepositoryCustom;

    @Override
    public Optional<Interview> findById(Integer id) {
        return interviewRepository.findById(id);
    }

    @Override
    public void save(Interview interview) {
        interviewRepository.save(interview);
    }

    @Override
    public void updateStatus(Integer id) {
        interviewRepository.updateStatus(id);
    }

    @Override
    public List<Interview> findByInterviewDate(LocalDate interviewDate) {

        return interviewRepository.findByInterviewDate(interviewDate);
    }

    @Override
    public void sendEmail(String recipientEmail, Interview interview, String link) throws MessagingException, UnsupportedEncodingException {

        Set<Interviewer> interviewers = interview.getInterviewers();
        List<String> interviewerName = new ArrayList<>();
        for (Interviewer inter : interviewers) {
            String name = inter.getInterviewerName();
            interviewerName.add(name);
        }

        String position = interview.getJobs().getTitle();
        String startTime = interview.getStartTime().toString();
        String endTime = interview.getEndTime().toString();
        String interviewTitle = interview.getScheduleTitle();
        String candidateName = interview.getCandidates().getFullName();
        String recruiterAccount = interview.getRecruiters().getRecruiterUserName();
        String meetingId = interview.getMeetingId();
        String fileName = interview.getCandidates().getCvAttachment();

        String subject = "no-reply-email-IMS-system " + interviewTitle;
        String content = "<p>This email is from IMS system,</p>" +
                "<p>You have an interview schedule TODAY at " + startTime + " to " + endTime + "</p>" +
                "<p>With Candidate " + candidateName + ", position " + position + ".</p>" +
                "<p>The CV is attached with this no-reply-email.</p>" +
                "<p>If anything is wrong, please refer to recruiter " + recruiterAccount + "@fpt.com or <a href=\"" + link + "\"> visit our website.</a></p>" +
                "<p>Please join interview room ID: " + meetingId + "</p>" +
                "<p>Thanks & Regards!</p>" +
                "<p>IMS Team.</p>";

        File file = new File(fileLocalCandidateService.getFileLocation() + "/" + fileName);
        FileSystemResource fileAttach = new FileSystemResource(file);

        MimeMessagePreparator preparator = mimeMessage -> {

            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            message.setTo(recipientEmail);
            message.setFrom("fjb04@fa.com", "FA Support");
            message.setSubject(subject);
            message.setText(content, true);
            message.addAttachment("file CV", fileAttach);
        };

        try {
            javaMailSender.send(preparator);
            interview.setStatus(ScheduleStatus.Invited);
            interviewRepository.save(interview);
        }
        catch (MailException ex) {
            System.err.println(ex.getMessage());
        }

    }


    @Override
    public Candidates getCandidateByInterviewId(Integer id) {
        return interviewRepository.getCandidateByInterviewId(id);
    }

    @Override
    public List<Interview> getInterviewsPass() {
        return interviewRepository.getInterviewsPass();
    }


    @Override
    public Page<InterviewListDTO> getPageInterview(Integer pageIndex, Integer pageSize, String search, String interviewer, String status) {
        List<InterviewListDTO> interviewList = interviewRepositoryCustom.getInterviewPaging(pageIndex, pageSize, search, interviewer, status);
        int pageTotal = (int) Math.ceil(interviewRepositoryCustom.getAllInterview(search, interviewer, status).size() * 1.0 / pageSize);
        String role = SecurityUtils.getCurrentRole().toString();
        Page<InterviewListDTO> page = new Page<>(pageTotal, pageIndex, interviewList, pageSize, role);
        return page;
    }

    @Override
    public InterviewCandidateDTO getPageCandidate(Integer id) {
        return interviewRepositoryCustom.getCandidateById(id);
    }

    @Override
    public PageInterviewer<InterviewerListDTO> getPageInterviewer(Integer id) {
        List<InterviewerListDTO> interviewListDTOList = interviewRepositoryCustom.getInterviewerById(id);
        PageInterviewer<InterviewerListDTO> pageInterviewer = new PageInterviewer<>(interviewListDTOList);
        return pageInterviewer;
    }

    @Override
    public InterviewJobDTO getPageJob(Integer id) {
        return interviewRepositoryCustom.getJobById(id);
    }

    @Override
    public List<Interview> findInterviewByCandidatesAndResult(Integer id, InterviewResult result) {
        return interviewRepository.findInterviewByCandidatesAndResult(id,result);
    }

    @Override
    public List<Interview> getListInterviewByCandidateId(Integer id) {
        return interviewRepository.getListInterviewByCandidateId(id);
    }

    @Override
    public List<Interviewer> findListInterviewerByInterviewId(Integer id) {
        return interviewRepositoryCustom.findListInterviewerByInterviewId(id);
    }

    @Override
    public List<Interview> findAll() {
        return (List<Interview>) interviewRepository.findAll();
    }


}
