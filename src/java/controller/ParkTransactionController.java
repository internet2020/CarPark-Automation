package controller;

import dao.ParkTransactionDAO;
import entity.ParkTransaction;
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
public class ParkTransactionController implements Serializable {

    private ParkTransactionDAO pdao;
    private List<ParkTransaction> plist;
    private ParkTransaction parkTransaction;

    private List<ParkTransaction> customerTransactionList;

    @Inject
    private UserController userController;
    @Inject
    private CarparkController carparkController;

    @Inject
    private ParkPackageController parkPackageController;

    @Inject
    private ExtraServicesController extraServicesController;

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

    public void updateForm(ParkTransaction parkTransaction) {
        this.parkTransaction = parkTransaction;
    }

    public void clearForm() {
        this.parkTransaction = new ParkTransaction();
    }

    public void create() {

        this.getPdao().insert(this.parkTransaction);

        this.clearForm();
    }

    public void createFront() {
        this.parkTransaction.setPark_status("Devam Ediyor");
        this.getPdao().insert(this.parkTransaction);

        this.clearForm();
    }

    public void deleteConfirm(ParkTransaction parkTransaction) {
        this.parkTransaction = parkTransaction;
    }

    public void delete() {
        this.getPdao().delete(this.parkTransaction);
        this.clearForm();
    }

    public void update() {
        this.getPdao().update(this.parkTransaction);
        this.clearForm();
    }

    public ParkTransactionDAO getPdao() {
        if (this.pdao == null) {
            this.pdao = new ParkTransactionDAO();
        }
        return pdao;
    }

    public void setPdao(ParkTransactionDAO pdao) {
        this.pdao = pdao;
    }

    public List<ParkTransaction> getPlist() {
        this.plist = this.getPdao().findAll(this.bul, this.page, this.pageSize);

        return plist;
    }

    public List<ParkTransaction> getCustomerTransactionList(int id) {
        this.customerTransactionList = this.getPdao().findCustomerTransaction(id, this.page, this.pageSize);
        return customerTransactionList;
    }

    public void setCustomerTransactionList(List<ParkTransaction> customerTransactionList) {
        this.customerTransactionList = customerTransactionList;
    }

    public void setPlist(List<ParkTransaction> plist) {
        this.plist = plist;
    }

    public ParkTransaction getParkTransaction() {
        if (this.parkTransaction == null) {
            this.parkTransaction = new ParkTransaction();
        }
        return parkTransaction;
    }

    public void setParkTransaction(ParkTransaction parkTransaction) {
        this.parkTransaction = parkTransaction;
    }

    public UserController getUserController() {
        return userController;
    }

    public CarparkController getCarparkController() {
        return carparkController;
    }

    public ParkPackageController getParkPackageController() {
        return parkPackageController;
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
        this.pageCount = (int) Math.ceil(this.getPdao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

}
