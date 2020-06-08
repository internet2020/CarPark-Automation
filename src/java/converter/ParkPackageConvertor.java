
package converter;

import dao.ParkPackageDAO;
import entity.ParkPackage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "parkPackageConverter")
public class ParkPackageConvertor implements Converter {

    private ParkPackageDAO pdao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return this.getPdao().find(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        ParkPackage parkPackage = (ParkPackage) o;
        return String.valueOf(parkPackage.getParkpackage_id());
    }

    public ParkPackageDAO getPdao() {
        if (this.pdao == null) {
            this.pdao = new ParkPackageDAO();
        }
        return pdao;
    }

}
