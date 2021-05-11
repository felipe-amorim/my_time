package com.mytime.products.website.stepdefs;

import com.mytime.products.website.objects.Results;
import com.mytime.support.CoreWeb;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SDResults extends CoreWeb {
    @Then("Assert that at least {int} results are shown")
    public void assertThatAtLeastResultAmountResultsAreShown(int resultAmount) {
        log().setLocator(Results.RESULTS_MAP);
        sleep().untilAppear(Results.texts.BUSINESS_NAME);
        int amountOfBusiness = find(Results.texts.BUSINESS_NAME).count();
        assertThat(String.valueOf(amountOfBusiness)).isHigherThan(resultAmount);
        evidence("Results displayed");
    }

    @When("Open business name {string}")
    public void openBusinessNameBusinessName(String businessName) {
        log().setLocator(Results.RESULTS_MAP);
        String businessNameXpath = Results.buttons.BUSINESS_TITLE_HREF.replace("arg0", businessName);
        log().updateLocator(Results.RESULTS_MAP, Results.buttons.BUSINESS_TITLE_HREF, businessNameXpath);
        find(businessNameXpath).click();
    }
}
