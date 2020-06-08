/*
 Entity Sınıfları->
         *Veritabanındaki tabloların birer örnekleridir!
         *İşlemler bu sınıfların nesneleri üzerinden yaplacaktır!
 */
package entity;

import java.util.Objects;
/**
 *
 * @author Alperen
 */
public class Settings {
 
    private int setting_id;
    private String setting_title;
    private String setting_description;
    private String setting_keywords;
    private String setting_author;
    private String setting_phone;
    private String setting_fax;
    private String setting_mail;
    private String setting_shift;

    private String setting_maps;
    private String setting_analystic;
    private String setting_zopim;

    private String setting_facebook;
    private String setting_twitter;
    private String setting_youtube;

    private String setting_smtphost;
    private String setting_smtppassword;
    private String setting_smtpport;

    private String setting_about_title;
    private String setting_about_content;
    private String setting_about_video;

    public Settings() {
    }

    public Settings(int setting_id, String setting_title, String setting_description, String setting_keywords, String setting_author, String setting_phone, String setting_fax, String setting_mail, String setting_shift, String setting_maps, String setting_analystic, String setting_zopim, String setting_facebook, String setting_twitter, String setting_youtube, String setting_smtphost, String setting_smtppassword, String setting_smtpport, String setting_about_title, String setting_about_content, String setting_about_video) {
        this.setting_id = setting_id;
        this.setting_title = setting_title;
        this.setting_description = setting_description;
        this.setting_keywords = setting_keywords;
        this.setting_author = setting_author;
        this.setting_phone = setting_phone;
        this.setting_fax = setting_fax;
        this.setting_mail = setting_mail;
        this.setting_shift = setting_shift;
        this.setting_maps = setting_maps;
        this.setting_analystic = setting_analystic;
        this.setting_zopim = setting_zopim;
        this.setting_facebook = setting_facebook;
        this.setting_twitter = setting_twitter;
        this.setting_youtube = setting_youtube;
        this.setting_smtphost = setting_smtphost;
        this.setting_smtppassword = setting_smtppassword;
        this.setting_smtpport = setting_smtpport;
        this.setting_about_title = setting_about_title;
        this.setting_about_content = setting_about_content;
        this.setting_about_video = setting_about_video;
    }

   
    public int getSetting_id() {
        return setting_id;
    }

    public void setSetting_id(int setting_id) {
        this.setting_id = setting_id;
    }

   

    public String getSetting_title() {
        return setting_title;
    }

    public void setSetting_title(String setting_title) {
        this.setting_title = setting_title;
    }

    public String getSetting_description() {
        return setting_description;
    }

    public void setSetting_description(String setting_description) {
        this.setting_description = setting_description;
    }

    public String getSetting_keywords() {
        return setting_keywords;
    }

    public void setSetting_keywords(String setting_keywords) {
        this.setting_keywords = setting_keywords;
    }

    public String getSetting_author() {
        return setting_author;
    }

    public void setSetting_author(String setting_author) {
        this.setting_author = setting_author;
    }

    public String getSetting_phone() {
        return setting_phone;
    }

    public void setSetting_phone(String setting_phone) {
        this.setting_phone = setting_phone;
    }

    public String getSetting_fax() {
        return setting_fax;
    }

    public void setSetting_fax(String setting_fax) {
        this.setting_fax = setting_fax;
    }

    public String getSetting_mail() {
        return setting_mail;
    }

    public void setSetting_mail(String setting_mail) {
        this.setting_mail = setting_mail;
    }

    public String getSetting_shift() {
        return setting_shift;
    }

    public void setSetting_shift(String setting_shift) {
        this.setting_shift = setting_shift;
    }

    public String getSetting_maps() {
        return setting_maps;
    }

    public void setSetting_maps(String setting_maps) {
        this.setting_maps = setting_maps;
    }

    public String getSetting_analystic() {
        return setting_analystic;
    }

    public void setSetting_analystic(String setting_analystic) {
        this.setting_analystic = setting_analystic;
    }

    public String getSetting_zopim() {
        return setting_zopim;
    }

    public void setSetting_zopim(String setting_zopim) {
        this.setting_zopim = setting_zopim;
    }

    public String getSetting_facebook() {
        return setting_facebook;
    }

    public void setSetting_facebook(String setting_facebook) {
        this.setting_facebook = setting_facebook;
    }

    public String getSetting_twitter() {
        return setting_twitter;
    }

    public void setSetting_twitter(String setting_twitter) {
        this.setting_twitter = setting_twitter;
    }

    public String getSetting_youtube() {
        return setting_youtube;
    }

    public void setSetting_youtube(String setting_youtube) {
        this.setting_youtube = setting_youtube;
    }

    public String getSetting_smtphost() {
        return setting_smtphost;
    }

    public void setSetting_smtphost(String setting_smtphost) {
        this.setting_smtphost = setting_smtphost;
    }

    public String getSetting_smtppassword() {
        return setting_smtppassword;
    }

    public void setSetting_smtppassword(String setting_smtppassword) {
        this.setting_smtppassword = setting_smtppassword;
    }

    public String getSetting_smtpport() {
        return setting_smtpport;
    }

