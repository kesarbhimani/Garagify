/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.TblArea;
import entity.TblCar;
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
import java.util.HashSet;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

/**
 *
 * @author Parth Computer
 */
@Stateless
public class userBean implements userBeanLocal {

    @PersistenceContext(unitName = "GaragifyJSFPU")
    EntityManager em;
    Pbkdf2PasswordHashImpl pb = new Pbkdf2PasswordHashImpl();

    
    @Override
    public Collection<TblUser> getAllUserNames() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<TblUser> users = em.createNamedQuery("TblUser.findAll").getResultList();
        return users;
    }

    @Override
    public void addUser(String username, String Newpassword, String firstname, String lastname, String phone, int areaid, String address) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String Pass=pb.generate(Newpassword.toCharArray());  
        TblArea area = em.find(TblArea.class, areaid);
        TblUser u = new TblUser();
        u.setUserName(username);
        u.setPassword(Pass);
        u.setFirstName(firstname);
        u.setLastName(lastname);
        u.setEmail(username);
        u.setPhoneNo(phone);
        u.setAreaId(area);
        u.setAddress(address);
        java.util.Date date=new java.util.Date();
        java.sql.Date sqlDate=new java.sql.Date(date.getTime());
        u.setJoinningDate(sqlDate);
        u.setStatus("Active");
        Collection<TblUser> a = area.getTblUserCollection();
        a.add(u);
        area.setTblUserCollection(a);
        em.persist(u);
        em.merge(area);
        
        TblGroup g = new TblGroup();
        g.setTblGroupPK(new TblGroupPK("user", username));
//        g.setTblGroupPK(new TblGroupPK("admin", username));
        g.setTblUser(u);
        em.persist(g);
        System.out.println("User added...");
    }

    @Override
    public void updateUser(String username, String firstname, String lastname, String phone,  String areaid, String address) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TblUser user = em.find(TblUser.class, username);
        TblArea area = em.find(TblArea.class, areaid);
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setPhoneNo(phone);
        user.setAreaId(area);
        user.setAddress(address);
        em.merge(user);
        em.merge(area);
        System.out.println("User updated...");
        
    }

    @Override
    public void deleteUser(String username) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TblUser user = em.find(TblUser.class, username);
        user.setStatus("Deleted");
        System.out.println("User deleted...");
    }

    @Override
    public Collection<TblServiceType> getAllServiceTypes() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<TblServiceType> stype = em.createNamedQuery("TblServiceType.findAll").getResultList();
        return stype;
        
    }

    @Override
    public void addFeedback(String username, String feedback) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TblUser u = em.find(TblUser.class, username);
        TblFeedback f = new TblFeedback();
        f.setUserName(u);
        f.setFeedback(feedback);
        Collection<TblFeedback> fusers = u.getTblFeedbackCollection();
        fusers.add(f);
        u.setTblFeedbackCollection(fusers);
        em.persist(f);
        em.merge(username);
        System.out.println("Feedback added...");
    }

    @Override
    public void updateFeedback(int feedback_id, String feedback) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TblFeedback f = em.find(TblFeedback.class, feedback_id);
        f.setFeedback(feedback);
        em.merge(f);
        System.out.println("Feedback updated...");
    }

    @Override
    public void removeFeedback(int feedback_id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TblFeedback f = em.find(TblFeedback.class, feedback_id);
        em.remove(f);
        System.out.println("Feedback removed...");
    }

    @Override
    public Collection<TblFeedback> getAllFeeback() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<TblFeedback> f = em.createNamedQuery("TblFeedback.findAll").getResultList();
        return f;
    }

    @Override
    public void addRating(String username, int rating) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TblUser u = em.find(TblUser.class, username);
        TblRating r = new TblRating();
        r.setUserName(u);
        r.setRating(rating);
        Collection<TblRating> rusers = u.getTblRatingCollection();
        rusers.add(r);
        u.setTblRatingCollection(rusers);
        em.persist(r);
        em.merge(username);
        System.out.println("Rating added...");
    }

    @Override
    public void updateRating(int rating_id, int rating) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TblRating r = em.find(TblRating.class, rating_id);
        r.setRating(rating);
        em.merge(r);
        System.out.println("Rating updated...");
    }

    @Override
    public void removeRating(int rating_id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TblRating r = em.find(TblRating.class, rating_id);
        em.remove(r);
        System.out.println("Rating removed...");
    }

    @Override
    public Collection<TblRating> getAllRating() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<TblRating> r = em.createNamedQuery("TblRating.findAll").getResultList();
        return r;
    }

    @Override
    public void addCar(String username, int model_id, String fuel_name, String color_name, String car_no) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TblUser u = em.find(TblUser.class, username);
        TblModel m = em.find(TblModel.class, model_id);
        TblCar car = new TblCar();
        car.setUserName(u);
        car.setModelId(m);
        car.setFuelName(fuel_name);
        car.setColorName(color_name);
        car.setCarNo(car_no);
        Collection<TblCar> uc = u.getTblCarCollection();
        Collection<TblCar> model = m.getTblCarCollection();
        uc.add(car);
        model.add(car);
        u.setTblCarCollection(uc);
        m.setTblCarCollection(model);
        em.persist(car);
        em.merge(u);
        em.merge(m);
        System.out.println("Car added...");
    }

    @Override
    public void updateCar(int car_id, int model_id, String fuel_name, String color_name, String car_no) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TblCar car = em.find(TblCar.class, car_id);
        TblModel m = em.find(TblModel.class, model_id);
        car.setModelId(m);
        car.setFuelName(fuel_name);
        car.setColorName(color_name);
        car.setCarNo(car_no);
        em.merge(car);
        em.merge(m);
        System.out.println("Car updated...");
    }

    @Override
    public void removeCar(int car_id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TblCar car = em.find(TblCar.class, car_id);
        em.remove(car);
        System.out.println("Car removed...");
    }

    @Override
    public Collection<TblCar> getCarByUsername(String username) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TblUser u = em.find(TblUser.class, username);
        Collection<TblCar> cars = u.getTblCarCollection();
        return cars;
    }

    @Override
    public void addToTblService(String username, int car_id, Collection<Integer> scartid) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        TblUser user = em.find(TblUser.class, username);
        TblCar car = em.find(TblCar.class, car_id);
        TblServices services = new TblServices();
       
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));

       char[] dateString = now.toString().toCharArray();
       char[] charArray = new char[17];
       int j=0;
       for(int i=0;i<dateString.length;i++){  
           if(i==4||i==7||i==10||i==13||i==16||i==19)
             continue;
           charArray[j++]=dateString[i];
        }
       
        String serviceId = new String(charArray);
        services.setServiceId(serviceId);
        services.setUserName(user);        
