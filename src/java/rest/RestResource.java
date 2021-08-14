/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ejb.adminBeanLocal;
import ejb.userBeanLocal;
import entity.TblArea;
import entity.TblCar;
import entity.TblCity;
import entity.TblFeedback;
import entity.TblGroup;
import entity.TblGroupPK;
import entity.TblModel;
import entity.TblRating;
import entity.TblServiceCart;
import entity.TblServiceDetail;
import entity.TblServiceType;
import entity.TblServices;
import entity.TblUser;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.DELETE;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Parth Computer
 */
@DeclareRoles({"admin", "user"})
@Path("rest")
//@RequestScoped
public class RestResource {

    @EJB
    adminBeanLocal abl;
    @EJB 
    userBeanLocal ubl;
    
    @Context
    private UriInfo context;
    

    /**
     * Creates a new instance of RestResource
     */
    public RestResource() {
    }
    
    //    @RolesAllowed({"admin","user"})
    @PermitAll
    @GET
    @Path("getAllUsers")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})    
    public Collection<TblUser> getAllUsers() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<TblUser> users = ubl.getAllUserNames();
        return users;
    }

    @RolesAllowed("admin")
    @GET
    @Path("getUsersByFirstName/{first_name}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<TblUser> getUsersByFirstName(@PathParam("first_name") String first_name) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<TblUser> users = abl.getUsersByFirstName(first_name);
        return users;
    }

    @RolesAllowed("admin")
    @GET
    @Path("getUsersByLastName/{last_name}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<TblUser> getUsersByLastName(@PathParam("last_name") String last_name) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<TblUser> users = abl.getUsersByLastName(last_name);
        return users;
    }

    @PermitAll
    @GET
    @Path("getUsersByAreaId/{area_id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<TblUser> getUsersByAreaId(@PathParam("area_id") String area_id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.        
        Collection<TblUser> users = abl.getUsersByAreaId(area_id);
        return users;
    }

    @PermitAll
    @GET
    @Path("getUsersByAreaName/{area_name}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<TblUser> getUsersByAreaName(@PathParam("area_name") String area_name) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<TblUser> users = abl.getUsersByAreaName(area_name);
        return users;
    }

    @RolesAllowed("admin")
    @GET
    @Path("getActiveUsers")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<TblUser> getActiveUsers() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<TblUser> users = abl.getActiveUsers();
        return users;
    }

    @RolesAllowed("admin")
    @GET
    @Path("getDeletedUsers")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<TblUser> getDeletedUsers() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<TblUser> users = abl.getDeletedUsers();
        return users;
    }

    @RolesAllowed("admin")
    @GET
    @Path("getUsersJoinedToday")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<TblUser> getUsersJoinedToday() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<TblUser> users = abl.getUsersJoinedToday();
        return users;
    }


    @POST
    @Path("addCity/{city_name}")
    public void addCity(@PathParam("city_name") String city_name) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        abl.addCity(city_name);
    }

    @PUT
    @Path("updateCity/{city_id}/{city_name}")
    public void updateCity(@PathParam("city_id") int city_id, @PathParam("city_name") String city_name) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        abl.updateCity(city_id, city_name);
    }

    @DELETE
    @Path("removeCity/{city_id}")
    public void removeCity(@PathParam("city_id") int city_id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        abl.removeCity(city_id);
    }

    @PermitAll
    @GET
    @Path("getAllCity")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<TblCity> getAllCity() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<TblCity> cities = abl.getAllCity();
        return cities;
    }

    @POST
    @Path("addArea/{area_name}/{city_id}")
    public void addArea(@PathParam("area_name") String area_name, @PathParam("city_id") int city_id) {
//        throw new Unsu?pportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       abl.addArea(area_name, city_id);
    }

    @PUT
    @Path("updateArea/{area_id}/{area_name}/(city_id)")
    public void updateArea(@PathParam("area_id") int area_id, @PathParam("area_name") String area_name, @PathParam("city_id") int city_id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        abl.updateArea(area_id, area_name, city_id);
    }

    @DELETE
    @Path("removeArea/{area_id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void removeArea(@PathParam("area_id") int area_id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        abl.removeArea(area_id);
    }

    @PermitAll
    @GET
    @Path("getAllArea")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<TblArea> getAllArea() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<TblArea> areas = abl.getAllArea();
        return areas;
    }

    @PermitAll
    @GET
    @Path("getAreaByCityId/{city_id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<TblArea> getAreaByCityId(@PathParam("city_id") int city_id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<TblArea> areas = abl.getAreaByCityId(city_id);
        return areas;
    }

    @POST
    @Path("addServiceType/{service_type}/{image}/{description}/{price}")
    public void addServiceType(@PathParam("service_type") String service_type, @PathParam("image") String image, @PathParam("description") String description, @PathParam("price") float price) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        abl.addServiceType(service_type, image, description, price);
    }

    @PUT
    @Path("updateServiceType/{service_type_id}/{service_type}/{image}/{description}/{price}")
    public void updateServiceType(@PathParam("service_type_id") int service_type_id, @PathParam("service_type") String service_type, @PathParam("image") String image, @PathParam("description") String description, @PathParam("price") float price) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            abl.updateServiceType(service_type_id, service_type, image, description, price);
    }

    
    @DELETE
    @Path("removeServiceType/{service_type_id}")
    public void removeServiceType(@PathParam("service_type_id") int service_type_id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        abl.removeServiceType(service_type_id);
    }

    @PermitAll
    @GET
    @Path("getAllServiceType")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<TblServiceType> getAllServiceType() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<TblServiceType> stype = abl.getAllServiceType();
        return stype;
    }

    @RolesAllowed("admin")
    @GET
    @Path("getAllFeedback")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<TblFeedback> getAllFeedback() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<TblFeedback> feedbacks = abl.getAllFeedback();
        return feedbacks;
    }

    @RolesAllowed("admin")
    @GET
    @Path("getAllRating")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<TblRating> getAllRating() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<TblRating> ratings = abl.getAllRating();
        return ratings;
    }

    @RolesAllowed("admin")
    @GET
    @Path("getAllServices")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<TblServices> getAllServices() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<TblServices> services = abl.getAllServices();
        return services; 
    }

    @RolesAllowed("admin")
    @GET
    @Path("getAllPendingServices")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<TblServices> getAllPendingServices() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<TblServices> services = abl.getAllPendingServices();
        return services; 
    }

    @RolesAllowed("admin")
    @GET
    @Path("getTodaysServices")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<TblServices> getTodaysServices() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<TblServices> services = abl.getTodaysServices();
        return services;
    }

    @RolesAllowed("admin")
    @GET
    @Path("getAllServiceDetails")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<TblServiceDetail> getAllServiceDetails() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<TblServiceDetail> sdetails = abl.getAllServiceDetails();
        return sdetails;
    }

