/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import static client.restFilter.mytoken;
import java.io.IOException;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;


/**
 *
 * @author Parth Computer
 */
@Provider
@PreMatching


public class restFilter implements ClientRequestFilter{
    
    public static String mytoken;
    
    public restFilter(String token) {
                mytoken = token;

    }
    
    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        System.out.println("-----------------------------------------------------------------");
        System.out.println(" In form Auth Client Filter "+ mytoken);
        System.out.println("-----------------------------------------------------------------");
        
        requestContext.getHeaders().add(HttpHeaders.AUTHORIZATION, "Bearer "+mytoken);
        
        System.out.println("-----------------------------------------------------------------");
        System.out.println(" After cookie header Auth Client Filter "+ mytoken);
        System.out.println("-----------------------------------------------------------------");

    }
}
