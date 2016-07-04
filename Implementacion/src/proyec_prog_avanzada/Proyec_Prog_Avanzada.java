/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyec_prog_avanzada;

import javax.swing.JFrame;
//import org.jvnet.substance.SubstanceLookAndFeel;

/**
 *
 * @author User
 */
public class Proyec_Prog_Avanzada {

    /**
    * @param args the command line arguments
    */
    public static void main(String[] args) {
        login ventana = new login();
        ventana.setVisible(true);
        JFrame.setDefaultLookAndFeelDecorated(true);
       // SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.CremeCoffeeSkin");
       // SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceEbonyTheme");
    }
}
