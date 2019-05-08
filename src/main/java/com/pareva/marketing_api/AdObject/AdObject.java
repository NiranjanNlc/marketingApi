package com.pareva.marketing_api.AdObject;


import com.facebook.ads.sdk.*;
import com.pareva.marketing_api.CustomResponse.CustomResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.pareva.marketing_api.AppProperty.Values.*;


@RestController
@RequestMapping("adobject")

public class AdObject {

    @RequestMapping("/archieve/{adid}")
    public CustomResponse archive(@PathVariable String adId)
    {
        CustomResponse customResponse = new CustomResponse();
        try {
            new Ad(adId, context).update()
                    .setStatus(Ad.EnumStatus.VALUE_ARCHIVED)
                    .execute();
            customResponse.setStatus(200);
            customResponse.setBody("Archieved");
            return customResponse;
        } catch (APIException e) {
            e.printStackTrace();
            customResponse.setStatus(500);
            customResponse.setMessage(e.toString());
            return customResponse;
        }


    }
    @RequestMapping("/delete/{adid}")
    public CustomResponse  delete( @PathVariable String adId)
    {  CustomResponse customResponse = new CustomResponse();
        try {
            new Ad(adId, context).update()
                    .setStatus(Ad.EnumStatus.VALUE_DELETED)
                    .execute();
            customResponse.setStatus(200);
            customResponse.setBody("Deleted ");
            return customResponse;
        } catch (APIException e) {
            e.printStackTrace();
            customResponse.setStatus(500);
            customResponse.setMessage(e.toString());
            return customResponse;

        }
    }
    @RequestMapping("/reterive/{campagainId}")
    public CustomResponse  reterive( @PathVariable String cid)
    {
        CustomResponse customResponse = new CustomResponse();
        try {
            new Campaign(cid, context).getAds()
                    .requestNameField()
                    .execute();

            customResponse.setStatus(200);
            customResponse.setBody("reterived .." +
                    "show also the results ");

            return customResponse;
        } catch (APIException e) {
            e.printStackTrace();
            customResponse.setStatus(500);
            customResponse.setMessage(e.toString());
            return customResponse;

        }
    }
    @RequestMapping("/reterive/archived/{campagainId}")
    public CustomResponse createCampagain( @PathVariable String cid)
    {
        CustomResponse customResponse = new CustomResponse();

        try {
            new Campaign(cid, context).getAds()
                    .setEffectiveStatus(String.valueOf(Ad.EnumStatus.VALUE_ARCHIVED))
                            .requestNameField()
                            .execute();
            customResponse.setStatus(200);
            customResponse.setBody("Archieved");
            return customResponse;
        } catch (APIException e) {
            e.printStackTrace();
            customResponse.setStatus(500);
            customResponse.setMessage(e.toString());
            return customResponse;

        }
    }
}
