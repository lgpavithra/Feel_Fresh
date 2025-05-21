package model.system;

import model.UserBean;

public class SystemStatus {

    public static UserBean getUser() {
        return user;
    }

    public static void setUser(UserBean aUser) {
        user = aUser;
    }

    /*
    __Description__
    
    This class is defined to represent specific status of systm components.
        There are some variables which descibes the status of relavent component
        
    $_States
        1: running/active
        0: stoped/inactive    
    
     */

 /* Dialogs */
    public static int settingsDialog;
    public static int connectionDialog;
    
 /* User 
    Admin : 1
    HR Manager : 2
    Inventory Manger : 3
    Cashire : 4       
    */
    
    public static final int ADMIN =1;
    public static final int HR_MANAGER = 2;
    public static final int INVENTORY_MANAGER = 3;
    public static final int CASHIER = 4;
    
    private static UserBean user;

    
    

}
