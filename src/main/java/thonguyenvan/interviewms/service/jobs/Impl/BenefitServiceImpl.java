package thonguyenvan.interviewms.service.jobs.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import thonguyenvan.interviewms.entity.jobs.Benefit;
import thonguyenvan.interviewms.repository.job.BenefitRepository;
import thonguyenvan.interviewms.service.jobs.BenefitService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BenefitServiceImpl implements BenefitService {

    private final BenefitRepository benefitRepository;
    @Override
    public List<Benefit> findAll() {
        return (List<Benefit>) benefitRepository.findAll();
    }

    @Override
    public Benefit findByBenefitName(String benefitName) {
        return benefitRepository.findByBenefitName(benefitName);
    }
}
