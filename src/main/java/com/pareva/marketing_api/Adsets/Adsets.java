package com.pareva.marketing_api.Adsets;

import com.facebook.ads.sdk.*;
import com.pareva.marketing_api.CustomResponse.CustomResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

import static com.pareva.marketing_api.AppProperty.Values.*;

@RestController
@RequestMapping("/adsets/")
public class Adsets {

                        @RequestMapping("/create/")
                        public CustomResponse createAdsets(@RequestParam (value= "name" ,defaultValue="myadset",required = true) String name ,
                                                             @RequestParam (value= "start_time" ) String start_time,
                                                             @RequestParam  (value= "end-time"  ) String end_time)
                        {
                            CustomResponse customResponse=new CustomResponse();
                            AdSet adSet = null;
                            try {
                                adSet = new AdAccount(ACCOUNT_ID, context).createAdSet()
                                        .setName(name)
                                        .setOptimizationGoal(AdSet.EnumOptimizationGoal.VALUE_REACH)
                                        .setBillingEvent(AdSet.EnumBillingEvent.VALUE_IMPRESSIONS)
                                        .setBidAmount(2L)
                                        .setDailyBudget(1000L)
                                        .setCampaignId(CAMPAIGN_ID)
                                    .setTargeting(
                                        new Targeting()
                                                .setFieldGeoLocations(
                                                        new TargetingGeoLocation()
                                                                .setFieldCountries(Arrays.asList("US"))
                                                )
                                )
                                        .setStartTime(start_time)
                                        .setEndTime(end_time)
                                        .setStatus(AdSet.EnumStatus.VALUE_PAUSED)
                                        .execute();
                                customResponse.setStatus(200);
                                customResponse.setBody(adSet.getId());
                                return customResponse;

                            } catch (APIException e) {
                                customResponse.setStatus(200);
                                customResponse.setBody("error encountered ");
                                return customResponse;

                            }


                        }
                            @RequestMapping("")
                                public CustomResponse reteriveAdsets(@PathVariable String id)
                                {
                                    CustomResponse customResponse=new CustomResponse();
                                    AdSet adSet = null;
                                    try {

                                        customResponse.setStatus(200);
                                        customResponse.setBody("suceedd");
                                        return customResponse;

                                    } catch (Exception e) {
                                        customResponse.setStatus(200);
                                        customResponse.setBody("error encountered ");
                                        return customResponse;

                                    }


                                }

}
