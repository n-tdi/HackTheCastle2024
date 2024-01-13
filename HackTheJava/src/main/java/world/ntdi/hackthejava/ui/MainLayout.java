package world.ntdi.hackthejava.ui;


import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class MainLayout extends AppLayout {

    public MainLayout() {
        final H1 logo = new H1("GN Screening");
        logo.addClassNames(
                LumoUtility.FontSize.LARGE,
                LumoUtility.Margin.MEDIUM
        );

        addToNavbar(new DrawerToggle(), logo);
        createDrawer();
    }

    private void createDrawer() {
        addToDrawer(new VerticalLayout(
                new RouterLink("Child Screening", ScreeningView.class)
        ));
    }
}
