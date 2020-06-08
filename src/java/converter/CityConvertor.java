
package converter;

import dao.CityDAO;
import entity.City;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "cityConverter")
public class CityConvertor implements Converter {

    private CityDAO cdao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return this.getCdao().find(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        City c = (City) o;
        return String.valueOf(c.getCity_id());
    }

    public CityDAO getCdao() {
        if (this.cdao == null) {
            this.cdao = new CityDAO();
        }
        return cdao;
    }
}
