package com.mytime.products.website.stepdefs;

import com.mytime.products.website.objects.Commons;
import com.mytime.products.website.objects.Index;
import com.mytime.support.CoreWeb;
import cucumber.api.java.en.And;


public class SDIndex extends CoreWeb {
    @And("Access mytime consumers page")
    public void accessMytimeConsumersPage() {
        webDriver().set().browser().chrome()/*.headless()*/;
        webDriver().set().options().maximized();
        webDriver().navigate(Commons.WEB_SITE_CONSUMERS_URL);
    }

    @And("Search for {string} in {string}")
    public void searchForServiceInLocation(String service, String location) {
        log().setLocator(Index.INDEX_MAP);
        find(Index.inputs.SERVICE_INPUT).send().text(service);
        String inputOption = Index.inputs.INPUT_OPTION.replace("arg0", service);
        log().updateLocator(Index.INDEX_MAP, Index.inputs.INPUT_OPTION, inputOption);
        find(inputOption).click();
        find(Index.inputs.LOCATION_INPUT).clear();
        find(Index.inputs.LOCATION_INPUT).send().text(location);
        sleep().until(300);
        inputOption = Index.inputs.INPUT_OPTION.replace("arg0", location);
        log().updateLocator(Index.INDEX_MAP, Index.inputs.INPUT_OPTION, inputOption);
        find(inputOption).click();
        evidence("Search criteria");
        find(Index.buttons.SEARCH_BUTTON).click();
    }

}
