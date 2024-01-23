package thonguyenvan.interviewms.util.dto.interview;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
import thonguyenvan.interviewms.util.validation.interview.CheckTimeFromTo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@CheckTimeFromTo({"startTime", "endTime"})
public class EditInterviewDTO {

    private Integer id;

    @NotEmpty(message = "{ME055}")
    private String scheduleTitle;

    @NotNull(message = "{ME056}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "{ME058}")
    private LocalDate interviewDate;

    @DateTimeFormat(pattern = "HH:mm")
    @NotNull(message = "start time {ME002}")
    private LocalTime startTime;

    @DateTimeFormat(pattern = "HH:mm")
    @NotNull(message = "end time {ME002}")
    private LocalTime endTime;

    private String notes;

    private String Location;

    private String meetingId;

    @NotNull(message = "{ME071}")
    private InterviewResult result;

    private ScheduleStatus status;

    @NotNull(message = "{ME042}")
    private Candidates candidates;

    @NotNull(message = "{ME034}")
    private Jobs jobs;

    @NotNull(message = "{ME050}")
    private Recruiters recruiters;

    @NotEmpty(message = "{ME057}")
    private Set<String> interviewers = new HashSet<>();
}
