package ro.crownstudio.internetspeed.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.crownstudio.internetspeed.database.repository.SpeedResultRepository;
import ro.crownstudio.internetspeed.pojo.SpeedResult;

@Service
public class ResultInjector {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResultInjector.class);

    @Autowired
    private SpeedResultRepository repository;

    public void saveResult(SpeedResult result) {
        try {
            repository.save(result);
            LOGGER.debug("Injected into database successfully.");
        } catch (Exception e) {
            throw new RuntimeException("Got error while trying to inject SpeedResult into database.", e);
        }
    }
}
