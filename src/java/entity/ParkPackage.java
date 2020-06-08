package entity;

import java.util.Objects;

public class ParkPackage {

    private int parkpackage_id;
    private String parkpackage_name;
    private Double parkpackage_cost;
    private String parkpackage_descritpion;
    private long parkpackage_time;

    public ParkPackage() {
    }

    public ParkPackage(int parkpackage_id, String parkpackage_name, Double parkpackage_cost, String parkpackage_descritpion, long parkpackage_time) {
        this.parkpackage_id = parkpackage_id;
        this.parkpackage_name = parkpackage_name;
        this.parkpackage_cost = parkpackage_cost;
        this.parkpackage_descritpion = parkpackage_descritpion;
        this.parkpackage_time = parkpackage_time;
    }

   
    public int getParkpackage_id() {
        return parkpackage_id;
    }

    public void setParkpackage_id(int parkpackage_id) {
        this.parkpackage_id = parkpackage_id;
    }

    public String getParkpackage_name() {
        return parkpackage_name;
    }

    public void setParkpackage_name(String parkpackage_name) {
        this.parkpackage_name = parkpackage_name;
    }

    public Double getParkpackage_cost() {
        return parkpackage_cost;
    }

    public void setParkpackage_cost(Double parkpackage_cost) {
        this.parkpackage_cost = parkpackage_cost;
    }

    public String getParkpackage_descritpion() {
        return parkpackage_descritpion;
    }

    public void setParkpackage_descritpion(String parkpackage_descritpion) {
        this.parkpackage_descritpion = parkpackage_descritpion;
    }

    public long getParkpackage_time() {
        return parkpackage_time;
    }

    public void setParkpackage_time(long parkpackage_time) {
        this.parkpackage_time = parkpackage_time;
    }

    @Override
    public String toString() {
        return "ParkPackage{" + "parkpackage_id=" + parkpackage_id + ", parkpackage_name=" + parkpackage_name + ", parkpackage_cost=" + parkpackage_cost + ", parkpackage_descritpion=" + parkpackage_descritpion + ", parkpackage_time=" + parkpackage_time + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.parkpackage_id;
        hash = 53 * hash + Objects.hashCode(this.parkpackage_name);
        hash = 53 * hash + Objects.hashCode(this.parkpackage_cost);
        hash = 53 * hash + Objects.hashCode(this.parkpackage_descritpion);
        hash = 53 * hash + (int) (this.parkpackage_time ^ (this.parkpackage_time >>> 32));
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
        final ParkPackage other = (ParkPackage) obj;
        if (this.parkpackage_id != other.parkpackage_id) {
            return false;
        }
        if (this.parkpackage_time != other.parkpackage_time) {
            return false;
        }
        if (!Objects.equals(this.parkpackage_name, other.parkpackage_name)) {
            return false;
        }
        if (!Objects.equals(this.parkpackage_descritpion, other.parkpackage_descritpion)) {
            return false;
        }
        if (!Objects.equals(this.parkpackage_cost, other.parkpackage_cost)) {
            return false;
        }
        return true;
    }
     
}
