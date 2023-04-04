/**
 * Practica 3 Algoritmos Avanzados - Ing Informática UIB
 *
 * @date 23/04/2023
 * @author jfher, JordiSM, peremarc, MarcoMG
 * @url
 */
package view;

import model.Model;
import controller.Controller;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.LineBorder;

/**
 * Vista de la aplicación, aquí interactuaremos con la aplicación y
 * visualizaremos todos los datos y los resultados de las operaciónes.
 */
public class View extends JFrame {

    // PUNTEROS DEL PATRÓN MVC
    private Controller controlador;
    private Model modelo;

    // CONSTANTES DE LA VISTA
    protected final int MARGENLAT = 200;
    protected final int MARGENVER = 150;
    
    // VARIABLES DEL JPanel
    private int GraphWidth;
    private int GraphHeight;
    
    
    // CONSTRUCTORS
    public View() {
    }

    public View(Controller controlador, Model modelo) {
        this.controlador = controlador;
        this.modelo = modelo;
    }

    // CLASS METHODS
    /**
     * Clase que inicializa la ventana principal y añade todos los elementos al
     * JFrame.
     */
    public void mostrar() {
        this.setTitle("Práctica 3 - Algoritmos Avanzados");
        this.setLayout(null);
        
        this.GraphWidth  = 850;
        this.GraphHeight = 650;
       
        // DIMENSION DEL JFRAME
        setSize(this.GraphWidth + this.MARGENLAT*2, this.GraphHeight + this.MARGENVER + 40);
        
        // POSICIONAR EL JFRAME EN EL CENTRO DE LA PANTALLA
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        // TITTLE PANEL
        JPanel title = new JPanel();
        title.setBounds(10, 10, getWidth() - 20, this.MARGENVER-20);
        title.setBackground(Color.WHITE);
        title.setBorder(new LineBorder(Color.BLACK, 2));
        
        JLabel titleLabel = new JLabel("Titulo");
        title.add(titleLabel);
        
        this.add(title);
        
        // GRAPH PANEL
        GraphPanel panel = new GraphPanel(this, GraphWidth, GraphHeight);
        this.add(panel);
        
        // PANELES LATERALES
        LeftLateralPanel leftPanel = new LeftLateralPanel(this);
        this.add(leftPanel);
        
        RightLateralPanel rightPanel = new RightLateralPanel(this);
        this.add(rightPanel);
        
        // ÚLTIMOS AJUSTES
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }

    // GETTERS & SETTERS
    public Controller getControlador() {
        return controlador;
    }

    public void setControlador(Controller controlador) {
        this.controlador = controlador;
    }

    public Model getModelo() {
        return modelo;
    }

    public void setModelo(Model modelo) {
        this.modelo = modelo;
    }

}
