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
            if (!estilosResumidosContains(c)) getEstilosResumidos().add(c);
        }
    }

    private boolean estilosResumidosContains(CellStyle candidate) {
        if (this.getEstilosResumidos().contains(candidate)) return true;

        for (CellStyle cs:getEstilosResumidos()) {
            if (igual(cs,candidate)) return true;
        }
        return false;
    }

    private boolean igual(CellStyle cs1, CellStyle cs2) {
        if (cs1.getAlignment()!=cs2.getAlignment()) return false;

        if (cs1.getBorderBottom()!=cs2.getBorderBottom()) return false;
        if (cs1.getBorderLeft()!= cs2.getBorderLeft()) return false;
        if (cs1.getBorderRight()!= cs2.getBorderRight()) return false;
        if (cs1.getBorderTop()!= cs2.getBorderTop()) return false;

        if (cs1.getBottomBorderColor()!=cs2.getBottomBorderColor()) return false;

        if (cs1.getDataFormat()!=cs2.getDataFormat()) return false;
        if (!cs1.getDataFormatString().equals(cs2.getDataFormatString())) return false;

        if (cs1.getFillBackgroundColor()!=cs2.getFillBackgroundColor()) return false;
        if (!cs1.getFillBackgroundColorColor().equals(cs2.getFillBackgroundColorColor())) return false;
        if (cs1.getFillForegroundColor()!=cs2.getFillForegroundColor()) return false;
        if (!cs1.getFillForegroundColorColor().equals(cs2.getFillForegroundColorColor())) return false;
        if (cs1.getFillPattern()!=cs2.getFillPattern()) return false;

        if (cs1.getFontIndex()!=cs2.getFontIndex()) return false;

        if (cs1.getIndention()!=cs2.getIndention()) return false;

        if (cs1.getLeftBorderColor()!=cs2.getLeftBorderColor()) return false;
        if (cs1.getRightBorderColor()!=cs2.getRightBorderColor()) return false;

        if (cs1.getRotation()!=cs2.getRotation()) return false;

        if (cs1.getTopBorderColor()!=cs2.getTopBorderColor()) return false;
        if (cs1.getVerticalAlignment()!=cs2.getVerticalAlignment()) return false;

        if (cs1.getHidden()!=cs2.getHidden()) return false;
        if (cs1.getLocked()!=cs2.getLocked()) return false;
        if (cs1.getShrinkToFit()!=cs2.getShrinkToFit()) return false;
        if (cs1.getWrapText()!=cs2.getWrapText()) return false;

        return true;
    }

    private List<CellStyle> getEstilosExistentes() {
        if (this.estilosExistentes==null) this.estilosExistentes = new ArrayList<CellStyle>();
        return this.estilosExistentes;
    }

    private List<CellStyle> getEstilosResumidos() {
        if (this.estilosResumidos==null) this.estilosResumidos = new ArrayList<CellStyle>();
        return this.estilosResumidos;
    }

    public int quantEstilosExistentes() {
        return this.getEstilosExistentes().size();
    }

    public int quantEstilosResumidos() {
        return this.getEstilosResumidos().size();
    }

}
