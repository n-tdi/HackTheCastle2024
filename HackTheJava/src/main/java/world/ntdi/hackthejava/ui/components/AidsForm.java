package world.ntdi.hackthejava.ui.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import world.ntdi.hackthejava.services.PredictionModelService;

public class AidsForm extends VerticalLayout {
    public AidsForm(PredictionModelService predictionModelService) {
        // insurance provider
        // Description of gyatt

        // Output cost

        String insuranceValue;
        final TextField insuranceProvider = new TextField("Insurance Provider");
//        insuranceProvider.setAllowCustomValue(true);
//        insuranceProvider.setItems(List.of("Insurance A", "Insurance B", "Insurance C")); // TODO: Add items to list
//        insuranceProvider.addCustomValueSetListener(comboBoxCustomValueSetEvent ->
//                insuranceProvider.setValue(comboBoxCustomValueSetEvent.getDetail()));

        final TextField descriptionOfHospitalization = new TextField("Hospitalization Reason");
//        descriptionOfHospitalization.setAllowCustomValue(true);
        descriptionOfHospitalization.setWidthFull();
//        descriptionOfHospitalization.setItems(List.of("Seizure", "Stroke", "Heart Attack")); // TODO: Add items to list
//        descriptionOfHospitalization.addCustomValueSetListener(comboBoxCustomValueSetEvent ->
//                descriptionOfHospitalization.setValue(comboBoxCustomValueSetEvent.getDetail()));

        final Button submit = new Button("Evaluate");
        submit.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        final Hr hr = new Hr();

        final TextField predictedCost = new TextField("Predicted Cost");
        predictedCost.setReadOnly(true);

        final HorizontalLayout horizontalLayout = new HorizontalLayout(insuranceProvider, descriptionOfHospitalization,
                submit);
        horizontalLayout.setWidthFull();
        horizontalLayout.setAlignItems(Alignment.BASELINE);

        add(horizontalLayout, hr, predictedCost);

        submit.addClickListener(buttonClickEvent -> {
           if (insuranceProvider.isEmpty() || descriptionOfHospitalization.isEmpty()) {
               final Notification errorNotification = new Notification("Please fill out all the requested fields!");
               errorNotification.addThemeVariants(NotificationVariant.LUMO_ERROR);
               errorNotification.setDuration(3 * 1000);
               errorNotification.open();
               return;
           }

           final String provider = insuranceProvider.getValue();
           final String description = descriptionOfHospitalization.getValue();

           final int value = predictionModelService.predictCost(provider, description);

           predictedCost.setValue("$" + value);
        });
    }
}
