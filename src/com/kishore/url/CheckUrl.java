package com.kishore.url;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class CheckUrl {

    private static final String imageUrl = "https://products.thomsonreuters.ca/BookCovers/";
    private static String productId = "30836375";
    private static String extension = ".gif";

    public static void main(String[] args) {
        CheckUrl obj = new CheckUrl();
        System.out.println(obj.checkUrl(productId));
    }

    public Boolean checkUrl(String productId) {
        String url = imageUrl + productId + extension;
        System.out.println(url);
        try {
            BufferedImage image = ImageIO.read(new URL(url));
            return image != null;

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            System.err.println("URL error with image");
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            System.err.println("IO error with image");
            // TODO Auto-generated catch block
            // e.printStackTrace();
            return false;
        }

    }
}
