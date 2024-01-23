package thonguyenvan.interviewms.repository.job;


import thonguyenvan.interviewms.entity.jobs.Jobs;
import thonguyenvan.interviewms.util.dto.jobs.JobsListDTO;
import thonguyenvan.interviewms.util.dto.jobs.LevelListDTO;
import thonguyenvan.interviewms.util.dto.jobs.SkillListDTO;

import java.util.List;

public interface JobsRepositoryCustom {

    List<JobsListDTO> getAllJob(String search, String status);

    List<JobsListDTO> getJobPaging(Integer pageIndex, Integer pageSize, String search, String status);

    List<SkillListDTO> getSkillsById(Integer id);

    List<LevelListDTO> getLevelsById(Integer id);

    List<Jobs> getJobsHaveStatusOpen();
}
