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
	}
}
