//package ergasia_1;

import java.util.*;
import java.io.*;

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

    public static String createHTML(String[] args) {
        String html = "<!DOCTYPE html><html lang=\"en\"><head>  <title>Software Technology</title>  <meta charset=\"utf-8\">  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script></head><body>    <form><div class=\"panel panel-info\">    <div class=\"panel-heading\" style=\"font-weight: bold; height: 65px;\"><img alt=\"My Image\" src=\"Software-Git.png\" width=\"40\" height=\"50\" align=\"left\"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Software Technology - Assignment 1    </div>            <div class=\"panel-body\" style=\"font-weight: bold;\">Repository name:" + args[0] + "</div></div>";
        html += " <div class=\"container\"><div class=\"panel panel-default\"><div class=\"panel-heading\"><img alt=\"My Image2\" src=\"file.png\" width=\"25\" height=\"25\" align=\"left\"/>&nbsp; Number of files in repository:";
        return html;
    }
    public static String addHTML1(String html) {
        html += "<div class=\"panel panel-default\"><div class=\"panel-heading\"><img alt=\"My Image3\" src=\"notepad.png\" width=\"25\" height=\"25\" align=\"left\"/>&nbsp; Number of lines in repository:";
        return html;
    }
    public static String addHTML2(String html) {
        html += "<div class=\"container\"><h3><img alt=\"My Image4\" src=\"file.png\" width=\"25\" height=\"25\" align=\"left\"/>&nbsp; List of files</h3><p>Click on the collapsible panel to open and close it.</p><div class=\"panel-group\"><div class=\"panel panel-default\"><div class=\"panel-heading\"><h4 class=\"panel-title\"><a data-toggle=\"collapse\" href=\"#collapse1\">Repository's files</a></h4></div><div id=\"collapse1\" class=\"panel-collapse collapse\"><ul class=\"list-group\">";
        return html;
    }
    public static String addHTML3(String html) {
        html += "<div class=\"container\"><h3>    <img alt=\"My Image5\" src=\"branch.png\" width=\"28\" height=\"28\" align=\"left\"/>    &nbsp; List of branches </h3><table class=\"table table-bordered\">  <thead>    <tr style=\"background:#d4e1f7;\">      <th>Branch Name</th>      <th>First commit</th>      <th>Last commit</th>    </tr>  </thead>  <tbody><tr>";
        return html;
    }
    public static String branchHTML1(String[] args) {
        String html;
        html = "<!DOCTYPE html><html lang=\"en\">    <head>      <title>Branch Information</title>      <meta charset=\"utf-8\">      <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">      <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">      <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>      <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>    </head>    <body><form><div class=\"panel panel-info\"><div class=\"panel-heading\" style=\"font-weight: bold; height: 65px;\">    <img alt=\"My Image\" src=\"Software-Git.png\" width=\"40\" height=\"50\" align=\"left\"/>    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Software Technology - Assignment 1</div><div class=\"panel-body\" style=\"font-weight: bold;\">Repository name: " + args[0];
        html += "</div></div><div class=\"container\"><h3><img alt=\"My Image4\"src=\"branch.png\" width=\"35\" height=\"35\" align=\"left\"/>";
        return html;
    }
    public static String addHTML4(String html) {
        html += "<div class=\"container\"><h3><img alt=\"My Image6\" src=\"tag.png\" width=\"25\" height=\"25\" align=\"left\"/>&nbsp; List of tags</h3><p>Click on the collapsible panel to open and close it.</p><div class=\"panel-group\">  <div class=\"panel panel-default\"><div class=\"panel-heading\">  <h4 class=\"panel-title\">    <a data-toggle=\"collapse\" href=\"#collapse3\">Repository's tags</a>  </h4></div><div id=\"collapse3\" class=\"panel-collapse collapse\">  <ul class=\"list-group\">";
        return html;
    }
    public static String addHTML5(String html) {
        html += "<div class=\"container\"><h3><img alt=\"My Image7\" src=\"user.png\" width=\"25\" height=\"25\" align=\"left\"/>&nbsp; List of committers</h3><p>Click on the collapsible panel to open and close it.</p><div class=\"panel-group\">  <div class=\"panel panel-default\"><div class=\"panel-heading\">      <h4 class=\"panel-title\"> <a data-toggle=\"collapse\" href=\"#collapse4\">Repository's committers</a> </h4>    </div> <div id=\"collapse4\" class=\"panel-collapse collapse\"> <ul class=\"list-group\">";
        return html;
    }
    public static String addHTML6(String html) {
        html += "<div class=\"container\"><h3>    <img alt=\"My Image6\" src=\"stat.jpeg\" width=\"30\" height=\"25\" align=\"left\"/>    &nbsp; Statistics </h3></div><p/><p/>  <div class=\"panel panel-info\">      <div class=\"panel-body\" style=\"font-weight: bold;\">Commits</div>  </div>";
        return html;
    }
    public static String addHTML7(String html) {
        html += " <table class=\"table table-bordered\"><caption>Commits per branch</caption><thead><tr style=\"background:#d4e1f7;\">  <th>Branch</th>  <th>Commits</th>  <th>Percents</th></tr></thead><tbody>";
        return html;
    }
    public static String addHTML8(String html) {
        html += "<table class=\"table table-bordered\"><caption>Commits per author per branch</caption><thead><tr style=\"background:#d4e1f7;\">  <th>Author - Branch</th>  <th>Commits</th>  <th>Percents</th></tr></thead><tbody>";
        return html;
    }
    public static String addHTML9(String html) {
        html += "<table class=\"table table-bordered\">    <caption>Commits per author per year</caption>  <thead>    <tr style=\"background:#d4e1f7;\">      <th>Commiter</th>      <th>Years</th>      <th>Commits</th>      <th>Percents</th>    </tr>  </thead>  <tbody>";
        return html;
    }

    public static String addHTML10(String html) {
        html += "<table class=\"table table-bordered\">    <caption>Commits per author per month</caption>  <thead>    <tr style=\"background:#d4e1f7;\">      <th>Commiter</th>      <th>Months</th>      <th>Commits</th>      <th>Percents</th>    </tr>  </thead>  <tbody>";
        return html;
    }
    public static String addHTML11(String html) {
        html += "<table class=\"table table-bordered\">    <caption>Commits per author per day</caption>  <thead>    <tr style=\"background:#d4e1f7;\">      <th>Commiter</th>      <th>Days</th>      <th>Commits</th>      <th>Percents</th>    </tr>  </thead>  <tbody>";
        return html;
    }
    public static String addHTML12(String html) {
        html += "<div class=\"panel panel-info\"><div class=\"panel-body\" style=\"font-weight: bold;\">Changes</div></div><table class=\"table table-bordered\"><caption>Insertions/Deletions per author</caption>  <thead><tr style=\"background:#d4e1f7;\">  <th>Commiter</th>  <th>Insertions</th>  <th>Deletions</th>  <th>Total</th></tr>  </thead><tbody>";
        return html;
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

        HTMLFile += numOfFiles + "</div></div>";

		//System.out.println("Repository contains " + numOfFiles + " files.");
		/*----------------------------END OF 1--------------------------------*/
        HTMLFile = addHTML1(HTMLFile);
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

        HTMLFile += totalLines + "</div></div>";
        HTMLFile = addHTML2(HTMLFile);
        for (i = 0; i < numOfFiles; ++i) {
            HTMLFile += "<li class=\"list-group-item\">" + fileNames[i] + " - " + numOfLines.get(i) +" lines</li>";
        }
		/*----------------------------END OF 2--------------------------------*/
        HTMLFile += "</ul><div class=\"panel-footer\">Total number:" + numOfFiles + "</div></div></div></div></div>";
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

        HTMLFile = addHTML3(HTMLFile);

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

            HTMLFile += "<td><a href=\"" + branchesNames[i] + ".html\">";
            HTMLFile += branchesNames[i] + "</a></td>";
            HTMLFile += "<td>" + firstCommit + "</td>";
            HTMLFile += "<td>"+ lastCommit + "</td>";

            //--------i

            String HTMLBranch = branchHTML1(args);
            HTMLBranch += "&nbsp;" + branchesNames[i] + "</h3>";
            for (j = 0; j < commitsR.length; ++j) {
                if (commitsR[j].startsWith("commit")) {
                    HTMLBranch += "<br/>";
                    HTMLBranch += "<h4><img alt=\"My Image7\" src=\"commit.png\" width=\"25\" height=\"25\"/>&nbsp;";
                    HTMLBranch += commitsR[j] + "</h4>";
                    HTMLBranch += "<hr>";
                }
                else if (commitsR[j].startsWith("Author:")){
                    HTMLBranch += "<h5><img alt=\"My Image8\" src=\"user.png\" width=\"25\" height=\"25\"/>&nbsp;" + commitsR[j] + "</h5>";
                }
                else if (commitsR[j].startsWith("Date:")) {
                    HTMLBranch += "<h5><img alt=\"My Image9\" src=\"callendar.jpeg\" width=\"25\" height=\"25\"/>&nbsp;" + commitsR[j] + "</h5>";
                }
                else {
                    HTMLBranch += "<h6>" + commitsR[j] + "</h6>";
                }
            }
            HTMLBranch += "</form></body></html>";
            for (j = 0; j < commitsR.length; ++j) {
            }
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

        HTMLFile += " </tbody></table><div class=\"panel panel-default\"><div class=\"panel-heading\">&nbsp; Number of branches in repository: " + numOfBranches + "</div></div></div>";

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
        for (i = 0; i < numOfTags; ++i){
            HTMLFile += "<li class=\"list-group-item\">" + tagsNames[i] + "</li>";
        }

        HTMLFile += "</ul><div class=\"panel-footer\">Total number: " + numOfTags + "</div><div></div></div></div></br>";
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
        for (i = 0; i < numOfCommitters; ++i) {
            HTMLFile += "<li class=\"list-group-item\">" + committersNames[i] + " - Commits: " + commitsArray[i] + "</li>";
        }

        HTMLFile += "</ul><div class=\"panel-footer\">Total number: " + numOfCommitters + "</div></div></div></div></div></br>";
        //--------End of Committers
        /*----------------------------END OF 3--------------------------------*/

        HTMLFile = addHTML6(HTMLFile);

        /*----------------------------------5---------------------------------*/
        //--------i
        Integer numOfCommits = 0;
		//command = "git rev-list --count HEAD";
        command = "git rev-list --count --all";
		commandResults = execute(command, filePath, null);
		scanner = new Scanner(commandResults);
		numOfCommits = scanner.nextInt();

        HTMLFile += "<h4>Number of commits: " + numOfCommits + "</h4>";

        double[] committersPercents = new double[numOfCommitters];

        HTMLFile += "<table class=\"table table-bordered\"><caption>Commits per author</caption><thead><tr style=\"background:#d4e1f7;\">  <th>Author</th>  <th>Commits</th>  <th>Percents</th></tr></thead><tbody>";

		if (numOfCommits != 0) {
			for (i = 0; i < numOfCommitters; ++i) {
				committersPercents[i] = (commitsArray[i]/numOfCommits)*100;
			}
			for (i = 0; i < numOfCommitters; ++i) {
                String perc = String.format("%.2f", committersPercents[i]);
                HTMLFile += "<tr><td>" + committersNames[i] + "</td><td>" + commitsArray[i] + "</td><td>" + perc + "%</td></tr>";
			}
		}
		else {
			System.out.println("No commits in this repository.");
		}

        HTMLFile += "</tbody></table><p/>";
        //--------End of i

        HTMLFile = addHTML7(HTMLFile);

        //--------ii
        Double[] branchesPercents = new Double[numOfBranches];
        for (i = 0; i < numOfBranches; ++i) {
            branchesPercents[i] = 0.0;
        }
		Double[] tempCount = new Double[numOfBranches];
		for (i = 0; i < numOfBranches; ++i) {
            if (branchesNames[i].startsWith("*")) continue;
            if (branchesNames[i].contains("->")) continue;
			command = "git log --oneline" + branchesNames[i];
			commandResults = execute(command, filePath, null);
			String array[] = commandResults.split("\\r?\\n");
			tempCount[i] = array.length*1.0;
		}
		if (numOfBranches != 0) {
			for (i = 0; i < numOfBranches; ++i) {
                if (branchesNames[i].startsWith("*")) continue;
                if (branchesNames[i].contains("->")) continue;
				branchesPercents[i] = (tempCount[i]/numOfCommits)*100;
            }
			for (i = 0; i < numOfBranches; ++i) {
                if (branchesNames[i].startsWith("*")) continue;
                if (branchesNames[i].contains("->")) continue;

                String perc = String.format("%.2f", branchesPercents[i]);
                HTMLFile += "<tr><td>" + branchesNames[i] + "</td><td>" + tempCount[i] + "</td><td>" + perc + "%</td></tr>";
			}
		}
		else {
			System.out.println("No branches in this repository.");
		}
        HTMLFile += "</tbody></table><p/>";
        //--------End of  ii
        HTMLFile = addHTML8(HTMLFile);
        //--------iii
        for (i = 0; i < numOfBranches; ++i) {
            if (branchesNames[i].startsWith("*")) continue;
            if (branchesNames[i].contains("->")) continue;
            command = "git log " + branchesNames[i];
            commandResults = execute(command, filePath, null);
            String array[] = commandResults.split("\\r?\\n");
            command = "git log --oneline" + branchesNames[i];
            String commandResults1;
            commandResults1 = execute(command, filePath, null);
            String array2[] = commandResults1.split("\\r?\\n");
			Double branchCommits = array2.length*1.0;
            for (j = 0; j < numOfCommitters; ++j) {
                Double userCommits = 0.0;
                for (k = 0; k < array.length; ++k) {
                    String authorName;
                    if (array[k].startsWith("Author: ")) {
                        scanner = new Scanner(array[k]);
                        scanner.next();
                        authorName = scanner.next();
                        while (scanner.hasNext()) {
                            String tmp = scanner.next();
                            if (tmp.contains("<")) {
                                break;
                            }
                            else {
                                authorName = authorName + " " + tmp;
                            }
                        }
                        if (authorName.equals(committersNames[j])) {
                            userCommits += 1.0;
                        }
                    }
                }
                String perc;
                if (branchCommits > 0) {
                    perc = String.format("%.2f", (userCommits/branchCommits)*100);
                }
                else perc = "0.00";
                HTMLFile += "<tr><td>" + committersNames[j] + " - " + branchesNames[i] + "</td><td>" + userCommits + "</td><td>" + perc + "%</td></tr>";
            }
        }
        HTMLFile += "</tbody></table><p/>";
        //--------End of iii
        /*----------------------------END OF 5--------------------------------*/
        HTMLFile = addHTML9(HTMLFile);
        /*----------------------------------6---------------------------------*/
        command = "git log --date=short";
        commandResults = execute(command, filePath, null);
        String array[] = commandResults.split("\\r?\\n");
        List<String> dates = new ArrayList<String>();
        List <String> authors = new ArrayList<String>();
        for (String line : array) {
            if (line.contains("Date: ")) {
                String l = line.replace("Date: ","");
                dates.add(l);
            }
            else if (line.contains("Author: ")) {
                authors.add(line);
            }
        }

        String singleAuthor = null;
        for (i = 0; i < authors.size(); ++i) {
            scanner = new Scanner(authors.get(i));
            scanner.next();
            singleAuthor = scanner.next();
            String temp;
            while (true) {
                temp = scanner.next();
                if (temp.contains("<")) {
                    break;
                }
                else {
                    singleAuthor = singleAuthor + " " + temp;
                }
            }
            authors.set(i, singleAuthor);
            singleAuthor = null;
        }

        Double fyear, lyear, fmonth, lmonth, fday, lday;
        Integer size = dates.size();
        String last  = dates.get(0);
        String first = dates.get(size-1);
        String nlast  = last.replace("-"," ");
        String nfirst = first.replace("-"," ");
        scanner = new Scanner(nlast);
        lyear = scanner.nextDouble(); lmonth = scanner.nextDouble(); lday = scanner.nextDouble();
        scanner = new Scanner(nfirst);
        fyear = scanner.nextDouble(); fmonth = scanner.nextDouble(); fday = scanner.nextDouble();
        Double totalDays = 0.0, totalMonths = 0.0, totalYears = 0.0;
        if (lyear == fyear) {
            totalYears = 1.0;
            totalMonths = lmonth - fmonth;
            totalDays = ((lmonth - 1) - (fmonth + 1))*30.0 + fday + lday;
        }
        else if (lyear - fyear == 1) {
            totalYears = 1.0;
            totalMonths = 12.0 - fmonth + lmonth + 1;
            totalDays = (totalMonths - 1.0)*30.0 + fday + lday;
        }
        else {
            totalYears = lyear - fyear;
            Double years = (lyear - 1) - (fyear + 1);
            totalDays += years*365.0;
            totalMonths += years*12.0;
            totalDays += totalMonths*30.0;
            totalMonths += 12.0 - fmonth + lmonth;
            totalDays += fday + 30.0 - lday;
        }

        List <MyDate> perDay = new ArrayList<MyDate>();
        List <MyDate> perMonth = new ArrayList<MyDate>();
        List <MyDate> perYear = new ArrayList<MyDate>();
        for (i = 0; i < numOfCommitters; ++i) {
            scanner = new Scanner(committers[i]);
            Double ammount = scanner.nextDouble();
            String name = scanner.next();
            MyDate tmp;
            if (totalDays > 0) {
                tmp = new MyDate(name, ammount/totalDays);
            }
            else {
                tmp = new MyDate(name, 0.0);
            }
            perDay.add(tmp);
            if (totalMonths > 0) {
                tmp = new MyDate(name, ammount/totalMonths);
            }
            else {
                tmp = new MyDate(name, 0.0);
            }
            perMonth.add(tmp);
            if (totalYears > 0) {
                tmp = new MyDate(name, ammount/totalYears);
            }
            else {
                tmp = new MyDate(name, 0.0);
            }
            perYear.add(tmp);
        }

        for (i = 0; i < numOfCommitters; ++i) {
            String perc = String.format("%.2f", perYear.get(i).getAmmount());
            HTMLFile += "<tr><td>" + perYear.get(i).getName() + "</td><td>" + totalYears + "</td><td>" + commitsArray[i] + "</td><td>" + perc + "%</td></tr>";
        }
        HTMLFile += "</tbody></table><p/>";
        HTMLFile = addHTML10(HTMLFile);
        for (i = 0; i < numOfCommitters; ++i) {
            String perc = String.format("%.2f", perMonth.get(i).getAmmount());
            HTMLFile += "<tr><td>" + perMonth.get(i).getName() + "</td><td>" + totalMonths + "</td><td>" + commitsArray[i] + "</td><td>" + perc + "%</td></tr>";
        }
        HTMLFile += "</tbody></table><p/>";
        HTMLFile = addHTML11(HTMLFile);
        for (i = 0; i < numOfCommitters; ++i) {
            String perc = String.format("%.2f", perDay.get(i).getAmmount());
            HTMLFile += "<tr><td>" + perDay.get(i).getName() + "</td><td>" + totalDays + "</td><td>" + commitsArray[i] + "</td><td>" + perc + "%</td></tr>";
        }
        HTMLFile += "</tbody></table><p/>";


        /*----------------------------END OF 6--------------------------------*/
        HTMLFile = addHTML12(HTMLFile);
        /*----------------------------------7---------------------------------*/
        command = "git log --stat";
		commandResults = execute(command, filePath, null);
		array = commandResults.split("\\r?\\n");
		List<String> commitsFinal = new ArrayList<String>();
		List<String> authorsFinal = new ArrayList<String>();
		int found = 0;
		String temp;
		for (i = 0; i < array.length; ++i) {
			if (array[i].contains("commit")) {
				temp = array[i];
				found = i;
			}
			else if (array[i].contains("Author: ") && found == i - 1) {
				commitsFinal.add(array[i-1]);
				authorsFinal.add(array[i]);
			}
		}
		for (i = 0; i < authorsFinal.size(); ++i) {
			String t = authorsFinal.get(i);
			scanner = new Scanner(t);
			String author, a;
			scanner.next();
			author = scanner.next();
			while (true) {
				a = scanner.next();
				if (a.contains("<")) {
					break;
				}
				else {
					author = author + " " + a;
				}
			}
			authorsFinal.set(i, author);
		}

		Double changes[][] = new Double[numOfCommitters][2];
		for (i = 0; i < numOfCommitters; ++i) {
			for (j = 0; j < 2; ++j) {
				changes[i][j] = 0.0;
			}
		}

		String firstCommit;
		for (i = 0; i < numOfCommitters; ++i) {
			String myName = committersNames[i];
			List<String> myCommits = new ArrayList<String>();
			int val = authorsFinal.size() - 1;
			for (j = 0; j < val; ++j) {
				if ((authorsFinal.get(j)).equals(myName)) {
					//System.out.println(commitsFinal.get(j));
					String commitName = commitsFinal.get(j);
					scanner = new Scanner(commitName);
					scanner.next();
					String cn = scanner.next();
					myCommits.add(cn);
				}
			}
			Double inserted = 0.0, deleted = 0.0;
            if (myCommits.size() == 1) {
                command = "git log --stat " + myCommits.get(0);
                commandResults = execute(command, filePath, null);
				String res[] = commandResults.split("\\r?\\n");
				String interested = res[res.length - 1];
				if ((interested.contains("insertions") || interested.contains("insertion")) && (interested.contains("deletions") || interested.contains("deletion"))) {
					scanner = new Scanner(interested);
					scanner.nextInt();scanner.next();scanner.next();
					inserted += scanner.nextDouble();
					scanner.next();
					deleted += scanner.nextDouble();
				}
				else if (interested.contains("insertions") || interested.contains("insertion")) {
					scanner = new Scanner(interested);
					scanner.nextInt();scanner.next();scanner.next();
					inserted += scanner.nextDouble();
				}
				else if (interested.contains("deletions") || interested.contains("deletion")) {
					scanner = new Scanner(interested);
					scanner.nextInt();scanner.next();scanner.next();
					deleted += scanner.nextDouble();
				}
            }
			for (k = 0; k < (myCommits.size() - 1); ++k) {
				String c1 = myCommits.get(k + 1);
				String c2 = myCommits.get(k);
				command = "git diff --stat " + c1 + " " + c2;
				commandResults = execute(command, filePath, null);
				String res[] = commandResults.split("\\r?\\n");
				String interested = res[res.length - 1];
				if ((interested.contains("insertions") || interested.contains("insertion")) && (interested.contains("deletions") || interested.contains("deletion"))) {
					scanner = new Scanner(interested);
					scanner.nextInt();scanner.next();scanner.next();
					inserted += scanner.nextDouble();
					scanner.next();
					deleted += scanner.nextDouble();
				}
				else if (interested.contains("insertions") || interested.contains("insertion")) {
					scanner = new Scanner(interested);
					scanner.nextInt();scanner.next();scanner.next();
					inserted += scanner.nextDouble();
				}
				else if (interested.contains("deletions") || interested.contains("deletion")) {
					scanner = new Scanner(interested);
					scanner.nextInt();scanner.next();scanner.next();
					deleted += scanner.nextDouble();
				}
			}
			if (commitsArray[i] > 0) {
				changes[i][0] = inserted/commitsArray[i];
				changes[i][1] = deleted/commitsArray[i];
			}
            String perc1 = String.format("%.2f", changes[i][0]);
            String perc2 = String.format("%.2f", changes[i][1]);
            String perc3 = String.format("%.2f", (changes[i][0] + changes[i][1])/2);
            HTMLFile += "<tr><td>" + committersNames[i] + "</td><td>" + perc1 + "</td><td>" +perc2 + "</td><td>" + perc3 + "</td></tr>";
		}
        HTMLFile += "</tbody></table><p/>    </form></body></html>";

        /*----------------------------END OF 7--------------------------------*/
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(results));
            writer.write(HTMLFile);
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
    }
}
