package br.com.paulopinheiro.leituraxls;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Resumo {
    private List<CellStyle> estilosExistentes;
    private List<CellStyle> estilosResumidos;
    private final FileInputStream inp;
    private final Workbook wb;

    public Resumo(String arquivo) throws FileNotFoundException, IOException, InvalidFormatException {
        this.inp = new FileInputStream(arquivo);
        this.wb = WorkbookFactory.create(inp);
    }

    private void resumeEstilos() {
        
    }
}
