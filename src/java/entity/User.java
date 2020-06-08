package entity;

import java.util.List;
import java.util.Objects;
/**
 *
 * @author Alperen
 */
public class User {

    private int user_id;
    private String user_name;
    private String user_surname;
    private String user_username;
    private String user_password;
    private String user_mail;
    private String phone;
    private String user_gender;
    private int user_age;
    private Double user_staff_salary;
    private City city;
    private Country country;
    private Carpark staff_carpark;
    private String user_address;
    private String participation_date; //Veritabanından gelen date datasını stringe dönüştürüyoruz DAO'da.Çünkü front-end'e date doğru gelmiyor
    private int user_type;

    private List<Privilege> userPrivileges;

    public User() {
    }

    public User(int user_id, String user_name, String user_surname, String user_username, String user_password, String user_mail, String phone, String user_gender, int user_age, Double user_staff_salary, City city, Country country, Carpark staff_carpark, String user_address, String user_participationDate, int user_type) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_surname = user_surname;
        this.user_username = user_username;
        this.user_password = user_password;
        this.user_mail = user_mail;
        this.phone = phone;
        this.user_gender = user_gender;
        this.user_age = user_age;
        this.user_staff_salary = user_staff_salary;
        this.city = city;
        this.country = country;
        this.staff_carpark = staff_carpark;
        this.user_address = user_address;
        this.participation_date = participation_date;
        this.user_type = user_type;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_surname() {
        return user_surname;
    }

    public void setUser_surname(String user_surname) {
        this.user_surname = user_surname;
    }

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_mail() {
        return user_mail;
    }

    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(String user_gender) {
        this.user_gender = user_gender;
    }

    public int getUser_age() {
        return user_age;
    }

    public void setUser_age(int user_age) {
        this.user_age = user_age;
    }

    public Double getUser_staff_salary() {
        return user_staff_salary;
    }

    public void setUser_staff_salary(Double user_staff_salary) {
        this.user_staff_salary = user_staff_salary;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Carpark getStaff_carpark() {
        return staff_carpark;
    }

    public void setStaff_carpark(Carpark staff_carpark) {
        this.staff_carpark = staff_carpark;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public String getParticipation_date() {
        return participation_date;
    }

    public void setParticipation_date(String participation_date) {
        this.participation_date = participation_date;
    }

    public int getUser_type() {
        return user_type;
    }

    public void setUser_type(int user_type) {
        this.user_type = user_type;
    }

    public List<Privilege> getUserPrivileges() {
        return userPrivileges;
    }

    public void setUserPrivileges(List<Privilege> userPrivileges) {
        this.userPrivileges = userPrivileges;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.user_id;
        hash = 23 * hash + Objects.hashCode(this.user_name);
        hash = 23 * hash + Objects.hashCode(this.user_surname);
        hash = 23 * hash + Objects.hashCode(this.user_username);
        hash = 23 * hash + Objects.hashCode(this.user_password);
        hash = 23 * hash + Objects.hashCode(this.user_mail);
        hash = 23 * hash + Objects.hashCode(this.phone);
        hash = 23 * hash + Objects.hashCode(this.user_gender);
        hash = 23 * hash + this.user_age;
        hash = 23 * hash + Objects.hashCode(this.user_staff_salary);
        hash = 23 * hash + Objects.hashCode(this.city);
        hash = 23 * hash + Objects.hashCode(this.country);
        hash = 23 * hash + Objects.hashCode(this.staff_carpark);
        hash = 23 * hash + Objects.hashCode(this.user_address);
        hash = 23 * hash + Objects.hashCode(this.participation_date);
        hash = 23 * hash + this.user_type;
        hash = 23 * hash + Objects.hashCode(this.userPrivileges);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.user_id != other.user_id) {
            return false;
        }
        if (this.user_age != other.user_age) {
            return false;
        }
        if (this.user_type != other.user_type) {
            return false;
        }
        if (!Objects.equals(this.user_name, other.user_name)) {
            return false;
        }
        if (!Objects.equals(this.user_surname, other.user_surname)) {
            return false;
        }
        if (!Objects.equals(this.user_username, other.user_username)) {
            return false;
        }
        if (!Objects.equals(this.user_password, other.user_password)) {
            return false;
        }
        if (!Objects.equals(this.user_mail, other.user_mail)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.user_gender, other.user_gender)) {
            return false;
        }
        if (!Objects.equals(this.user_address, other.user_address)) {
            return false;
        }
        if (!Objects.equals(this.participation_date, other.participation_date)) {
            return false;
        }
        if (!Objects.equals(this.user_staff_salary, other.user_staff_salary)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.country, other.country)) {
            return false;
        }
        if (!Objects.equals(this.staff_carpark, other.staff_carpark)) {
            return false;
        }
        if (!Objects.equals(this.userPrivileges, other.userPrivileges)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "user_id=" + user_id + ", user_name=" + user_name + ", user_surname=" + user_surname + ", user_username=" + user_username + ", user_password=" + user_password + ", user_mail=" + user_mail + ", phone=" + phone + ", user_gender=" + user_gender + ", user_age=" + user_age + ", user_staff_salary=" + user_staff_salary + ", city=" + city + ", country=" + country + ", staff_carpark=" + staff_carpark + ", user_address=" + user_address + ", participation_date=" + participation_date + ", user_type=" + user_type + ", userPrivileges=" + userPrivileges + '}';
    }

}
