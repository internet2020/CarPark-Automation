package controller;

import dao.ExtraServicesDAO;
import entity.ExtraServices;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class ExtraServicesController implements Serializable {

    private ExtraServicesDAO edao;
    private List<ExtraServices> elist;

    private ExtraServices extraServices;

    private List<ExtraServices> testlist;
    /**
     * bul değişkeni search için diğerleri pagination için oluşturuldu.
     */
    private String bul = "";
    private int page = 1;
    private int pageSize = 5;
    private int pageCount;

    public void setTestlist(List<ExtraServices> testlist) {
        this.testlist = testlist;
    }

    @Inject
    private CarparkController carparkController;

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

    public void updateForm(ExtraServices extraServices) {
        this.extraServices = extraServices;
    }

    public void clearForm() {
        this.extraServices = new ExtraServices();
    }

    public void create() {
        this.getEdao().insert(this.extraServices);
        this.clearForm();
    }

    public void deleteConfirm(ExtraServices extraServices) {
        this.extraServices = extraServices;
    }

    public void delete() {
        this.getEdao().delete(this.extraServices);
        this.clearForm();
    }

    public void update() {
        this.getEdao().update(this.extraServices);
        this.clearForm();
    }

    public ExtraServicesDAO getEdao() {
        if (this.edao == null) {
            this.edao = new ExtraServicesDAO();
        }
        return edao;
    }

    public void setEdao(ExtraServicesDAO edao) {
        this.edao = edao;
    }

    public List<ExtraServices> getElist() {
        this.elist = this.getEdao().findAll(this.bul, this.page, this.pageSize);
        return elist;
    }

    public void setElist(List<ExtraServices> elist) {
        this.elist = elist;
    }

    public ExtraServices getExtraServices() {
        if (this.extraServices == null) {
            this.extraServices = new ExtraServices();
        }
        return extraServices;
    }

    public void setExtraServices(ExtraServices extraServices) {
        this.extraServices = extraServices;
    }

    public CarparkController getCarparkController() {
        return carparkController;
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
        this.pageCount = (int) Math.ceil(this.getEdao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

}
