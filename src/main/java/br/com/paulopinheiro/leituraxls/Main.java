package br.com.paulopinheiro.leituraxls;

import br.com.paulopinheiro.leituraxls.view.Principal;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class Main {
    public static void main (String[] args) throws FileNotFoundException, IOException, InvalidFormatException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        JFrame principal = new Principal();
        principal.setVisible(true);
    }
}
