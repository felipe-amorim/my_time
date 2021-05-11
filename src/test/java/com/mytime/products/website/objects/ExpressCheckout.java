package com.mytime.products.website.objects;

import java.util.LinkedHashMap;

public class ExpressCheckout {
    public static class variables{
        public static String APPOINTMENT_PRICE = "";
        public static String APPOINTMENT_NAME = "";
        public static String LEFT_MENU_SECOND_STAFF_NAME = "";
    }

    public static class buttons{
        public static final String MENS_HAIRCUT_BUTTON = "//button[@aria-label=\"Book Service Men's Haircut\"]";
        public static final String MENS_HAIRCUT_PRICE = MENS_HAIRCUT_BUTTON+"//ancestor::div[2]//span[contains(@class, \"variation-price\")]//span";
        public static final String MENS_HAIRCUT_TITLE = MENS_HAIRCUT_BUTTON+"//ancestor::div[2]//h5[@class=\"variation-title\"]//span";
        public static final String SELECT_TIME = "//div[contains(@class, \"modal-container\")]//button[text()=\"Select Time\"]";
        public static final String AVAILABLE_DAYS = "//div[@class=\"rwdp-DayCircle-date\"][not(.//following-sibling::div)]";
        public static final String AVAILABLE_DAY = "(//div[@class=\"rwdp-DayCircle-date\"][not(.//following-sibling::div)])[arg0]";
        public static final String AVAILABLE_ENTRY = "//button[text()=\"select\"]";
    }

    public static class leftMenu{
        public static class buttons {
            public static final String LEFT_MENU_ALL_SERVICES = "//span[text()=\"All services\"]";
            public static final String LEFT_MENU_SECOND_STAFF = "(//input[@name=\"staff member\"]//following-sibling::span[not(text()=\"all staff members\")])[2]";
        }
    }

    public static class rightSidePanel{
        public static class texts{
            public static final String APPOINTMENT_NAME = "//li[@class=\"variation-item\"]//span[contains(@class,\"variation-name\")]";
            public static final String APPOINTMENT_PRICE = "//li[@class=\"variation-item\"]//span[contains(@class,\"variation-price\")]/span";
            public static final String STAFF_NAME = "//div[contains(@class, \"employee-selector\")]//div[@class=\"Select-value\"]/span";
        }
    }

    public static LinkedHashMap<String, String> EXPRESS_CHECKOUT_MAP = createData();
    private static LinkedHashMap<String, String> createData() {
        LinkedHashMap<String, String> ret = new LinkedHashMap<>();
        ret.put(leftMenu.buttons.LEFT_MENU_ALL_SERVICES, "Left menu - All services");
        ret.put(leftMenu.buttons.LEFT_MENU_SECOND_STAFF, "Left menu - Second staff");
        ret.put(buttons.MENS_HAIRCUT_BUTTON, "Mens haircut book button");
        ret.put(buttons.MENS_HAIRCUT_PRICE, "Mens haircut price");
        ret.put(buttons.MENS_HAIRCUT_TITLE, "Mens haircut title");
        ret.put(buttons.SELECT_TIME, "Select time inside appointment modal");
        ret.put(buttons.AVAILABLE_DAYS, "Available days");
        ret.put(buttons.AVAILABLE_DAY, "Next available day");
        ret.put(buttons.AVAILABLE_ENTRY, "Available entry");
        ret.put(rightSidePanel.texts.APPOINTMENT_NAME, "Appointment name");
        ret.put(rightSidePanel.texts.APPOINTMENT_PRICE, "Appointment price");
        ret.put(rightSidePanel.texts.STAFF_NAME, "Staff name");
        return ret;
    }
}
