package thonguyenvan.interviewms.service.jobs;


import thonguyenvan.interviewms.entity.jobs.Jobs;
import thonguyenvan.interviewms.util.dto.jobs.JobsListDTO;
import thonguyenvan.interviewms.util.dto.jobs.LevelListDTO;
import thonguyenvan.interviewms.util.dto.jobs.SkillListDTO;
import thonguyenvan.interviewms.util.page.Page;
import thonguyenvan.interviewms.util.page.PageLevel;
import thonguyenvan.interviewms.util.page.PageSkill;

import java.util.List;
import java.util.Optional;

public interface JobService {

    Jobs save(Jobs job);
    void updateJobStatus();

    List<Jobs> findAll();

    Page<JobsListDTO> getPageJob(Integer pageIndex, Integer pageSize, String search, String status);

    PageSkill<SkillListDTO> getPageSkill(Integer id);

    PageLevel<LevelListDTO> getPageLevel(Integer id);

    Optional<Jobs> findByJobId(Integer id);

    void deleteJob(Integer jobId);

    void saveAllJob(List<Jobs> list);

    Jobs changeStatus(Integer id);

    Jobs findByTitle(String title);

    List<Jobs> getJobsHaveStatusOpen();
}
