package com.pareva.marketing_api.Ads;

import com.facebook.ads.sdk.*;
import com.pareva.marketing_api.CustomResponse.CustomResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

import static com.pareva.marketing_api.AppProperty.Values.*;

@RestController
@RequestMapping("/ad/")
public class Ads {

                    @RequestMapping("/create/")
                    public CustomResponse createAdsets(@RequestParam (value= "name",required = true) String name,
                                                       @RequestParam (value= "adacount",required = true) String adAccount,
                                                       @RequestParam (value= "adset",required = true) String adcreative ,
                                                       @RequestParam (value= "adset",required = true) String adset

                                                       )
                    {
                        CustomResponse customResponse=new CustomResponse();

                        try {
                          Ad ads =  new AdAccount(adAccount, context).createAd()
                                    .setName(name)
                                            .setAdsetId(adset)
                                    .setCreative(
                                            new AdCreative()
                                                    .setFieldId(adcreative)
                                                    )
                                                    .setStatus(Ad.EnumStatus.VALUE_PAUSED)
                                                    .execute();
                            customResponse.setStatus(200);
                            customResponse.setBody("suceed");
                            return customResponse;

                        } catch (Exception e) {
                            customResponse.setStatus(200);
                            customResponse.setBody("error encountered ");
                            return customResponse;

                        }


                    }
                    @RequestMapping("/reterive/")
                    public CustomResponse reteriveAd(@RequestParam (value= "adsetid" ,required = true) String adset)
                    {
                        CustomResponse customResponse=new CustomResponse();
                       ;
                        try {
                            APINodeList<Ad> ads = new AdSet(adset, context).getAds()
                                    .setEffectiveStatus("[\"ACTIVE\",\"PAUSED\",\"PENDING_REVIEW\",\"PREAPPROVED\"]")
                                    .requestNameField()
                                    .requestConfiguredStatusField()
                                    .requestEffectiveStatusField()
                                    .requestCreativeField()
                                    .execute();
                            customResponse.setStatus(200);
                            customResponse.setBody("reterived");
                            return customResponse;

                        } catch (Exception e) {
                            customResponse.setStatus(500);
                            customResponse.setBody("error encountered ");
                            return customResponse;

                        }


    }




}

