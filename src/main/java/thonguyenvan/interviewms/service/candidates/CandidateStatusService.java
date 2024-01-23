package thonguyenvan.interviewms.service.candidates;



import thonguyenvan.interviewms.entity.candidates.CandidateStatus;

import java.util.List;

public interface CandidateStatusService {
    List<CandidateStatus> findAll();

    CandidateStatus findByStatusName(String statusName);

    CandidateStatus findByCandidateStatusName(String candidateStatusName);
}
