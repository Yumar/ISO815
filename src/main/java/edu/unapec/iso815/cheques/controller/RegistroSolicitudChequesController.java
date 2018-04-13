package edu.unapec.iso815.cheques.controller;

import edu.unapec.iso815.cheques.modelos.RegistroSolicitudCheques;
import edu.unapec.iso815.cheques.facade.RegistroSolicitudChequesFacade;
import edu.unapec.iso815.cheques.controller.util.MobilePageController;
import edu.unapec.iso815.cheques.facade.EntityUtility;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "registroSolicitudChequesController")
@ViewScoped
public class RegistroSolicitudChequesController extends AbstractController<RegistroSolicitudCheques> {

    @Inject
    private ProveedoresController identificadorController;
    @Inject
    private MobilePageController mobilePageController;

    public RegistroSolicitudChequesController() {
        // Inform the Abstract parent controller of the concrete RegistroSolicitudCheques Entity
        super(RegistroSolicitudCheques.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        identificadorController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Proveedores controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdentificador(ActionEvent event) {
        RegistroSolicitudCheques selected = this.getSelected();
        if (selected != null && identificadorController.getSelected() == null) {
            identificadorController.setSelected(selected.getIdentificador());
        }
    }

    public Collection<RegistroSolicitudCheques> getPendientes() {
        List<RegistroSolicitudCheques> pendientes = new ArrayList<RegistroSolicitudCheques>();
        for (RegistroSolicitudCheques solicitud : this.getItems()) {
            if (solicitud.getEstado().equals(EntityUtility.ESTADO_CHEQUE_PENDIENTE)) {
                pendientes.add(solicitud);
            }
        }
        return pendientes;
    }

    public void anularChueque(ActionEvent event) {
        this.getSelected().setEstado(EntityUtility.ESTADO_CHEQUE_ANULADO);
        this.save(event);
    }

    public void generarChueque(ActionEvent event) {
        this.getSelected().setEstado(EntityUtility.ESTADO_CHEQUE_APROBADO);
        this.save(event);
    }

}