    public void setSetting_smtpport(String setting_smtpport) {
        this.setting_smtpport = setting_smtpport;
    }

    public String getSetting_about_title() {
        return setting_about_title;
    }

    public void setSetting_about_title(String setting_about_title) {
        this.setting_about_title = setting_about_title;
    }

    public String getSetting_about_content() {
        return setting_about_content;
    }

    public void setSetting_about_content(String setting_about_content) {
        this.setting_about_content = setting_about_content;
    }

    public String getSetting_about_video() {
        return setting_about_video;
    }

    public void setSetting_about_video(String setting_about_video) {
        this.setting_about_video = setting_about_video;
    }

    @Override
    public String toString() {
        return "Settings{" + "setting_id=" + setting_id + ", setting_title=" + setting_title + ", setting_description=" + setting_description + ", setting_keywords=" + setting_keywords + ", setting_author=" + setting_author + ", setting_phone=" + setting_phone + ", setting_fax=" + setting_fax + ", setting_mail=" + setting_mail + ", setting_shift=" + setting_shift + ", setting_maps=" + setting_maps + ", setting_analystic=" + setting_analystic + ", setting_zopim=" + setting_zopim + ", setting_facebook=" + setting_facebook + ", setting_twitter=" + setting_twitter + ", setting_youtube=" + setting_youtube + ", setting_smtphost=" + setting_smtphost + ", setting_smtppassword=" + setting_smtppassword + ", setting_smtpport=" + setting_smtpport + ", setting_about_title=" + setting_about_title + ", setting_about_content=" + setting_about_content + ", setting_about_video=" + setting_about_video + '}';
    }

   

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.setting_id;
        hash = 97 * hash + Objects.hashCode(this.setting_title);
        hash = 97 * hash + Objects.hashCode(this.setting_description);
        hash = 97 * hash + Objects.hashCode(this.setting_keywords);
        hash = 97 * hash + Objects.hashCode(this.setting_author);
        hash = 97 * hash + Objects.hashCode(this.setting_phone);
        hash = 97 * hash + Objects.hashCode(this.setting_fax);
        hash = 97 * hash + Objects.hashCode(this.setting_mail);
        hash = 97 * hash + Objects.hashCode(this.setting_shift);
        hash = 97 * hash + Objects.hashCode(this.setting_maps);
        hash = 97 * hash + Objects.hashCode(this.setting_analystic);
        hash = 97 * hash + Objects.hashCode(this.setting_zopim);
        hash = 97 * hash + Objects.hashCode(this.setting_facebook);
        hash = 97 * hash + Objects.hashCode(this.setting_twitter);
        hash = 97 * hash + Objects.hashCode(this.setting_youtube);
        hash = 97 * hash + Objects.hashCode(this.setting_smtphost);
        hash = 97 * hash + Objects.hashCode(this.setting_smtppassword);
        hash = 97 * hash + Objects.hashCode(this.setting_smtpport);
        hash = 97 * hash + Objects.hashCode(this.setting_about_title);
        hash = 97 * hash + Objects.hashCode(this.setting_about_content);
        hash = 97 * hash + Objects.hashCode(this.setting_about_video);
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
        final Settings other = (Settings) obj;
        if (this.setting_id != other.setting_id) {
            return false;
        }
        if (!Objects.equals(this.setting_title, other.setting_title)) {
            return false;
        }
        if (!Objects.equals(this.setting_description, other.setting_description)) {
            return false;
        }
        if (!Objects.equals(this.setting_keywords, other.setting_keywords)) {
            return false;
        }
        if (!Objects.equals(this.setting_author, other.setting_author)) {
            return false;
        }
        if (!Objects.equals(this.setting_phone, other.setting_phone)) {
            return false;
        }
        if (!Objects.equals(this.setting_fax, other.setting_fax)) {
            return false;
        }
        if (!Objects.equals(this.setting_mail, other.setting_mail)) {
            return false;
        }
        if (!Objects.equals(this.setting_shift, other.setting_shift)) {
            return false;
        }
        if (!Objects.equals(this.setting_maps, other.setting_maps)) {
            return false;
        }
        if (!Objects.equals(this.setting_analystic, other.setting_analystic)) {
            return false;
        }
        if (!Objects.equals(this.setting_zopim, other.setting_zopim)) {
            return false;
        }
        if (!Objects.equals(this.setting_facebook, other.setting_facebook)) {
            return false;
        }
        if (!Objects.equals(this.setting_twitter, other.setting_twitter)) {
            return false;
        }
        if (!Objects.equals(this.setting_youtube, other.setting_youtube)) {
            return false;
        }
        if (!Objects.equals(this.setting_smtphost, other.setting_smtphost)) {
            return false;
        }
        if (!Objects.equals(this.setting_smtppassword, other.setting_smtppassword)) {
            return false;
        }
        if (!Objects.equals(this.setting_smtpport, other.setting_smtpport)) {
            return false;
        }
        if (!Objects.equals(this.setting_about_title, other.setting_about_title)) {
            return false;
        }
        if (!Objects.equals(this.setting_about_content, other.setting_about_content)) {
            return false;
        }
        if (!Objects.equals(this.setting_about_video, other.setting_about_video)) {
            return false;
        }
        return true;
    }

}
