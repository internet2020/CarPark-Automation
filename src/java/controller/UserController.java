package controller;

import dao.UserDAO;
import entity.User;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
/**
 *
 * @author Alperen
 */
@Named
@SessionScoped
public class UserController implements Serializable {

    private UserDAO userDao;
    private List<User> ulist;
    private User user;

    @Inject
    private CityController cityController;
    @Inject
    private CountryController countryController;
    @Inject
    private CarparkController carparkController;
    @Inject
    private PrivilegeController privilegeController;

    /**
     * bul değişkeni search için diğerleri pagination için oluşturuldu.
     */
    private String bulUser = "";
    private int pageUser = 1;

    private int pageSize = 5;

    private int pageCountUser;
    private String bulCustomer = "";
    private int pageCustomer = 1;
    private int pageCountCustomer;

    public void geri(int type) {

        if (type == 1) {
            //User.xhtml için geri methodu
            if (this.pageUser == 1) {
                if (this.getPageCountUser() != 0) {
                    this.pageUser = this.getPageCountUser();
                }
            } else {
                this.pageUser--;
            }
        } else if (type == 2) {
            //Customer.xhtml için geri methodu
            if (this.pageCustomer == 1) {
                if (this.getPageCountCustomer() != 0) {
                    this.pageCustomer = this.getPageCountCustomer();
                }
            } else {
                this.pageCustomer--;
            }
        }

    }

    public void ileri(int type) {
        if (type == 1) {
            //User.xhtml için ileri methodu
            if (this.pageUser == this.getPageCountUser() || this.getPageCountUser() == 0) {
                this.pageUser = 1;
            } else {
                this.pageUser++;
            }
        } else if (type == 2) {
            //Customer.xhtml için ileri methodu
            if (this.pageCustomer == this.getPageCountCustomer() || this.getPageCountCustomer() == 0) {
                this.pageCustomer = 1;
            } else {
                this.pageCustomer++;
            }
        }

    }

    public void ilk(int type) {
        if (type == 1) {
            this.pageUser = 1;
        } else if (type == 2) {
            this.pageCustomer = 1;
        }

    }

    public void son(int type) {

        if (type == 1) {
            if (this.getPageCountUser() != 0) {

                this.pageUser = this.getPageCountUser();
            }
        } else if (type == 2) {
            if (this.getPageCountCustomer() != 0) {

                this.pageCustomer = this.getPageCountCustomer();
            }
        }

    }

    public void updateForm(User user) {
        this.user = user;
    }

    public void clearForm() {
        this.user = new User();
    }

    public void createStaff() {
        this.user.setUser_type(1);    //1 personel,2 müşteri
        this.getUserDao().insert(this.user);
        this.clearForm();
    }

    public void createCustomer() {
        this.user.setUser_type(2); //1 personel,2 müşteri
        this.getUserDao().insert(this.user);
        this.clearForm();
    }

    public void deleteConfirm(User user) {
        this.user = user;
    }

    public void delete() {
        this.getUserDao().delete(this.user);
        this.clearForm();
    }

    public void update() {
        this.getUserDao().update(this.user);
        this.clearForm();
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

    public List<User> getUlist(int type) {

        if (type == 1) {
            this.ulist = this.getUserDao().findAll(this.bulUser, this.pageUser, this.pageSize, type);
        } else if (type == 2) {
            this.ulist = this.getUserDao().findAll(this.bulCustomer, this.pageCustomer, this.pageSize, type);
        }

        return ulist;
    }

    public void setUlist(List<User> ulist) {
        this.ulist = ulist;
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

    public CityController getCityController() {
        return cityController;
    }

    public void setCityController(CityController cityController) {
        this.cityController = cityController;
    }

    public CountryController getCountryController() {
        return countryController;
    }

    public void setCountryController(CountryController countryController) {
        this.countryController = countryController;
    }

    public CarparkController getCarparkController() {
        return carparkController;
    }

    public void setCarparkController(CarparkController carparkController) {
        this.carparkController = carparkController;
    }

    public PrivilegeController getPrivilegeController() {
        return privilegeController;
    }

    public String getBulUser() {
        return bulUser;
    }

    public void setBulUser(String bulUser) {
        this.bulUser = bulUser;
    }

    public int getPageUser() {
        return pageUser;
    }

    public void setPageUser(int pageUser) {
        this.pageUser = pageUser;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCountUser() {
        this.pageCountUser = (int) Math.ceil(this.getUserDao().count(1) / (double) pageSize);
        return pageCountUser;
    }

    public void setPageCountUser(int pageCountUser) {
        this.pageCountUser = pageCountUser;
    }

    //Customer için
    public String getBulCustomer() {
        return bulCustomer;
    }

    public void setBulCustomer(String bulCustomer) {
        this.bulCustomer = bulCustomer;
    }

    public int getPageCustomer() {
        return pageCustomer;
    }

    public void setPageCustomer(int pageCustomer) {
        this.pageCustomer = pageCustomer;
    }

    public int getPageCountCustomer() {
        this.pageCountCustomer = (int) Math.ceil(this.getUserDao().count(2) / (double) pageSize);
        return pageCountCustomer;
    }

    public void setPageCountCustomer(int pageCountCustomer) {
        this.pageCountCustomer = pageCountCustomer;
    }
}
