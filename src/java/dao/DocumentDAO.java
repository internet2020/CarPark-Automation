package dao;


import entity.Document;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DocumentDAO extends SuperDAO {

    PreparedStatement pst = null;
    ResultSet rs = null;

    CarparkDAO carparkDao;
    UserDAO userDao;

    public void insert(Document file) {

        try {
            pst = this.getConnection().prepareStatement("INSERT INTO  File(file_name, file_path, file_type, file_carpark_id, file_user_id) "
                    + "values(?, ?, ?, ?, ?)");
            pst.setString(1, file.getFile_name());
            pst.setString(2, file.getFile_path());
            pst.setString(3, file.getFile_type());
            pst.setInt(4, file.getFile_carpark().getCarpark_id());
            pst.setInt(5, file.getFile_user().getUser_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println("FileDAO HATA(INSERT):" + ex.getMessage());
        }

    }

    public void delete(Document file) {

        try {
            pst = this.getConnection().prepareStatement("DELETE FROM File WHERE file_id=?");
            pst.setInt(1, file.getFile_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println(" FileDAO HATA(Delete): " + ex.getMessage());
        }
    }

    public int count() {
        int count = 0;
        try {
            pst = this.getConnection().prepareStatement("SELECT count(file_id) as file_count FROM File ");
            rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("file_count");

        } catch (SQLException ex) {
            System.out.println("FileDAO HATA(Count):" + ex.getMessage());
        }

        return count;
    }

    public List<Document> findAll(String deger, int page, int pageSize) {
        List<Document> flist = new ArrayList();
        int start = (page - 1) * pageSize;
        try {
            pst = this.getConnection().prepareStatement("SELECT * FROM File WHERE file_name LIKE ? ORDER BY file_id asc LIMIT ?,? ");
            pst.setString(1, "%" + deger + "%");
            pst.setInt(2, start);
            pst.setInt(3, pageSize);
            
            rs = pst.executeQuery();
            while (rs.next()) {
                Document temp = new Document(rs.getInt("file_id"), rs.getString("file_name"), rs.getString("file_path"), rs.getString("file_type"),
                        this.getCarparkDao().find(rs.getInt("file_carpark_id")), this.getUserDao().find(rs.getInt("file_user_id")), rs.getDate("upload_date"));
                flist.add(temp);
            }
        } catch (SQLException ex) {
            System.out.println("FileDAO HATA(READ):" + ex.getMessage());
        }
        return flist;
    }

    public void update(Document file) {

        try {
            pst = this.getConnection().prepareStatement("UPDATE File SET file_name=?,file_path=?,file_type=?"
                    + " file_carpark_id=? file_user_id=? where file_id=?");
            pst.setString(1, file.getFile_name());
            pst.setString(2, file.getFile_path());
            pst.setString(3, file.getFile_type());
            pst.setInt(4, file.getFile_carpark().getCarpark_id());
            pst.setInt(5, file.getFile_user().getUser_id());
            pst.setInt(6, file.getFile_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println(" FileDAO HATA(Update): " + ex.getMessage());
        }
    }

    public Document find(int id) {
        Document f = null;
        try {
            pst = this.getConnection().prepareStatement("SELECT * FROM File WHERE file_id=?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            rs.next();
            f = new Document(rs.getInt("file_id"), rs.getString("file_name"), rs.getString("file_path"), rs.getString("file_type"),
                    this.getCarparkDao().find(rs.getInt("file_carpark_id")), this.getUserDao().find(rs.getInt("file_user_id")), rs.getDate("upload_date"));
        } catch (SQLException ex) {
            System.out.println("FileDAO HATA(FİND) :" + ex.getMessage());
        }
        return f;
    }

    public CarparkDAO getCarparkDao() {
        if (this.carparkDao == null) {
            this.carparkDao = new CarparkDAO();
        }
        return carparkDao;
    }

    public UserDAO getUserDao() {
        if (this.userDao == null) {
            this.userDao = new UserDAO();
        }
        return userDao;
    }

}
