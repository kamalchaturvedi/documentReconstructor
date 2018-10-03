package com.kamal.reconstructor;

import java.io.IOException;
import java.nio.file.Path;

import org.apache.commons.cli.CommandLine;

public interface FileReconstructor {
	public void writeToOutputFile(StringBuffer outputStringBuffer, Path pathToWriteOutput) throws IOException;

	public StringBuffer reconstructMissingSpaces(CommandLine line) throws IOException;
}
