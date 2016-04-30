package ar.edu.itba.tla;

import org.apache.commons.cli.*;

public class Main {
    public static void main(String[] args) {
        CommandLineParser parser = new DefaultParser();
        Options options = getCommandLineOptions();
        HelpFormatter formatter = new HelpFormatter();
        try {
            CommandLine line = parser.parse(options, args);
            if (line.hasOption("h")) {
                formatter.printHelp("cafe", options);
            }
        } catch (ParseException e) {
            formatter.printHelp("cafe", options);
        }
    }

    private static Options getCommandLineOptions() {
        Options options = new Options();
        options.addOption("d", "debug", false, "print debugging information");
        options.addOption("h", "help", false, "print help");
        return options;
    }
}
