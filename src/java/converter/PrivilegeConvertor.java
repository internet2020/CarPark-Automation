package converter;

import dao.PrivilegeDAO;
import entity.Privilege;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
/**
 *
 * @author Alperen
 */
@FacesConverter(value = "privilegeConverter")
public class PrivilegeConvertor implements Converter {

    private PrivilegeDAO pdao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return this.getPdao().find(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Privilege p = (Privilege) o;
        return String.valueOf(p.getPrivilege_id());
    }

    public PrivilegeDAO getPdao() {
        if (this.pdao == null) {
            this.pdao = new PrivilegeDAO();
        }
        return pdao;
    }

}
