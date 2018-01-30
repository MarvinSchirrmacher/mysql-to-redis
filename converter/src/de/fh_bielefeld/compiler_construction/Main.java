package de.fh_bielefeld.compiler_construction;

import org.apache.commons.cli.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    private final static String inputFileOption = "i";

    public static void main(String[] args) throws IOException {
        final Options options = getOptions();
        CommandLineParser parser = new DefaultParser();
        CommandLine commandLine;

        String inputFilePath = null;

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

        MySqlToRedisConverter converter = new MySqlToRedisConverter();
        converter.convert(inputFilePath);
    }

    private static Options getOptions() {
        Options options = new Options();

        Option filepath = Option.builder(inputFileOption)
                .longOpt("input-file")
                .hasArg()
                .argName("PATH")
                .required(true)
                .desc("File path to the sql file to convert")
                .build();

        options.addOption(filepath);

        return options;
    }
}
