package dao;

import entity.Settings;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alperen
 * Ayar tablosunda tek satırlık veri tutacağımız için insert,delete ve findAll methodlarına ihtiyacımız bulunmamaktadır.
 * Update methodunun case içersinde olma sebebi front-end üzerinde farklı menülerde farklı ayar güncellemelerini desteklemesini sağlamaktır.

 */
public class SettingsDAO extends SuperDAO {
    
    PreparedStatement pst = null;
    ResultSet rs = null;

    public List<Settings> findAll() {
        List<Settings> slist = new ArrayList();
        try {
            pst = this.getConnection().prepareStatement("SELECT * FROM Settings ORDER BY setting_id ASC");
            rs = pst.executeQuery();
            while (rs.next()) {
                Settings s = new Settings();
                s.setSetting_id(rs.getInt("setting_id"));
                s.setSetting_title(rs.getString("setting_title"));
                s.setSetting_description(rs.getString("setting_description"));
                s.setSetting_keywords(rs.getString("setting_keywords"));
                s.setSetting_author(rs.getString("setting_author"));
                s.setSetting_phone(rs.getString("setting_phone"));
                s.setSetting_fax(rs.getString("setting_fax"));
                s.setSetting_mail(rs.getString("setting_mail"));
                s.setSetting_shift(rs.getString("setting_shift"));
                s.setSetting_maps(rs.getString("setting_maps"));
                s.setSetting_analystic(rs.getString("setting_analystic"));
                s.setSetting_zopim(rs.getString("setting_zopim"));
                s.setSetting_facebook(rs.getString("setting_facebook"));
                s.setSetting_twitter(rs.getString("setting_twitter"));
                s.setSetting_youtube(rs.getString("setting_youtube"));
                s.setSetting_smtphost(rs.getString("setting_smtphost"));
                s.setSetting_smtppassword(rs.getString("setting_smtppassword"));
                s.setSetting_smtpport(rs.getString("setting_smtpport"));
                s.setSetting_about_title(rs.getString("setting_about_title"));
                s.setSetting_about_content(rs.getString("setting_about_content"));
                s.setSetting_about_video(rs.getString("setting_about_video"));
                slist.add(s);
            }
        } catch (SQLException ex) {
            System.out.println("SettingsDAO HATA(READall):" + ex.getMessage());
        }
        return slist;
    }

    public void update(Settings s, int form) {

        try {
            switch (form) {
                case 1:

                    pst = this.getConnection().prepareStatement("UPDATE Settings SET setting_title=?,setting_description=?,setting_keywords=?,setting_author=? where setting_id=?");
                    pst.setString(1, s.getSetting_title());
                    pst.setString(2, s.getSetting_description());
                    pst.setString(3, s.getSetting_keywords());
                    pst.setString(4, s.getSetting_author());
                    pst.setInt(5, 1);
                    break;
                case 2:
                    pst = this.getConnection().prepareStatement("UPDATE Settings SET setting_phone=?,setting_fax=?,setting_mail=?,setting_shift=? where setting_id=?");
                    pst.setString(1, s.getSetting_phone());
                    pst.setString(2, s.getSetting_fax());
                    pst.setString(3, s.getSetting_mail());
                    pst.setString(4, s.getSetting_shift());
                    pst.setInt(5, 1);
                    break;
                case 3:
                    pst = this.getConnection().prepareStatement("UPDATE Settings SET setting_maps=?,setting_analystic=?,setting_zopim=? where setting_id=?");
                    pst.setString(1, s.getSetting_maps());
                    pst.setString(2, s.getSetting_analystic());
                    pst.setString(3, s.getSetting_zopim());
                    pst.setInt(4, 1);
                    break;
                case 4:
                    pst = this.getConnection().prepareStatement("UPDATE Settings SET setting_facebook=?,setting_twitter=?,setting_youtube=? where setting_id=?");
                    pst.setString(1, s.getSetting_facebook());
                    pst.setString(2, s.getSetting_twitter());
                    pst.setString(3, s.getSetting_youtube());
                    pst.setInt(4, 1);
                    break;
                case 5:
                    pst = this.getConnection().prepareStatement("UPDATE Settings SET setting_smtphost=?,setting_smtppassword=?,setting_smtpport=? where setting_id=?");
                    pst.setString(1, s.getSetting_smtphost());
                    pst.setString(2, s.getSetting_smtppassword());
                    pst.setString(3, s.getSetting_smtpport());
                    pst.setInt(4, 1);
                    break;
                case 6:
                    pst = this.getConnection().prepareStatement("UPDATE Settings SET setting_about_title=?,setting_about_content=?,setting_about_video=? where setting_id=?");
                    pst.setString(1, s.getSetting_about_title());
                    pst.setString(2, s.getSetting_about_content());
                    pst.setString(3, s.getSetting_about_video());
                    pst.setInt(4, 1);
                    break;
            }
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println(" SettingsDAO HATA(Update): " + ex.getMessage());
        }
    }

    public Settings find() {
        Settings s = null;

        try {
            pst = this.getConnection().prepareStatement("SELECT * FROM Settings WHERE setting_id=?");
            pst.setInt(1, 1);
            rs = pst.executeQuery();
            rs.next();
            s = new Settings();
            s.setSetting_id(rs.getInt("setting_id"));
            s.setSetting_title(rs.getString("setting_title"));
            s.setSetting_description(rs.getString("setting_description"));
            s.setSetting_keywords(rs.getString("setting_keywords"));
            s.setSetting_author(rs.getString("setting_author"));
            s.setSetting_phone(rs.getString("setting_phone"));
            s.setSetting_fax(rs.getString("setting_fax"));
            s.setSetting_mail(rs.getString("setting_mail"));
            s.setSetting_shift(rs.getString("setting_shift"));
            s.setSetting_maps(rs.getString("setting_maps"));
            s.setSetting_analystic(rs.getString("setting_analystic"));
            s.setSetting_zopim(rs.getString("setting_zopim"));
            s.setSetting_facebook(rs.getString("setting_facebook"));
            s.setSetting_twitter(rs.getString("setting_twitter"));
            s.setSetting_youtube(rs.getString("setting_youtube"));
            s.setSetting_smtphost(rs.getString("setting_smtphost"));
            s.setSetting_smtppassword(rs.getString("setting_smtppassword"));
            s.setSetting_smtpport(rs.getString("setting_smtpport"));
            s.setSetting_about_title(rs.getString("setting_about_title"));
            s.setSetting_about_content(rs.getString("setting_about_content"));
            s.setSetting_about_video(rs.getString("setting_about_video"));
        } catch (SQLException ex) {
            System.out.println("SettingsDAO HATA(FİND) :" + ex.getMessage());
        }
        return s;
    }

}
