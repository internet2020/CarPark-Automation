package dao;

import entity.Privilege;
import entity.User;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alperen
 */
public class UserDAO extends SuperDAO {

    PreparedStatement pst = null;
    ResultSet rs = null;

    private CountryDAO countryDao;
    private CityDAO cityDao;
    private CarparkDAO carparkDao;
    private PrivilegeDAO privilegeDao;

    public void insert(User user) {
         user.setParticipation_date(LocalDateTime.now().toLocalDate().toString());
        switch (user.getUser_type()) {

            case 1:
                //Personel ekler
                try {
                    pst = this.getConnection().prepareStatement("INSERT INTO  User(user_name,user_surname,user_username,user_password,user_mail,"
                            + "user_phone,user_gender,user_age,user_staff_salary,user_city_id,user_country_id,user_staff_carpark_id,user_address,user_type,participation_date) "
                            + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);

                    pst.setString(1, user.getUser_name());
                    pst.setString(2, user.getUser_surname());
                    pst.setString(3, user.getUser_username());
                    pst.setString(4, user.getUser_password());
                    pst.setString(5, user.getUser_mail());
                    pst.setString(6, user.getPhone());
                    pst.setString(7, user.getUser_gender());
                    pst.setInt(8, user.getUser_age());
                    pst.setDouble(9, user.getUser_staff_salary());
                    pst.setInt(10, user.getCity().getCity_id());
                    pst.setInt(11, user.getCountry().getCountry_id());
                    pst.setInt(12, user.getStaff_carpark().getCarpark_id());
                    pst.setString(13, user.getUser_address());
                    pst.setInt(14, user.getUser_type());
                    pst.setString(15, user.getParticipation_date());

                    pst.executeUpdate();

                    int u_id = 0;
                    ResultSet gk = pst.getGeneratedKeys();

                    if (gk.next()) {
                        u_id = gk.getInt(1);
                    }

                    for (Privilege p : user.getUserPrivileges()) {

                        pst = this.getConnection().prepareStatement("INSERT INTO  user_privilege (user_id,privilege_id) values (?,?)");
                        pst.setInt(1, u_id);
                        pst.setInt(2, p.getPrivilege_id());
                        pst.executeUpdate();
                    }

                } catch (SQLException ex) {
                    System.out.println("UserDAO HATA(INSERTSTAFF):" + ex.getMessage());
                }
                break;
            case 2:
                //Müşteri ekler!

                try {
                    pst = this.getConnection().prepareStatement("INSERT INTO User(user_name,user_surname,user_username,user_password,user_mail,"
                            + "user_phone,user_gender,user_age,user_city_id,user_country_id,user_address,user_type) "
                            + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");

                    pst.setString(1, user.getUser_name());
                    pst.setString(2, user.getUser_surname());
                    pst.setString(3, user.getUser_username());
                    pst.setString(4, user.getUser_password());
                    pst.setString(5, user.getUser_mail());
                    pst.setString(6, user.getPhone());
                    pst.setString(7, user.getUser_gender());
                    pst.setInt(8, user.getUser_age());
                    pst.setInt(9, user.getCity().getCity_id());
                    pst.setInt(10, user.getCountry().getCountry_id());
                    pst.setString(11, user.getUser_address());
                    pst.setInt(12, user.getUser_type());

                    pst.executeUpdate();
                    pst.close();

                } catch (SQLException ex) {
                    System.out.println("UserDAO HATA(INSERTCUSTOMER):" + ex.getMessage());
                }
                break;
            default:
                System.out.println("User type gönderim hatası! UserDao(INSERT)");
                break;
        }

    }

    public void delete(User user) {

        try {
            pst = this.getConnection().prepareStatement("DELETE FROM User WHERE user_id=?");
            pst.setInt(1, user.getUser_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println(" UserDAO HATA(Delete): " + ex.getMessage());
        }
    }

    public int count(int type) {
        int count = 0;
        try {
            pst = this.getConnection().prepareStatement("SELECT count(user_id) as user_count FROM User WHERE user_type=? ");
            pst.setInt(1, type);
            rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("user_count");

        } catch (SQLException ex) {
            System.out.println("UserDAO HATA(Count):" + ex.getMessage());
        }

        return count;
    }

    public List<User> findAll(String deger, int page, int pageSize, int type) {
        List<User> ulist = new ArrayList();
        int start = (page - 1) * pageSize;

        try {
            pst = this.getConnection().prepareStatement("SELECT * FROM User WHERE user_type=? AND user_name LIKE ? ORDER BY user_id asc LIMIT ?,? ");
            pst.setInt(1, type);
            pst.setString(2, "%" + deger + "%");
            pst.setInt(3, start);
            pst.setInt(4, pageSize);

            rs = pst.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setUser_id(rs.getInt("user_id"));
                u.setUser_name(rs.getString("user_name"));
                u.setUser_surname(rs.getString("user_surname"));
                u.setUser_username(rs.getString("user_username"));
                u.setUser_password(rs.getString("user_password"));
                u.setUser_mail(rs.getString("user_mail"));
                u.setPhone(rs.getString("user_phone"));
                u.setUser_gender(rs.getString("user_gender"));
                u.setUser_age(rs.getInt("user_age"));
                u.setUser_staff_salary(rs.getDouble("user_staff_salary"));
                u.setCity(this.getCityDao().find(rs.getInt("user_city_id")));
                u.setCountry(this.getCountryDao().find(rs.getInt("user_country_id")));
                u.setStaff_carpark(this.getCarparkDao().find(rs.getInt("user_staff_carpark_id")));
                u.setUser_address(rs.getString("user_address"));
                u.setUser_type(rs.getInt("user_type"));
                u.setParticipation_date(rs.getDate("participation_date").toString());
                u.setUserPrivileges(this.getPrivilegeDao().getUserPrivileges(rs.getInt("user_id")));
                ulist.add(u);
            }
        } catch (SQLException ex) {
            System.out.println("UserDAO HATA(READ):" + ex.getMessage());
        }
        return ulist;
    }

    public void update(User user) {

        switch (user.getUser_type()) {
            case 1:   //Personel
                try {
                    pst = this.getConnection().prepareStatement("UPDATE User SET user_name=?,user_surname=?,user_username=?,user_password=?,user_mail=?,"
                            + "user_phone=?,user_gender=?,user_age=?,user_staff_salary=?,user_city_id=?,user_country_id=?,user_staff_carpark_id=?,user_address=?,user_type=?"
                            + " where user_id=?");
                    pst.setString(1, user.getUser_name());
                    pst.setString(2, user.getUser_surname());
                    pst.setString(3, user.getUser_username());
                    pst.setString(4, user.getUser_password());
                    pst.setString(5, user.getUser_mail());
                    pst.setString(6, user.getPhone());
                    pst.setString(7, user.getUser_gender());
                    pst.setInt(8, user.getUser_age());
                    pst.setDouble(9, user.getUser_staff_salary());
                    pst.setInt(10, user.getCity().getCity_id());
                    pst.setInt(11, user.getCountry().getCountry_id());
                    pst.setInt(12, user.getStaff_carpark().getCarpark_id());
                    pst.setString(13, user.getUser_address());
                    pst.setInt(14, user.getUser_type());
                    pst.setInt(15, user.getUser_id());

                    pst.executeUpdate();
                    //Önce 3. tablodan servisleri siliyoruz.
                    pst = this.getConnection().prepareStatement("DELETE FROM user_privilege where user_id=?");
                    pst.setInt(1, user.getUser_id());
                    pst.executeUpdate();
                    //Burada tekrar ekliyoruz.
                    for (Privilege p : user.getUserPrivileges()) {
                        pst = this.getConnection().prepareStatement("INSERT INTO  user_privilege (user_id,privilege_id) values (?,?)");
                        pst.setInt(1, user.getUser_id());
                        pst.setInt(2, p.getPrivilege_id());
                        pst.executeUpdate();
                    }

                } catch (SQLException ex) {
                    System.out.println("UserDAO HATA(UpdateSTAFF): " + ex.getMessage());
                }
                break;
            case 2:     //Müşteri

                try {
                    pst = this.getConnection().prepareStatement("UPDATE User SET user_name=?,user_surname=?,user_username=?,user_password=?,user_mail=?,"
                            + "user_phone=?,user_gender=?,user_age=?,user_city_id=?,user_country_id=?,user_address=?"
                            + " where user_id=?");
                    pst.setString(1, user.getUser_name());
                    pst.setString(2, user.getUser_surname());
                    pst.setString(3, user.getUser_username());
                    pst.setString(4, user.getUser_password());
                    pst.setString(5, user.getUser_mail());
                    pst.setString(6, user.getPhone());
                    pst.setString(7, user.getUser_gender());
                    pst.setInt(8, user.getUser_age());
                    pst.setInt(9, user.getCity().getCity_id());
                    pst.setInt(10, user.getCountry().getCountry_id());
                    pst.setString(11, user.getUser_address());
                    pst.setInt(12, user.getUser_id());

                    pst.executeUpdate();
                    pst.close();

                } catch (SQLException ex) {
                    System.out.println("UserDAO HATA(UpdateCUSTOMER): " + ex.getMessage());
                }
                break;
            default:
                System.out.println("User type gönderim hatası! UserDao(update)");
                break;
        }

    }

    public User find(int id) {
        User u = null;
        try {
            pst = this.getConnection().prepareStatement("SELECT * FROM User WHERE user_id=?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            rs.next();
            u = new User();
            u.setUser_id(rs.getInt("user_id"));
            u.setUser_name(rs.getString("user_name"));
            u.setUser_surname(rs.getString("user_surname"));
            u.setUser_username(rs.getString("user_username"));
            u.setUser_password(rs.getString("user_password"));
            u.setUser_mail(rs.getString("user_mail"));
            u.setPhone(rs.getString("user_phone"));
            u.setUser_gender(rs.getString("user_gender"));
            u.setUser_age(rs.getInt("user_age"));
            u.setUser_staff_salary(rs.getDouble("user_staff_salary"));
            u.setCity(this.getCityDao().find(rs.getInt("user_city_id")));
            u.setCountry(this.getCountryDao().find(rs.getInt("user_country_id")));
            u.setStaff_carpark(this.getCarparkDao().find(rs.getInt("user_staff_carpark_id")));
            u.setUser_address(rs.getString("user_address"));
            u.setUser_type(rs.getInt("user_type"));
            u.setParticipation_date(rs.getDate("participation_date").toString());
            u.setUserPrivileges(this.getPrivilegeDao().getUserPrivileges(rs.getInt("user_id")));

        } catch (SQLException ex) {
            System.out.println("UserDAO HATA(FİND) :" + ex.getMessage());
        }
        return u;
    }

    // login kontrolü  type=1 personel ,2= müşteri
    public User loginControl(User user, int type) {
        User u = null;

        try {
            pst = this.getConnection().prepareStatement("SELECT * FROM User WHERE user_username=? AND user_password=? AND user_type=? ");
            pst.setString(1, user.getUser_username());
            pst.setString(2, user.getUser_password());
            pst.setInt(3, type == 1 ? 1 : 2);
            rs = pst.executeQuery();

            if (rs.next()) {

                u = new User();
                u.setUser_id(rs.getInt("user_id"));
                u.setUser_name(rs.getString("user_name"));
                u.setUser_surname(rs.getString("user_surname"));
                u.setUser_username(rs.getString("user_username"));
                u.setUser_password(rs.getString("user_password"));
                u.setUser_mail(rs.getString("user_mail"));
                u.setPhone(rs.getString("user_phone"));
                u.setUser_gender(rs.getString("user_gender"));
                u.setUser_age(rs.getInt("user_age"));
                u.setUser_staff_salary(rs.getDouble("user_staff_salary"));
                u.setCity(this.getCityDao().find(rs.getInt("user_city_id")));
                u.setCountry(this.getCountryDao().find(rs.getInt("user_country_id")));
                u.setStaff_carpark(this.getCarparkDao().find(rs.getInt("user_staff_carpark_id")));
                u.setUser_address(rs.getString("user_address"));
                u.setUser_type(rs.getInt("user_type"));
                u.setParticipation_date(rs.getDate("participation_date").toString());
                u.setUserPrivileges(this.getPrivilegeDao().getUserPrivileges(rs.getInt("user_id")));
            }

        } catch (SQLException ex) {
            System.out.println(" UserDAO Hata(isAdmin?) :" + ex.getMessage());
        }

        return u;
    }

    public CountryDAO getCountryDao() {
        if (this.countryDao == null) {
            this.countryDao = new CountryDAO();
        }
        return countryDao;
    }

    public CityDAO getCityDao() {
        if (this.cityDao == null) {
            this.cityDao = new CityDAO();
        }
        return cityDao;
    }

    public CarparkDAO getCarparkDao() {
        if (this.carparkDao == null) {
            this.carparkDao = new CarparkDAO();
        }
        return carparkDao;
    }

    public PrivilegeDAO getPrivilegeDao() {
        if (this.privilegeDao == null) {
            this.privilegeDao = new PrivilegeDAO();
        }
        return privilegeDao;
    }

    public boolean isStaff(User u) {

        try {
            pst = this.getConnection().prepareStatement("SELECT * FROM User WHERE user_username=? AND user_password=? ");
            pst.setString(1, u.getUser_username());
            pst.setString(2, u.getUser_password());

            rs = pst.executeQuery();

            if (rs.next()) {
                if (rs.getInt("user_type") == 1) {
                    return true;

                }
            }
        } catch (SQLException ex) {
            System.out.println(" UserDAO Hata(isAdmin?) :" + ex.getMessage());
        }
        return false;
    }

}
