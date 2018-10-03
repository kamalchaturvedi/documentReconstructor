package com.kamal.inputResolver;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

/**
 * @author kamalchaturvedi15
 *
 */
public class ResolveInputParameters implements ResolveParameters {

	@Override
	public Options extractFlags() {
		Options commandLineFlagOptions = new Options();
		Option lexiconPathOption = Option.builder("l").longOpt("lexicon").desc("Filepath to the lexicon being used")
				.hasArg().build();
		Option documentPathOption = Option.builder("d").longOpt("document")
				.desc("Filepath to the ruined document to reconstruct").hasArg().build();
		Option outputPathOption = Option.builder("o").longOpt("output")
				.desc("Filepath to which the reconstructed document will be written").hasArg().build();
		commandLineFlagOptions.addOption(lexiconPathOption).addOption(documentPathOption).addOption(outputPathOption);
		return commandLineFlagOptions;
	}
}
