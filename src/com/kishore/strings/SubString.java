package com.kishore.strings;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;

public class SubString {

    public static void main(String[] args) {
        @NonNull
        String path = "federal-grand-jury-a-guide-to-law-and-practice-2d-criminal-practice-series-11597043"; //11597043
        // String path = "federal-grand-jury-a-guide-to-law-and-practice-2d-criminal-practice-series-"; //ProductId is empty
        //String path = "federal/grand/jury/11597043"; //ProductId is empty
        //String path = ""; //ProductId is empty
        // String path =null; //ProductId is empty
        String productId = StringUtils.substringAfterLast(path, "-");
        if (StringUtils.isNotEmpty(productId)) {
            System.out.println(productId);
        } else {
            System.out.println("ProductId is empty");
        }
    }

}
