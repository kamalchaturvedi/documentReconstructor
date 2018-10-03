package com.kamal.util;

import java.util.Set;

/**
 * @author kamalchaturvedi15
 *
 */
public class FixFaultyFileUtil {
	public StringBuffer fixFaultyFile(String input, Set<String> lexiconSet) {
		StringBuffer buffer = new StringBuffer();
		StringBuffer outputStringBuffer = new StringBuffer();
		int inputIndex = 0, lastPatternFoundAtIndex = -1, resetAtIndex = 0;
		char currentlyProcessedChar;
		while (inputIndex < (input.length() - 1)) {
			currentlyProcessedChar = input.charAt(inputIndex);
			if (currentlyProcessedChar != '.') {
				if (!checkIfAPatternExists(buffer, lexiconSet, currentlyProcessedChar)) {
					if ((inputIndex - lastPatternFoundAtIndex - resetAtIndex) > 1) {
						buffer.delete(lastPatternFoundAtIndex + 1, inputIndex - resetAtIndex);
						inputIndex = resetAtIndex + lastPatternFoundAtIndex + 1;
					}
					buffer.append(" ");
					outputStringBuffer.append(buffer);
					buffer.setLength(0);
					lastPatternFoundAtIndex = -1;
					resetAtIndex = inputIndex;
				} else {
					buffer.append(currentlyProcessedChar);
					if (lexiconSet.contains(buffer.toString())) {
						lastPatternFoundAtIndex = (inputIndex - resetAtIndex);
					}
					++inputIndex;
				}
			} else {
				buffer.append(". ");
				outputStringBuffer.append(buffer);
				buffer.setLength(0);
				++inputIndex;
			}
		}
		return outputStringBuffer;
	}

	private boolean checkIfAPatternExists(StringBuffer buffer, Set<String> lexiconSet, char nextInput) {
		boolean doesExist = lexiconSet.stream().anyMatch(w -> w.startsWith(buffer.toString() + nextInput));
		return doesExist;
	}
}
