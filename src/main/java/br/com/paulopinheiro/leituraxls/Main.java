package br.com.paulopinheiro.leituraxls;

import br.com.paulopinheiro.leituraxls.view.Principal;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class Main {
    public static void main (String[] args) throws FileNotFoundException, IOException, InvalidFormatException {
        JFrame principal = new Principal();
        principal.setVisible(true);
    }
}
