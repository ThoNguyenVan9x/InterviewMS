package thonguyenvan.interviewms.service.jobs;


import thonguyenvan.interviewms.entity.jobs.Benefit;

import java.util.List;

public interface BenefitService {

    List<Benefit> findAll();

    Benefit findByBenefitName(String benefitName);


}
