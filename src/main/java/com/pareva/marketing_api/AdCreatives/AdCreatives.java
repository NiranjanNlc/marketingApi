package com.pareva.marketing_api.AdCreatives;

import com.facebook.ads.sdk.*;
import com.pareva.marketing_api.CustomResponse.CustomResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.io.File;

import static com.pareva.marketing_api.AppProperty.Values.*;

@RestController
@RequestMapping("/adcreatives")
public class AdCreatives {

    @RequestMapping("/create")
    public CustomResponse reteriveAdsets(@RequestParam(value= "name" ,defaultValue="myadset",required = true) String name ,
                                         @RequestParam (value= "pageID",required = true ) String pageID,
                                         @RequestParam  (value= "imagehash" ,required=false ) String imagehash) {
        CustomResponse customResponse = new CustomResponse();

        try {
            AdCreative adcerative = new AdAccount(ACCOUNT_ID, context).createAdCreative()
                    .setName(name)
                    .setObjectStorySpec(
                            new AdCreativeObjectStorySpec()
                                    .setFieldLinkData(
                                            new AdCreativeLinkData()
                                                    .setFieldImageHash(imagehash)
                                                    .setFieldLink("https://facebook.com/" + pageID)
                                                    .setFieldMessage("try it out")
                                    )
                                    .setFieldPageId(pageID)
                    )
                    .execute();
            customResponse.setStatus(200);
            customResponse.setBody("suceedd");
            return customResponse;
        } catch (Exception e) {
            customResponse.setStatus(200);
            customResponse.setBody("error encountered ");
            customResponse.setError(e.toString());
            return customResponse;

        }
    }
        @RequestMapping("/addimage")
        public CustomResponse addImageForCreatives(@RequestParam(value= "name" ,required = true) String name ,
                                                   @RequestParam (value= "image",required = true ) String imagePath )
        {
            CustomResponse customResponse=new CustomResponse();

            try {
                AdImage adImage = new AdAccount(ACCOUNT_ID, context).createAdImage()
                        .addUploadFile(name, new File(imagePath))
                        .execute();
                customResponse.setStatus(200);
                customResponse.setBody("suceedd");
                return customResponse;

            } catch (Exception e) {
                customResponse.setStatus(200);
                customResponse.setBody("error encountered ");
                customResponse.setError(e.toString());
                return customResponse;

            }
            }

}
