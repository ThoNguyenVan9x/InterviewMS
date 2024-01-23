package thonguyenvan.interviewms.service.jobs;


import thonguyenvan.interviewms.entity.jobs.Skills;

import java.util.List;

public interface SkillService {

    List<Skills> findAll();
    Skills findBySkillName(String skillName);
}
