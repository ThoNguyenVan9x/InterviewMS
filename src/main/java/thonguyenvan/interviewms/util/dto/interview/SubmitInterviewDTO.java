package thonguyenvan.interviewms.util.dto.interview;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import thonguyenvan.interviewms.entity.candidates.Candidates;
import thonguyenvan.interviewms.entity.candidates.Recruiters;
import thonguyenvan.interviewms.entity.jobs.Jobs;
import thonguyenvan.interviewms.enums.interview.InterviewResult;
import thonguyenvan.interviewms.enums.interview.ScheduleStatus;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubmitInterviewDTO {

    private Integer id;

    private String scheduleTitle;

    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private LocalDate interviewDate;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime startTime;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime endTime;

    private String notes;

    private String Location;

    private String meetingId;

    private InterviewResult result;

    private ScheduleStatus status;


    private Candidates candidates;


    private Jobs jobs;


    private Recruiters recruiters;


    private Set<String> interviewers = new HashSet<>();
}
