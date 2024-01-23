package thonguyenvan.interviewms.repository.job;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import thonguyenvan.interviewms.entity.jobs.Levels;


@Repository
public interface LevelRepository extends CrudRepository<Levels,Integer> {

    Levels findByLevelName(String levelName);
}
