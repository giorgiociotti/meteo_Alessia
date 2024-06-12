package org.example;

public class Xpath {
    private static final String REPLACEMENT = "#REPLACEMENT#";
    
    public String genericreplace(String input, String replacement) {
        return input.replace(REPLACEMENT, replacement);
    }
    
    //DWH
    public static final String liAriaLabel = "//li[@aria-label='#REPLACEMENT#']";
    public static final String inputId = "//input[@id='#REPLACEMENT#']";
    public static final String buttonClass = "//button[@class='#REPLACEMENT#']";
    public static final String spanClass = "//span[@class='#REPLACEMENT#']";
    public static final String divClass = "//div[@class='#REPLACEMENT#']";
    public static final String inputForm = "//input[@formcontrolname='#REPLACEMENT#']";
    public static final String inputNg = "//input[@ng-reflect-name='#REPLACEMENT#']";
    public static final String inputClass = "//input[@class='#REPLACEMENT#']";
    public static final String iClass = "//i[@class='#REPLACEMENT#']";
    public static final String buttonLabel = "//button[@label='#REPLACEMENT#']";
    public static final String tabellaDivRole = "//tabella//div[@role='#REPLACEMENT#']";
    public static final String loginSso = "//*[@id='#REPLACEMENT#']";
    public static final String tabellaThClass = "//tabella//th[@class='#REPLACEMENT#']";
    public static final String tabellaTd = "//tabella//td[@class='#REPLACEMENT#']";
    public static final String spanNg_reflect_ng_class = "//span[@ng-reflect-ng-class='#REPLACEMENT#']";
    public static final String idPaginator = "//*[@id='#REPLACEMENT#'";
    public static final String buttonngReflectLabel = "//button[@ng-reflect-label='#REPLACEMENT#']";
    public static final String formClass = "//formPath[@class='#REPLACEMENT#']";
    public static final String h3Class = "//h3[@class='#REPLACEMENT#']";
    //FINE DWH
    public static final String tableTbody = "//table//tbody";
    public static final String tabTableTbody = "//tabella//table//tbody";
    public static final String formPath = "//form";
    public static final String pdropdownForm = "//p-dropdown[@formcontrolname='#REPLACEMENT#']";
    public static final String tabTbodyTr = "//table//tbody//tr";
    public static final String buttonNgReflectText = "//button[@ng-reflect-text='#REPLACEMENT#']";
    public static final String tbodyDivRole = "//tbody//div[@role='#REPLACEMENT#']";
    public static final String emClass = "//em[@class='#REPLACEMENT#']";
    public static final String ulClass = "//ul[@class='#REPLACEMENT#']";
    public static final String spanText = "//span[text()='#REPLACEMENT#']";
    public static final String customNgLabel = "//custom-button[@ng-reflect--label='#REPLACEMENT#']";
    public static final String textAreaForm = "//textarea[@formcontrolname='#REPLACEMENT#']";//'diagnosi'
    public static final String aClass = "//a[@class='#REPLACEMENT#']";
    public static final String aId = "//a[@id='#REPLACEMENT#']";
    public static final String spanContains = "//span[contains(text(),'#REPLACEMENT#')]";
    public static final String thNgReflectField = "//th[@ng-reflect-field='#REPLACEMENT#']";
    public static final String tr2td2 = "//tr[2]/td[2]";
    public static final String divRole = "//div[@role='#REPLACEMENT#']";
    public static final String aText = "//a[text()='#REPLACEMENT#']";
    public static final String liClass = "//li[@class='#REPLACEMENT#']";
    public static final String ngreflectngclass = "//div[@ng-reflect-ng-class='#REPLACEMENT#']";
    public static final String pfieldsetleggend = "//p-fieldset[@legend='#REPLACEMENT#']";
    public static final String h1Text = "//h1[text()='#REPLACEMENT#']";
    public static final String pcardngreflect = "//p-card[@ng-reflect-header='#REPLACEMENT#']";
    public static final String tableTheadTh = "//table//thead//th";
    public static final String ngreflecttooltip = "ng-reflect--tool-tip='#REPLACEMENT#'";
    public static final String customngreflecttooltip = "//custom-button[@ng-reflect--tool-tip='#REPLACEMENT#']";
    public static final String pdropdownClass = "//p-dropdown[@class='#REPLACEMENT#']";
    public static final String buttonlabel = "//button[@label='#REPLACEMENT#']";
    public static final String divText = "//div[text()='#REPLACEMENT#']";
    
}