//    @GET
//    @Path("getAllServiceDetailByServiceId/{service_id}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public Collection<TblServiceDetail> getAllServiceDetailsByServiceId(@PathParam("service_id") String service_id) {
////        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.               
//        Collection<TblServiceDetail> sdetails = abl.getAllServiceDetails();
//        return sdetails;
//    }

//    @PUT
//    @Path("updateStatusOfServiceDetail/{sdetail_id}")
//    public void updateStatusOfServiceDetail(@PathParam("sdetail_id") int sdetail_id) {
////        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        abl.updateStatusOfServiceDetail(sdetail_id);
//    }

    
//    ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @POST
    @Path("addUser/{username}/{Newpassword}/{firstname}/{lastname}/{phone}/{areaid}/{address}")
    public void addUser(@PathParam("username") String username, @PathParam("Newpassword") String Newpassword, @PathParam("firstname") String firstname, @PathParam("lastname") String lastname, @PathParam("phone") String phone, @PathParam("areaid") int areaid, @PathParam("address") String address) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ubl.addUser(username, Newpassword, firstname, lastname, phone, areaid, address);
        }
    
    @PUT
    @Path("updateUser/{username}/{firstname}/{lastname}/{phone}/{areaid}/{address}")
    public void updateUser(@PathParam("username") String username, @PathParam("firstname") String firstname, @PathParam("lastname") String lastname, @PathParam("phone") String phone, @PathParam("areaid") String areaid, @PathParam("address") String address) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ubl.updateUser(username, firstname, lastname, phone, areaid, address);
    }

    @PUT //because the status of user is changed from "active" to "deleted"
    @Path("deleteUser/{username}")
    public void deleteUser(@PathParam("username") String username) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ubl.deleteUser(username);
    }

    @POST
    @Path("addFeedback/{username}/{feedback}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void addFeedback(@PathParam("username") String username, @PathParam("feedback") String feedback) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ubl.addFeedback(username, feedback);
    }

    @PUT
    @Path("updateFeedback/{feedback_id}/{feedback}")
    public void updateFeedback(@PathParam("feedback_id") int feedback_id, @PathParam("feedback") String feedback) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ubl.updateFeedback(feedback_id, feedback);
    }

    @DELETE
    @Path("removeFeedback/{feedback_id}")
    public void removeFeedback(@PathParam("feedback_id") int feedback_id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ubl.removeFeedback(feedback_id);
    }

