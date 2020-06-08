/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.ExtraServicesDAO;
import entity.ExtraServices;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "extraservicesConverter")
public class ExtraServicesConvertor implements Converter {

    private ExtraServicesDAO edao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return this.getEdao().find(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        ExtraServices es = (ExtraServices) o;
        return String.valueOf(es.getService_id());
    }

    public ExtraServicesDAO getEdao() {
        if (this.edao == null) {
            this.edao = new ExtraServicesDAO();
        }
        return edao;
    }
}
