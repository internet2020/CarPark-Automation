package controller;

import dao.CarparkDAO;
import entity.Carpark;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class CarparkController implements Serializable {

    private CarparkDAO carparkdao;
    private List<Carpark> clist;

    private Carpark carpark;

    /**
     * bul değişkeni search için diğerleri pagination için oluşturuldu.
     */
    private String bul = "";
    private int page = 1;
    private int pageSize = 5;
    private int pageCount;

    @Inject
    private CountryController countryController;
    @Inject
    private CityController cityController;
    @Inject
    private ExtraServicesController extraServicesController;

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

    public void updateForm(Carpark carpark) {
        this.carpark = carpark;
    }

    public void clearForm() {
        this.carpark = new Carpark();
    }

    public void create() {

        this.getCarparkdao().insert(this.carpark);

        this.clearForm();
    }

    public void deleteConfirm(Carpark carpark) {
        this.carpark = carpark;
    }

    public void delete() {
        this.getCarparkdao().delete(this.carpark);
        this.clearForm();
    }

    public void update() {
        this.getCarparkdao().update(this.carpark);
        this.clearForm();
    }

    public CarparkDAO getCarparkdao() {
        if (this.carparkdao == null) {
            this.carparkdao = new CarparkDAO();
        }
        return carparkdao;
    }

    public void setCarpakdao(CarparkDAO carparkdao) {
        this.carparkdao = carparkdao;
    }

    public List<Carpark> getClist() {
        this.clist = this.getCarparkdao().findAll(this.bul, this.page, this.pageSize);
        return clist;
    }

    public void setClist(List<Carpark> clist) {
        this.clist = clist;
    }

    public Carpark getCarpark() {
        if (this.carpark == null) {
            this.carpark = new Carpark();
        }
        return carpark;
    }

    public void setCarpark(Carpark carpark) {
        this.carpark = carpark;
    }

    public CountryController getCountryController() {
        return countryController;
    }

    public CityController getCityController() {
        return cityController;
    }

    public ExtraServicesController getExtraServicesController() {
        return extraServicesController;
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
        this.pageCount = (int) Math.ceil(this.getCarparkdao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

}
