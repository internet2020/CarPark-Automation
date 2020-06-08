package dao;

import entity.Carpark;
import entity.ExtraServices;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarparkDAO extends SuperDAO {
    //carparkdao
    
    

    PreparedStatement pst = null;
    ResultSet rs = null;

    private CountryDAO cdao;
    private CityDAO citydao;

    private ExtraServicesDAO exdao;

    public void insert(Carpark carpark) {
        try {
            pst = this.getConnection().prepareStatement("INSERT INTO  Carpark(carpark_name,carpark_capacity,carpark_city_id,carpark_country_id,"
                    + "carpark_address,carpark_popularity) values(?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, carpark.getCarpark_name());
            pst.setInt(2, carpark.getCarpark_capacity());
            pst.setInt(3, carpark.getCarpark_city().getCity_id());
            pst.setInt(4, carpark.getCarpark_country().getCountry_id());
            pst.setString(5, carpark.getCarpark_address());
            pst.setInt(6, carpark.getCarpark_popularity());
            pst.executeUpdate();

            int c_id = 0;
            ResultSet gk = pst.getGeneratedKeys();

            if (gk.next()) {
                c_id = gk.getInt(1);
            }

            for (ExtraServices ex : carpark.getCarparkServices()) {

                pst = this.getConnection().prepareStatement("INSERT INTO  carpark_extraservices(carpark_id,extraservices_id) values (?,?)");
                pst.setInt(1, c_id);
                pst.setInt(2, ex.getService_id());
                pst.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println(" CarparkDAO HATA(Create): " + ex.getMessage());
        }
    }

    public void delete(Carpark c) { //Carpark tablosu ilişkilendirilen diğer tablolarda CASCADE Veya SETNULL durumunda olduğundan extra işleme gerek yok!

        try {
            pst = this.getConnection().prepareStatement("DELETE FROM Carpark WHERE carpark_id=?");
            pst.setInt(1, c.getCarpark_id());
            pst.executeUpdate();
            //Carpark'ı silince ilişkili tablolardan verileri silmemize gerek yok otomatik siliniyor.
            pst.close();
        } catch (SQLException ex) {
            System.out.println(" CarparkDAO HATA(Delete): " + ex.getMessage());
        }
    }

    public int count() {
        int count = 0;
        try {
            pst = this.getConnection().prepareStatement("SELECT count(carpark_id) AS carpark_count FROM Carpark ");
            rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("carpark_count");

        } catch (SQLException ex) {
            System.out.println("CarparkDAO HATA(Count):" + ex.getMessage());
        }

        return count;
    }

    public List<Carpark> findAll(String deger, int page, int pageSize) {
        List<Carpark> clist = new ArrayList();
        int start = (page - 1) * pageSize;
        try {
            pst = this.getConnection().prepareStatement("SELECT * FROM Carpark WHERE carpark_name LIKE ? ORDER BY carpark_id asc LIMIT ?,?");
            pst.setString(1, "%" + deger + "%");
            pst.setInt(2, start);
            pst.setInt(3, pageSize);
            
            rs = pst.executeQuery();
            while (rs.next()) {
                Carpark temp = new Carpark();

                temp.setCarpark_id(rs.getInt("carpark_id"));
                temp.setCarpark_name(rs.getString("carpark_name"));
                temp.setCarpark_capacity(rs.getInt("carpark_capacity"));
                temp.setCarpark_city(this.getCitydao().find(rs.getInt("carpark_city_id")));
                temp.setCarpark_country(this.getCdao().find(rs.getInt("carpark_country_id")));
                temp.setCarpark_address(rs.getString("carpark_address"));
                temp.setCarpark_popularity(rs.getInt("carpark_popularity"));
                temp.setCarparkServices(this.getExdao().getCarparkServices(rs.getInt("carpark_id")));

                clist.add(temp);
            }
        } catch (SQLException ex) {
            System.out.println("CarparkDAO HATA(ReadAll):" + ex.getMessage());
        }
        return clist;
    }

    public void update(Carpark c) {

        try {
            pst = this.getConnection().prepareStatement("UPDATE Carpark SET carpark_name=?,carpark_capacity=?,carpark_city_id=?,"
                    + "carpark_country_id=?,carpark_address=?,carpark_popularity=? where carpark_id=?");
            pst.setString(1, c.getCarpark_name());
            pst.setInt(2, c.getCarpark_capacity());
            pst.setInt(3, c.getCarpark_city().getCity_id());
            pst.setInt(4, c.getCarpark_country().getCountry_id());
            pst.setString(5, c.getCarpark_address());
            pst.setInt(6, c.getCarpark_popularity());
            pst.setInt(7, c.getCarpark_id());
            pst.executeUpdate();

            //Önce 3. tablodan servisleri siliyoruz.
            pst = this.getConnection().prepareStatement("DELETE FROM carpark_extraservices where carpark_id=?");
            pst.setInt(1, c.getCarpark_id());
            pst.executeUpdate();
            //Burada tekrar ekliyoruz.
            for (ExtraServices e : c.getCarparkServices()) {
                pst = this.getConnection().prepareStatement("INSERT INTO  carpark_extraservices (carpark_id,extraservices_id) values (?,?)");
                pst.setInt(1, c.getCarpark_id());
                pst.setInt(2, e.getService_id());
                pst.executeUpdate();
            }

        } catch (SQLException ex) {
            System.out.println("CarparkDAO HATA(Update): " + ex.getMessage());
        }
    }

    public Carpark find(int id) {
        Carpark c = null;
        try {
            pst = this.getConnection().prepareStatement("SELECT * FROM Carpark WHERE carpark_id=?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                c = new Carpark();
                c.setCarpark_id(rs.getInt("carpark_id"));
                c.setCarpark_name(rs.getString("carpark_name"));
                c.setCarpark_city(this.getCitydao().find(rs.getInt("carpark_city_id")));
                c.setCarpark_country(this.getCdao().find(rs.getInt("carpark_country_id")));
                c.setCarpark_capacity(rs.getInt("carpark_capacity"));
                c.setCarpark_address(rs.getString("carpark_address"));
                c.setCarpark_popularity(rs.getInt("carpark_popularity"));
                c.setCarparkServices(this.getExdao().getCarparkServices(rs.getInt("carpark_id")));   //Buraya dikkat buradan patlayabilir!
            }

        } catch (SQLException ex) {
            System.out.println("CarparkDAO HATA(FİND) :" + ex.getMessage());
        }
        return c;
    }

    public List<Carpark> getServiceCarparks(int service_id) {

        List<Carpark> list = new ArrayList<>();

        try {
            PreparedStatement pst1 = this.getConnection().prepareStatement("SELECT * FROM carpark_extraservices WHERE extraservices_id=?");
            pst1.setInt(1, service_id);
            ResultSet rs1 = pst1.executeQuery();

            while (rs1.next()) {

                list.add(this.find(rs1.getInt("carpark_id")));

            }
        } catch (SQLException ex) {
            System.out.println("CarparkDAO HATA(getServicesCarparks): " + ex.getMessage());
        }
        return list;
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

    public CityDAO getCitydao() {
        if (this.citydao == null) {
            this.citydao = new CityDAO();
        }
        return citydao;
    }

    public void setCitydao(CityDAO citydao) {
        this.citydao = citydao;
    }

    public ExtraServicesDAO getExdao() {
        if (this.exdao == null) {
            this.exdao = new ExtraServicesDAO();
        }
        return exdao;
    }

    public void setExdao(ExtraServicesDAO exdao) {
        this.exdao = exdao;
    }

}
