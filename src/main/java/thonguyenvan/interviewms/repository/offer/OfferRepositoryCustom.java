package thonguyenvan.interviewms.repository.offer;


import thonguyenvan.interviewms.util.dto.offer.DepartmentListDTO;
import thonguyenvan.interviewms.util.dto.offer.OfferCandidateListDTO;
import thonguyenvan.interviewms.util.dto.offer.OfferListDTO;
import thonguyenvan.interviewms.util.dto.offer.OfferUserListDTO;

import java.util.List;

public interface OfferRepositoryCustom {

    List<OfferListDTO> getAllOffer(String search, String department, String status);
    List<OfferListDTO> getOfferPage(Integer pageIndex,Integer pageSize,String search,String department,String status);

    OfferCandidateListDTO getCandidateById(Integer id);

    List<DepartmentListDTO>getDepartmentById(Integer id);

   OfferUserListDTO getUserById(Integer id);
}
