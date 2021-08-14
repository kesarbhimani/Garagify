/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import client.restClient;
//import Entity.TblUser;
import static com.sun.faces.context.flash.ELFlash.getFlash;
import ejb.userBeanLocal;
import entity.TblUser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;


/**
 *
 * @author Parth Computer
 */
@Named(value = "regManagedBean")
@RequestScoped
public class regManagedBean {
    @EJB userBeanLocal ubl;
    
    Response res;
    restClient rc;
    
    String username;
    String password;
    String firstname;
    String lastname;
    String phone;
//    int city_id;
    String areaid;
    String address;
    String gender;
    
    Integer selectedCityId;
    
    Collection<TblUser> getAllUser;
    GenericType<Collection<TblUser>> ggetAllUser;

    public userBeanLocal getUbl() {
        return ubl;
    }

    public void setUbl(userBeanLocal ubl) {
        this.ubl = ubl;
    }

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public restClient getRc() {
        return rc;
    }

    public void setRc(restClient rc) {
        this.rc = rc;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getArea_id() {
        return areaid;
    }

    public void setArea_id(String areaid) {
        this.areaid = areaid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getSelectedCityId() {
        return selectedCityId;
    }

    public void setSelectedCityId(Integer selectedCityId) {
        this.selectedCityId = selectedCityId;
    }

    public Collection<TblUser> getGetAllUser() {
        res = rc.getAllUsers_XML(Response.class);
        getAllUser = res.readEntity(ggetAllUser);
        return getAllUser;
    }

    public void setGetAllUser(Collection<TblUser> getAllUser) {
        this.getAllUser = getAllUser;
    }

    public GenericType<Collection<TblUser>> getGgetAllUser() {
        return ggetAllUser;
    }

    public void setGgetAllUser(GenericType<Collection<TblUser>> ggetAllUser) {
        this.ggetAllUser = ggetAllUser;
    }

    

    
   
    /**
     * Creates a new instance of regManagedBean
     */
    public regManagedBean() {
        System.out.println("Hello RegManagedBean ");
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

        String token = "";
        rc = new restClient(token);
//        token = request.getSession().getAttribute("token").toString();
        getAllUser = new ArrayList<>();
        ggetAllUser = new GenericType<Collection<TblUser>>() {
        };
    }
    
    public String addUser() {


//        rc.addUser(username, password, firstname, lastname, phone, areaid, address);
        System.out.println("username: "+ username );
        System.out.println("password: "+ password);
        System.out.println("firstname: "+ firstname);
        System.out.println("lastname: " +lastname);
        System.out.println("phone: "+ phone);
        System.out.println("areaid: "+ areaid);
        System.out.println("address:" +address);
        System.out.println("record inserted...!!!");
        return "index";
        
    }
}