//    @GET
//    @Path("getAllFeedback")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public Collection<TblFeedback> getAllFeeback() {
////        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        Collection<TblFeedback> f = ubl.getAllFeeback();
//        return f;
//    }

    @POST
    @Path("addRating/{username}/{rating}")
    public void addRating(@PathParam("username") String username, @PathParam("rating") int rating) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ubl.addRating(username, rating);
    }

    @PUT
    @Path("updateRating/{rating_id}/{rating}")
    public void updateRating(@PathParam("rating_id") int rating_id, @PathParam("rating") int rating) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ubl.updateRating(rating_id, rating);
    }

    @DELETE
    @Path("removeRating/{rating_id}")
    public void removeRating(@PathParam("rating_id") int rating_id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ubl.removeRating(rating_id);
    }

    //getAllRating alrady defined in admin

    @POST
    @Path("addCar/{username}/{model_id}/{fuel_name}/{color_name}/{car_no}")
    public void addCar(@PathParam("username") String username, @PathParam("model_id") int model_id, @PathParam("fuel_name") String fuel_name, @PathParam("color_name") String color_name, @PathParam("car_no") String car_no) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ubl.addCar(username, model_id, fuel_name, color_name, car_no);
    }

    @PUT
    @Path("updateCar/{car_id}/{model_id}/{fuel_name}/{color_name}/{car_no}")
    public void updateCar(@PathParam("car_id") int car_id, @PathParam("model_id") int model_id, @PathParam("fuel_name") String fuel_name, @PathParam("color_name") String color_name, @PathParam("car_no") String car_no) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ubl.updateCar(car_id, model_id, fuel_name, color_name, car_no);
    }

    @DELETE
    @Path("removeCar/{car_id}")
    public void removeCar(@PathParam("car_id") int car_id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ubl.removeCar(car_id);
    }
    
    @RolesAllowed("user")
    @GET
    @Path("getCarByUsername/{username}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<TblCar> getCarByUsername(@PathParam("username") String username) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<TblCar> cars = ubl.getCarByUsername(username);
        return cars;
    }

    @POST
    @Path("addToTblService/{username}/{car_id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void addToTblService(@PathParam("username") String username,@PathParam("car_id") int car_id, Collection<Integer> scartid) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ubl.addToTblService(username, car_id, scartid);
    }

    @POST
    @Path("addToCart/{username}/{service_type_id}")
    public void addToCart(@PathParam("username") String username, @PathParam("service_type_id") int service_type_id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ubl.addToCart(username, service_type_id);
    }

    @DELETE
    @Path("removeServiceFromCart/{scart_id}")
    public void removeServiceFromCart(@PathParam("scart_id") int scart_id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ubl.removeServiceFromCart(scart_id);
    }

    @RolesAllowed("user")
    @GET
    @Path("getCartItemsByUsername/{username}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<TblServiceCart> getCartItemsByUsername(@PathParam("username") String username) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<TblServiceCart> scart = ubl.getCartItemsByUsername(username);
        return scart;
    }


}
