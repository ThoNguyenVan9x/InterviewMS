package thonguyenvan.interviewms.util.dto.candidates;

import lombok.*;
import thonguyenvan.interviewms.entity.candidates.CandidateStatus;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CandidatesListDTO {

    private Integer id;

    private String fullName;

    private String phone;

    private String email;

    private CandidateStatus candidateStatus;

}
