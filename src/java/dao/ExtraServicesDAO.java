package dao;

import entity.Carpark;
import entity.ExtraServices;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExtraServicesDAO extends SuperDAO {

    PreparedStatement pst = null;
    ResultSet rs = null;

    //private CarparkDAO carparkdao;
    public void insert(ExtraServices e) {

        try {
            pst = this.getConnection().prepareStatement("INSERT INTO  ExtraServices(service_name,service_cost) values(?,?)"/*,
                    PreparedStatement.RETURN_GENERATED_KEYS*/);
            pst.setString(1, e.getService_name());
            pst.setDouble(2, e.getService_cost());
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(" ExtraServicesDAO HATA(Create): " + ex.getMessage());
        }
    }

    public void delete(ExtraServices e) { //ExtraServices tablosu ilişkilendirilen diğer tablolarda CASCADE Veya SETNULL durumunda olduğundan extra işleme gerek yok!

        try {
            pst = this.getConnection().prepareStatement("DELETE FROM ExtraServices WHERE service_id=?");
            pst.setInt(1, e.getService_id());
            pst.executeUpdate();
            //ExtraService'ı silince ilişkili tablolardan verileri silmemize gerek yok otomatik siliniyor.
            pst.close();
        } catch (SQLException ex) {
            System.out.println(" CarparkDAO HATA(Delete): " + ex.getMessage());
        }
    }

    public int count() {
        int count = 0;
        try {
            pst = this.getConnection().prepareStatement("SELECT count(service_id) as service_count FROM ExtraServices ");
            rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("service_count");

        } catch (SQLException ex) {
            System.out.println("ExtraServicesDAO HATA(Count):" + ex.getMessage());
        }

        return count;
    }

    public List<ExtraServices> findAll(String deger, int page, int pageSize) {
        List<ExtraServices> elist = new ArrayList();
        int start = (page - 1) * pageSize;
        try {
            pst = this.getConnection().prepareStatement("SELECT * FROM ExtraServices WHERE service_name LIKE ? ORDER BY service_id asc LIMIT ?,?");
            pst.setString(1, "%" + deger + "%");
            pst.setInt(2, start);
            pst.setInt(3, pageSize);
            
            rs = pst.executeQuery();
            while (rs.next()) {
                ExtraServices temp = new ExtraServices();
                temp.setService_id(rs.getInt("service_id"));
                temp.setService_name(rs.getString("service_name"));
                temp.setService_cost(rs.getDouble("service_cost"));
                elist.add(temp);
            }
        } catch (SQLException ex) {
            System.out.println("ExtraServicesDAO HATA(READ):" + ex.getMessage());
        }
        return elist;
    }

    public void update(ExtraServices e) {

        try {
            pst = this.getConnection().prepareStatement("UPDATE ExtraServices SET service_name=?,service_cost=? WHERE service_id=?");
            pst.setString(1, e.getService_name());
            pst.setDouble(2, e.getService_cost());
            pst.setInt(3, e.getService_id());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ExtraServicesDAO HATA(Update): " + ex.getMessage());
        }
    }

    public ExtraServices find(int id) {

        ExtraServices e = null;
        try {
            pst = this.getConnection().prepareStatement("SELECT * FROM ExtraServices WHERE service_id=?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            rs.next();
            e = new ExtraServices();
            e.setService_id(rs.getInt("service_id"));
            e.setService_name(rs.getString("service_name"));
            e.setService_cost(rs.getDouble("service_cost"));
        } catch (SQLException ex) {
            System.out.println("ExtraServicesDAO HATA(FİND) :" + ex.getMessage());
        }
        return e;
    }

    public List<ExtraServices> getCarparkServices(int carpark_id) {

        List<ExtraServices> list = new ArrayList<>();

        try {
            PreparedStatement pst1 = this.getConnection().prepareStatement("SELECT * FROM carpark_extraservices WHERE carpark_id=?");
            pst1.setInt(1, carpark_id);
            ResultSet rs1 = pst1.executeQuery();

            while (rs1.next()) {

                list.add(this.find(rs1.getInt("extraservices_id")));

            }
        } catch (SQLException ex) {
            System.out.println("ExtraServicesDAO HATA(getCarparkServices): " + ex.getMessage());
        }
        return list;
    }

    public List<ExtraServices> getParkTransactionServices(int parkTransaction_id) {

        List<ExtraServices> list = new ArrayList<>();

        try {
            PreparedStatement pst1 = this.getConnection().prepareStatement("SELECT * FROM parktransaction_extraservices WHERE parktransaction_id=?");
            pst1.setInt(1, parkTransaction_id);
            ResultSet rs1 = pst1.executeQuery();

            while (rs1.next()) {

                list.add(this.find(rs1.getInt("extraservices_id")));

            }
        } catch (SQLException ex) {
            System.out.println("ExtraServicesDAO HATA(getParkTransactionServices): " + ex.getMessage());
        }
        return list;
    }

    /* public CarparkDAO getCarparkdao() {
        if (this.carparkdao == null) {
            this.carparkdao = new CarparkDAO();
        }
        return carparkdao;
    }

    public void setCarparkdao(CarparkDAO carparkdao) {
        this.carparkdao = carparkdao;
    }*/
}
