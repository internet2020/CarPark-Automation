package entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
/**
 *
 * @author Alperen
 */
public class ParkTransaction {

    private int park_id;
    private User park_user;
    private Carpark park_carpark;

    private Double park_cost;

    private LocalDateTime park_start_time;
    private LocalDateTime park_end_time;
    private ParkPackage park_parkpackage;
    private String park_status;
    private String park_car_name;
    
    private List<ExtraServices> parkTransactionExtraServices;

    public ParkTransaction() {
    }

    public ParkTransaction(int park_id, User park_user, Carpark park_carpark, Double park_cost, LocalDateTime park_start_time, LocalDateTime park_end_time, ParkPackage park_parkpackage, String park_status, String park_car_name, List<ExtraServices> parkTransactionExtraServices) {
        this.park_id = park_id;
        this.park_user = park_user;
        this.park_carpark = park_carpark;
        this.park_cost = park_cost;
        this.park_start_time = park_start_time;
        this.park_end_time = park_end_time;
        this.park_parkpackage = park_parkpackage;
        this.park_status = park_status;
        this.park_car_name = park_car_name;
        this.parkTransactionExtraServices = parkTransactionExtraServices;
    }

   

    public String getPark_car_name() {
        return park_car_name;
    }

    public void setPark_car_name(String park_car_name) {
        this.park_car_name = park_car_name;
    }

    public int getPark_id() {
        return park_id;
    }

    public void setPark_id(int park_id) {
        this.park_id = park_id;
    }

    public User getPark_user() {
        return park_user;
    }

    public void setPark_user(User park_user) {
        this.park_user = park_user;
    }

    public Carpark getPark_carpark() {
        return park_carpark;
    }

    public void setPark_carpark(Carpark park_carpark) {
        this.park_carpark = park_carpark;
    }

    public Double getPark_cost() {
        return park_cost;
    }

    public void setPark_cost(Double park_cost) {
        this.park_cost = park_cost;
    }

    public LocalDateTime getPark_start_time() {
        return park_start_time;
    }

    public void setPark_start_time(LocalDateTime park_start_time) {
        this.park_start_time = park_start_time;
    }

    public LocalDateTime getPark_end_time() {
        return park_end_time;
    }

    public void setPark_end_time(LocalDateTime park_end_time) {
        this.park_end_time = park_end_time;
    }

    public ParkPackage getPark_parkpackage() {
        return park_parkpackage;
    }

    public void setPark_parkpackage(ParkPackage park_parkpackage) {
        this.park_parkpackage = park_parkpackage;
    }

    public String getPark_status() {
        return park_status;
    }

    public void setPark_status(String park_status) {
        this.park_status = park_status;
    }

    public List<ExtraServices> getParkTransactionExtraServices() {
        return parkTransactionExtraServices;
    }

    public void setParkTransactionExtraServices(List<ExtraServices> parkTransactionExtraServices) {
        this.parkTransactionExtraServices = parkTransactionExtraServices;
    }

    @Override
    public String toString() {
        return "ParkTransaction{" + "park_id=" + park_id + ", park_user=" + park_user + ", park_carpark=" + park_carpark + ", park_cost=" + park_cost + ", park_start_time=" + park_start_time + ", park_end_time=" + park_end_time + ", park_parkpackage=" + park_parkpackage + ", park_status=" + park_status + ", park_car_name=" + park_car_name + ", parkTransactionExtraServices=" + parkTransactionExtraServices + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.park_id;
        hash = 79 * hash + Objects.hashCode(this.park_user);
        hash = 79 * hash + Objects.hashCode(this.park_carpark);
        hash = 79 * hash + Objects.hashCode(this.park_cost);
        hash = 79 * hash + Objects.hashCode(this.park_start_time);
        hash = 79 * hash + Objects.hashCode(this.park_end_time);
        hash = 79 * hash + Objects.hashCode(this.park_parkpackage);
        hash = 79 * hash + Objects.hashCode(this.park_status);
        hash = 79 * hash + Objects.hashCode(this.park_car_name);
        hash = 79 * hash + Objects.hashCode(this.parkTransactionExtraServices);
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
        final ParkTransaction other = (ParkTransaction) obj;
        if (this.park_id != other.park_id) {
            return false;
        }
        if (!Objects.equals(this.park_status, other.park_status)) {
            return false;
        }
        if (!Objects.equals(this.park_car_name, other.park_car_name)) {
            return false;
        }
        if (!Objects.equals(this.park_user, other.park_user)) {
            return false;
        }
        if (!Objects.equals(this.park_carpark, other.park_carpark)) {
            return false;
        }
        if (!Objects.equals(this.park_cost, other.park_cost)) {
            return false;
        }
        if (!Objects.equals(this.park_start_time, other.park_start_time)) {
            return false;
        }
        if (!Objects.equals(this.park_end_time, other.park_end_time)) {
            return false;
        }
        if (!Objects.equals(this.park_parkpackage, other.park_parkpackage)) {
            return false;
        }
        if (!Objects.equals(this.parkTransactionExtraServices, other.parkTransactionExtraServices)) {
            return false;
        }
        return true;
    }

}
