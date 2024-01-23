package thonguyenvan.interviewms.repository.candidates;

import org.springframework.data.repository.CrudRepository;
import thonguyenvan.interviewms.entity.candidates.CandidateStatus;

public interface CandidateStatusRepository extends CrudRepository<CandidateStatus,Integer> {

    CandidateStatus findByStatusName(String statusName);
}
