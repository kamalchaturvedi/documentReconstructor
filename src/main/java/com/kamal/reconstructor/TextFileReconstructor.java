package com.kamal.reconstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.cli.CommandLine;

import com.kamal.util.FixFaultyFileUtil;

/**
 * @author kamalchaturvedi15
 *
 */
public class TextFileReconstructor implements FileReconstructor {

	public void writeToOutputFile(StringBuffer outputStringBuffer, Path pathToWriteOutput) throws IOException {
		if (Files.exists(pathToWriteOutput)) {
			Files.delete(pathToWriteOutput);
		}
		Files.createFile(pathToWriteOutput);
		if (Files.isWritable(pathToWriteOutput)) {
			Files.write(pathToWriteOutput, outputStringBuffer.toString().getBytes());
		}
	}

	public StringBuffer reconstructMissingSpaces(CommandLine line) throws IOException {
		Set<String> lexiconSet = new HashSet<String>();
		FixFaultyFileUtil faultyFileFixer = new FixFaultyFileUtil();
		lexiconSet.addAll(Files.readAllLines(Paths.get(line.getOptionValue("lexicon"))));
		String input = new String(Files.readAllBytes(Paths.get(line.getOptionValue("document"))));
		StringBuffer outputStringBuffer = faultyFileFixer.fixFaultyFile(input, lexiconSet);
		return outputStringBuffer;
	}

}
