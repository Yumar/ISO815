package edu.unapec.iso815.cheques.converter;

import edu.unapec.iso815.cheques.modelos.ConceptosPago;
import edu.unapec.iso815.cheques.facade.ConceptosPagoFacade;
import edu.unapec.iso815.cheques.controller.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "conceptosPagoConverter")
public class ConceptosPagoConverter implements Converter {

    private ConceptosPagoFacade ejbFacade;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.getEjbFacade().find(getKey(value));
    }

    java.lang.Integer getKey(String value) {
        java.lang.Integer key;
        key = Integer.valueOf(value);
        return key;
    }

    String getStringKey(java.lang.Integer value) {
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
        if (object instanceof ConceptosPago) {
            ConceptosPago o = (ConceptosPago) object;
            return getStringKey(o.getIdentificador());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ConceptosPago.class.getName()});
            return null;
        }
    }

    private ConceptosPagoFacade getEjbFacade() {
        this.ejbFacade = CDI.current().select(ConceptosPagoFacade.class).get();
        return this.ejbFacade;
    }
}
