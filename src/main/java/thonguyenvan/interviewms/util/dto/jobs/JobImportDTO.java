package thonguyenvan.interviewms.util.dto.jobs;

import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import thonguyenvan.interviewms.enums.job.JobStatus;
import thonguyenvan.interviewms.util.validation.addNewJob.DateOrder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@DateOrder({"startDate","endDate"})
public class JobImportDTO {

    private Integer id;

    @NotBlank(message = "{ME034}")
    private String title;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "{ME017}")
    @NotNull(message = "{ME035}" )
    private LocalDate startDate;

    @Min(value = 0, message = "{ME028}")
    private BigDecimal minSalary;

    @NotNull(message = "{ME036}")
    @Min(value = 0, message = "{ME028}")
    private BigDecimal maxSalary;

    @NotBlank(message = "{ME037}")
    private String workingAddress;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "{ME038}")
    private LocalDate endDate;

    private String description;

    @NotEmpty(message = "{ME039}")
    private String skillsSet;

    @NotEmpty(message = "{ME040}")
    private String benefitSet;

    @NotEmpty(message = "{ME041}")
    private String levelsSet;

    private JobStatus jobStatus;
}
