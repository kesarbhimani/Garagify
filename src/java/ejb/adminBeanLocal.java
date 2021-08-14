/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.TblArea;
import entity.TblCity;
import entity.TblFeedback;
import entity.TblRating;
import entity.TblServiceDetail;
import entity.TblServiceType;
import entity.TblServices;
import entity.TblUser;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Parth Computer
 */
@Local
public interface adminBeanLocal {
    
    //TblUser
    
    Collection<TblUser> getAllUsersNames();
    
    Collection<TblUser> getUsersByFirstName(String first_name);
    
    Collection<TblUser> getUsersByLastName(String last_name);
    
    Collection<TblUser> getUsersByAreaId(String area_id);
    
    Collection<TblUser> getUsersByAreaName(String area_name);
    
    Collection<TblUser> getActiveUsers();

    Collection<TblUser> getDeletedUsers();
    
    Collection<TblUser> getUsersJoinedToday();
        
    
    //TblCity
    
    public void addCity(String city_name);
    
    public void updateCity(int city_id, String city_name);
    
    public void removeCity(int city_id);
    
    Collection<TblCity> getAllCity();
    
    
    
    //TblArea
    
    public void addArea(String area_name, int city_id);
    
    public void updateArea(int area_id, String area_name, int city_id);
    
    public void removeArea(int area_id);
    
    Collection<TblArea> getAllArea();
    
    Collection<TblArea> getAreaByCityId(int city_id);
    
    
    //TblServiceType
    
    public void addServiceType(String service_type, String image, String description, float price);
    
    public void updateServiceType(int service_type_id, String service_type, String image, String description, float price);
    
    public void removeServiceType(int service_type_id);
    
    Collection<TblServiceType> getAllServiceType();
    
    
    //TblFeedback
    
    Collection<TblFeedback> getAllFeedback();
    
    
    //TblRating
    
    Collection<TblRating> getAllRating();
    
    
    //TblServices
    
    Collection<TblServices> getAllServices();
    
    Collection<TblServices> getAllPendingServices();
    
    Collection<TblServices> getTodaysServices();
    
    
    //TblServiceDetail
    
    Collection<TblServiceDetail> getAllServiceDetails();
    
    Collection<TblServiceDetail> getAllServiceDetailsByServiceId(String service_id);
    
    public void updateStatusOfServiceDetail(int sdetail_id);
       
}
