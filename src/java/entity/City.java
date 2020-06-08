package entity;

import java.util.Objects;

public class City {

    private int city_id;
    private String city_name;
    private long city_population;
    private Country country;

    public City() {
    }

    public City(int city_id, String city_name, long city_population, Country country) {
        this.city_id = city_id;
        this.city_name = city_name;
        this.city_population = city_population;
        this.country = country;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public long getCity_population() {
        return city_population;
    }

    public void setCity_population(long city_population) {
        this.city_population = city_population;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.city_id;
        hash = 43 * hash + Objects.hashCode(this.city_name);
        hash = 43 * hash + (int) (this.city_population ^ (this.city_population >>> 32));
        hash = 43 * hash + Objects.hashCode(this.country);
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
        final City other = (City) obj;
        if (this.city_id != other.city_id) {
            return false;
        }
        if (this.city_population != other.city_population) {
            return false;
        }
        if (!Objects.equals(this.city_name, other.city_name)) {
            return false;
        }
        if (!Objects.equals(this.country, other.country)) {
            return false;
        }
        return true;
    }

  

    @Override
    public String toString() {
        return "City{" + "city_id=" + city_id + ", city_name=" + city_name + ", city_population=" + city_population + ", country=" + country + '}';
    }

    

}
