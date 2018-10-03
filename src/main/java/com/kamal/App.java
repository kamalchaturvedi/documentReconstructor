package com.kamal;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.kamal.inputResolver.ResolveInputParameters;
import com.kamal.inputResolver.ResolveParameters;
import com.kamal.reconstructor.FileReconstructor;
import com.kamal.reconstructor.TextFileReconstructor;

/**
 * @author kamalchaturvedi15
 *
 */
public class App {
	private final static Logger logger = Logger.getLogger(App.class.getName());

	public static void main(String[] args) {
		ResolveParameters inputResolver = new ResolveInputParameters();
		FileReconstructor fileReconstructor = new TextFileReconstructor();
		Options commandLineFlagOptions = inputResolver.extractFlags();
		CommandLineParser parser = new DefaultParser();
		try {
			CommandLine line = parser.parse(commandLineFlagOptions, args, true);
			StringBuffer outputStringBuffer = fileReconstructor.reconstructMissingSpaces(line);
			Path pathToWriteOutput = Paths.get(line.getOptionValue("output"));
			fileReconstructor.writeToOutputFile(outputStringBuffer, pathToWriteOutput);
			logger.info("Successfully generated the space separated output file");
		} catch (ParseException exp) {
			logger.severe("Could not parse -> " + exp.getMessage());
		} catch (IOException exp) {
			logger.severe("Could not read the file specified -> " + exp.getMessage());
		}
	}
}
