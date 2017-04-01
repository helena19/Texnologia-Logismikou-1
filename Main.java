import java.util.*;

public class Main {

	public static String execute(String command, String filePath, String filename) {
		String results = null;
		StringBuilder output = new StringBuilder();
		try {
			Runtime rt = Runtime.getRuntime();
			Process pr = rt.exec(command, null, new File(filePath));
			BufferedReader reader = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			while ((results = reader.readLine()) != null) {
				output.append(results + '\n');
			}
			try {
				pr.waitFor();
			}
			catch (InterruptedException ex) {
			}
			pr.destroy();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		String commandResults = output.toString();
		return commandResults;
	}

	public static void main(String[] args) {
		Scanner scanner;
        /*--------------------------------------------------------------------*/
		if (args.length != 2) {
			System.out.println("Wrong arguments. Exiting...");
			System.exit(-1);
		}
		String filePath = args[0];
		String resultsPath = args[1];
        String  HTMLFile = createHTML(args);

        System.out.println("Path to clone: " + filePath);
		System.out.println("Path to print results: " + resultsPath);
		File resultsDirectory = null;
		boolean bool = false;
		try {
			resultsDirectory = new File(resultsPath);
			bool = resultsDirectory.mkdir();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		String results = resultsDirectory + "/results.html";
		String resultsHTML = null;
		/*--------------------------------------------------------------------*/
        int i, j, k;
        String commandResults = null;
        /*----------------------------------1---------------------------------*/
        String command = "git ls-files";	//get all files
		commandResults = execute(command, filePath, null);
		String fileNames[] = commandResults.split("\\r?\\n");
		Integer numOfFiles = fileNames.length;
		//System.out.println("Repository contains " + numOfFiles + " files.");
		/*----------------------------END OF 1--------------------------------*/

		/*----------------------------------2---------------------------------*/
		ArrayList<Integer> numOfLines = new ArrayList<Integer>();
		for (String filename : fileNames) {
			command = filePath + "/" + filename;
			String line = null;
            Integer filelines = 0;
            try {
                FileReader fileReader = new FileReader(command);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                while((line = bufferedReader.readLine()) != null) {
                    filelines++;
                }
                bufferedReader.close();
            }
            catch(FileNotFoundException ex) {
                System.out.println("Unable to open file '" + command + "'");
            }
            catch(IOException ex) {
                System.out.println("Error reading file '" + command + "'");
            }
			numOfLines.add(filelines);
		}
		Integer totalLines = 0;
		for (Integer n : numOfLines) {
			totalLines += n;
		}
		/*----------------------------END OF 2--------------------------------*/

	 	/*----------------------------------3---------------------------------*/
        //--------Branches
		command = "git branch";
		commandResults = execute(command, filePath, null);
		String branchesNames[] = commandResults.split("\\r?\\n");
		Integer numOfBranches = branchesNames.length;
		for (i = 0; i < numOfBranches; ++i) {
			String temp = branchesNames[i];
			String newtemp = temp.replace("*", " ");
			branchesNames[i] = newtemp;
		}
        int realNumber = 0;
        for (i = 0; i < numOfBranches; ++i) {
            if (!branchesNames[i].contains("->")) realNumber++;

//--------End of Branches

        HTMLFile = addHTML4(HTMLFile);

        //--------Tags
	command = "git tag";
	commandResults = execute(command, filePath, null);
        Integer numOfTags = 0;
        String tagsNames[] = commandResults.split("\\r?\\n");
        if (commandResults.equals("")) {
            numOfTags = 0;
        }
        else {
		    numOfTags = tagsNames.length;
        }
        
        //--------End of Tags

        HTMLFile = addHTML5(HTMLFile);

        //--------Committers
        command = "git shortlog -s -n HEAD";                                    //-e for email
        commandResults = execute(command, filePath, null);
        String committers[] = commandResults.split("\\r?\\n");
        Integer numOfCommitters = committers.length;
        String committersNames[] = new String[numOfCommitters];
        Double commitsArray[] = new Double[numOfCommitters];
        for (i = 0; i < numOfCommitters; ++i) {
            scanner = new Scanner(committers[i]);
            commitsArray[i] = scanner.nextDouble();
            String name = scanner.next();
            while (scanner.hasNext()) {
                name = name + " " + scanner.next();
            }
            committersNames[i] = name;
        }
       
        //--------End of Committers
        }
		/*----------------------------END OF 3--------------------------------*/

		/*----------------------------------4---------------------------------*/
        for (i = 0; i < numOfBranches; ++i) {
            if (branchesNames[i].startsWith("*")) continue;
            if (branchesNames[i].contains("->")) continue;
            command = "git log --reverse " + branchesNames[i];                  //commits -> first commit is first
    		commandResults = execute(command, filePath, null);
            String commitsR[] = commandResults.split("\\r?\\n");
            String firstCommit = commitsR[2];
            firstCommit = firstCommit.replace("Date:   ","");
            command = "git log " + branchesNames[i];                            //commits -> last commit is first
    		commandResults = execute(command, filePath, null);
            String commitsN[] = commandResults.split("\\r?\\n");
            String lastCommit = commitsN[2];
            lastCommit = lastCommit.replace("Date:   ","");

         

            //--------i

            
            //--------End of i
            //--------ii
            command = "git tag --contains " + branchesNames[i];
            commandResults = execute(command, filePath, null);

            HTMLBranch += "Tags " + commandResults + "<br/>";
            HTMLBranch += "</li>";
            HTMLBranch += "</div></div></div></div></form></body></html>";

            BufferedWriter writer = null;
            String where = args[1] + "/" + branchesNames[i] + ".html";
            String w2 = where.replace(" ", "");
            try {
                writer = new BufferedWriter(new FileWriter(w2));
                writer.write(HTMLBranch);
            }
            catch ( IOException e) {
            }
            finally {
                try {
                    if (writer != null)
                    writer.close();
                }
                catch (IOException e)
                {
                }
            }
            //--------End of ii
        }
        /*----------------------------END OF 4--------------------------------*/
	}
}
