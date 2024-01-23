package thonguyenvan.interviewms.service.candidates;


import thonguyenvan.interviewms.entity.candidates.CandidateStatus;
import thonguyenvan.interviewms.entity.candidates.Candidates;
import thonguyenvan.interviewms.util.dto.candidates.CandidatePositionDTO;
import thonguyenvan.interviewms.util.dto.candidates.CandidateRecruiterDTO;
import thonguyenvan.interviewms.util.dto.candidates.CandidatesListDTO;
import thonguyenvan.interviewms.util.page.Page;

import java.util.List;
import java.util.Optional;

public interface CandidatesService {

    Page<CandidatesListDTO> getPageCandidates(Integer pageIndex, Integer pageSize, String search, String field);

    CandidatePositionDTO getPagePosition(Integer id);

    CandidateRecruiterDTO getPageRecruiter(Integer id);
    Optional<Candidates> findByCandidateId(Integer id);
    Candidates save(Candidates candidates);
     void deleteCandidate(Integer id);


    Boolean existsByPhone(String phoneNumber);
    Boolean existsByEmail(String email);
    Boolean existsByPhoneAndId(String phoneNumber,Integer id);
    Boolean existsByEmailAndId(String email,Integer id);

    List<Candidates> findAll();
    Candidates findByFullName(String fullName);


    List<Candidates> getCandidatesHaveStatusOtherThanBan();

    void updateStatusCancelScheduleInterview(Integer id, CandidateStatus status);

 boolean existsByPhoneOrEmail(String phone, String email);

 Candidates findCandidatesByOfferId(Integer id);

 List<Candidates> getCandidatesHaveStatusPassedInterview();
}
