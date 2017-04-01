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
	}
}
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
        }
/*----------------------------END OF 3--------------------------------*/

