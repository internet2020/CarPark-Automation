package entity;

import java.util.List;
import java.util.Objects;

public class Carpark {

    private int carpark_id;
    private String carpark_name;
    private int carpark_capacity;
    private City carpark_city;
    private Country carpark_country;
    private String carpark_address;
    private int carpark_popularity;

    private List<ExtraServices> CarparkServices;

    public Carpark() {
    }

    public Carpark(int carpark_id, String carpark_name, int carpark_capacity, City carpark_city, Country carpark_country, String carpark_address, int carpark_popularity, List<ExtraServices> CarparkServices) {
        this.carpark_id = carpark_id;
        this.carpark_name = carpark_name;
        this.carpark_capacity = carpark_capacity;
        this.carpark_city = carpark_city;
        this.carpark_country = carpark_country;
        this.carpark_address = carpark_address;
        this.carpark_popularity = carpark_popularity;
        this.CarparkServices = CarparkServices;
    }

    public int getCarpark_id() {
        return carpark_id;
    }

    public void setCarpark_id(int carpark_id) {
        this.carpark_id = carpark_id;
    }

    public String getCarpark_name() {
        return carpark_name;
    }

    public void setCarpark_name(String carpark_name) {
        this.carpark_name = carpark_name;
    }

    public int getCarpark_capacity() {
        return carpark_capacity;
    }

    public void setCarpark_capacity(int carpark_capacity) {
        this.carpark_capacity = carpark_capacity;
    }

    public City getCarpark_city() {
        return carpark_city;
    }

    public void setCarpark_city(City carpark_city) {
        this.carpark_city = carpark_city;
    }

    public Country getCarpark_country() {
        return carpark_country;
    }

    public void setCarpark_country(Country carpark_country) {
        this.carpark_country = carpark_country;
    }

    public String getCarpark_address() {
        return carpark_address;
    }

    public void setCarpark_address(String carpark_address) {
        this.carpark_address = carpark_address;
    }

    public int getCarpark_popularity() {
        return carpark_popularity;
    }

    public void setCarpark_popularity(int carpark_popularity) {
        this.carpark_popularity = carpark_popularity;
    }

    public List<ExtraServices> getCarparkServices() {
        return CarparkServices;
    }

    public void setCarparkServices(List<ExtraServices> CarparkServices) {
        this.CarparkServices = CarparkServices;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.carpark_id;
        hash = 97 * hash + Objects.hashCode(this.carpark_name);
        hash = 97 * hash + this.carpark_capacity;
        hash = 97 * hash + Objects.hashCode(this.carpark_city);
        hash = 97 * hash + Objects.hashCode(this.carpark_country);
        hash = 97 * hash + Objects.hashCode(this.carpark_address);
        hash = 97 * hash + this.carpark_popularity;
        hash = 97 * hash + Objects.hashCode(this.CarparkServices);
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
        final Carpark other = (Carpark) obj;
        if (this.carpark_id != other.carpark_id) {
            return false;
        }
        if (this.carpark_capacity != other.carpark_capacity) {
            return false;
        }
        if (this.carpark_popularity != other.carpark_popularity) {
            return false;
        }
        if (!Objects.equals(this.carpark_name, other.carpark_name)) {
            return false;
        }
        if (!Objects.equals(this.carpark_address, other.carpark_address)) {
            return false;
        }
        if (!Objects.equals(this.carpark_city, other.carpark_city)) {
            return false;
        }
        if (!Objects.equals(this.carpark_country, other.carpark_country)) {
            return false;
        }
        if (!Objects.equals(this.CarparkServices, other.CarparkServices)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Carpark{" + "carpark_id=" + carpark_id + ", carpark_name=" + carpark_name + ", carpark_capacity=" + carpark_capacity + ", carpark_city=" + carpark_city + ", carpark_country=" + carpark_country + ", carpark_address=" + carpark_address + ", carpark_popularity=" + carpark_popularity + ", CarparkServices=" + CarparkServices + '}';
    }

}
