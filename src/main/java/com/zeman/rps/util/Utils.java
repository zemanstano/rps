package com.zeman.rps.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class Utils {

    public static final ResourceBundle BUNDLE = ResourceBundle.getBundle("messages", new Locale("en"));

    //private constructor to hide the implicit public one
    private Utils(){}
}
