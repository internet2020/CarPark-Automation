package controller;

import dao.SettingsDAO;
import entity.Settings;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
/**
 *
 * @author Alperen
 */
@Named
@SessionScoped
public class SettingsController implements Serializable {

    
    private SettingsDAO sdao;
    private Settings setting;
   

    public void updateForm(Settings settings) {
        this.setting = settings;
    }

    public void clearForm() {
        this.setting = new Settings();
    }

    public void create() {

    }

    public void deleteConfirm(Settings settings) {

    }

    public void delete() {

    }

    public void update(int form) {
        this.getSdao().update(this.setting, form);

    }

    public SettingsDAO getSdao() {
        if (this.sdao == null) {
            this.sdao = new SettingsDAO();
        }
        return sdao;
    }

    public void setSdao(SettingsDAO sdao) {
        this.sdao = sdao;
    }

    public Settings getSetting() {
        if (this.setting == null) {
            this.setting = new Settings();
            this.setting=this.getSdao().find();
        }
        return setting;
    }

    public void setSetting(Settings setting) {
        this.setting = setting;
    }

 

}
