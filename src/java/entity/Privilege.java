package entity;

import java.util.Objects;
/**
 *
 * @author Alperen
 */
public class Privilege {

    private int privilege_id;
    private String privilege_name;
    private String privilege_description;

    public Privilege() {
    }

    public Privilege(int privilege_id, String privilege_name, String privilege_description) {
        this.privilege_id = privilege_id;
        this.privilege_name = privilege_name;
        this.privilege_description = privilege_description;
    }

    public int getPrivilege_id() {
        return privilege_id;
    }

    public void setPrivilege_id(int privilege_id) {
        this.privilege_id = privilege_id;
    }

    public String getPrivilege_name() {
        return privilege_name;
    }

    public void setPrivilege_name(String privilege_name) {
        this.privilege_name = privilege_name;
    }

    public String getPrivilege_description() {
        return privilege_description;
    }

    public void setPrivilege_description(String privilege_description) {
        this.privilege_description = privilege_description;
    }

    @Override
    public String toString() {
        return "Privilege{" + "privilege_id=" + privilege_id + ", privilege_name=" + privilege_name + ", privilege_description=" + privilege_description + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.privilege_id;
        hash = 11 * hash + Objects.hashCode(this.privilege_name);
        hash = 11 * hash + Objects.hashCode(this.privilege_description);
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
        final Privilege other = (Privilege) obj;
        if (this.privilege_id != other.privilege_id) {
            return false;
        }
        if (!Objects.equals(this.privilege_name, other.privilege_name)) {
            return false;
        }
        if (!Objects.equals(this.privilege_description, other.privilege_description)) {
            return false;
        }
        return true;
    }

}
