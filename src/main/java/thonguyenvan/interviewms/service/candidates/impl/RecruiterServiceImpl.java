package thonguyenvan.interviewms.service.candidates.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import thonguyenvan.interviewms.entity.candidates.Recruiters;
import thonguyenvan.interviewms.repository.candidates.RecruiterRepository;
import thonguyenvan.interviewms.service.candidates.RecruiterService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecruiterServiceImpl implements RecruiterService {
    private final RecruiterRepository recruiterRepository;


    @Override
    public List<Recruiters> findAll() {
        return (List<Recruiters>) recruiterRepository.findAll();
    }

    @Override
    public Recruiters findByRecruiterName(String recruiterName) {
        return recruiterRepository.findByRecruiterName(recruiterName);
    }

    @Override
    public Recruiters save(Recruiters recruiters) {
        return recruiterRepository.save(recruiters);
    }

    @Override
    public Integer findIdByUserName(String userName) {
        return recruiterRepository.findIdByUserName(userName);
    }

    @Override
    public Recruiters findById(Integer id) {

        return recruiterRepository.findById(id).orElse(null);
    }


}

