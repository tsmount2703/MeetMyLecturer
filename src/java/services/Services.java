/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.text.SimpleDateFormat;

/**
 *
 * @author Dell
 */
public class Services {
    
    private static final String fDate = "yyyy-MM-dd";
    private static final String fTime = "HH:mm";
    private static final String fDateTime = "yyyy-MM-dd HH:mm";

    //Convert Date into String
    public static final SimpleDateFormat sdfDate = new SimpleDateFormat(fDate);
    public static final SimpleDateFormat sdfTime = new SimpleDateFormat(fTime);
    public static final SimpleDateFormat sdfDateTime = new SimpleDateFormat(fDateTime);
    
    public static String getStatusOfUsers(boolean userStatus){
        String statusText = null;
        if(userStatus == true){
            statusText = "Active";
        }else
            statusText = "Unactive";
        
        return statusText;
    }
}
