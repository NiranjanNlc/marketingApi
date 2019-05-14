package com.pareva.marketing_api.AdCreatives;

import com.facebook.ads.sdk.APIException;

public interface AdcreativeInterface   {

    public void getAdCreatives() throws APIException;
    public void create() throws APIException;
    public void createCanvas()throws APIException;
    public void createLinkedAd()throws APIException;
    public void createPageLike()throws APIException;
    public void createAssetsFeedspec()throws APIException;
    public void createCAllToAppInstall()throws APIException;
    public void createDynamicAd()throws APIException;
    public void createLinkedAppToInstall()throws APIException;
    public void createVideoLead()throws APIException;
    public void createVideoPageLike()throws APIException;
    public void createAdNotToPage()throws APIException;
    public void createMAIDPA() throws APIException;
}