//        services.setTotal(total);
        java.util.Date date=new java.util.Date();
        java.sql.Date sqlDate=new java.sql.Date(date.getTime());
        services.setDate(sqlDate);
        
        services.setCarId(car);
        services.setStatus("Pending");
     
        Collection<TblServices> users = user.getTblServicesCollection();
        Collection<TblServices>  cars = car.getTblServicesCollection();
        users.add(services);
        cars.add(services);
        user.setTblServicesCollection(users);
        car.setTblServicesCollection(cars);
        em.persist(services);
        em.merge(user);
        em.merge(car);
       
        float total = 0;
        
        
         for(Integer sid : scartid)
         {
        
            TblServiceCart cartItem = em.find(TblServiceCart.class, sid);        
            TblServices service_id = em.find(TblServices.class, serviceId);
        
            TblServiceDetail sdetail = new TblServiceDetail();
            sdetail.setServiceId(service_id);
            sdetail.setStatus("Pending");
            sdetail.setServiceTypeId(cartItem.getServiceTypeId());    
            
            total = total + sdetail.getServiceTypeId().getPrice();
            
            Collection<TblServiceDetail> sdservices = service_id.getTblServiceDetailCollection();
            Collection<TblServiceDetail> sdtypes = cartItem.getServiceTypeId().getTblServiceDetailCollection();
            sdservices.add(sdetail);
            sdtypes.add(sdetail);
            service_id.setTblServiceDetailCollection(sdservices);
            cartItem.getServiceTypeId().setTblServiceDetailCollection(sdtypes);
            em.persist(sdetail);         
            em.merge(cartItem);
        }
         
        services.setTotal(total);
        em.persist(services);
//        em.persist(sdetail);
    }

    @Override
    public void addToCart(String username, int service_type_id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TblUser u = em.find(TblUser.class, username);
        TblServiceType stype = em.find(TblServiceType.class, service_type_id);
        TblServiceCart scart = new TblServiceCart();
        scart.setUserName(u);
        scart.setServiceTypeId(stype);
        Collection<TblServiceCart> userCart = u.getTblServiceCartCollection();
        Collection<TblServiceCart> stypeCart = stype.getTblServiceCartCollection();
        userCart.add(scart);
        stypeCart.add(scart);
        u.setTblServiceCartCollection(userCart);
        stype.setTblServiceCartCollection(stypeCart);
        em.persist(scart);
        em.merge(u);
        em.merge(stype);
    }

    @Override
    public void removeServiceFromCart(int scart_id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TblServiceCart scart = em.find(TblServiceCart.class, scart_id);
        em.remove(scart);
        System.out.println("Service removed from cart...");
    }

    @Override
    public Collection<TblServiceCart> getCartItemsByUsername(String username) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TblUser u = em.find(TblUser.class, username);
        Collection<TblServiceCart> scart = u.getTblServiceCartCollection();
        return scart;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
