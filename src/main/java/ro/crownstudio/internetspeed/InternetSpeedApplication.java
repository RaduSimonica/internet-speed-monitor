package ro.crownstudio.internetspeed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ro.crownstudio.internetspeed.config.AppConfig;
import ro.crownstudio.internetspeed.database.repository.SpeedResultRepository;
import ro.crownstudio.internetspeed.pojo.SpeedResult;
import ro.crownstudio.internetspeed.service.ResultParser;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class InternetSpeedApplication implements ApplicationRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(InternetSpeedApplication.class);

	@Autowired
	private AppConfig config;
	@Autowired
	private ResultParser resultParser;
	@Autowired
	private SpeedResultRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(InternetSpeedApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		LOGGER.info("Started application...");
		while (true) {
			LOGGER.info("Starting speed test...");

			SpeedResult result = resultParser.getSpeedResult();

			LOGGER.info("Download speed: " + result.getDownload().getBandwidth() / 125000);
			LOGGER.info("Upload speed: " + result.getUpload().getBandwidth() / 125000);
			LOGGER.info("Ping: " + result.getPing().getHigh());

			repository.save(result);
			LOGGER.info("Sleeping for %s before running again.".formatted(config.getWaitIntervalSeconds()));

			TimeUnit.SECONDS.sleep(config.getWaitIntervalSeconds());
		}
	}
}
