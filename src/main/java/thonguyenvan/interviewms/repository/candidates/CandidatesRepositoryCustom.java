package thonguyenvan.interviewms.repository.candidates;


import thonguyenvan.interviewms.entity.candidates.CandidateStatus;
import thonguyenvan.interviewms.entity.candidates.Candidates;
import thonguyenvan.interviewms.util.dto.candidates.CandidatePositionDTO;
import thonguyenvan.interviewms.util.dto.candidates.CandidateRecruiterDTO;
import thonguyenvan.interviewms.util.dto.candidates.CandidatesListDTO;

import java.util.List;

public interface CandidatesRepositoryCustom  {
    public List<CandidatesListDTO> getCandidatesPaging(Integer pageIndex, Integer pageSize, String search, String status);
    List<CandidatesListDTO> getCandidatesSearch(String search, String status);
    CandidatePositionDTO getPositionById(Integer id);
    CandidateRecruiterDTO getRecruiterById(Integer id);
    List<Candidates> getCandidatesHaveStatusOtherThanBan();
    void updateStatusCancelScheduleInterview(Integer id, CandidateStatus status);
    List<Candidates> getCandidatesHaveStatusPassedInterview();
}
