package com.pareva.marketing_api.AdCreatives;


import static com.pareva.marketing_api.AppProperty.Values.*;

import com.facebook.ads.sdk.*;

import java.util.Arrays;

public class AdCreativeImplementation implements AdcreativeInterface {
                        @Override
                        public void getAdCreatives() throws APIException {
                            new AdAccount(id, context).getAdCreatives()
                                    .requestNameField()
                                    .execute();

                        }

                        @Override
                        public void create() throws APIException {
                            new AdAccount(id, context).createAdCreative()
                                    .setName("Sample Promoted Post")
                                    .setObjectStoryId("<pageID>_<postID>")
                                    .execute();
                            new AdAccount(id, context).createAdCreative()
                                    .setObjectStoryId("<pageID>_<postID>")
                                    .execute();
                        }

                        @Override
                        public void createCanvas() throws APIException {
                            new AdAccount(id, context).createAdCreative()
                                    .setImageHash("<imageHash>")
                                    .setObjectStorySpec(
                                            new AdCreativeObjectStorySpec()
                                                    .setFieldLinkData(
                                                            new AdCreativeLinkData()
                                                                    .setFieldCallToAction(
                                                                            new AdCreativeLinkDataCallToAction()
                                                                                    .setFieldType(AdCreativeLinkDataCallToAction.EnumType.VALUE_LEARN_MORE)
                                                                    )
                                                                    .setFieldImageHash("<imageHash>")
                                                                    .setFieldLink("<canvasURI>")
                                                                    .setFieldName("Creative message")
                                                    )
                                                    .setFieldPageId("<pageID>")
                                    )
                                    .execute();
                        }

                        @Override
                        public void createLinkedAd() throws APIException{
                            new AdAccount(id, context).createAdCreative()
                                    .setName("Sample Creative")
                                    .setObjectStorySpec(
                                            new AdCreativeObjectStorySpec()
                                                    .setFieldLinkData(
                                                            new AdCreativeLinkData()
                                                                    .setFieldImageHash("<imageHash>")
                                                                    .setFieldLink("https://facebook.com/<pageID>")
                                                                    .setFieldMessage("try it out")
                                                    )
                                                    .setFieldPageId("<pageID>")
                                    )
                                    .execute();

                        }

                        @Override
                        public void createPageLike() throws APIException{
                            new AdAccount(id, context).createAdCreative()
                                    .setName("Creative")
                                    .setObjectStorySpec(
                                            new AdCreativeObjectStorySpec()
                                                    .setFieldLinkData(
                                                            new AdCreativeLinkData()
                                                                    .setFieldCallToAction(
                                                                            new AdCreativeLinkDataCallToAction()
                                                                                    .setFieldType(AdCreativeLinkDataCallToAction.EnumType.VALUE_LIKE_PAGE)
                                                                                    .setFieldValue(
                                                                                            new AdCreativeLinkDataCallToActionValue()
                                                                                                    .setFieldPage("<pageID>")
                                                                                    )
                                                                    )
                                                                    .setFieldImageHash("<imageHash>")
                                                                    .setFieldLink("https://facebook.com/<pageID>")
                                                                    .setFieldMessage("Creative message")
                                                    )
                                                    .setFieldPageId("<pageID>")
                                    )
                                    .execute();
                        }

                        @Override
                        public void createAssetsFeedspec() throws APIException{
                            new AdAccount(id, context).createAdCreative()
                                    .setName("Dynamic Ad Creative with Asset Feed Spec Sample")
                                    .setObjectStorySpec(
                                            new AdCreativeObjectStorySpec()
                                                    .setFieldPageId("<pageID>")
                                    )
                                    .setAssetFeedSpec("{\"images\":[{\"hash\":\"<imageHash>\"}],\"bodies\":[{\"text\":\"Begin Your Adventure\"},{\"text\":\"Once a Trainer, always a Trainer.\"}],\"titles\":[{\"text\":\"Level Up\"},{\"text\":\"Swipe to evolve\"}],\"descriptions\":[{\"text\":\"First Dynamic Ad Creative Sample\"}],\"ad_formats\":[\"SINGLE_IMAGE\"],\"call_to_action_types\":[\"SHOP_NOW\"],\"link_urls\":[{\"website_url\":\"https://www.example.com/\"}],\"videos\":[]}")
                                    .execute();
                        }

