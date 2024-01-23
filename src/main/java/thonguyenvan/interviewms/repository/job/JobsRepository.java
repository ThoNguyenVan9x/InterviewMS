package thonguyenvan.interviewms.repository.job;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import thonguyenvan.interviewms.entity.jobs.Jobs;
import thonguyenvan.interviewms.enums.job.JobStatus;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface JobsRepository extends CrudRepository<Jobs,Integer>, JobsRepositoryCustom {

    List<Jobs> findByStartDateAndStatus(LocalDate startDate, JobStatus status);

    List<Jobs> findByEndDateAndStatus(LocalDate endDate, JobStatus status);

    Jobs findByTitle(String titleName);



}
