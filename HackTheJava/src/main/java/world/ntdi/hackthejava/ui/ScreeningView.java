package world.ntdi.hackthejava.ui;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import world.ntdi.hackthejava.ui.components.AidsForm;

@PageTitle("Child Hospital Costs")
@Route(value = "", layout = MainLayout.class)
public class ScreeningView extends VerticalLayout {
    public ScreeningView() {
        final H2 title = new H2("Is your child in the hospital?");
        final Paragraph paragraph = new Paragraph("Fill out the cost evaluation survey below, and with our trained A.I. dataset, we can give you a estimate of the final cost.");

        add(title, paragraph, new AidsForm());
    }
}
