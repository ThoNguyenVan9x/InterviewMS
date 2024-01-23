package thonguyenvan.interviewms.util.dto.offer;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import thonguyenvan.interviewms.entity.candidates.Candidates;
import thonguyenvan.interviewms.entity.candidates.Positions;
import thonguyenvan.interviewms.entity.candidates.Recruiters;
import thonguyenvan.interviewms.entity.interview.Interview;
import thonguyenvan.interviewms.entity.jobs.Levels;
import thonguyenvan.interviewms.entity.user.Department;
import thonguyenvan.interviewms.entity.user.User;
import thonguyenvan.interviewms.enums.offer.ContractType;
import thonguyenvan.interviewms.enums.offer.OfferStatus;
import thonguyenvan.interviewms.util.validation.offer.editOffer.CheckDateFromToEdit;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@CheckDateFromToEdit({"contractPeriodFrom", "contractPeriodTo"})
public class EditOfferDTO {

    private Integer id;

    @NotNull(message = "{ME051}")
    private Candidates candidate;

    @NotNull(message = "{ME048}")
    private Positions position;

    @NotNull(message = "{ME062}")
    private User approvedBy;

    @NotNull(message = "{ME063}")
    private Interview interviewInfo;

    @NotNull(message = "{ME064}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate contractPeriodFrom;

    @NotNull(message = "{ME065}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate contractPeriodTo;

    private String interviewNotes;

    @NotNull(message = "{ME066}")
    private ContractType contractType;

    @NotNull(message = "{ME041}")
    private Levels level;

    @NotNull(message = "{ME059}")
    private Department department;

    @NotNull(message = "{ME050}")
    private Recruiters recruiterOwner;

    @NotNull(message = "{ME067}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    @NotNull(message = "{ME068}")
    @Min(value = 0,message = "{ME028}")
    private BigDecimal basicSalary;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "offer_status")
    @NotNull(message = "Offer {ME061}")
    private OfferStatus offerStatus;

    private String note;
}
