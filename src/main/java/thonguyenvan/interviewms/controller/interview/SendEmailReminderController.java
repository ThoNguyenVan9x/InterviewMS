package thonguyenvan.interviewms.controller.interview;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import thonguyenvan.interviewms.entity.interview.Interview;
import thonguyenvan.interviewms.entity.interview.Interviewer;
import thonguyenvan.interviewms.service.interview.InterviewService;

import java.io.UnsupportedEncodingException;
import java.util.Set;

@Controller
@RequiredArgsConstructor
public class SendEmailReminderController {

    private final InterviewService interviewService;

    @GetMapping("interview/schedule-reminder/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','RECRUITER','MANAGER')")
    public String sendEmailReminder(@PathVariable Integer id) throws MessagingException, UnsupportedEncodingException {

        Interview interview = interviewService.findById(id).orElse(null);
        if (interview == null) {
            return "error/404";
        }
        String link = "http://localhost:8080/interview/view/" + id;
        Set<Interviewer> interviewers = interview.getInterviewers();

        for(Interviewer inter: interviewers){
            String email = inter.getEmail();
            interviewService.sendEmail(email, interview, link);
        }

        return "redirect:/interview/view/" + id;

    }

}
