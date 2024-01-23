package thonguyenvan.interviewms.util.dto.jobs;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import thonguyenvan.interviewms.enums.job.JobStatus;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class JobsListDTO {

    private Integer id;

    private String title;

    private LocalDate startDate;

    private JobStatus status;

    private LocalDate endDate;
}
