package ro.crownstudio.internetspeed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service
public class Helper {

    private static final Logger LOGGER = LoggerFactory.getLogger(Helper.class);

    public String inputStreamToString(InputStream input) {
        StringBuilder builder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(System.lineSeparator());
            }
        } catch (Exception e) {
            LOGGER.error("Failed to transform Input Stream to String", e);
            return null;
        }

        String result = builder.toString();
        if (result.isEmpty()) {
            return null;
        }

        return result;
    }
}
