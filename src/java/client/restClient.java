/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:RestResource [rest]<br>
 * USAGE:
 * <pre>
 *        restClient client = new restClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Parth Computer
 */
public class restClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/GaragifyJSF/webresources";

    public restClient(String token) {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        client.register(new restFilter(token));
        webTarget = client.target(BASE_URI).path("Rest");
    }

    public void updateCity(String city_id, String city_name) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateCity/{0}/{1}", new Object[]{city_id, city_name})).request().put(null);
    }

    public <T> T getAllServices_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllServices");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllServices_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllServices");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeArea(String area_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeArea/{0}", new Object[]{area_id})).request().delete();
    }

    public <T> T getUsersByAreaName_XML(Class<T> responseType, String area_name) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getUsersByAreaName/{0}", new Object[]{area_name}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getUsersByAreaName_JSON(Class<T> responseType, String area_name) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getUsersByAreaName/{0}", new Object[]{area_name}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addFeedback(String username, String feedback) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addFeedback/{0}/{1}", new Object[]{username, feedback})).request().post(null);
    }

    public void addUser(String username, String Newpassword, String firstname, String lastname, String phone, String areaid, String address) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addUser/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{username, Newpassword, firstname, lastname, phone, areaid, address})).request().post(null);
    }

    public void addCar(String username, String model_id, String fuel_name, String color_name, String car_no) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addCar/{0}/{1}/{2}/{3}/{4}", new Object[]{username, model_id, fuel_name, color_name, car_no})).request().post(null);
    }

    public <T> T getUsersJoinedToday_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getUsersJoinedToday");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getUsersJoinedToday_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getUsersJoinedToday");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeServiceFromCart(String scart_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeServiceFromCart/{0}", new Object[]{scart_id})).request().delete();
    }

    public <T> T getUsersByAreaId_XML(Class<T> responseType, String area_id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getUsersByAreaId/{0}", new Object[]{area_id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getUsersByAreaId_JSON(Class<T> responseType, String area_id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getUsersByAreaId/{0}", new Object[]{area_id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addArea(String area_name, String city_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addArea/{0}/{1}", new Object[]{area_name, city_id})).request().post(null);
    }

    public <T> T getUsersByFirstName_XML(Class<T> responseType, String first_name) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getUsersByFirstName/{0}", new Object[]{first_name}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getUsersByFirstName_JSON(Class<T> responseType, String first_name) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getUsersByFirstName/{0}", new Object[]{first_name}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllCity_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllCity");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllCity_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllCity");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllServiceDetails_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllServiceDetails");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllServiceDetails_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllServiceDetails");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addRating(String username, String rating) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addRating/{0}/{1}", new Object[]{username, rating})).request().post(null);
    }

    public <T> T getDeletedUsers_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getDeletedUsers");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getDeletedUsers_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getDeletedUsers");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeServiceType(String service_type_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeServiceType/{0}", new Object[]{service_type_id})).request().delete();
    }

    public <T> T getAllFeedback_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllFeedback");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllFeedback_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllFeedback");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addToCart(String username, String service_type_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addToCart/{0}/{1}", new Object[]{username, service_type_id})).request().post(null);
    }

    public void updateCar(String car_id, String model_id, String fuel_name, String color_name, String car_no) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateCar/{0}/{1}/{2}/{3}/{4}", new Object[]{car_id, model_id, fuel_name, color_name, car_no})).request().put(null);
    }

    public <T> T getUsersByLastName_XML(Class<T> responseType, String last_name) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getUsersByLastName/{0}", new Object[]{last_name}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getUsersByLastName_JSON(Class<T> responseType, String last_name) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getUsersByLastName/{0}", new Object[]{last_name}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addToTblService_XML(Object requestEntity, String username, String car_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addToTblService/{0}/{1}", new Object[]{username, car_id})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void addToTblService_JSON(Object requestEntity, String username, String car_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addToTblService/{0}/{1}", new Object[]{username, car_id})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void updateFeedback(String feedback_id, String feedback) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateFeedback/{0}/{1}", new Object[]{feedback_id, feedback})).request().put(null);
    }

    public <T> T getAllRating_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllRating");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllRating_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllRating");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeCar(String car_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeCar/{0}", new Object[]{car_id})).request().delete();
    }

    public <T> T getAllUsers_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllUsers");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllUsers_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllUsers");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeRating(String rating_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeRating/{0}", new Object[]{rating_id})).request().delete();
    }

    public void updateArea(String area_id, String area_name) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateArea/{0}/{1}/(city_id)", new Object[]{area_id, area_name})).request().put(null);
    }

    public void removeFeedback(String feedback_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeFeedback/{0}", new Object[]{feedback_id})).request().delete();
    }

    public void updateServiceType(String service_type_id, String service_type, String image, String description, String price) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateServiceType/{0}/{1}/{2}/{3}/{4}", new Object[]{service_type_id, service_type, image, description, price})).request().put(null);
    }

    public <T> T getAllPendingServices_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllPendingServices");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllPendingServices_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllPendingServices");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateUser(String username, String firstname, String lastname, String phone, String areaid, String address) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateUser/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{username, firstname, lastname, phone, areaid, address})).request().put(null);
    }

    public void addCity(String city_name) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addCity/{0}", new Object[]{city_name})).request().post(null);
    }

    public <T> T getTodaysServices_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getTodaysServices");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getTodaysServices_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getTodaysServices");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getActiveUsers_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getActiveUsers");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getActiveUsers_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getActiveUsers");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getCartItemsByUsername_XML(Class<T> responseType, String username) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getCartItemsByUsername/{0}", new Object[]{username}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getCartItemsByUsername_JSON(Class<T> responseType, String username) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getCartItemsByUsername/{0}", new Object[]{username}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAreaByCityId_XML(Class<T> responseType, String city_id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getAreaByCityId/{0}", new Object[]{city_id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAreaByCityId_JSON(Class<T> responseType, String city_id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getAreaByCityId/{0}", new Object[]{city_id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateRating(String rating_id, String rating) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateRating/{0}/{1}", new Object[]{rating_id, rating})).request().put(null);
    }

    public <T> T getCarByUsername_XML(Class<T> responseType, String username) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getCarByUsername/{0}", new Object[]{username}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getCarByUsername_JSON(Class<T> responseType, String username) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getCarByUsername/{0}", new Object[]{username}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllServiceType_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllServiceType");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllServiceType_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllServiceType");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteUser(String username) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteUser/{0}", new Object[]{username})).request().put(null);
    }

    public void addServiceType(String service_type, String image, String description, String price) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addServiceType/{0}/{1}/{2}/{3}", new Object[]{service_type, image, description, price})).request().post(null);
    }

    public void removeCity(String city_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeCity/{0}", new Object[]{city_id})).request().delete();
    }

    public <T> T getAllArea_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllArea");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllArea_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllArea");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
