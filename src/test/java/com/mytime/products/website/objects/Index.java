package com.mytime.products.website.objects;

import java.util.LinkedHashMap;

public class Index {

    public static class buttons{
        public static final String SEARCH_BUTTON = "//div[contains(@class, \"form-overlay\")]//button";
    }

    public static class inputs{
        public static final String SERVICE_INPUT = "//div[contains(@class, \"form-overlay\")]//*[@id=\"search-query\"]";
        public static final String INPUT_OPTION = "//a[text()=\"arg0\"]";
        public static final String LOCATION_INPUT = "//div[contains(@class, \"form-overlay\")]//*[@id=\"search-location\"]";
    }

    public static LinkedHashMap<String, String> INDEX_MAP = createData();
    private static LinkedHashMap<String, String> createData() {
        LinkedHashMap<String, String> ret = new LinkedHashMap<>();
        ret.put(inputs.SERVICE_INPUT, "Enter a business or service input");
        ret.put(inputs.INPUT_OPTION, "Input option element");
        ret.put(inputs.LOCATION_INPUT, "Location input");
        ret.put(buttons.SEARCH_BUTTON, "Search button");

        return ret;
    }
}
