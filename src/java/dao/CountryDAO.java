package dao;

import entity.Country;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO extends SuperDAO {

    PreparedStatement pst = null;
    ResultSet rs = null;

    public void insert(Country country) {

        try {
            pst = this.getConnection().prepareStatement("INSERT INTO Country(country_name,country_population) "
                    + "values(?,?)");
            pst.setString(1, country.getCountry_name());
            pst.setLong(2, country.getCountry_population());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println("CountryDAO HATA(INSERT):" + ex.getMessage());
        }

    }

    public void delete(Country country) {

        try {
            pst = this.getConnection().prepareStatement("DELETE FROM Country WHERE country_id=?");
            pst.setInt(1, country.getCountry_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println(" CountryDAO HATA(Delete): " + ex.getMessage());
        }
    }

    public int count() {
        int count = 0;
        try {
            pst = this.getConnection().prepareStatement("SELECT count(country_id) as country_count FROM Country ");
            rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("country_count");

        } catch (SQLException ex) {
            System.out.println("CountryDAO HATA(Count):" + ex.getMessage());
        }

        return count;
    }

    public List<Country> findAll(String deger, int page, int pageSize) {
        List<Country> clist = new ArrayList();
        int start = (page - 1) * pageSize;
        try {
            pst = this.getConnection().prepareStatement("SELECT * FROM Country WHERE country_name LIKE ? ORDER BY country_id asc LIMIT ?,? ");
            pst.setString(1, "%" + deger + "%");
             pst.setInt(2, start);
            pst.setInt(3, pageSize);
           
            rs = pst.executeQuery();
            while (rs.next()) {
                Country temp = new Country(rs.getInt("country_id"), rs.getString("country_name"), rs.getInt("country_population"));
                clist.add(temp);
            }
        } catch (SQLException ex) {
            System.out.println("CountryDAO HATA(READ):" + ex.getMessage());
        }
        return clist;
    }

    public void update(Country country) {

        try {
            pst = this.getConnection().prepareStatement("UPDATE Country SET country_name=?,country_population=? where country_id=?");
            pst.setString(1, country.getCountry_name());
            pst.setLong(2, country.getCountry_population());
            pst.setInt(3, country.getCountry_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println(" CountryDAO HATA(Update): " + ex.getMessage());
        }
    }

    public Country find(int id) {
        Country c = null;
        try {
            pst = this.getConnection().prepareStatement("SELECT * FROM Country WHERE country_id=?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            rs.next();
            c = new Country(rs.getInt("country_id"), rs.getString("country_name"), rs.getInt("country_population"));
        } catch (SQLException ex) {
            System.out.println("CountryDAO HATA(FİND) :" + ex.getMessage());
        }
        return c;
    }


}
