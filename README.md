------------------------------------------------------------------------------------------------------------------------------------------

								RECONSTRUCT-DOCUMENT

------------------------------------------------------------------------------------------------------------------------------------------

Author: Kamal Chaturvedi (kamal.chaturvedi@colorado.edu)

-------------------------------------------------------------------------------------------------------------------------------------------
This project reconstructs a text file which has no spaces, into a file separated by words taken from the lexicon

The input taken 3 parameters (file paths) with the following flags

--lexicon: Filepath to the lexicon being used.
--document: Filepath to the ruined document to reconstruct.
--output: Filepath to which the reconstructed document will be written.

The output of the program is the file specified in the --output flag. You can find the executable in the target folder with the name "reconstruct-document-0.0.1-jar-with-dependencies.jar"

You can run the executable with the sample command 
"java -jar reconstruct-document-0.0.1-jar-with-dependencies.jar --lexicon ./lexicon.txt --document ./doc1.txt --output ./out2.txt"

This executable has all the required dependencies, and can be used to run the program.

To re-create the executable, you need to have maven installed in your machine, and then run "maven clean install"

The program also has a test-suite, which takes in the input arguments (test file paths of the test files present in the parent directory)
and checks the output with the correct-output file present in the same directory (outToCheckWith.txt)

--------------------------------------------------------------------------------------------------------------------------------------------

