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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Parth Computer
 */
@Stateless
public class adminBean implements adminBeanLocal {

    @PersistenceContext(unitName = "GaragifyJSFPU")
    EntityManager em;
    
    @Override
    public Collection<TblUser> getAllUsersNames() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<TblUser> users = em.createNamedQuery("TblUser.findAll").getResultList();
        return users;
    }


    @Override
    public Collection<TblUser> getUsersByFirstName(String first_name) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<TblUser> users = em.createNamedQuery("TblUser.findByFirstName").setParameter("firstName", first_name).getResultList();
        return users;
    }

    @Override
    public Collection<TblUser> getUsersByLastName(String last_name) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<TblUser> users = em.createNamedQuery("TblUser.findByLastName").setParameter("lastName", last_name).getResultList();
        return users;
    }

    @Override
    public Collection<TblUser> getUsersByAreaId(String area_id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.        
        TblArea a = em.find(TblArea.class, area_id);
        Collection<TblUser> users = a.getTblUserCollection();
        return users;
    }

    @Override
    public Collection<TblUser> getUsersByAreaName(String area_name) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TblArea a = em.find(TblArea.class, area_name);
        Collection<TblUser> users = a.getTblUserCollection();
        return users;
    }

    @Override
    public Collection<TblUser> getActiveUsers() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<TblUser> users = em.createNamedQuery("TblUser.findByStatus").setParameter("status", "Active").getResultList();
        return users;
    }

    @Override
    public Collection<TblUser> getDeletedUsers() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<TblUser> users = em.createNamedQuery("TblUser.findByStatus").setParameter("status", "Deleted").getResultList();
        return users;
    }

    @Override
    public Collection<TblUser> getUsersJoinedToday() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        java.util.Date date=new java.util.Date();
        java.sql.Date sqlDate=new java.sql.Date(date.getTime());
        Collection<TblUser> users = em.createNamedQuery("TblUser.findByJoinningDate").setParameter("joiningDate", sqlDate).getResultList();
        return users;
    }

    @Override
    public void addCity(String city_name) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TblCity c = new TblCity();
        c.setCityName(city_name);
        em.persist(c);
        System.out.println("City added...");
    }

    @Override
    public void updateCity(int city_id, String city_name) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TblCity c = em.find(TblCity.class, city_id);
        c.setCityName(city_name);
        em.merge(c);
        System.out.println("City updated...");
    }

    @Override
    public void removeCity(int city_id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TblCity cities = em.find(TblCity.class, city_id);
        em.remove(cities);
        System.out.println("City removed...");
    }

    @Override
    public Collection<TblCity> getAllCity() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<TblCity> cities = em.createNamedQuery("TblCity.findAll").getResultList();
        return cities;
    }

    @Override
    public void addArea(String area_name, int city_id) {
//        throw new Unsu?pportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TblCity c = em.find(TblCity.class, city_id);
        TblArea a = new TblArea();
        a.setAreaName(area_name);
        a.setCityId(c);
        Collection<TblArea> areas = c.getTblAreaCollection();
        areas.add(a);
        c.setTblAreaCollection(areas);
        em.persist(a);
        em.merge(c);
        System.out.println("Area added...");
    }

    @Override
    public void updateArea(int area_id, String area_name, int city_id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TblArea a = em.find(TblArea.class, area_id);
        TblCity c = em.find(TblCity.class, city_id);
        a.setAreaName(area_name);
        a.setCityId(c);
        em.merge(a);
        em.merge(c);
        System.out.println("Area updated...");
    }

    @Override
    public void removeArea(int area_id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TblArea a = em.find(TblArea.class, area_id);
        em.remove(a);
        System.out.println("Area removed...");
    }

    @Override
    public Collection<TblArea> getAllArea() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<TblArea> areas = em.createNamedQuery("TblArea.findAll").getResultList();
        return areas;
    }

    @Override
    public Collection<TblArea> getAreaByCityId(int city_id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TblCity c = em.find(TblCity.class, city_id);
        Collection<TblArea> areas = c.getTblAreaCollection();
        return areas;
    }

    @Override
    public void addServiceType(String service_type, String image, String description, float price) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TblServiceType stype = new TblServiceType();
        stype.setServiceType(service_type);
        stype.setImage(image);
        stype.setDescription(description);
        stype.setPrice(price);
        em.persist(stype);
        System.out.println("ServiceType added...");
        
    }

    @Override
    public void updateServiceType(int service_type_id, String service_type, String image, String description, float price) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TblServiceType stype = em.find(TblServiceType.class, service_type_id);
        stype.setServiceType(service_type);
        stype.setImage(image);
        stype.setDescription(description);
        stype.setPrice(price);
        em.merge(stype);
        System.out.println("ServiceType updated...");
    }

    @Override
    public void removeServiceType(int service_type_id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TblServiceType stype = em.find(TblServiceType.class, service_type_id);
        em.remove(stype);
        System.out.println("ServiceTyped removed...");
    }

    @Override
    public Collection<TblServiceType> getAllServiceType() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<TblServiceType> stype = em.createNamedQuery("TblServiceType.findAll").getResultList();
        return stype;
    }

    @Override
    public Collection<TblFeedback> getAllFeedback() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<TblFeedback> feedbacks = em.createNamedQuery("TblFeedback.findAll").getResultList();
        return feedbacks;
    }

    @Override
    public Collection<TblRating> getAllRating() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<TblRating> ratings = em.createNamedQuery("TblRating.findAll").getResultList();
        return ratings;
    }

    @Override
    public Collection<TblServices> getAllServices() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<TblServices> services = em.createNamedQuery("TblServices.findAll").getResultList();
        return services; 
    }

    @Override
    public Collection<TblServices> getAllPendingServices() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<TblServices> services = em.createNamedQuery("TblServices.findByStatus").setParameter("status", "Pending").getResultList();
        return services; 
    }

    @Override
    public Collection<TblServices> getTodaysServices() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        java.util.Date date=new java.util.Date();
        java.sql.Date sqlDate=new java.sql.Date(date.getTime());
        Collection<TblServices> services = em.createNamedQuery("TblServices.findByDate").setParameter("date", sqlDate).getResultList();
        return services;
    }

    @Override
    public Collection<TblServiceDetail> getAllServiceDetails() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<TblServiceDetail> sdetails = em.createNamedQuery("TblServiceDetail.findAll").getResultList();
        return sdetails;
    }

    @Override
    public Collection<TblServiceDetail> getAllServiceDetailsByServiceId(String service_id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.               
        TblServices s = em.find(TblServices.class, service_id);
        Collection<TblServiceDetail> sdetails = s.getTblServiceDetailCollection();
        return sdetails;
        
        
    }

    @Override
    public void updateStatusOfServiceDetail(int sdetail_id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TblServiceDetail sd = em.find(TblServiceDetail.class, sdetail_id);
        if(sd.getStatus().equalsIgnoreCase("Pending"))
        {
            sd.setStatus("In Progress");
            em.merge(sd);
        }
        else if(sd.getStatus().equalsIgnoreCase("In Progress") )
        {
            sd.setStatus("Done");
            em.merge(sd);
        }    
        else
        {
            sd.setStatus("Done");
            em.merge(sd);
        }
        
        TblServices s = sd.getServiceId();
//        TblServices s = em.find(TblServices.class, service_id);
        Collection<TblServiceDetail> servicedetails = s.getTblServiceDetailCollection();
        
        Integer totalServices = servicedetails.size();
        Integer doneCounter=0;
        Integer inProgressCounter=0;
        
        for(TblServiceDetail sds : servicedetails)
        {
            if(sds.getStatus().equalsIgnoreCase("Done"))
                doneCounter++;
            if(sds.getStatus().equalsIgnoreCase("In progress"))
                inProgressCounter++;
            if(inProgressCounter>0 && doneCounter!=totalServices)
                s.setStatus("In progress");
            else if(doneCounter==totalServices)
                s.setStatus("Done");
            
            System.out.println("Service status updated...");
        }
    }

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
