package dao;

import entity.ExtraServices;
import entity.Privilege;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Alperen
 */
public class PrivilegeDAO extends SuperDAO {

    PreparedStatement pst = null;
    ResultSet rs = null;

    public void insert(Privilege p) {

        try {
            pst = this.getConnection().prepareStatement("INSERT INTO  Privilege(privilege_name,privilege_description) values(?,?)"/*,
                    PreparedStatement.RETURN_GENERATED_KEYS*/);
            pst.setString(1, p.getPrivilege_name());
            pst.setString(2, p.getPrivilege_description());
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(" PrivilegeDAO HATA(Create): " + ex.getMessage());
        }
    }

    public void delete(Privilege p) { //Privilege tablosu ilişkilendirilen diğer tablolarda CASCADE  durumunda olduğundan extra işleme gerek yok!

        try {
            pst = this.getConnection().prepareStatement("DELETE FROM Privilege WHERE privilege_id=?");
            pst.setInt(1, p.getPrivilege_id());
            pst.executeUpdate();
            //Privilege'i silince ilişkili tablolardan verileri silmemize gerek yok otomatik siliniyor.
            pst.close();
        } catch (SQLException ex) {
            System.out.println(" PrivilegeDAO HATA(Delete): " + ex.getMessage());
        }
    }

    public int count() {
        int count = 0;
        try {
            pst = this.getConnection().prepareStatement("SELECT count(privilege_id) as privilege_count FROM Privilege ");
            rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("privilege_count");

        } catch (SQLException ex) {
            System.out.println("PrivilegeDAO HATA(Count):" + ex.getMessage());
        }

        return count;
    }

    public List<Privilege> findAll(String deger, int page, int pageSize) {
        List<Privilege> plist = new ArrayList();
        int start = (page - 1) * pageSize;
        try {
            pst = this.getConnection().prepareStatement("SELECT * FROM Privilege  WHERE privilege_name LIKE ? OR privilege_description LIKE ? ORDER BY privilege_id asc LIMIT ?,?");
            pst.setString(1, "%" + deger + "%");
            pst.setString(2, "%" + deger + "%");
            pst.setInt(3, start);
            pst.setInt(4, pageSize);
            
            rs = pst.executeQuery();
            while (rs.next()) {
                Privilege temp = new Privilege();
                temp.setPrivilege_id(rs.getInt("privilege_id"));
                temp.setPrivilege_name(rs.getString("privilege_name"));
                temp.setPrivilege_description(rs.getString("privilege_description"));

                plist.add(temp);
            }
        } catch (SQLException ex) {
            System.out.println("PrivilegeDAO HATA(READ):" + ex.getMessage());
        }
        return plist;
    }

    public void update(Privilege p) {

        try {
            pst = this.getConnection().prepareStatement("UPDATE Privilege SET privilege_name=?,privilege_description=? WHERE privilege_id=?");
            pst.setString(1, p.getPrivilege_name());
            pst.setString(2, p.getPrivilege_description());
            pst.setInt(3, p.getPrivilege_id());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("PrivilegeDAO HATA(Update): " + ex.getMessage());
        }
    }

    public Privilege find(int id) {

        Privilege p = null;
        try {
            pst = this.getConnection().prepareStatement("SELECT * FROM Privilege WHERE privilege_id=?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            rs.next();
            p = new Privilege();

            p.setPrivilege_id(rs.getInt("privilege_id"));
            p.setPrivilege_name(rs.getString("privilege_name"));
            p.setPrivilege_description(rs.getString("privilege_description"));
        } catch (SQLException ex) {
            System.out.println("PrivilegeDAO HATA(FİND) :" + ex.getMessage());
        }
        return p;
    }

    public List<Privilege> getUserPrivileges(int user_id) {

        List<Privilege> list = new ArrayList<>();

        try {
            PreparedStatement pst1 = this.getConnection().prepareStatement("SELECT * FROM user_privilege WHERE user_id=?");
            pst1.setInt(1, user_id);
            ResultSet rs1 = pst1.executeQuery();

            while (rs1.next()) {

                list.add(this.find(rs1.getInt("privilege_id")));

            }
        } catch (SQLException ex) {
            System.out.println("PrivilegeDAO HATA(getUserPrivileges): " + ex.getMessage());
        }
        return list;
    }
}
