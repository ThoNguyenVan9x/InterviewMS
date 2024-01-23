package thonguyenvan.interviewms.service.jobs.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import thonguyenvan.interviewms.entity.jobs.Skills;
import thonguyenvan.interviewms.repository.job.SkillRepository;
import thonguyenvan.interviewms.service.jobs.SkillService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;
    @Override
    public List<Skills> findAll() {
        return (List<Skills>) skillRepository.findAll();
    }

    @Override
    public Skills findBySkillName(String skillName) {
        return skillRepository.findBySkillName(skillName);
    }
}
