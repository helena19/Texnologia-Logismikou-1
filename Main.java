import java.util.*;

public class Main {
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
