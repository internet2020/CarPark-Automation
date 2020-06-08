package controller;

import dao.PrivilegeDAO;
import entity.Privilege;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
/**
 *
 * @author Alperen
 */
@Named
@SessionScoped
public class PrivilegeController implements Serializable {

    private PrivilegeDAO pdao;
    private List<Privilege> plist;

    private Privilege privilege;

    @Inject
    private UserController userController;

    /**
     * bul değişkeni search için diğerleri pagination için oluşturuldu.
     */
    private String bul = "";
    private int page = 1;
    private int pageSize = 5;
    private int pageCount;

    public void geri() {
        if (this.page == 1) {
            if (this.getPageCount() != 0) {
                this.page = this.getPageCount();
            }
        } else {
            this.page--;
        }
    }

    public void ileri() {
        if (this.page == this.getPageCount() || this.getPageCount() == 0) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public void ilk() {
        this.page = 1;
    }

    public void son() {
        if (this.getPageCount() != 0) {

            this.page = this.getPageCount();
        }
    }

    public void updateForm(Privilege privilege) {
        this.privilege = privilege;
    }

    public void clearForm() {
        this.privilege = new Privilege();
    }

    public void create() {
        this.getPdao().insert(this.privilege);
        this.clearForm();
    }

    public void deleteConfirm(Privilege privilege) {
        this.privilege = privilege;
    }

    public void delete() {
        this.getPdao().delete(this.privilege);
        this.clearForm();
    }

    public void update() {
        this.getPdao().update(this.privilege);
        this.clearForm();
    }

    public PrivilegeDAO getPdao() {
        if (this.pdao == null) {
            this.pdao = new PrivilegeDAO();
        }
        return pdao;
    }

    public void setPdao(PrivilegeDAO pdao) {
        this.pdao = pdao;
    }

    public List<Privilege> getPlist() {
        this.plist = this.getPdao().findAll(this.bul, this.page, this.pageSize);
        return plist;
    }

    public void setPlist(List<Privilege> plist) {
        this.plist = plist;
    }

    public Privilege getPrivilege() {
        if (this.privilege == null) {
            this.privilege = new Privilege();
        }
        return privilege;
    }

    public void setPrivilege(Privilege privilege) {
        this.privilege = privilege;
    }

    public UserController getUserController() {
        return userController;
    }

    public String getBul() {
        return bul;
    }

    public void setBul(String bul) {
        this.bul = bul;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getPdao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
