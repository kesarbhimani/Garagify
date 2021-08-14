/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 *
 * @author dell
 */
    
    @DatabaseIdentityStoreDefinition(
        dataSourceLookup = "jdbc/garagify",  
        callerQuery = "select password from tbl_user where user_name = ?",
        groupsQuery = "select group_name from tbl_group where user_name = ?",
        hashAlgorithm = Pbkdf2PasswordHash.class,
        priority = 30)




@Named
@ApplicationScoped
public class projectconfig {
     public projectconfig() {
        System.out.println("Project Config Initialized");
    }


    
}
