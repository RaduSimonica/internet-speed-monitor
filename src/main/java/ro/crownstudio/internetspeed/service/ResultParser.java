package ro.crownstudio.internetspeed.service;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ro.crownstudio.internetspeed.pojo.SpeedResult;

import java.io.*;

@Service
public class ResultParser {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResultParser.class);

    public SpeedResult getSpeedResult() {
        SpeedResult result;
        Process process = null;
        try {
            LOGGER.info("Creating command");
            Runtime runtime = Runtime.getRuntime();
            process = runtime.exec(new String[]{"speedtest", "-f json-pretty"});
            LOGGER.info("Starting process builder");
            process.waitFor();

            String processResult = parseInputStream(process.getInputStream());
            LOGGER.info("Got result from process:");
            LOGGER.info("-> " + processResult);

            result = new Gson().fromJson(processResult, SpeedResult.class);
            LOGGER.info("Parsed as: " + result);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            if (process != null) {
                process.destroy();
            }
        }

        return result;
    }

    private String parseInputStream(InputStream input) {
        StringBuilder builder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String result = builder.toString();
        if (result.isEmpty()) {
            return null;
        }
        return result;
    }
}
