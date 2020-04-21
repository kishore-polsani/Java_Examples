package com.kishore;

public class StringReplace {

    public static void main(String[] args) {
        String request = "{\"storeOrder\":{\"storeName\":\"\",\"customerDetails\":{\"firstName\":\"Kishore\",\"lastName\":\"Polsani\",\"organizationName\":\"TCS\",\"businessEmail\":\"kishore.polsani1@tr.com\",\"phoneNumber\":\"3036966478\",\"address\":{\"addressLine1\":\"610 Opperman Dr\",\"city\":\"Eagan\",\"state\":\"Minnesota\",\"zipCode\":\"55123\",\"country\":\"United States\"}},\"selectedProducts\":[{\"productId\":\"01t130000067SvyAAE\",\"quantity\":1,\"contractTerm\":\"3 Years\",\"assignedUsers\":null}]}}";
        request = request.replace("\"storeName\":\"\"", "\"storeName\":\"Small Law\"");
        System.out.println(request);
    }
}
