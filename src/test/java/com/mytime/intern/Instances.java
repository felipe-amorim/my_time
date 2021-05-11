package com.mytime.intern;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.mytime.support.commons.*;
import com.mytime.support.web.ScrollWeb;
import com.mytime.support.web.driver.*;
import com.mytime.support.web.find.*;
import com.mytime.support.web.find.combobox.ComboBox;
import com.mytime.support.web.find.combobox.GetterComboBox;
import com.mytime.support.web.find.combobox.SetterComboBox;
import com.mytime.support.web.find.exceptionals.ExceptionalsWeb;
import com.mytime.support.web.find.exceptionals.FramesWeb;
import com.mytime.support.web.find.exceptionals.GetterPopUps;
import com.mytime.support.web.find.exceptionals.PopUps;
import com.mytime.support.web.sleep.SleepWeb;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class Instances {
    private static Runnable environmentKill = null;
    public static String operationalSystem = System.getProperty("os.name");
    private static final String operationalSystemSufix = operationalSystem.toLowerCase().startsWith("win") ? ".exe" : "" ;
    private static final String operationalSystemLinux = operationalSystem.toLowerCase().startsWith("mac") ? "mac/" : "" ;
    public static String chrome = "chrome";
    public static String firefox = "firefox";
    public static String opera = "opera";
    public static String internetExplorer = "internetExplorer";
    public static String phantomjs = "phantomjs";
    private static boolean isAvailable = false;
    private static String webLastLocatorResult = null;
    private static ActionsWeb actionsWebClassInstance = null;
    private static Log logClassInstance = null;
    private static PopUps popUpsClassInstance = null;
    private static ScrollWeb scrollWebClassInstance = null;
    private static SleepWeb sleepWebClassInstance = null;
    private static WebDriver webDriverClassInstance = null;
    private static Error errorClassInstance = null;
    private static FramesWeb framesWebClassInstance = null;
    private static ExceptionalsWeb exceptionalsWebClassInstance = null;
    private static SendsWeb sendsWebClassInstance = null;
    private static ClicksWeb clicksWebClassInstance = null;
    private static ComboBox comboBoxClassInstance = null;
    private static GetterActionsWeb findGetterActionsWebClassInstance = null;
    private static LocatorWeb locatorWebClassInstance = null;
    private static GetterPopUps getterPopUpsClassInstance = null;
    private static SetterComboBox setterComboBoxClassInstance = null;
    private static GetterComboBox getterComboBoxClassInstance = null;
    private static GetterConfig getterConfigClassInstance = null;
    private static SetterConfig setterConfigClassInstance = null;
    private static boolean incognito = false;
    private static boolean userData = false;
    private static String userDataPath = "";
    private static ChromeCapabilities chromeCapabilitiesClassInstance = null;
    private static IEOptions iEOptionsClassInstance = null;
    private static BrowserTypes browserTypesClassInstance = null;
    private static DriverOptions driverOptionsClassInstance = null;
    private static Screenshot screenshotClassInstance = null;
    private static AssertThat assertThatClassInstance = null;
    private static Date dateClassInstance = null;
    private static Execute executeClassInstance = null;
    private static LinkedHashMap<String, String> locator;
    private static String screenShotLocation = "";
    private static String screenShotLocationAfter = "";
    private static Boolean softAssert = false;
    private static final String resourcesPath = System.getProperty("user.dir") + "/src/test/resources/";
    private static final String reportPartPath = resourcesPath + "utils/part.html";
    private static final String reportPath = resourcesPath + "report/";
    private static final String reportFilesPath = reportPath + "anexos/";
    private static final String detailedHtmlReportFileName = "Detailed_test_report.html";
    private static final String reportFilePath = reportFilesPath + detailedHtmlReportFileName;
    private static final String jenkinsEvidencesPath = reportPath + "evidencias/";
    private static final int defaultWaitMilisBackUp = 10000;
    private static int defaultWaitMilis = 10000;
    private static boolean headless = false;
    private static boolean compability = false;
    private static boolean cleanSection = false;
    private static boolean maximized = false;
    private static final int[] resolution = {1440, 900};
    private static String webdriverType = "chrome";
    public static List<org.openqa.selenium.WebDriver> webDriver = new ArrayList<>();
    private static String webLastXpath = "";
    private static String assertionText = "";
    private static List<WebElement> webLastElements = null;
    private static String lastTag = "";
    private static String lastTechnology = "";
    public static int webDriverIndex = 0;
    public static boolean detailed = false;
    public static boolean atLeastOneAssert = false;
    public static boolean thenTagAssert = false;
    public static boolean atLeastOneWhen = false;
    public static boolean atLeastOneThen = false;
    public static boolean atLeastOneEvidence = false;
    public static boolean printLog = false;

    public static boolean getPrintLog() {
        return printLog;
    }

    public static void setPrintLog(boolean printLog) {
        Instances.printLog = printLog;
    }

    public static boolean getAtLeastOneEvidence() {
        return atLeastOneEvidence;
    }

    public static void setAtLeastOneEvidence(boolean atLeastOneEvidence) {
        Instances.atLeastOneEvidence = atLeastOneEvidence;
    }

    public static boolean getDetailed() {
        return detailed;
    }

    public static void setDetailed(boolean detailed) {
        Instances.detailed = detailed;
    }

    public static boolean getThenTagAssert() {
        return thenTagAssert;
    }

    public static void setThenTagAssert(boolean thenTagAssert) {
        Instances.thenTagAssert = thenTagAssert;
    }

    public static boolean getAtLeastOneAssert() {
        return atLeastOneAssert;
    }

    public static void setAtLeastOneAssert(boolean atLeastOneAssert) {
        Instances.atLeastOneAssert = atLeastOneAssert;
    }

    public static boolean getAtLeastOneWhen() {
        return atLeastOneWhen;
    }

    public static void setAtLeastOneWhen(boolean atLeastOneWhen) {
        Instances.atLeastOneWhen = atLeastOneWhen;
    }

    public static boolean getAtLeastOneThen() {
        return atLeastOneThen;
    }

    public static void setAtLeastOneThen(boolean atLeastOneThen) {
        Instances.atLeastOneThen = atLeastOneThen;
    }

    public static class Technology{
        public static String WEB = "web";
        public static String MOBILE = "mobile";
        public static String SCREEN = "screen";
    }
    private static final String userLanguage = System.getProperty("user.language");

    private static final String propertiesLoc = getPropertiesLoc();

    public static String getPropertiesLoc(){
        String location = System.getProperty("user.dir")+"/src/test/resources/translations/"+userLanguage+".properties";
        File loc = new File(location);
        if(!loc.exists()){
            location = System.getProperty("user.dir")+"/src/test/resources/translations/en.properties";
        }
        return location;
    }

    private static final Properties appProps = readPropertiesFile();

    private static Properties readPropertiesFile(){
        Properties appProps = new Properties();
        try {
            appProps.load(new FileInputStream(propertiesLoc));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return appProps;
    }

    private static final String messageStepSkipped                            = appProps.getProperty("messageStepSkipped");
    private static final String messageWaitDisapearStillHasElement            = appProps.getProperty("messageWaitDisapearStillHasElement");
    private static final String messageWaitAppearStillHasElement              = appProps.getProperty("messageWaitAppearStillHasElement");
    private static final String messageExecutionInterrupted                   = appProps.getProperty("messageExecutionInterrupted");
    private static final String messageFailTests                              = appProps.getProperty("messageFailTests");
    private static final String messageWarning                                = appProps.getProperty("messageWarning");
    private static final String messageEnvironmentError                       = appProps.getProperty("messageEnvironmentError");
    private static final String messageNumberTooLong                          = appProps.getProperty("messageNumberTooLong");
    private static final String messageMapNotDefined                          = appProps.getProperty("messageMapNotDefined");
    private static final String messageScreenshotForced                       = appProps.getProperty("messageScreenshotForced");
    private static final String messageWaitAppear                             = appProps.getProperty("messageWaitAppear");
    private static final String messageWaitAppearEach                         = appProps.getProperty("messageWaitAppearEach");
    private static final String messageWaitDisapear                           = appProps.getProperty("messageWaitDisapear");
    private static final String messageWaitDisapearEach                       = appProps.getProperty("messageWaitDisapearEach");
    private static final String messageClick                                  = appProps.getProperty("messageClick");
    private static final String messageClickTwice                             = appProps.getProperty("messageClickTwice");
    private static final String messageClickThrice                            = appProps.getProperty("messageClickThrice");
    private static final String messageClickEach                              = appProps.getProperty("messageClickEach");
    private static final String messageClear                                  = appProps.getProperty("messageClear");
    private static final String messageClearEach                              = appProps.getProperty("messageClearEach");
    private static final String messageDoubleClick                            = appProps.getProperty("messageDoubleClick");
    private static final String messageDoubleClickEach                        = appProps.getProperty("messageDoubleClickEach");
    private static final String messageSend                                   = appProps.getProperty("messageSend");
    private static final String messageSendEach                               = appProps.getProperty("messageSendEach");
    private static final String messageSendSlow                               = appProps.getProperty("messageSendSlow");
    private static final String messageSendSlowEach                           = appProps.getProperty("messageSendSlowEach");
    private static final String messageMove                                   = appProps.getProperty("messageMove");
    private static final String messageMoveScreen                             = appProps.getProperty("messageMoveScreen");
    private static final String messageMoveScreenCoord                        = appProps.getProperty("messageMoveScreenCoord");
    private static final String messageMoveScreenRelative                     = appProps.getProperty("messageMoveScreenRelative");
    private static final String messageMoveEach                               = appProps.getProperty("messageMoveEach");
    private static final String messageExists                                 = appProps.getProperty("messageExists");
    private static final String messageExistsEach                             = appProps.getProperty("messageExistsEach");
    private static final String messageComboBoxText                           = appProps.getProperty("messageComboBoxText");
    private static final String messageComboBoxTextEach                       = appProps.getProperty("messageComboBoxTextEach");
    private static final String messageComboBoxValue                          = appProps.getProperty("messageComboBoxValue");
    private static final String messageComboBoxValueEach                      = appProps.getProperty("messageComboBoxValueEach");
    private static final String messageComboBoxIndex                          = appProps.getProperty("messageComboBoxIndex");
    private static final String messageComboBoxIndexEach                      = appProps.getProperty("messageComboBoxIndexEach");
    private static final String messageComboBoxGetSize                        = appProps.getProperty("messageComboBoxGetSize");
    private static final String messageNavigate                               = appProps.getProperty("messageNavigate");
    private static final String messageInterrupt                              = appProps.getProperty("messageInterrupt");
    private static final String messageAssertFailEquals                       = appProps.getProperty("messageAssertFailEquals");
    private static final String messageAssertFailHigherThan                   = appProps.getProperty("messageAssertFailHigherThan");
    private static final String messageAssertFailLowerThan                    = appProps.getProperty("messageAssertFailLowerThan");
    private static final String messageAssertFailContains                     = appProps.getProperty("messageAssertFailContains");
    private static final String messageAssertFailNotContains                  = appProps.getProperty("messageAssertFailNotContains");
    private static final String messageAssertFailStartsWith                   = appProps.getProperty("messageAssertFailStartsWith");
    private static final String messageAssertFailEndsWith                     = appProps.getProperty("messageAssertFailEndsWith");
    private static final String messageAssertEquals                           = appProps.getProperty("messageAssertEquals");
    private static final String messageAssertHigherThan                       = appProps.getProperty("messageAssertHigherThan");
    private static final String messageAssertLowerThan                        = appProps.getProperty("messageAssertLowerThan");
    private static final String messageAssertContains                         = appProps.getProperty("messageAssertContains");
    private static final String messageAssertNotContains                      = appProps.getProperty("messageAssertNotContains");
    private static final String messageAssertStartsWith                       = appProps.getProperty("messageAssertStartsWith");
    private static final String messageAssertEndsWith                         = appProps.getProperty("messageAssertEndsWith");


    public static void setWebLastLocatorResult(String webLastLocatorResult) {
        Instances.webLastLocatorResult = webLastLocatorResult;
    }


    public static String getAssertionText() {
        return assertionText;
    }

    public static void setAssertionText(String assertionText) {
        Instances.assertionText = assertionText;
    }

    public static boolean getIsAvailable() {
        return isAvailable;
    }

    static void setIsAvailable(boolean isAvailable) {
        Instances.isAvailable = isAvailable;
    }

    public static boolean getIncognito() {
        return incognito;
    }

    public static void setIncognito(boolean incognito) {
        Instances.incognito = incognito;
    }

    public static boolean getUserData() {
        return userData;
    }

    public static void setUserData(boolean userData, String userDataPath) {
        Instances.userData = userData;
        Instances.userDataPath = userDataPath;
    }

    public static org.openqa.selenium.WebDriver getWebDriver() {
        return webDriver.get(webDriverIndex);
    }

    public static void setWebDriver() {
        if (webDriver == null || webDriver.size()<=webDriverIndex) {
            if (webdriverType.equals(chrome)) {
                createChrome();
            } else if (webdriverType.equals(internetExplorer)) {
                createInternetExplorer();
            } else if (webdriverType.equals(phantomjs)) {
                //createPhantomJs();
            } else if (webdriverType.equals(opera)) {
                createOpera();
            }else {
                createFireFox();
            }
        }
    }

    private static void createOpera() {
        System.setProperty("webdriver.opera.driver", "src/test/resources/drivers/operadriver"+operationalSystemSufix);
        webDriver.add(new OperaDriver());
        commonsDriver();
        webDriver.get(webDriverIndex).manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
    }

    private static void createFireFox() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver"+operationalSystemSufix);
        webDriver.add(new FirefoxDriver());
        commonsDriver();
        webDriver.get(webDriverIndex).manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
    }

    private static void createInternetExplorer() {
        System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/IEDriverServer"+operationalSystemSufix);
        InternetExplorerOptions options = new InternetExplorerOptions();
        if (getCleanSection()) {
            options.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        }
        options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        options.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR, true);
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        options.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
        webDriver.add(new InternetExplorerDriver(options));
        commonsDriver();
        webDriver.get(webDriverIndex).manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
    }

    private static void createChrome() {
        File path = new File(Commons.getProjectDownloadsFolder());

        try {
            FileUtils.deleteDirectory(path);
        } catch (IOException ignored) {

        }

        if(path.mkdirs()){
            Log.logPurple("Downloads folder created");
        }else {
            Log.logYellow("Something wrong happened during the downloads folder creation");
        }

        int mockupVideoIndex = webDriverIndex+1;
        if(mockupVideoIndex > 10){
            mockupVideoIndex = 10;
        }

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/"+operationalSystemLinux+"chromedriver"+operationalSystemSufix);

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", path.getPath());
        prefs.put("profile.default_content_setting_values.media_stream_mic", 1);
        prefs.put("profile.default_content_setting_values.media_stream_camera", 1);
        options.setExperimentalOption("prefs", prefs);

        options.addArguments("--use-fake-ui-for-media-stream");
        options.addArguments("--use-fake-device-for-media-stream");
        options.addArguments("--use-file-for-fake-video-capture="+System.getProperty("user.dir")+"/src/test/resources/drivers/mockup_video/u"+mockupVideoIndex+".y4m");
        options.addArguments("--use-file-for-fake-audio-capture="+System.getProperty("user.dir")+"/src/test/resources/drivers/mockup_video/audio.wav");

        if(getUserData()){
            options.addArguments("user-data-dir="+userDataPath);
        }

        options.addArguments("--allow-insecure-localhost");
        options.addArguments("--ignore-certificate-errors");

        if(getIncognito()){
            options.addArguments("--incognito");
        }

        if (getHeadless()) {
            options.addArguments("--headless");
        }
        options.addArguments("--window-size=" + resolution[0] + "," + resolution[1] + "");
        webDriver.add(new ChromeDriver(options));
        commonsDriver();
        webDriver.get(webDriverIndex).manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
    }

    private static void commonsDriver() {
        webDriver.get(webDriverIndex).manage().window().setPosition(new Point(0, 0));
        webDriver.get(webDriverIndex).manage().window().setSize(new Dimension(resolution[0], resolution[1]));
        if (maximized) {
            webDriver.get(webDriverIndex).manage().window().maximize();
        }
    }


    public static void killAllDrivers() {
        if (webDriver.size()>0) {
            for (org.openqa.selenium.WebDriver driver : webDriver){
                driver.quit();
            }
            webDriver = new ArrayList<>();
            webDriverIndex = 0;
        }
    }

    public static String getLastTechnology() {
        return lastTechnology;
    }

    public static void setLastTechnology(String lastTechnology) {
        Instances.lastTechnology = lastTechnology;
    }


    public static Execute getExecuteClassInstance() {
        if (executeClassInstance == null) {
            executeClassInstance = new Execute();
        }
        return executeClassInstance;
    }

    public static Screenshot getScreenshotClassInstance() {
        if (screenshotClassInstance == null) {
            screenshotClassInstance = new Screenshot();
        }
        return screenshotClassInstance;
    }

    public static BrowserTypes getBrowserTypesClassInstance() {
        if (browserTypesClassInstance == null) {
            browserTypesClassInstance = new BrowserTypes();
        }
        return browserTypesClassInstance;
    }

    public static DriverOptions getDriverOptionsClassInstance() {
        if (driverOptionsClassInstance == null) {
            driverOptionsClassInstance = new DriverOptions();
        }
        return driverOptionsClassInstance;
    }

    public static IEOptions getIEOptionsClassInstance() {
        if (iEOptionsClassInstance == null) {
            iEOptionsClassInstance = new IEOptions();
        }
        return iEOptionsClassInstance;
    }

    public static ChromeCapabilities getChromeCapabilitiesClassInstance() {
        if (chromeCapabilitiesClassInstance == null) {
            chromeCapabilitiesClassInstance = new ChromeCapabilities();
        }
        return chromeCapabilitiesClassInstance;
    }

    public static SetterConfig getSetterConfigClassInstance() {
        if (setterConfigClassInstance == null) {
            setterConfigClassInstance = new SetterConfig();
        }
        return setterConfigClassInstance;
    }

    public static GetterConfig getGetterConfigClassInstance() {
        if (getterConfigClassInstance == null) {
            getterConfigClassInstance = new GetterConfig();
        }
        return getterConfigClassInstance;
    }

    public static GetterComboBox getGetterComboBoxClassInstance() {
        if (getterComboBoxClassInstance == null) {
            getterComboBoxClassInstance = new GetterComboBox();
        }
        return getterComboBoxClassInstance;
    }

    public static SetterComboBox getSetterComboBoxClassInstance() {
        if (setterComboBoxClassInstance == null) {
            setterComboBoxClassInstance = new SetterComboBox();
        }
        return setterComboBoxClassInstance;
    }

    public static GetterPopUps getGetterPopUpsClassInstance() {
        if (getterPopUpsClassInstance == null) {
            getterPopUpsClassInstance = new GetterPopUps();
        }
        return getterPopUpsClassInstance;
    }

    public static LocatorWeb getLocatorWebClassInstance() {
        if (locatorWebClassInstance == null) {
            locatorWebClassInstance = new LocatorWeb();
        }
        return locatorWebClassInstance;
    }

    public static GetterActionsWeb getFindGetterClassInstance() {
        if (findGetterActionsWebClassInstance == null) {
            findGetterActionsWebClassInstance = new GetterActionsWeb();
        }
        return findGetterActionsWebClassInstance;
    }

    public static ComboBox getComboBoxClassInstance() {
        if (comboBoxClassInstance == null) {
            comboBoxClassInstance = new ComboBox();
        }
        return comboBoxClassInstance;
    }

    public static ClicksWeb getClicksClassInstance() {
        if (clicksWebClassInstance == null) {
            clicksWebClassInstance = new ClicksWeb();
        }
        return clicksWebClassInstance;
    }

    public static SendsWeb getSendsClassInstance() {
        if (sendsWebClassInstance == null) {
            sendsWebClassInstance = new SendsWeb();
        }
        return sendsWebClassInstance;
    }

    public static ActionsWeb getActionsClassInstance() {
        if (actionsWebClassInstance == null) {
            actionsWebClassInstance = new ActionsWeb();
        }
        return actionsWebClassInstance;
    }

    public static WebDriver getWebDriverClassInstance() {
        if (webDriverClassInstance == null) {
            webDriverClassInstance = new WebDriver();
        }
        return webDriverClassInstance;
    }

    public static Log getLogClassInstance() {
        if (logClassInstance == null) {
            logClassInstance = new Log();
        }
        return logClassInstance;
    }

    public static ScrollWeb getScrollWebClassInstance() {
        if (scrollWebClassInstance == null) {
            scrollWebClassInstance = new ScrollWeb();
        }
        return scrollWebClassInstance;
    }

    public static PopUps getPopUpsClassInstance() {
        if (popUpsClassInstance == null) {
            popUpsClassInstance = new PopUps();
        }
        return popUpsClassInstance;
    }

    public static SleepWeb getSleepWebClassInstance() {
        if (sleepWebClassInstance == null) {
            sleepWebClassInstance = new SleepWeb();
        }
        return sleepWebClassInstance;
    }

    public static Error getErrorClassInstance() {
        if (errorClassInstance == null) {
            errorClassInstance = new Error();
        }
        return errorClassInstance;
    }

    public static FramesWeb getFramesWebClassInstance() {
        if (framesWebClassInstance == null) {
            framesWebClassInstance = new FramesWeb();
        }
        return framesWebClassInstance;
    }

    public static ExceptionalsWeb getExceptionalsWebClassInstance() {
        if (exceptionalsWebClassInstance == null) {
            exceptionalsWebClassInstance = new ExceptionalsWeb();
        }
        return exceptionalsWebClassInstance;
    }

    public static AssertThat getAssertThatClassInstance() {
        if (assertThatClassInstance == null) {
            assertThatClassInstance = new AssertThat();
        }
        return assertThatClassInstance;
    }

    public static LinkedHashMap<String, String> getLocator() {
        return locator;
    }

    public static void setLocator(LinkedHashMap<String, String> locator) {
        Instances.locator = locator;
    }

    public static Boolean getSoftAssert() {
        return softAssert;
    }

    public static void setSoftAssert(Boolean softAssert) {
        Instances.softAssert = softAssert;
    }

    public static String getWebLastXpath() {
        return webLastXpath;
    }

    public static void setWebLastXpath(String xpath) {
        setWebLastXpath(xpath, true);
    }

    public static void setWebLastXpath(String xpath, boolean printLog) {
        Instances.setPrintLog(printLog);
        Instances.webLastXpath = xpath;
        Instances.setIsAvailable(false);
        Instances.getLocatorWebClassInstance().locate(xpath);
    }

    public static List<WebElement> getWebLastElements() {
        return webLastElements;
    }

    static void setWebLastElements(List<WebElement> list) {
        webLastElements = list;
    }

    public static int getDefaultWaitMilis() {
        return defaultWaitMilis;
    }

    public static void setDefaultWaitMilis(int defaultWaitMilis) {
        Instances.defaultWaitMilis = defaultWaitMilis;
    }

    public static void setDefaultWaitMilisBackUp() {
        Instances.defaultWaitMilis = Instances.defaultWaitMilisBackUp;
    }

    private static boolean getHeadless() {
        return headless;
    }

    public static void setHeadless(boolean headless) {
        Instances.headless = headless;
    }

    private static boolean getCompability() {
        return compability;
    }

    public static void setCompability(boolean compability) {
        Instances.compability = compability;
    }

    private static boolean getCleanSection() {
        return cleanSection;
    }

    public static void setCleanSection(boolean cleanSection) {
        Instances.cleanSection = cleanSection;
    }

    private static boolean getMaximized() {
        return maximized;
    }

    public static void setMaximized(boolean maximized) {
        Instances.maximized = maximized;
    }

    public static void setResolution(int width, int height) {
        Instances.resolution[0] = width;
        Instances.resolution[1] = height;
    }

    public static int[] getResolution() {
        return Instances.resolution;
    }

    public static String getWebdriverType() {
        return webdriverType;
    }

    public static void setWebdriverType(String webdriverType) {
        Instances.webdriverType = webdriverType;
    }

    public static Date getDateClassInstance() {
        if (dateClassInstance == null) {
            dateClassInstance = new Date();
        }
        return dateClassInstance;
    }

    public static void setDateClassInstance(Date dateClassInstance) {
        Instances.dateClassInstance = dateClassInstance;
    }

    public static String getReportFilePath() {
        return reportFilePath;
    }

    static String getJenkinsEvidencesPath() {
        return jenkinsEvidencesPath;
    }

    public static String getWebLastXpathLog() {

        String r;
        if (locator.get(Instances.getWebLastXpath()) == null) {
            r = "[Xpath name not defined, pherhaps you should update your log map using log().updateLocator(...)]";
        } else {
            r = locator.get(Instances.getWebLastXpath());
        }

        if(r.contains("not defined")){
            Log.logYellow(r);
        }
        return r;
    }

    static String getScreenShotLocation() {
        return screenShotLocation;
    }

    static void setScreenShotLocation(String screenShotLocation) {
        Instances.screenShotLocation = screenShotLocation;
    }

    public static String getScreenShotLocationAfter() {
        return screenShotLocationAfter;
    }

    public static void setScreenShotLocationAfter(String screenShotLocationAfter) {
        Instances.screenShotLocationAfter = screenShotLocationAfter;
    }

    public static String getMessageMoveScreen() {
        return messageMoveScreen;
    }

    public static String getMessageMoveScreenCoord() {
        return messageMoveScreenCoord;
    }

    public static String getMessageMoveScreenRelative() {
        return messageMoveScreenRelative;
    }

    public static String getLastTag() {
        return lastTag;
    }

    public static void setLastTag(String lastTag) {
        Instances.lastTag = lastTag;
    }

    public static String getMessageStepSkipped() {
        return messageStepSkipped;
    }

    public static String getMessageExecutionInterrupted() {
        return messageExecutionInterrupted;
    }

    public static String getMessageFailTests() {
        return messageFailTests;
    }

    public static String getMessageWarning() {
        return messageWarning;
    }

    public static String getMessageEnvironmentError() {
        return messageEnvironmentError;
    }

    public static String getMessageNumberTooLong() {
        return messageNumberTooLong;
    }

    public static String getMessageWaitDisapearStillHasElement() {
        return messageWaitDisapearStillHasElement;
    }

    public static String getMessageWaitAppearStillHasElement() {
        return messageWaitAppearStillHasElement;
    }

    public static String getMessageMapNotDefined() {
        return messageMapNotDefined;
    }

    public static String getMessageAssertEquals() {
        return messageAssertEquals;
    }

    public static String getMessageAssertContains() {
        return messageAssertContains;
    }

    public static String getMessageAssertStartsWith() {
        return messageAssertStartsWith;
    }

    public static String getMessageAssertEndsWith() {
        return messageAssertEndsWith;
    }

    public static String getMessageInterrupt() {
        return messageInterrupt;
    }

    public static String getMessageScreenshotForced() {
        return messageScreenshotForced;
    }

    public static String getMessageWaitAppear() {
        return messageWaitAppear;
    }

    public static String getMessageWaitAppearEach() {
        return messageWaitAppearEach;
    }

    public static String getMessageWaitDisapear() {
        return messageWaitDisapear;
    }

    public static String getMessageWaitDisapearEach() {
        return messageWaitDisapearEach;
    }

    public static String getMessageAssertFailEndsWith() {
        return messageAssertFailEndsWith;
    }

    public static String getMessageAssertFailStartsWith() {
        return messageAssertFailStartsWith;
    }

    public static String getMessageAssertFailContains() {
        return messageAssertFailContains;
    }

    public static String getMessageAssertFailNotContains() {
        return messageAssertFailNotContains;
    }

    public static String getMessageAssertNotContains() {
        return messageAssertNotContains;
    }

    public static String getMessageAssertFailEquals() {
        return messageAssertFailEquals;
    }

    public static String getMessageAssertFailHigherThan() {
        return messageAssertFailHigherThan;
    }

    public static String getMessageAssertHigherThan() {
        return messageAssertHigherThan;
    }

    public static String getMessageAssertFailLowerThan() {
        return messageAssertFailLowerThan;
    }

    public static String getMessageAssertLowerThan() {
        return messageAssertLowerThan;
    }

    public static String getMessageClear() {
        return messageClear;
    }

    public static String getMessageClick() {
        return messageClick;
    }

    public static String getMessageClickTwice() {
        return messageClickTwice;
    }

    public static String getMessageClickThrice() {
        return messageClickThrice;
    }

    public static String getMessageDoubleClick() {
        return messageDoubleClick;
    }

    public static String getMessageSend() {
        return messageSend;
    }

    public static String getMessageSendSlow() {
        return messageSendSlow;
    }

    public static String getMessageMove() {
        return messageMove;
    }

    public static String getMessageExists() {
        return messageExists;
    }

    public static String getMessageClickEach() {
        return messageClickEach;
    }

    public static String getMessageClearEach() {
        return messageClearEach;
    }

    public static String getMessageDoubleClickEach() {
        return messageDoubleClickEach;
    }

    public static String getMessageSendEach() {
        return messageSendEach;
    }

    public static String getMessageSendSlowEach() {
        return messageSendSlowEach;
    }

    public static String getMessageMoveEach() {
        return messageMoveEach;
    }

    public static String getMessageExistsEach() {
        return messageExistsEach;
    }

    public static String getMessageComboBoxText() {
        return messageComboBoxText;
    }

    public static String getMessageComboBoxValue() {
        return messageComboBoxValue;
    }

    public static String getMessageComboBoxValueEach() {
        return messageComboBoxValueEach;
    }

    public static String getMessageComboBoxTextEach() {
        return messageComboBoxTextEach;
    }

    public static String getMessageComboBoxIndex() {
        return messageComboBoxIndex;
    }

    public static String getMessageComboBoxIndexEach() {
        return messageComboBoxIndexEach;
    }

    public static String getMessageComboBoxGetSize() {
        return messageComboBoxGetSize;
    }

    public static String getMessageNavigate() {
        return messageNavigate;
    }

    public static Runnable getEnvironmentKill() {
        return environmentKill;
    }

    public static void setEnvironmentKill(Runnable environmentKill) {
        Instances.environmentKill = environmentKill;
    }

    public static void killEnvironment(){
        if(environmentKill!=null){
            environmentKill.run();
        }
    }

    public static void removeReportFolder(){
        try {
            FileUtils.deleteDirectory(new File(reportPath));
        } catch (IOException ignored) {
        }
    }

    private static ExtentReports extent;
    private static ExtentTest feature;
    private static ExtentTest scenario;
    private static ExtentTest stepsection;

    private static String featureName;
    private static String scenarioName;
    private static String stepName;

    private static boolean skip = false;
    private static boolean freshScenario = false;

    public static String getFeatureName() {
        return featureName;
    }

    public static String getScenarioName() {
        return scenarioName;
    }

    public static String getStepName() {
        return stepName;
    }

    public static void createANewReport(){
        File reportFolder = new File(reportPath);
        reportFolder.mkdirs();
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(reportFilePath)
                .viewConfigurer()
                .viewOrder()
                .as(new ViewName[] {
                        ViewName.DASHBOARD,
                        ViewName.TEST,
                        ViewName.AUTHOR,
                        ViewName.CATEGORY,
                        ViewName.DEVICE,
                        ViewName.EXCEPTION,
                        ViewName.LOG
                })
                .apply();
        extent.setAnalysisStrategy(AnalysisStrategy.SUITE);
        extent.attachReporter(spark);
        extent.flush();
    }

    public static boolean itsANewFeature(String featureName){
        return !featureName.equals(Instances.featureName);
    }

    public static void createANewFeature(String featureName){
        feature = extent.createTest(featureName);
        Instances.featureName = featureName;
        flushReport();
    }

    public static void createANewScenario(String scenarioName, String authorName, String[] categoryName, String deviceName){//todo acertar categoria
        if(freshScenario){
            stepsection = scenario.createNode("No step was found");
            stepsection.warning("No execution");
        }

        Instances.scenarioName = scenarioName;

        scenario = feature.createNode(scenarioName);
        scenario.assignAuthor(authorName);
        scenario.assignCategory(categoryName[0]);//todo acertar category
        scenario.assignDevice(deviceName);
        freshScenario = true;

        flushReport();
    }

    public static void createANewStep(String stepName){
        freshScenario = false;
        if(skip){
            stepsection.warning("No execution");
        }

        stepsection = scenario.createNode(stepName);
        Instances.stepName = stepName;

        skip = true;

        flushReport();
    }

    private static void removeSkip(){
        if(skip){
            skip = false;
        }
    }

    public static void actionPass(String action){
        removeSkip();
        stepsection.pass(action+getScreenshot()+getScreenshotAfter());
        flushReport();
    }

    public static void actionWarning(String action){
        removeSkip();
        stepsection.warning(action+getScreenshot()+getScreenshotAfter());
        flushReport();
    }

    public static void actionInfo(String action){
        removeSkip();
        stepsection.info(action+getScreenshot()+getScreenshotAfter());
        flushReport();
    }

    public static void actionGenericCodeBlock(String action){
        removeSkip();
        stepsection.info(MarkupHelper.createCodeBlock(action, CodeLanguage.XML));
        flushReport();
    }

    public static void actionJsonCodeBlock(String action){
        removeSkip();
        stepsection.info(MarkupHelper.createCodeBlock(action, CodeLanguage.JSON));
        flushReport();
    }

    public static void actionFail(String action){
        removeSkip();
        if(!getScreenshot().equals("")) {
            actionInfo("Last screen");
        }
        stepsection.fail(action);
        flushReport();
    }

    public static void actionFail(Throwable action){
        removeSkip();
        if(!getScreenshot().equals("")) {
            actionInfo("Last screen");
        }
        stepsection.fail(action);
        flushReport();
    }

    private static String getScreenshot(){
        String ret = "";
        if(screenShotLocation!=null && screenShotLocation.length()>0) {
            ret = " <a data-featherlight='image' onclick='createArrows(event)' style='float: right;padding: 0px;' href='"+screenShotLocation+
                    "'>before</a>";
        }
        return ret;
    }

    private static String getScreenshotAfter(){
        String ret = "";
        if(screenShotLocationAfter!=null && screenShotLocationAfter.length()>0) {
            ret = "<div></div><a data-featherlight='image' onclick='createArrows(event)' style='float: right;padding: 0px;' href='"+screenShotLocationAfter+
                    "'>after</a>";
        }
        return ret;
    }


    private static void flushReport(){
        extent.flush();
        screenShotLocation = "";
        screenShotLocationAfter = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(reportFilePath));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line).append("\n");
                line = br.readLine();
            }
            List<String> linhasDoRelatorio = Arrays.asList(sb.toString().split("\n"));
            int index = 0;
            for(String linha:sb.toString().split("\n")){
                linha = linha.trim();

                if(linha.equals("<h6 class=\"card-title\">Suite</h6>")){
                    linhasDoRelatorio.set(index, "<h6 class=\"card-title\">Features</h6>");
                }

                if(linha.equals("<h6 class=\"card-title\">Class</h6>")){
                    linhasDoRelatorio.set(index, "<h6 class=\"card-title\">Scenarios</h6>");
                }

                if(linha.equals("<h6 class=\"card-title\">Test</h6>")){
                    linhasDoRelatorio.set(index, "<h6 class=\"card-title\">Steps</h6>");
                }

                if(linha.equals("<h6 class=\"card-title\">Log events</h6>")){
                    linhasDoRelatorio.set(index, "<h6 class=\"card-title\">Actions</h6>");
                }

                if(linha.equals("<p class=\"m-b-0 text-pass\">Suite Passed</p>")){
                    linhasDoRelatorio.set(index, "<p class=\"m-b-0 text-pass\">Feature Passed</p>");
                }

                if(linha.equals("<p class=\"m-b-0 text-fail\">Suite Failed</p>")){
                    linhasDoRelatorio.set(index, "<p class=\"m-b-0 text-fail\">Feature Failed</p>");
                }

                if(linha.equals("<li><a href=\"#\"><span class=\"font-size-14\">Tests</span></a></li>")){
                    linhasDoRelatorio.set(index, "<li><a href=\"#\"><span class=\"font-size-14\">Feature</span></a></li>");
                }

                if(linha.equals("<div class=\"accordion\">")){
                    linhasDoRelatorio.set(index, "<div class=\"accordion collapse\">");
                }

                if(linha.contains("</b> suite ") || linha.contains("</b> class ") || linha.contains("</b> test ") || linha.contains("</b> events ")){
                    String rep = linha
                            .replace("</b> suite ", "</b> ")
                            .replace("</b> class ", "</b> ")
                            .replace("</b> test ", "</b> ")
                            .replace("</b> events ", "</b> ");
                    linhasDoRelatorio.set(index, rep);
                }

                if(
                        (linha.contains("\">Given: ")||linha.contains("\">When: ")||linha.contains("\">Then: ")||linha.contains("\">And: "))
                                &&!linha.contains("style=\"color:#FF8C00;\"")){
                    String rep = linha
                            .replace("\">Given: ",  "\"><span style=\"color:#FF8C00;\">Given:    </span> ")
                            .replace("\">When: ",   "\"><span style=\"color:#FF8C00;\">When:     </span> ")
                            .replace("\">Then: ",   "\"><span style=\"color:#FF8C00;\">Then:     </span> ")
                            .replace("\">And: ",    "\"><span style=\"color:#FF8C00;\">And:      </span> ");
                    linhasDoRelatorio.set(index, rep);
                    linhasDoRelatorio.set(index+5, "");
                    linhasDoRelatorio.set(index+6, "");
                    linhasDoRelatorio.set(index+7, "");
                    linhasDoRelatorio.set(index+8, "");
                }

                String scriptRef = "<script src=\"https://cdn.jsdelivr.net/gh/extent-framework/";
                if(linha.contains(scriptRef)){
                    BufferedReader br2 = new BufferedReader(new FileReader(reportPartPath));
                    StringBuilder sb2 = new StringBuilder();
                    String line2 = br2.readLine();
                    while (line2 != null) {
                        sb2.append(line2).append("\n");
                        line2 = br2.readLine();
                    }

                    linhasDoRelatorio.set(index, linha.replace(scriptRef, sb2.toString()+scriptRef));
                }
                index++;
            }
            sb = new StringBuilder();
            for (String linha : linhasDoRelatorio) {
                sb.append(linha).append("\n");
            }

            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(reportFilePath, false), StandardCharsets.UTF_8))) {
                writer.write(sb.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}