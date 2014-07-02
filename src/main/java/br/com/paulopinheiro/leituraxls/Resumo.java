package br.com.paulopinheiro.leituraxls;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
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
        populateEstilosExistentes();
        extractEstilosResumidos();
    }

    private void populateEstilosExistentes() {
        for (int i=0;i<wb.getNumberOfSheets();i++) {
            Sheet sheet = wb.getSheetAt(i);

            Iterator<Row> iRow = sheet.rowIterator();

            while (iRow.hasNext()) {
                Row r = iRow.next();
                Iterator<Cell> iCell = r.cellIterator();

                while (iCell.hasNext()) {
                    Cell c = iCell.next();
                    CellStyle cStyle = c.getCellStyle();
                    if (!getEstilosExistentes().contains(cStyle)) {
                        getEstilosExistentes().add(cStyle);
                    }
                }
            }
        }
    }

    private void extractEstilosResumidos() {
        this.estilosResumidos=null;
        for (CellStyle c:this.getEstilosExistentes()) {
            
        }
    }

    private boolean estilosResumidosContains(CellStyle candidate) {
        for (CellStyle cs:getEstilosResumidos()) {
            
        }
        return false;
    }

    private List<CellStyle> getEstilosExistentes() {
        if (this.estilosExistentes==null) this.estilosExistentes = new ArrayList<CellStyle>();
        return this.estilosExistentes;
    }

    private List<CellStyle> getEstilosResumidos() {
        if (this.estilosResumidos==null) this.estilosResumidos = new ArrayList<CellStyle>();
        return this.estilosResumidos;
    }
}
