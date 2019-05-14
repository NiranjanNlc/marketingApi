package com.pareva.marketing_api.AppProperty;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.AdAccount;

public class Values {
    public static final String ACCESS_TOKEN = "EAAlgDpmUhOYBAJMbMbDHYcNSQilBic1uY51QZCnDv6MpsizZCFGpcy8pQ57MdPmuCREHZAECT8M44sC1VQHSOoWWAz10YhAfT5i8cRZAMGECZBAzG6GgK4K7ANjw34GceZCRtuAbLZBWaCE4BXSVqCLgDoJxKkRMOHDZA3SQNIfOnQZDZD";
    public static final String ACCOUNT_ID = "318153082200920" ;
    public static final String APP_SECRET ="e8bde3bfc80d6c6064860032a61296f5" ;
    public static final String CAMPAIGN_ID = "23843629838130426";
    public static final APIContext context = new APIContext(ACCESS_TOKEN,APP_SECRET);
    public static  AdAccount account = new AdAccount(ACCOUNT_ID, context);
    public static final String id = "318153082200920" ;

}
