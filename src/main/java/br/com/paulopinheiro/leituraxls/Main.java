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

public class Main {
    public static void main (String[] args) throws FileNotFoundException, IOException, InvalidFormatException {
        List<CellStyle> lista = new ArrayList<CellStyle>();
        FileInputStream inp = new FileInputStream(args[0]);
        Workbook wb = WorkbookFactory.create(inp);

        for (int i=0;i<wb.getNumberOfSheets();i++) {
            Sheet sheet = wb.getSheetAt(i);

            Iterator<Row> iRow = sheet.rowIterator();

            while (iRow.hasNext()) {
                Row r = iRow.next();
                Iterator<Cell> iCell = r.cellIterator();

                while (iCell.hasNext()) {
                    Cell c = iCell.next();
                    CellStyle cStyle = c.getCellStyle();
                    if (!lista.contains(cStyle)) {
                        lista.add(cStyle);
                    }
                }
            }
        }

        for (CellStyle style:lista) {
            System.out.println(style);
        }

        System.out.println("Total: " + lista.size() + " estilos");
    }

    private static boolean equals(CellStyle c1, CellStyle c2) {
        return false;
    }

}
