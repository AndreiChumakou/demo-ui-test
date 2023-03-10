package by.itacademy.andreichumakou.web;

public class AmazonPage {
    public static final String URL = "https://www.amazon.com/";
    public static final String COPYRIGHT_XPATH = "//span[contains(text(), '© 1996-2023, Amazon')]";
    public static final String COPYRIGHT_TEXT = "© 1996-2023, Amazon.com, Inc. or its affiliates";

    public static final String CART_FROM_MAIN_XPATH = "//span[contains(text(),'Cart')]";
    public static final String ROW_YOUR_AMAZON_CART_IS_EMPTY_XPATH =
            "//div[@class='a-row sc-your-amazon-cart-is-empty']";
    public static final String ROW_YOUR_AMAZON_CART_IS_EMPTY_TEXT = "Your Amazon Cart is empty";

    public static final String BUTTON_SIGN_TO_ACCOUNT_XPATH =
            "//span[contains(text(),'Sign in to your account')]";

    public static final String SING_IN_XPATH = "//h1[contains(text(),'Sign in')]";
    public static final String SING_IN_TEXT = "Sign in";

    public static final String BUTTON_CONTINUE_SIGN_IN_XPATH
            = "//span[@id='continue']";
    public static final String ALERT_MISSING_EMAIL_TEXT = "Enter your email or mobile phone number";









}
