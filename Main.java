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
        System.out.println("Please give the path of the git repository.");
		Scanner scanner = new Scanner(System.in);
		String filePath = scanner.nextLine();
		System.out.println(filePath);
        System.out.println("Please give the path of the results.");
		String resultsPath = scanner.nextLine();
		System.out.println(resultsPath);
		scanner.close();
	}
}
