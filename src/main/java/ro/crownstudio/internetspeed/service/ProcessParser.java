package ro.crownstudio.internetspeed.service;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.crownstudio.internetspeed.Helper;
import ro.crownstudio.internetspeed.pojo.SpeedResult;

@Service
public class ProcessParser {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessParser.class);

    @Autowired
    private Helper helper;

    public SpeedResult parse(Process process) {
        try {
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                String errorMsg = helper.inputStreamToString(process.getErrorStream());
                LOGGER.error("Got error message from process. {}", errorMsg);
                return null;
            }
            String result = helper.inputStreamToString(process.getInputStream());

            LOGGER.debug(result);

            return new Gson().fromJson(result, SpeedResult.class);
        } catch (InterruptedException e) {
            LOGGER.error("Unexpected error from process: ", e);
            return null;
        }
    }
}
