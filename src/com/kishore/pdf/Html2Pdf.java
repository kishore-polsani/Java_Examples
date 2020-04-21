package com.kishore.pdf;

import io.woo.htmltopdf.HtmlToPdf;
import io.woo.htmltopdf.HtmlToPdfException;
import io.woo.htmltopdf.HtmlToPdfObject;

import java.io.*;

public class Html2Pdf {

    public static void main(String[] args) {
        OutputStream outputStream = null;
        HtmlToPdf htmlToPdf = HtmlToPdf.create()
            .object(HtmlToPdfObject.forUrl("https://opwebdev1.thomsonreuters.com/content/cxd/en/small-law-firm/sales.html"));

        try (InputStream in = htmlToPdf.convert()) {
            System.out.println(in);
            // write the inputStream to a FileOutputStream
            outputStream =
                new FileOutputStream(new File("fileIn.pdf"));

            int read = 0;
            byte[] bytes = new byte[10240];

            while ((read = in.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }

            System.out.println("Done!");
            // "in" has PDF bytes loaded
        } catch (HtmlToPdfException e) {
            System.err.println(e);
        } catch (IOException e1) {
            System.err.println(e1);
        }
			
			
		/*boolean successHtml = HtmlToPdf.create()
			    .object(HtmlToPdfObject.forHtml("<p><em>Apples</em>, not oranges</p>"))
			    .convert("/path/to/fileUrl.pdf");
		System.out.println(successHtml);
		
		boolean successUrl = HtmlToPdf.create()
			    .object(HtmlToPdfObject.forUrl("https://opwebdev1.thomsonreuters.com/content/cxd/en/small-law-firm/sales.html"))
			    .convert("/path/to/fileUrl.pdf");
		System.out.println(successUrl);*/
    }
}
