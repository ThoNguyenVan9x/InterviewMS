package thonguyenvan.interviewms.repository.job;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import thonguyenvan.interviewms.entity.jobs.Benefit;

@Repository
public interface BenefitRepository extends CrudRepository<Benefit,Integer> {

    Benefit findByBenefitName(String benefitName);
}
