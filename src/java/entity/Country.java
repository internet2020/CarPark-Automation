package entity;

import java.util.Objects;

public class Country {

    private int country_id;
    private String country_name;
    private long country_population;

    public Country() {
    }

    public Country(int country_id, String country_name, long country_population) {
        this.country_id = country_id;
        this.country_name = country_name;
        this.country_population = country_population;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public long getCountry_population() {
        return country_population;
    }

    public void setCountry_population(long country_population) {
        this.country_population = country_population;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.country_id;
        hash = 37 * hash + Objects.hashCode(this.country_name);
        hash = 37 * hash + (int) (this.country_population ^ (this.country_population >>> 32));
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
        final Country other = (Country) obj;
        if (this.country_id != other.country_id) {
            return false;
        }
        if (this.country_population != other.country_population) {
            return false;
        }
        if (!Objects.equals(this.country_name, other.country_name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Country{" + "country_id=" + country_id + ", country_name=" + country_name + ", country_population=" + country_population + '}';
    }

}
