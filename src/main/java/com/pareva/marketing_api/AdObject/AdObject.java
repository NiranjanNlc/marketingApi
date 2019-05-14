package com.pareva.marketing_api.AdObject;


import com.facebook.ads.sdk.*;
import com.pareva.marketing_api.CustomResponse.CustomResponse;
import org.springframework.web.bind.annotation.*;

import static com.pareva.marketing_api.AppProperty.Values.*;


@RestController
@RequestMapping("/adobject/")

public class AdObject {

    @RequestMapping("/archieve")
    public CustomResponse archive(@RequestParam(name="adid",defaultValue = "23843632368460426") String adId)
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
    @RequestMapping("/delete")
    public CustomResponse  delete(@RequestParam(name="adid",defaultValue = "23843632368460426") String adId)
    {  CustomResponse customResponse = new CustomResponse();
        try {
            new Ad(adId, context).update()
                    .setStatus(Ad.EnumStatus.VALUE_DELETED)
                    .execute();
            customResponse.setStatus(200);
            customResponse.setBody("Deleted ");
            return customResponse;
        } catch (APIException e) {
            customResponse.setStatus(500);
            customResponse.setMessage(e.toString());
            return customResponse;

        }
    }
    @RequestMapping("/reterive")
    public CustomResponse  reterive( @RequestParam(name="cid",defaultValue ="23843661855790426") String cid)
    {
        CustomResponse customResponse = new CustomResponse();
        try {
            new Campaign(cid, context).getAds()
                    .requestNameField()
                    .execute();

            customResponse.setStatus(200);
            customResponse.setBody("reterived .." +
                    "show also the results .." +
                    "sabbai ad aaunay garri loop chalau  ");

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
