package edu.unapec.iso815.cheques.controller;

import edu.unapec.iso815.cheques.modelos.ConceptosPago;
import edu.unapec.iso815.cheques.facade.ConceptosPagoFacade;
import edu.unapec.iso815.cheques.controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "conceptosPagoController")
@ViewScoped
public class ConceptosPagoController extends AbstractController<ConceptosPago> {

    @Inject
    private MobilePageController mobilePageController;

    public ConceptosPagoController() {
        // Inform the Abstract parent controller of the concrete ConceptosPago Entity
        super(ConceptosPago.class);
    }

}
