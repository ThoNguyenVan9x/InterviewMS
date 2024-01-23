package thonguyenvan.interviewms.repository.job;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import thonguyenvan.interviewms.entity.jobs.Skills;

@Repository
public interface SkillRepository extends CrudRepository<Skills,Integer> {

    Skills findBySkillName(String skillName);
}
