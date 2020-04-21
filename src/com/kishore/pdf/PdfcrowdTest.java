package com.kishore.pdf;

import com.pdfcrowd.Client;
import com.pdfcrowd.PdfcrowdError;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

public class PdfcrowdTest {

    public static void main(String[] args) {
        try {
            System.out.println("PdfcrowdTest");
            FileOutputStream fileStream;

            // create an API client instance
            Client client = new Client("username", "apikey");

            // convert a web page and save the PDF to a file
	            /*fileStream = new FileOutputStream("google_com.pdf");
	            client.convertURI("http://www.google.com/", fileStream);
	            fileStream.close();*/

            // convert an HTML string and store the PDF into a byte array
            ByteArrayOutputStream memStream = new ByteArrayOutputStream();
            String html = "<head></head><body>My HTML Layout</body>";
            client.convertHtml(html, memStream);

            // convert an HTML file
	            /*fileStream = new FileOutputStream("file.pdf");
	            client.convertFile("/path/to/local/file.html", fileStream);
	            fileStream.close();*/

            // retrieve the number of credits in your account
            Integer ncredits = client.numTokens();
        } catch (PdfcrowdError why) {
            System.err.println(why.getMessage());
        }
	        /*catch(IOException exc) {
	            // handle the exception
	        }*/
    }
}