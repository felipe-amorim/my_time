package com.mytime.products.website.objects;

import java.util.LinkedHashMap;

public class Results {
    public static class texts{
        public static final String BUSINESS_NAME = "//h2[@class=\"business-name\"]";
    }

    public static class buttons{
        public static final String BUSINESS_TITLE_HREF = "//a[text()=\"arg0\"]";
    }

    public static LinkedHashMap<String, String> RESULTS_MAP = createData();
    private static LinkedHashMap<String, String> createData() {
        LinkedHashMap<String, String> ret = new LinkedHashMap<>();
        ret.put(texts.BUSINESS_NAME, "Business name card");
        ret.put(buttons.BUSINESS_TITLE_HREF, "Business Title href");
        return ret;
    }
}
