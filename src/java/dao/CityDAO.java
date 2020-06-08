package dao;

import entity.City;
import entity.Country;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDAO extends SuperDAO {

    PreparedStatement pst = null;
    ResultSet rs = null;

    private CountryDAO cdao;

    public void insert(City city) {

        try {
            pst = this.getConnection().prepareStatement("INSERT INTO  City(city_name,city_population,city_country_id) "
                    + "values(?,?,?)");
            pst.setString(1, city.getCity_name());
            pst.setLong(2, city.getCity_population());
            pst.setLong(3, city.getCountry().getCountry_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println("CityDAO HATA(INSERT):" + ex.getMessage());
        }

    }

    public void delete(City city) {

        try {
            pst = this.getConnection().prepareStatement("DELETE FROM City WHERE city_id=?");
            pst.setInt(1, city.getCity_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println(" CityDAO HATA(Delete): " + ex.getMessage());
        }
    }

    public int count() {
        int count = 0;
        try {
            pst = this.getConnection().prepareStatement("SELECT count(city_id) as city_count FROM City ");
            rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("city_count");

        } catch (SQLException ex) {
            System.out.println("CityDAO HATA(Count):" + ex.getMessage());
        }

        return count;
    }

    public List<City> findAll(String deger, int page, int pageSize) {
        List<City> clist = new ArrayList();
        int start = (page - 1) * pageSize;
        try {
            pst = this.getConnection().prepareStatement("SELECT * FROM City WHERE city_name LIKE ? ORDER BY city_id asc LIMIT ?,? ");
            pst.setString(1, "%" + deger + "%");
             pst.setInt(2, start);
            pst.setInt(3, pageSize);
            rs = pst.executeQuery();
            while (rs.next()) {
                City temp = new City(rs.getInt("city_id"), rs.getString("city_name"), rs.getInt("city_population"),
                        this.getCdao().find(rs.getInt("city_country_id")));
                clist.add(temp);
            }
        } catch (SQLException ex) {
            System.out.println("CityDAO HATA(READ):" + ex.getMessage());
        }
        return clist;
    }

    public void update(City city) {

        try {
            pst = this.getConnection().prepareStatement("UPDATE City SET city_name=?,city_population=?,city_country_id=? where city_id=?");
            pst.setString(1, city.getCity_name());
            pst.setLong(2, city.getCity_population());
            pst.setInt(3, city.getCountry().getCountry_id());
            pst.setInt(4, city.getCity_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println(" CityDAO HATA(Update): " + ex.getMessage());
        }
    }

    public City find(int id) {
        City c = null;
        try {
            pst = this.getConnection().prepareStatement("SELECT * FROM City WHERE city_id=?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            rs.next();
            c = new City(rs.getInt("city_id"), rs.getString("city_name"), rs.getInt("city_population"),
                    this.getCdao().find(rs.getInt("city_country_id")));
        } catch (SQLException ex) {
            System.out.println("CityDAO HATA(FİND) :" + ex.getMessage());
        }
        return c;
    }

    public CountryDAO getCdao() {
        if (this.cdao == null) {
            this.cdao = new CountryDAO();
        }
        return cdao;
    }

    public void setCdao(CountryDAO cdao) {
        this.cdao = cdao;
    }

}
