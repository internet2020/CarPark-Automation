package controller;

import dao.ParkPackageDAO;
import entity.ParkPackage;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class ParkPackageController implements Serializable {

    private ParkPackageDAO pdao;
    private List<ParkPackage> plist;

    private ParkPackage parkPackage;

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

    public void updateForm(ParkPackage parkPackage) {
        this.parkPackage = parkPackage;
    }

    public void clearForm() {
        this.parkPackage = new ParkPackage();
    }

    public void create() {
        this.getPdao().insert(this.parkPackage);
        this.clearForm();
    }

    public void deleteConfirm(ParkPackage parkPackage) {
        this.parkPackage = parkPackage;
    }

    public void delete() {
        this.getPdao().delete(this.parkPackage);
        this.clearForm();
    }

    public void update() {
        this.getPdao().update(this.parkPackage);
        this.clearForm();
    }

    public ParkPackageDAO getPdao() {
        if (this.pdao == null) {
            this.pdao = new ParkPackageDAO();
        }
        return pdao;
    }

    public void setPdao(ParkPackageDAO pdao) {
        this.pdao = pdao;
    }

    public List<ParkPackage> getPlist() {
        this.plist = this.getPdao().findAll(this.bul, this.page, this.pageSize);
        return plist;
    }

    public void setPlist(List<ParkPackage> plist) {
        this.plist = plist;
    }

    public ParkPackage getParkPackage() {
        if (this.parkPackage == null) {
            this.parkPackage = new ParkPackage();
        }
        return parkPackage;
    }

    public void setParkPackage(ParkPackage parkPackage) {
        this.parkPackage = parkPackage;
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
