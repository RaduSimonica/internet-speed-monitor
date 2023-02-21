package ro.crownstudio.internetspeed.service;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import ro.crownstudio.internetspeed.pojo.SpeedResult;

import java.io.*;

@Service
public class ResultParser {

    public SpeedResult getSpeedResult() {
        SpeedResult result;
        Process process = null;
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("speedtest -f json-preety");
            process = processBuilder.start();
            process.waitFor();

            result = new Gson().fromJson(parseInputStream(process.getInputStream()), SpeedResult.class);
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
