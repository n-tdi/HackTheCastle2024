package world.ntdi.hackthejava.ui;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import world.ntdi.hackthejava.ui.components.AidsForm;

@PageTitle("Child Screening")
@Route(value = "", layout = MainLayout.class)
public class ScreeningView extends VerticalLayout {
    public ScreeningView() {
        final H2 title = new H2("Does your child have AIDS/HIV?");
        final Paragraph paragraph = new Paragraph("Here at GN, we've trained A.I. data model to predict the progress of children with aids. Fill out the form below and see how your child is predicted to do.");

        add(title, paragraph, new AidsForm());
    }
}
