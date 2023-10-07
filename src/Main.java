import java.io.*;
import java.net.*;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        String url, emailId, name = null;
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader webReader;

        // Get input and construct the url
        System.out.print("Input Email ID: ");
        emailId = inputReader.readLine();
        System.out.println();
        url = "https://www.southampton.ac.uk/people/" + emailId;

        // Read the webpage and find the name
        URL webpage = new URL(url);
        URLConnection conn = webpage.openConnection();
        webReader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
        String line = "";
        int index;

        while (true){

            line = webReader.readLine();
            // If it is end of the html break out the loop
            if (line == null) {break;}
            index = line.indexOf("meta property=\"og:title\"");
            // If not found go to next line
            if (index == -1) {continue;}

            // Found the line which contains the name
            name = line.substring(35, line.indexOf('>')-3);
        }

        if (name != null){
            System.out.println(name);
        } else{
            System.out.println("Didn't found the name!");
        }

    }

}
