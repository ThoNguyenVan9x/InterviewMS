package thonguyenvan.interviewms.util.dto.interview;

import lombok.*;
import thonguyenvan.interviewms.enums.interview.InterviewResult;
import thonguyenvan.interviewms.enums.interview.ScheduleStatus;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class InterviewListDTO {

    private Integer id;

    private String scheduleTitle;

    private LocalDate interviewDate;

    private LocalTime startTime;

    private LocalTime endTime;

    private InterviewResult result;

    private ScheduleStatus status;

}

