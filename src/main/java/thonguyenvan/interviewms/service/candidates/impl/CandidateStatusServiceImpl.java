package thonguyenvan.interviewms.service.candidates.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import thonguyenvan.interviewms.entity.candidates.CandidateStatus;
import thonguyenvan.interviewms.repository.candidates.CandidateStatusRepository;
import thonguyenvan.interviewms.service.candidates.CandidateStatusService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateStatusServiceImpl implements CandidateStatusService {
    private final CandidateStatusRepository candidateStatusRepository;
    @Override
    public List<CandidateStatus> findAll() {
        return (List<CandidateStatus>) candidateStatusRepository.findAll();
    }

    @Override
    public CandidateStatus findByStatusName(String statusName) {
        return candidateStatusRepository.findByStatusName(statusName);
    }

    @Override
    public CandidateStatus findByCandidateStatusName(String candidateStatusName) {
        return candidateStatusRepository.findByStatusName(candidateStatusName);
    }


}
