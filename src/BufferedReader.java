import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.net.*;

public class BufferedReader {

    private final String emailId;

    public BufferedReader(){

        Scanner myScanner = new Scanner(System.in);

        System.out.print("Enter Email ID: ");
        emailId = myScanner.nextLine();
        System.out.println();

    }

    public void readURL(String url) throws IOException {

        URL webpage = new URL(url);
        URLConnection conn = webpage.openConnection();
        InputStreamReader reader = new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8);


    }

    public String getEmailId(){
        return emailId;
    }

}
