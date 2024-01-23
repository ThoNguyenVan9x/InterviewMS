package thonguyenvan.interviewms.service.offer;

import jakarta.mail.MessagingException;
import thonguyenvan.interviewms.entity.offer.Offer;
import thonguyenvan.interviewms.util.dto.offer.DepartmentListDTO;
import thonguyenvan.interviewms.util.dto.offer.OfferCandidateListDTO;
import thonguyenvan.interviewms.util.dto.offer.OfferListDTO;
import thonguyenvan.interviewms.util.dto.offer.OfferUserListDTO;
import thonguyenvan.interviewms.util.page.Page;
import thonguyenvan.interviewms.util.page.PageDepartment;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.List;

import java.util.Optional;

public interface OfferService {

    void save(Offer offer);

    List<Offer> findByDueDate(LocalDate dueDate);

    Optional<Offer> findById(Integer id);

    void sendEmail(String recipientEmail, Offer offer, String link) throws MessagingException, UnsupportedEncodingException;



    List<Offer> findAll();
    List<Offer> findAllByDate(LocalDate startDate, LocalDate endDate);

    Page<OfferListDTO> getPageOffer(Integer pageIndex, Integer pageSize, String search, String department, String status);

//    PageCandidate<OfferCandidateListDTO>getPageCandidate(Integer id);

    PageDepartment<DepartmentListDTO> getPageDepartment(Integer id);

    OfferUserListDTO getPageUser(Integer id);

    OfferCandidateListDTO getPageCandidate(Integer id);

    Offer findByOfferToken(String token);

}
