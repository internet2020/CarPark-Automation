
package converter;

import dao.CarparkDAO;
import entity.Carpark;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "carparkConverter")
public class CarparkConvertor implements Converter {

    private CarparkDAO cdao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return this.getCdao().find(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Carpark c = (Carpark) o;
        return String.valueOf(c.getCarpark_id());
    }

    public CarparkDAO getCdao() {
        if (this.cdao == null) {
            this.cdao = new CarparkDAO();
        }
        return cdao;
    }
}
