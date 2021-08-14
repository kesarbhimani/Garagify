/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.TblCar;
import entity.TblFeedback;
import entity.TblRating;
import entity.TblServiceCart;
import entity.TblServiceType;
import entity.TblUser;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Parth Computer
 */
@Local
public interface userBeanLocal {
    
    //TblUser
    
    Collection<TblUser> getAllUserNames();
    
    public void addUser(String username, String Newpassword, String firstname, String lastname, String phone, int areaid, String address);// add in bean Status and joinningDate
    
    public void updateUser(String username, String firstname, String lastname, String phone,  String areaid, String address);
    
    public void deleteUser(String username);
    
    
    //TblService_type
    
    Collection<TblServiceType> getAllServiceTypes();
    
    //TblFeedBack
    
    public void addFeedback(String username, String feedback);
    
    public void updateFeedback(int feedback_id, String feedback);
    
    public void removeFeedback(int feedback_id);
    
    Collection<TblFeedback> getAllFeeback();
    
    
    //TblRating
    
    public void addRating(String username, int rating);
    
    public void updateRating(int rating_id, int rating);
    
    public void removeRating(int rating_id);
    
    Collection<TblRating> getAllRating();
    
    
    //TblCar
    
    public void addCar(String username, int model_id, String fuel_name, String color_name, String car_no);
    
    public void updateCar(int car_id, int model_id, String fuel_name, String color_name, String car_no);
    
    public void removeCar(int car_id);
    
    Collection<TblCar> getCarByUsername(String username);
    
    
    //TblServices and TblServiceDetail
    
    public void addToTblService(String username, int car_id, Collection<Integer> scartid);
    
    //TblServiceCart
    
    public void addToCart(String username, int service_type_id);
    
    public void removeServiceFromCart(int scart_id);
    
    Collection<TblServiceCart> getCartItemsByUsername(String username);
    
    
    
    
}
