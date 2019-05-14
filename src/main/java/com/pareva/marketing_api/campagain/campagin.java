package com.pareva.marketing_api.campagain;

import com.pareva.marketing_api.CustomResponse.CustomResponse;
import org.springframework.web.bind.annotation.*;
import com.facebook.ads.sdk.*;
import static com.pareva.marketing_api.AppProperty.Values.*;


@RestController
@RequestMapping("/campagin/")
public class campagin {


    @GetMapping
    public CustomResponse test(){
        CustomResponse customResponse = new CustomResponse();
        AdAccount account = new AdAccount(ACCOUNT_ID, context);
        APINodeList<Campaign> campaigns = null;
        try {
            campaigns = account.getCampaigns().requestAllFields().execute();
        } catch (APIException e) {
            e.printStackTrace();
        }
        for(Campaign campaign : campaigns) {
            System.out.println(campaign.getFieldId());
            delete(campaign.getFieldId());
            customResponse.setStatus(200);
            customResponse.setBody("All deleted ");

        }
        return customResponse;
    }


    @RequestMapping("/create/{name}")
    public CustomResponse createCampagain( @PathVariable String name)
    {   CustomResponse customResponse=new CustomResponse();
        try {

            System.out.println(context.toString());
            Campaign campaign = account.createCampaign()
                    .setName(name)
                    .setObjective(Campaign.EnumObjective.VALUE_LINK_CLICKS)
                    .setSpendCap(10000L)
                    .setStatus(Campaign.EnumStatus.VALUE_PAUSED)
                    .execute();
            System.out.println(campaign.fetch());

            customResponse.setStatus(200);
            customResponse.setBody("Created");
            customResponse.setMessage("Field id="+campaign.getFieldId());
            return customResponse;

        } catch (APIException e) {

            customResponse.setStatus(500);
            customResponse.setMessage(e.toString());
            return customResponse;

        }
    }
    @RequestMapping("/read/{cid}")
    public CustomResponse getCampagainObject(@PathVariable String cid )
    {   CustomResponse customResponse=new CustomResponse();
        try {
            Campaign campaign = Campaign.fetchById(cid, context);
            String id = campaign.getFieldId();
            String name = campaign.getFieldName();
            System.out.println("Campagain id \n"+id+"name "+name);
            System.out.println(campaign.fetch());

            customResponse.setStatus(200);
            customResponse.setBody(campaign.fetch().toString());
            return customResponse;
        } catch (APIException e) {

            customResponse.setStatus(500);
            customResponse.setBody(e.toString());
            customResponse.setMessage(e.toString());

            return customResponse;

        }
    }
    @RequestMapping("/update")
    public CustomResponse update(@RequestParam(name="id") String id,@RequestParam(name="name") String name)   {
        Campaign campaign = null;
        CustomResponse customResponse=new CustomResponse();
        try {
            campaign = Campaign.fetchById(id, context);
            campaign.update()
                    .setName(name) // set parameter for the API call
                    .execute();
            System.out.println(campaign.fetch());

            customResponse.setStatus(200);
            customResponse.setBody("Updated to "+name);
            return customResponse;
        } catch (APIException e) {

            customResponse.setStatus(500);
            customResponse.setMessage(e.getMessage());
            e.printStackTrace();
        }

        return customResponse;
    }
    @RequestMapping("/delete/{id}")
    public CustomResponse delete (@PathVariable String id)
    {
        CustomResponse customResponse=new CustomResponse();
        Campaign campaign = null;
        try {
            campaign = Campaign.fetchById(id, context);
            campaign.delete().execute();
            System.out.println(campaign.fetch());

            customResponse.setStatus(200);
            customResponse.setBody("Deleted");
            return customResponse;
        } catch (APIException e) {

            customResponse.setStatus(500);
            customResponse.setMessage(e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

}
