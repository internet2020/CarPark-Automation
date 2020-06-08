package controller;

import dao.UserDAO;
import entity.User;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("loginController")
@SessionScoped
public class LoginController implements Serializable {

    private User user;
    private UserDAO userDao;
    
    

    /* YetkiKontrol methodu ile;
 Back_end tarafını seviyelendirdik.Back_end template klasörüne girin ordaki layout'un içindeki butonları rendered ile gizlediğimizi görebilirsiniz
     */
 /* public boolean yetkiKontrol() {
        Kullanici k = (Kullanici) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().getOrDefault("valid_user", null);

        for (Yetki y : k.getKullaniciYetkileri()) {
            if (y.getYetki_turu().equalsIgnoreCase("Admin")) {
                return true;
            }
        }
        return false;
    }
     */
    public String loginAdmin() {
       
        User u = this.getUserDao().loginControl(this.user,1);
        
        if (u == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hatalı Kullanıcı adı veya şifre!!"));
            return "/front-end-ortak/adminlogin";
        } else {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user",u);
            return "/back_end/admin?faces-redirect=true";
        }
    }
    
     public String loginCustomer() {
       
        User u = this.getUserDao().loginControl(this.user,2);
        
        if (u == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hatalı Kullanıcı adı veya şifre!!"));
            return "/front-end-ortak/customerlogin";
        } else {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user",u);
            return "/front-end-customer/customer?faces-redirect=true";
        }
    }

    public User getUser() {
        if (this.user == null) {
            this.user = new User();
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserDAO getUserDao() {
        if (this.userDao == null) {
            this.userDao = new UserDAO();
        }
        return userDao;
    }

    public void setUserDao(UserDAO userDao) {
        this.userDao = userDao;
    }

}
