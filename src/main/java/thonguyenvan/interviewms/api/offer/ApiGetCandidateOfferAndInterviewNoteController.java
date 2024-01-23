package thonguyenvan.interviewms.api.offer;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import thonguyenvan.interviewms.entity.candidates.Candidates;
import thonguyenvan.interviewms.entity.interview.Interview;
import thonguyenvan.interviewms.entity.interview.Interviewer;
import thonguyenvan.interviewms.service.candidates.CandidatesService;
import thonguyenvan.interviewms.service.interview.InterviewService;
import thonguyenvan.interviewms.service.offer.OfferService;
import thonguyenvan.interviewms.util.dto.offer.DepartmentListDTO;
import thonguyenvan.interviewms.util.dto.offer.OfferCandidateListDTO;
import thonguyenvan.interviewms.util.dto.offer.OfferListDTO;
import thonguyenvan.interviewms.util.dto.offer.OfferUserListDTO;
import thonguyenvan.interviewms.util.page.Page;
import thonguyenvan.interviewms.util.page.PageDepartment;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/offer")
@RequiredArgsConstructor
public class ApiGetCandidateOfferAndInterviewNoteController {

    private final CandidatesService candidatesService;
    private final InterviewService interviewService;
    private final OfferService offerService;

    @GetMapping("/candidate/{id}")
    public List<Interview> getListInterviewByCandidateId(@PathVariable Integer id) {
        return interviewService.getListInterviewByCandidateId(id);
    }

    @GetMapping("/candidateEmail/{id}")
    public Optional<Candidates> getCandidateByCandidateId(@PathVariable Integer id) {
        return candidatesService.findByCandidateId(id);
    }

    @GetMapping("/interview/{id}")
    public Optional<Interview> getInterview(@PathVariable Integer id) {
        return interviewService.findById(id);
    }

    @GetMapping("/interviewer/{id}")
    public List<Interviewer> getInterviewerList(@PathVariable Integer id) {
        return interviewService.findListInterviewerByInterviewId(id);
    }
    @GetMapping
    public Page<OfferListDTO> getOfferviews(@RequestParam(defaultValue = "1",required = false,value = "pageIndex")Integer pageIndex,
                                            @RequestParam(defaultValue = "5",required = false,value = "pageSize") Integer pageSize,
                                            @RequestParam(required = false,value="search") String search,
                                            @RequestParam(required = false,value = "department") String department,
                                            @RequestParam(required = false,value = "status") String status, Model model){
        return offerService.getPageOffer(pageIndex,pageSize,search,department,status);
    }

    @GetMapping("/user/{id}")
    public OfferUserListDTO offerUserListDTO(@PathVariable Integer id){
        return offerService.getPageUser(id);
    }

    @GetMapping("/candidateDTO/{id}")
    public OfferCandidateListDTO offerCandidateListDTO(@PathVariable Integer id){
        return offerService.getPageCandidate(id);
    }

    @GetMapping("/department/{id}")
    public PageDepartment<DepartmentListDTO> offerDepartmentDTO(@PathVariable Integer id){
        return offerService.getPageDepartment(id);
    }
}
