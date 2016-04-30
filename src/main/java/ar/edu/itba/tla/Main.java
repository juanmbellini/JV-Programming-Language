package ar.edu.itba.tla;

import org.apache.commons.cli.*;

public class Main {
    private static String NAME = "cafe";
    public static void main(String[] args) {
        CommandLineParser parser = new DefaultParser();
        Options options = getCommandLineOptions();
        HelpFormatter formatter = new HelpFormatter();
        try {
            CommandLine line = parser.parse(options, args);
            if (line.hasOption("h")) {
                formatter.printHelp(NAME, options);
            }
        } catch (ParseException e) {
            formatter.printHelp(NAME, options);
        }
    }

    private static Options getCommandLineOptions() {
        Options options = new Options();
        options.addOption("d", "debug", false, "print debugging information");
        options.addOption("h", "help", false, "print help");
        return options;
    }
}
