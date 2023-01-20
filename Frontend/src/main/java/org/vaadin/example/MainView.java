package org.vaadin.example;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and
 * use @Route annotation to announce it in a URL as a Spring managed
 * bean.
 * Use the @PWA annotation make the application installable on phones,
 * tablets and some desktop browsers.
 * <p>
 * A new instance of this class is created for every new user and every
 * browser tab/window.
 */
@Route
@PWA(name = "Vaadin Application",
        shortName = "Vaadin App",
        description = "This is an example Vaadin application.",
        enableInstallPrompt = false)
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends VerticalLayout {

    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     *
     * @param service The message service. Automatically injected Spring managed bean.
     */
    public MainView(@Autowired GreetService service) {
        HorizontalLayout horizontal1= new HorizontalLayout();
        HorizontalLayout horizontal2= new HorizontalLayout();
        ArrayList<Producto> listaProductos = new ArrayList<>();
        // Use TextField for standard text input
        Label etiqueta1 = new Label("Nombre:");
        TextField texto1 = new TextField();
        Label etiqueta2 = new Label("Categoría:");
        TextField texto2 = new TextField();
        Label etiqueta3 = new Label("Precio:");
        TextField texto3 = new TextField();
        Label etiqueta4 = new Label("EAN13:");
        TextField texto4 = new TextField();

        Button boton = new Button("Añadir");

        Grid<Producto> grid = new Grid<>(Producto.class, false);
        grid.addColumn(Producto::getNombre).setHeader("Nombre");
        grid.addColumn(Producto::getCategoria).setHeader("Categoria");
        grid.addColumn(Producto::getPrecio).setHeader("Precio");
        grid.addColumn(Producto::getEAN13).setHeader("EAN13");

        try {
            listaProductos = DataService.getProductos(listaProductos);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        grid.setItems(listaProductos);

        horizontal1.add(etiqueta1, texto1, etiqueta2, texto2, etiqueta3, texto3, etiqueta4, texto4);
        add(horizontal1, boton);

        horizontal2.add(grid);
        add(horizontal2, grid);



    }

}
