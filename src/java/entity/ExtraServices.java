package entity;

import java.util.List;
import java.util.Objects;

public class ExtraServices {

    private int service_id;
    private String service_name;
    private double service_cost;

    public ExtraServices() {
    }

    public ExtraServices(int service_id, String service_name, double service_cost) {
        this.service_id = service_id;
        this.service_name = service_name;
        this.service_cost = service_cost;

    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public double getService_cost() {
        return service_cost;
    }

    public void setService_cost(double service_cost) {
        this.service_cost = service_cost;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.service_id;
        hash = 53 * hash + Objects.hashCode(this.service_name);
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.service_cost) ^ (Double.doubleToLongBits(this.service_cost) >>> 32));
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
        final ExtraServices other = (ExtraServices) obj;
        if (this.service_id != other.service_id) {
            return false;
        }
        if (Double.doubleToLongBits(this.service_cost) != Double.doubleToLongBits(other.service_cost)) {
            return false;
        }
        if (!Objects.equals(this.service_name, other.service_name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ExtraServices{" + "service_id=" + service_id + ", service_name=" + service_name + ", service_cost=" + service_cost + '}';
    }

}
