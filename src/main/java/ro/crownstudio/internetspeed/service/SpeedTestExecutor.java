package ro.crownstudio.internetspeed.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ro.crownstudio.internetspeed.pojo.SpeedResult;

import java.io.IOException;

@Service
public class SpeedTestExecutor {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpeedTestExecutor.class);

    @Autowired
    private ProcessParser parser;

    @Autowired
    private ResultInjector injector;

    @Scheduled(fixedRateString = "${WAIT_INTERVAL_MILLIS}")
    public void run() {
        LOGGER.info("Starting speed test...");

        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec(new String[]{"speedtest", "-f", "json-pretty"});

            SpeedResult result = parser.parse(process);

            LOGGER.info("Download speed: " + result.getDownload().getBandwidth() / 125000);
            LOGGER.info("Upload speed: " + result.getUpload().getBandwidth() / 125000);
            LOGGER.info("Ping: " + result.getPing().getHigh());

            injector.saveResult(result);

        } catch (IOException e) {
            LOGGER.error("Got an unexpected error while running speed test.", e);
        }

        LOGGER.info("Speed test ran successfully!");
    }
}
