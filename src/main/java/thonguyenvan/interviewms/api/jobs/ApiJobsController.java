package thonguyenvan.interviewms.api.jobs;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import thonguyenvan.interviewms.service.jobs.JobService;
import thonguyenvan.interviewms.util.dto.jobs.JobsListDTO;
import thonguyenvan.interviewms.util.dto.jobs.LevelListDTO;
import thonguyenvan.interviewms.util.dto.jobs.SkillListDTO;
import thonguyenvan.interviewms.util.page.Page;
import thonguyenvan.interviewms.util.page.PageLevel;
import thonguyenvan.interviewms.util.page.PageSkill;

@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
public class ApiJobsController {

    private final JobService jobService;

    @GetMapping
    public Page<JobsListDTO> getEmployees(
            @RequestParam(defaultValue = "1",required = false, value="pageIndex") Integer pageIndex,
            @RequestParam(defaultValue = "7", required = false, value="pageSize") Integer pageSize,
            @RequestParam(required = false, value="search") String search,
            @RequestParam(required = false, value="status") String status) {

        return jobService.getPageJob(pageIndex, pageSize, search, status);
    }

    @GetMapping("/skills/{id}")
    public PageSkill<SkillListDTO> getSkill(@PathVariable Integer id) {

        return jobService.getPageSkill(id);
    }

    @GetMapping("/levels/{id}")
    public PageLevel<LevelListDTO> getLevel(@PathVariable Integer id) {

        return jobService.getPageLevel(id);
    }
}
