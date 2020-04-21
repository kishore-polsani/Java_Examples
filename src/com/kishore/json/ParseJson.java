package com.kishore.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseJson {

    public static void main(String[] args) {
        String loginJson = "{\n    \"loginAccounts\": [\n        {\n            \"name\": \"ThomsonReuters GLI � MajQA\",\n            \"accountId\": \"1970775\",\n            \"baseUrl\": \"https://demo.docusign.net/restapi/v2/accounts/1970775\",\n            \"isDefault\": \"true\",\n            \"userName\": \"App-SFDC-Deploy\",\n            \"userId\": \"fe436172-e14d-4ae7-9aae-0cb4853b6637\",\n            \"email\": \"app-sfdc-deploy@thomsonreuters.com\",\n            \"siteDescription\": \"\"\n        },\n        {\n            \"name\": \"ThomsonReuters GLI � PPE\",\n            \"accountId\": \"2934209\",\n            \"baseUrl\": \"https://demo.docusign.net/restapi/v2/accounts/2934209\",\n            \"isDefault\": \"false\",\n            \"userName\": \"App-SFDC-Deploy\",\n            \"userId\": \"fe436172-e14d-4ae7-9aae-0cb4853b6637\",\n            \"email\": \"app-sfdc-deploy@thomsonreuters.com\",\n            \"siteDescription\": \"\"\n        },\n        {\n            \"name\": \"GTAX-Test\",\n            \"accountId\": \"3171422\",\n            \"baseUrl\": \"https://demo.docusign.net/restapi/v2/accounts/3171422\",\n            \"isDefault\": \"false\",\n            \"userName\": \"App-SFDC-Deploy\",\n            \"userId\": \"fe436172-e14d-4ae7-9aae-0cb4853b6637\",\n            \"email\": \"app-sfdc-deploy@thomsonreuters.com\",\n            \"siteDescription\": \"\"\n        },\n        {\n            \"name\": \"ThomsonReuters GLI � MinQA\",\n            \"accountId\": \"2957008\",\n            \"baseUrl\": \"https://demo.docusign.net/restapi/v2/accounts/2957008\",\n            \"isDefault\": \"false\",\n            \"userName\": \"App-SFDC-Deploy\",\n            \"userId\": \"fe436172-e14d-4ae7-9aae-0cb4853b6637\",\n            \"email\": \"app-sfdc-deploy@thomsonreuters.com\",\n            \"siteDescription\": \"\"\n        },\n        {\n            \"name\": \"ThomsonReuters GLI � UAT\",\n            \"accountId\": \"2944528\",\n            \"baseUrl\": \"https://demo.docusign.net/restapi/v2/accounts/2944528\",\n            \"isDefault\": \"false\",\n            \"userName\": \"App-SFDC-Deploy\",\n            \"userId\": \"fe436172-e14d-4ae7-9aae-0cb4853b6637\",\n            \"email\": \"app-sfdc-deploy@thomsonreuters.com\",\n            \"siteDescription\": \"\"\n        },\n        {\n            \"name\": \"ThomsonReuters GLI � QA\",\n            \"accountId\": \"2949126\",\n            \"baseUrl\": \"https://demo.docusign.net/restapi/v2/accounts/2949126\",\n            \"isDefault\": \"false\",\n            \"userName\": \"App-SFDC-Deploy\",\n            \"userId\": \"fe436172-e14d-4ae7-9aae-0cb4853b6637\",\n            \"email\": \"app-sfdc-deploy@thomsonreuters.com\",\n            \"siteDescription\": \"\"\n        }\n    ]\n}";
        String accountId = "2949126";
        try {
            final JSONObject obj = new JSONObject(loginJson);
            final JSONArray docuAccountArray = obj.getJSONArray("loginAccounts");
            final int n = docuAccountArray.length();
            for (int i = 0; i < n; ++i) {
                final JSONObject docuAccountInfo = docuAccountArray.getJSONObject(i);
                String docuAccountId = docuAccountInfo.getString("accountId");
                if (docuAccountId.equals(accountId)) {
                    System.out.println(docuAccountInfo.getString("userName"));
                    System.out.println(docuAccountInfo.getString("email"));
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
