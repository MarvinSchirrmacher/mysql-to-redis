package de.fh_bielefeld.compiler_construction;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.json.JsonWriterFactory;
import javax.json.stream.JsonGenerator;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

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
    MySqlToRedisAdapter(String host) {
        this.analyzer = new MySqlAnalyzer();
        this.client = new Jedis(host);
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

    /**
     * Parses the generic set requests and generates and calls the
     * corresponding redis commands.
     * @param setRequests The generic object holding all set requests.
     */
    private void processSetRequests(JsonObject setRequests) {
        Set<String> keys = setRequests.keySet();

        for (String key : keys) {
            int index = getNextFreeIndex(key);

            for (JsonValue value : setRequests.getJsonArray(key)) {
                Set<String> subKeys = ((JsonObject) value).keySet();
                Map<String, String> hashValues = new HashMap<>();

                subKeys.forEach(k -> hashValues.put(
                        k, this.getHashValue((JsonObject) value, k)));

                String hashKey = String.format("%s:%05d", key, index++);
                this.client.hmset(hashKey, hashValues);
            }
        }
    }

    /**
     * Gets the hash value and additionally calls the toString method on the
     * hash value if it is no string.
     * @param value The value to get the hash value from.
     * @param subKey The key of the target value.
     * @return
     */
    private String getHashValue(JsonObject value, String subKey) {
        return value.get(subKey).getValueType() == JsonValue.ValueType.STRING
                ? value.getString(subKey)
                : value.get(subKey).toString();
    }

    /**
     * Looks for the next free key using the given kex prefix.
     * @param keyPrefix The prefix to look for.
     * @return The next free key.
     */
    private int getNextFreeIndex(String keyPrefix) {
        return this.client.keys(keyPrefix + ":*").size();
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
