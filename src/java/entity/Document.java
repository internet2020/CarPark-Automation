package entity;

import java.sql.Date;
import java.util.Objects;

public class Document {

    private int file_id;
    private String file_name;
    private String file_path;
    private String file_type;

    private Carpark file_carpark;
    private User file_user;
    private Date file_upload_date;

    public Document() {
    }

    public Document(int file_id, String file_name, String file_path, String file_type, Carpark file_carpark, User file_user, Date file_upload_date) {
        this.file_id = file_id;
        this.file_name = file_name;
        this.file_path = file_path;
        this.file_type = file_type;
        this.file_carpark = file_carpark;
        this.file_user = file_user;
        this.file_upload_date = file_upload_date;
    }

    public int getFile_id() {
        return file_id;
    }

    public void setFile_id(int file_id) {
        this.file_id = file_id;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public String getFile_type() {
        return file_type;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }

    public Carpark getFile_carpark() {
        return file_carpark;
    }

    public void setFile_carpark(Carpark file_carpark) {
        this.file_carpark = file_carpark;
    }

    public User getFile_user() {
        return file_user;
    }

    public void setFile_user(User file_user) {
        this.file_user = file_user;
    }

    public Date getFile_upload_date() {
        return file_upload_date;
    }

    public void setFile_upload_date(Date file_upload_date) {
        this.file_upload_date = file_upload_date;
    }

}
