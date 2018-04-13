package edu.unapec.iso815.cheques.controller;

import edu.unapec.iso815.cheques.modelos.Proveedores;
import edu.unapec.iso815.cheques.modelos.RegistroSolicitudCheques;
import java.util.Collection;
import edu.unapec.iso815.cheques.facade.ProveedoresFacade;
import edu.unapec.iso815.cheques.controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "proveedoresController")
@ViewScoped
public class ProveedoresController extends AbstractController<Proveedores> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isRegistroSolicitudChequesCollectionEmpty;

    public ProveedoresController() {
        // Inform the Abstract parent controller of the concrete Proveedores Entity
        super(Proveedores.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsRegistroSolicitudChequesCollectionEmpty();
    }

    public boolean getIsRegistroSolicitudChequesCollectionEmpty() {
        return this.isRegistroSolicitudChequesCollectionEmpty;
    }

    private void setIsRegistroSolicitudChequesCollectionEmpty() {
        Proveedores selected = this.getSelected();
        if (selected != null) {
            ProveedoresFacade ejbFacade = (ProveedoresFacade) this.getFacade();
            this.isRegistroSolicitudChequesCollectionEmpty = ejbFacade.isRegistroSolicitudChequesCollectionEmpty(selected);
        } else {
            this.isRegistroSolicitudChequesCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of RegistroSolicitudCheques
     * entities that are retrieved from Proveedores and returns the navigation
     * outcome.
     *
     * @return navigation outcome for RegistroSolicitudCheques page
     */
    public String navigateRegistroSolicitudChequesCollection() {
        Proveedores selected = this.getSelected();
        if (selected != null) {
            ProveedoresFacade ejbFacade = (ProveedoresFacade) this.getFacade();
            Collection<RegistroSolicitudCheques> selectedRegistroSolicitudChequesCollection = ejbFacade.findRegistroSolicitudChequesCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("RegistroSolicitudCheques_items", selectedRegistroSolicitudChequesCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/registroSolicitudCheques/index";
    }

}