                        @Override
                        public void createCAllToAppInstall() throws APIException{
                            new AdAccount(id, context).createAdCreative()
                                    .setName("Carousel app ad")
                                    .setObjectStorySpec(
                                            new AdCreativeObjectStorySpec()
                                                    .setFieldLinkData(
                                                            new AdCreativeLinkData()
                                                                    .setFieldCaption("WWW.ITUNES.COM")
                                                                    .setFieldChildAttachments(Arrays.asList(
                                                                            new AdCreativeLinkDataChildAttachment()
                                                                                    .setFieldCallToAction(
                                                                                            new AdCreativeLinkDataCallToAction()
                                                                                                    .setFieldType(AdCreativeLinkDataCallToAction.EnumType.VALUE_USE_MOBILE_APP)
                                                                                                    .setFieldValue(
                                                                                                            new AdCreativeLinkDataCallToActionValue()
                                                                                                                    .setFieldAppLink("<deepLink>")
                                                                                                    )
                                                                                    )
                                                                                    .setFieldImageHash("<imageHash>")
                                                                                    .setFieldLink("http://www.example.com/appstoreurl")
                                                                            ,
                                                                            new AdCreativeLinkDataChildAttachment()
                                                                                    .setFieldCallToAction(
                                                                                            new AdCreativeLinkDataCallToAction()
                                                                                                    .setFieldType(AdCreativeLinkDataCallToAction.EnumType.VALUE_USE_MOBILE_APP)
                                                                                                    .setFieldValue(
                                                                                                            new AdCreativeLinkDataCallToActionValue()
                                                                                                                    .setFieldAppLink("<deepLink>")
                                                                                                    )
                                                                                    )
                                                                                    .setFieldImageHash("<imageHash>")
                                                                                    .setFieldLink("http://www.example.com/appstoreurl")
                                                                            ,
                                                                            new AdCreativeLinkDataChildAttachment()
                                                                                    .setFieldCallToAction(
                                                                                            new AdCreativeLinkDataCallToAction()
                                                                                                    .setFieldType(AdCreativeLinkDataCallToAction.EnumType.VALUE_USE_MOBILE_APP)
                                                                                                    .setFieldValue(
                                                                                                            new AdCreativeLinkDataCallToActionValue()
                                                                                                                    .setFieldAppLink("<deepLink>")
                                                                                                    )
                                                                                    )
                                                                                    .setFieldImageHash("<imageHash>")
                                                                                    .setFieldLink("http://www.example.com/appstoreurl")
                                                                            ,
                                                                            new AdCreativeLinkDataChildAttachment()
                                                                                    .setFieldCallToAction(
                                                                                            new AdCreativeLinkDataCallToAction()
                                                                                                    .setFieldType(AdCreativeLinkDataCallToAction.EnumType.VALUE_USE_MOBILE_APP)
                                                                                                    .setFieldValue(
                                                                                                            new AdCreativeLinkDataCallToActionValue()
                                                                                                                    .setFieldAppLink("<deepLink>")
                                                                                                    )
                                                                                    )
                                                                                    .setFieldImageHash("<imageHash>")
                                                                                    .setFieldLink("http://www.example.com/appstoreurl")
                                                                    ))
                                                                    .setFieldDescription("The link description")
                                                                    .setFieldLink("http://www.example.com/appstoreurl")
                                                                    .setFieldMessage("My message")
                                                                    .setFieldMultiShareOptimized(true)
                                                                    .setFieldName("The link name")
                                                    )
                                                    .setFieldPageId("<pageID>")
                                    )
                                    .execute();
                        }

                        @Override
                        public void createDynamicAd() throws APIException {
                            new AdAccount(id, context).createAdCreative()
                                    .setName("Dynamic Ad Template Creative Sample")
                                    .setObjectStorySpec(
                                            new AdCreativeObjectStorySpec()
                                                    .setFieldPageId("<pageID>")
                                                    .setFieldTemplateData(
                                                            new AdCreativeLinkData()
                                                                    .setFieldCustomizationRulesSpec(Arrays.asList(
                                                                            new AdCustomizationRuleSpec()
                                                                                    .setFieldCustomizationSpec("{\"language\":\"en_XX\"}")
                                                                            ,
                                                                            new AdCustomizationRuleSpec()
                                                                                    .setFieldCustomizationSpec("{\"language\":\"fr_XX\"}")
                                                                                    .setFieldDescription("French Description {{product.description}}")
                                                                                    .setFieldLink("http://www.example.com/frenchurl")
                                                                                    .setFieldMessage("French Test {{product.name | titleize}}")
                                                                                    .setFieldName("French Headline {{product.price}}")
                                                                                    .setFieldTemplateUrlSpec(
                                                                                            new AdCreativeTemplateURLSpec()
                                                                                                    .setFieldWeb("{\"url\":\"http://www.example.com/frenchdeeplink\"}")
                                                                                    )
                                                                    ))
                                                                    .setFieldDescription("English Description {{product.description}}")
                                                                    .setFieldLink("http://www.example.com/englishurl")
                                                                    .setFieldMessage("English Test {{product.name | titleize}}")
                                                                    .setFieldName("English Headline {{product.price}}")
                                                    )
                                    )
                                    .setProductSetId("<productSetID>")
                                    .setTemplateUrlSpec("{\"web\":{\"url\":\"http://www.example.com/englishdeeplink\"}}")
                                    .execute();

                        }

