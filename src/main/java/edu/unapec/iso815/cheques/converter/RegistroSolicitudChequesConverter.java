package edu.unapec.iso815.cheques.converter;

import edu.unapec.iso815.cheques.modelos.RegistroSolicitudCheques;
import edu.unapec.iso815.cheques.facade.RegistroSolicitudChequesFacade;
import edu.unapec.iso815.cheques.controller.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "registroSolicitudChequesConverter")
public class RegistroSolicitudChequesConverter implements Converter {

    private RegistroSolicitudChequesFacade ejbFacade;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.getEjbFacade().find(getKey(value));
    }

    java.lang.Long getKey(String value) {
        java.lang.Long key;
        key = Long.valueOf(value);
        return key;
    }

    String getStringKey(java.lang.Long value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value);
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof RegistroSolicitudCheques) {
            RegistroSolicitudCheques o = (RegistroSolicitudCheques) object;
            return getStringKey(o.getNúmeroSolicitud());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), RegistroSolicitudCheques.class.getName()});
            return null;
        }
    }

    private RegistroSolicitudChequesFacade getEjbFacade() {
        this.ejbFacade = CDI.current().select(RegistroSolicitudChequesFacade.class).get();
        return this.ejbFacade;
    }
}
