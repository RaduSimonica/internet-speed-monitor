package ro.crownstudio.internetspeed.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.crownstudio.internetspeed.pojo.SpeedResult;

public interface SpeedResultRepository extends JpaRepository<SpeedResult, Long> {
}
