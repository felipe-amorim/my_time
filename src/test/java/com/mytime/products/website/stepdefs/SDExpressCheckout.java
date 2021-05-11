package com.mytime.products.website.stepdefs;

import com.mytime.products.website.objects.ExpressCheckout;
import com.mytime.support.CoreWeb;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class SDExpressCheckout extends CoreWeb {
    @And("On the results screen - Select All services in the services filter from the left panel")
    public void onTheResultsScreenSelectServiceFilterInTheServicesFilterFromTheLeftPanel() {
        log().setLocator(ExpressCheckout.EXPRESS_CHECKOUT_MAP);
        find(ExpressCheckout.leftMenu.buttons.LEFT_MENU_ALL_SERVICES).click();
    }

    @And("On the results screen - Select second staff from the staff filter in the left side panel")
    public void onTheResultsScreenSelectSecondStaffFromTheStaffFilterInTheLeftSidePanel() {
        log().setLocator(ExpressCheckout.EXPRESS_CHECKOUT_MAP);
        ExpressCheckout.variables.LEFT_MENU_SECOND_STAFF_NAME = find(ExpressCheckout.leftMenu.buttons.LEFT_MENU_SECOND_STAFF).get().text();
        find(ExpressCheckout.leftMenu.buttons.LEFT_MENU_SECOND_STAFF).click();
    }

    @And("On the results screen - Click the Book button for the Mens Haircut service")
    public void onTheResultsScreenClickTheBookButtonForTheMensHaircutService() {
        log().setLocator(ExpressCheckout.EXPRESS_CHECKOUT_MAP);
        ExpressCheckout.variables.APPOINTMENT_PRICE = find(ExpressCheckout.buttons.MENS_HAIRCUT_PRICE).get().text();
        ExpressCheckout.variables.APPOINTMENT_NAME = find(ExpressCheckout.buttons.MENS_HAIRCUT_TITLE).get().text();
        find(ExpressCheckout.buttons.MENS_HAIRCUT_BUTTON).click();
    }

    @And("On the results screen - Press Select Time in the add-on modal opened")
    public void onTheResultsScreenPressSelectTimeInTheAddOnModalOpened() {
        log().setLocator(ExpressCheckout.EXPRESS_CHECKOUT_MAP);
        find(ExpressCheckout.buttons.SELECT_TIME).click();
    }

    @Then("Verify that the user is presented with a list of available time slots with at least {int} entries")
    public void verifyThatTheUserIsPresentedWithAListOfAvailableTimeSlotsWithAtLeastEntriesAmountEntries(int entriesAmount) {
        log().setLocator(ExpressCheckout.EXPRESS_CHECKOUT_MAP);
        int amountOfAvailableDays = find(ExpressCheckout.buttons.AVAILABLE_DAYS).count();
        for (int i = 1; i <= amountOfAvailableDays; i++){
            String nextAvailableDayXpath = ExpressCheckout.buttons.AVAILABLE_DAY.replace("arg0", String.valueOf(i));
            log().updateLocator(ExpressCheckout.EXPRESS_CHECKOUT_MAP, ExpressCheckout.buttons.AVAILABLE_DAY, nextAvailableDayXpath);
            find(nextAvailableDayXpath).click();
            int amountOfEntries = find(ExpressCheckout.buttons.AVAILABLE_ENTRY).count();
            if(assertThat(String.valueOf(amountOfEntries)).isHigherThan(entriesAmount)){
                break;
            }
        }
        evidence("Entries displayed");
    }

    @And("Verify in the right side panel - Service displayed is the one selected in the step before")
    public void verifyInTheRightSidePanelServiceDisplayedIsTheOneSelectedInTheStepBefore() {
        log().setLocator(ExpressCheckout.EXPRESS_CHECKOUT_MAP);
        String serviceName = find(ExpressCheckout.rightSidePanel.texts.APPOINTMENT_NAME).get().text();
        assertThat(serviceName).isEqualTo(ExpressCheckout.variables.APPOINTMENT_NAME);
        evidence("Appointment name");
    }

    @And("Verify in the right side panel - Service price is the same as the one displayed in the step before")
    public void verifyInTheRightSidePanelServicePriceIsTheSameAsTheOneDisplayedInTheStepBefore() {
        log().setLocator(ExpressCheckout.EXPRESS_CHECKOUT_MAP);
        String servicePrice = find(ExpressCheckout.rightSidePanel.texts.APPOINTMENT_PRICE).get().text();
        assertThat(servicePrice).isEqualTo(ExpressCheckout.variables.APPOINTMENT_PRICE);
        evidence("Appointment price");
    }

    @And("Verify in the right side panel - Staff selected is the staff chosen before")
    public void verifyInTheRightSidePanelStaffSelectedIsTheStaffChosenBefore() {
        log().setLocator(ExpressCheckout.EXPRESS_CHECKOUT_MAP);
        String staffName = find(ExpressCheckout.rightSidePanel.texts.STAFF_NAME).get().text();
        assertThat(staffName).isEqualTo(ExpressCheckout.variables.LEFT_MENU_SECOND_STAFF_NAME);
        evidence("Staff name");
    }
}
