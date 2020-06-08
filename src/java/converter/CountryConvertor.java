package converter;

import dao.CountryDAO;
import entity.Country;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "countryConverter")
public class CountryConvertor implements Converter {

    private CountryDAO cdao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return this.getCdao().find(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Country c = (Country) o;
        return String.valueOf(c.getCountry_id());
    }

    public CountryDAO getCdao() {
        if (this.cdao == null) {
            this.cdao = new CountryDAO();
        }
        return cdao;
    }
}
