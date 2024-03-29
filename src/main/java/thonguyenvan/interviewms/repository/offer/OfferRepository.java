package thonguyenvan.interviewms.repository.offer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import thonguyenvan.interviewms.entity.offer.Offer;

import java.time.LocalDate;
import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Integer> {

    List<Offer> findByDueDate(LocalDate dueDate);

    List<Offer> findByDueDateBetween(LocalDate startDate, LocalDate endDate);

    Offer findByOfferToken(String token);


    @Query("select o from Offer o join o.candidate c where c.id=:id")
    List<Offer> findByCandidateId(Integer id);
}
