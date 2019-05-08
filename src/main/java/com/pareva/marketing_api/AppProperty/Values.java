package com.pareva.marketing_api.AppProperty;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.AdAccount;

public class Values {
    public static final String ACCESS_TOKEN = "EAAGbtsIL7M8BAOXwxZBIQdUpdHzyqlUAQqKDqNiz89ZBaHGKVMDIDvu7lLgnCMA7F8TZCDZCQdsVudmbIDbZAgtQ62IPFmgU9EtJzOQ3P4Knb5DwOzk042cT4GG0fKO1DY9DDUM6hLNcICOHQSlPqZB5RLIZAO3cIqGAyvjLPgyfeaZCeV6b1kQF";
    public static final String ACCOUNT_ID = "318153082200920" ;
    public static final String APP_SECRET ="277bb3ac914300a4c9c51e80b936475f" ;
    public static final String CAMPAIGN_ID = "23843629838130426";
    public static final APIContext context = new APIContext(ACCESS_TOKEN, APP_SECRET);
    public static  AdAccount account = new AdAccount(ACCOUNT_ID, context);

}
