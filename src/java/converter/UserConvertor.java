package converter;

import dao.UserDAO;
import entity.User;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
/**
 *
 * @author Alperen
 */
@FacesConverter(value = "userConverter")
public class UserConvertor implements Converter {

    private UserDAO udao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return this.getUdao().find(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        User u = (User) o;
        return String.valueOf(u.getUser_id());
    }

    public UserDAO getUdao() {
        if (this.udao == null) {
            this.udao = new UserDAO();
        }
        return udao;
    }

}
