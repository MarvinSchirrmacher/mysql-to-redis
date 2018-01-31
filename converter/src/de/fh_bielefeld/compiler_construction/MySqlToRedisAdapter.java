package de.fh_bielefeld.compiler_construction;

import redis.clients.jedis.Jedis;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriterFactory;
import javax.json.stream.JsonGenerator;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Adapter class to act with a redis server via sql commands.
 */
public class MySqlToRedisAdapter {

    private final String genericRequestsFilePath = "generic-requests.json";
    private final MySqlAnalyzer analyzer;
    private final Jedis client;
    private boolean saveGenericRequest = false;

    public boolean getSaveGenericRequest() {
        return saveGenericRequest;
    }

    public void setSaveGenericRequest(boolean saveGenericRequest) {
        this.saveGenericRequest = saveGenericRequest;
    }

    /**
     * Initializes the mysql analyzer and the redis connection.
     */
    MySqlToRedisAdapter() {
        this.analyzer = new MySqlAnalyzer();
        this.client = new Jedis("localhost");
    }

    /**
     * Executes all given sql commands on the redis server instance.
     *
     * Reads in the given sql file and parses it to get a generic request
     * object with which the redis statement will be generated and executed.
     * @param inputFilePath The file path to the sql file to process.
     * @throws IOException
     */
    public void process(String inputFilePath) throws IOException {
        System.out.println(String.format(
                "[MySqlToRedisAdapter] Process sql file \"%s\"", inputFilePath
        ));
        JsonObject genericRequest = this.analyzer.process(inputFilePath);

        if (this.getSaveGenericRequest()) {
            this.saveJsonToFile(genericRequest);
        }

        JsonObject setRequests = genericRequest.getJsonObject("set");
        if (!setRequests.isEmpty()) {
            this.processSetRequests(setRequests);
        }
    }

    private void processSetRequests(JsonObject setRequests) {
    }

    /**
     * Saves the interim generic requests object to a json file.
     * @param json The request object to save.
     * @throws FileNotFoundException
     */
    private void saveJsonToFile(JsonObject json) throws FileNotFoundException {
        System.out.println(String.format(
                "[MySqlToRedisAdapter] Save generic requests to \"%s\"",
                genericRequestsFilePath
        ));

        Map<String, Boolean> config = new HashMap<>();
        config.put(JsonGenerator.PRETTY_PRINTING, true);
        JsonWriterFactory writerFactory = Json.createWriterFactory(config);

        OutputStream out = new FileOutputStream(genericRequestsFilePath);
        writerFactory.createWriter(out).write(json);
    }
}
