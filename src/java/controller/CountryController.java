package controller;

import dao.CountryDAO;
import entity.Country;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class CountryController implements Serializable {

    private CountryDAO cdao;
    private List<Country> clist;

    private Country country;

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

    public void updateForm(Country country) {
        this.country = country;
    }

    public void clearForm() {
        this.country = new Country();
    }

    public void create() {
        this.getCdao().insert(this.country);
        this.clearForm();
    }

    public void deleteConfirm(Country country) {
        this.country = country;
    }

    public void delete() {
        this.getCdao().delete(this.country);
        this.clearForm();
    }

    public void update() {
        this.getCdao().update(this.country);
        this.clearForm();
    }

    public CountryDAO getCdao() {
        if (this.cdao == null) {
            this.cdao = new CountryDAO();
        }
        return cdao;
    }

    public void setCdao(CountryDAO cdao) {
        this.cdao = cdao;
    }

    public List<Country> getClist() {
        this.clist = this.getCdao().findAll(this.bul, this.page, this.pageSize);
        return clist;
    }

    public void setClist(List<Country> clist) {
        this.clist = clist;
    }

    public Country getCountry() {
        if (this.country == null) {
            this.country = new Country();
        }
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
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
        this.pageCount = (int) Math.ceil(this.getCdao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

}
