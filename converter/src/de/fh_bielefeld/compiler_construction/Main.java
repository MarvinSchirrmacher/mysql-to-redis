package de.fh_bielefeld.compiler_construction;

import org.apache.commons.cli.*;

import java.io.IOException;

/**
 * Programs main class.
 */
public class Main {
    private final static String inputFileOption = "i";
    private final static String genericRequestOption = "g";

    /**
     * Program entry point for this command line tool.
     *
     * Parses any options and start the adapter.
     * @param args Command line arguments.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        final Options options = getOptions();
        CommandLineParser parser = new DefaultParser();
        CommandLine commandLine;

        String inputFilePath = null;
        Boolean saveGenericRequests = false;

        try {
            if (args.length == 0)
                throw new Exception("No arguments are given");
            commandLine = parser.parse(options, args);
        } catch (Exception exception) {
            System.out.println("Failed to parse the options: " + exception.getMessage());
            return;
        }

        if (commandLine.hasOption("h")) {
            new HelpFormatter().printHelp(
                    "mysql-to-redis-converter", options, true);
            return;
        }

        if (commandLine.hasOption(inputFileOption))
            inputFilePath = commandLine.getOptionValue(inputFileOption);

        if (commandLine.hasOption(genericRequestOption))
            saveGenericRequests = true;

        MySqlToRedisAdapter adapter = new MySqlToRedisAdapter();
        adapter.setSaveGenericRequest(saveGenericRequests);
        adapter.process(inputFilePath);
    }

    /**
     * Collects the option parameters.
     * @return The filled options.
     */
    private static Options getOptions() {
        Options options = new Options();

        Option filepath = Option.builder(inputFileOption)
                .longOpt("input-file")
                .hasArg()
                .argName("PATH")
                .required(true)
                .desc("File path to the sql file to convert")
                .build();

        Option saveGenericRequests = Option.builder(genericRequestOption)
                .longOpt("generic-requests")
                .desc("If true the generic interim request will be saved to a json file")
                .build();

        options.addOption(filepath);
        options.addOption(saveGenericRequests);

        return options;
    }
}
