/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author Dell
 */
public class Services {
    public static String getStatusOfUsers(boolean userStatus){
        String statusText = null;
        if(userStatus == true){
            statusText = "Active";
        }else
            statusText = "Unactive";
        
        return statusText;
    }
}