                        @Override
                        public void createLinkedAppToInstall() throws APIException{
                            new AdAccount(id, context).createAdCreative()
                                    .setName("Sample Creative")
                                    .setObjectStorySpec(
                                            new AdCreativeObjectStorySpec()
                                                    .setFieldLinkData(
                                                            new AdCreativeLinkData()
                                                                    .setFieldCallToAction(
                                                                            new AdCreativeLinkDataCallToAction()
                                                                                    .setFieldType(AdCreativeLinkDataCallToAction.EnumType.VALUE_INSTALL_MOBILE_APP)
                                                                                    .setFieldValue(
                                                                                            new AdCreativeLinkDataCallToActionValue()
                                                                                                    .setFieldLink("<appLink>")
                                                                                    )
                                                                    )
                                                                    .setFieldImageHash("<imageHash>")
                                                                    .setFieldLink("<appLink>")
                                                                    .setFieldMessage("Try it out")
                                                    )
                                                    .setFieldPageId("<pageID>")
                                    )
                                    .execute();

                        }

                        @Override
                        public void createVideoLead() throws APIException{
                            new AdAccount(id, context).createAdCreative()
                                    .setObjectStorySpec(
                                            new AdCreativeObjectStorySpec()
                                                    .setFieldPageId("<pageID>")
                                                    .setFieldVideoData(
                                                            new AdCreativeVideoData()
                                                                    .setFieldCallToAction(
                                                                            new AdCreativeLinkDataCallToAction()
                                                                                    .setFieldType(AdCreativeLinkDataCallToAction.EnumType.VALUE_SIGN_UP)
                                                                                    .setFieldValue(
                                                                                            new AdCreativeLinkDataCallToActionValue()
                                                                                                    .setFieldLeadGenFormId("<formID>")
                                                                                                    .setFieldLink("http://fb.me/")
                                                                                    )
                                                                    )
                                                                    .setFieldImageUrl("<imageURL>")
                                                                    .setFieldLinkDescription("try it out")
                                                                    .setFieldVideoId("<videoID>")
                                                    )
                                    )
                                    .execute();

                        }

                        @Override
                        public void createVideoPageLike() throws APIException {
                            new AdAccount(id, context).createAdCreative()
                                    .setName("Sample Creative")
                                    .setObjectStorySpec(
                                            new AdCreativeObjectStorySpec()
                                                    .setFieldPageId("<pageID>")
                                                    .setFieldVideoData(
                                                            new AdCreativeVideoData()
                                                                    .setFieldCallToAction(
                                                                            new AdCreativeLinkDataCallToAction()
                                                                                    .setFieldType(AdCreativeLinkDataCallToAction.EnumType.VALUE_LIKE_PAGE)
                                                                                    .setFieldValue(
                                                                                            new AdCreativeLinkDataCallToActionValue()
                                                                                                    .setFieldPage("<pageID>")
                                                                                    )
                                                                    )
                                                                    .setFieldImageUrl("<imageURL>")
                                                                    .setFieldVideoId("<videoID>")
                                                    )
                                    )
                                    .execute();

                        }

                        @Override
                        public void createAdNotToPage()throws APIException {
                            new AdAccount(id, context).createAdCreative()
                                    .setName("Sample Creative")
                                    .setTitle("My title")
                                    .setBody("My body")
                                    .setObjectUrl("<url>")
                                    .setLinkUrl("<url>")
                                    .setImageHash("<imageHash>")
                                    .execute();

                        }

                        @Override
                        public void createMAIDPA() throws APIException {
                            new AdAccount(id, context).createAdCreative()
                                    .setName("Dynamic Ad Template Creative Sample")
                                    .setObjectStorySpec(
                                            new AdCreativeObjectStorySpec()
                                                    .setFieldPageId("<pageID>")
                                                    .setFieldTemplateData(
                                                            new AdCreativeLinkData()
                                                                    .setFieldCallToAction(
                                                                            new AdCreativeLinkDataCallToAction()
                                                                                    .setFieldType(AdCreativeLinkDataCallToAction.EnumType.VALUE_INSTALL_MOBILE_APP)
                                                                                    .setFieldValue(
                                                                                            new AdCreativeLinkDataCallToActionValue()
                                                                                                    .setFieldLink("http://www.example.com/appstoreurl")
                                                                                    )
                                                                    )
                                                                    .setFieldDescription("Description {{product.description}}")
                                                                    .setFieldLink("http://www.example.com/appstoreurl")
                                                                    .setFieldMessage("Test {{product.name | titleize}}")
                                                                    .setFieldName("Headline {{product.price}}")
                                                    )
                                    )
                                    .setProductSetId("<productSetID>")
                                    .execute();

                        }
}
