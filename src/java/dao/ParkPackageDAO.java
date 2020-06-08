package dao;

import entity.ParkPackage;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParkPackageDAO extends SuperDAO {

    PreparedStatement pst = null;
    ResultSet rs = null;

    public void insert(ParkPackage parkPackage) {

        try {
            pst = this.getConnection().prepareStatement("INSERT INTO ParkPackage(parkpackage_name,parkpackage_cost,parkpackage_description,parkpackage_time) "
                    + "values(?,?,?,?)");
            pst.setString(1, parkPackage.getParkpackage_name());
            pst.setDouble(2, parkPackage.getParkpackage_cost());
            pst.setString(3, parkPackage.getParkpackage_descritpion());
            pst.setLong(4, parkPackage.getParkpackage_time());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println("ParkPackageDAO HATA(INSERT):" + ex.getMessage());
        }

    }

    public void delete(ParkPackage parkPackage) {

        try {
            pst = this.getConnection().prepareStatement("DELETE FROM ParkPackage WHERE parkpackage_id=?");
            pst.setInt(1, parkPackage.getParkpackage_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println(" ParkPackageDAO HATA(Delete): " + ex.getMessage());
        }
    }

    public int count() {
        int count = 0;
        try {
            pst = this.getConnection().prepareStatement("SELECT count(parkpackage_id) AS parkpackage_count FROM ParkPackage ");
            rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("parkpackage_count");

        } catch (SQLException ex) {
            System.out.println("ParkPackageDAO HATA(Count):" + ex.getMessage());
        }

        return count;
    }

    public List<ParkPackage> findAll(String deger, int page, int pageSize) {
        List<ParkPackage> plist = new ArrayList();
        int start = (page - 1) * pageSize;
        try {
            pst = this.getConnection().prepareStatement("SELECT * FROM ParkPackage WHERE parkpackage_name LIKE ? ORDER BY parkpackage_id asc LIMIT ?,? ");
            pst.setString(1, "%" + deger + "%");
            pst.setInt(2, start);
            pst.setInt(3, pageSize);
            rs = pst.executeQuery();
            while (rs.next()) {
                ParkPackage temp = new ParkPackage(rs.getInt("parkpackage_id"), rs.getString("parkpackage_name"), rs.getDouble("parkpackage_cost"),
                        rs.getString("parkpackage_description"), rs.getLong("parkpackage_time"));
                plist.add(temp);
            }
        } catch (SQLException ex) {
            System.out.println("ParkPackageDAO HATA(READ):" + ex.getMessage());
        }
        return plist;
    }

    public void update(ParkPackage parkPackage) {

        try {
            pst = this.getConnection().prepareStatement("UPDATE ParkPackage SET parkpackage_name=?,parkpackage_cost=?,parkpackage_description=?,parkpackage_time=? where parkpackage_id=?");
            pst.setString(1, parkPackage.getParkpackage_name());
            pst.setDouble(2, parkPackage.getParkpackage_cost());
            pst.setString(3, parkPackage.getParkpackage_descritpion());
            pst.setLong(4, parkPackage.getParkpackage_time());
            pst.setInt(5, parkPackage.getParkpackage_id());

            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println(" ParkPackageDAO HATA(Update): " + ex.getMessage());
        }
    }

    public ParkPackage find(int id) {
        ParkPackage p = null;
        try {
            pst = this.getConnection().prepareStatement("SELECT * FROM ParkPackage WHERE parkpackage_id=?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            rs.next();
            p = new ParkPackage(rs.getInt("parkpackage_id"), rs.getString("parkpackage_name"), rs.getDouble("parkpackage_cost"),
                    rs.getString("parkpackage_description"), rs.getLong("parkpackage_time"));
        } catch (SQLException ex) {
            System.out.println("ParkPackageDAO HATA(FİND) :" + ex.getMessage());
        }
        return p;
    }

}
