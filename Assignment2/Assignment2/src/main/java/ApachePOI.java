/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.servlet.annotation.WebServlet;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author palak
 */
@WebServlet(urlPatterns = {"/ApachePOI.xls"})
public class ApachePOI extends HttpServlet {

    public List<List<String>> list = new ArrayList<>();
    public List<String> head = new ArrayList<>();
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            FileInputStream file = new FileInputStream(new File("D:\\HW2\\store.xls"));

            HSSFWorkbook workbook = new HSSFWorkbook(file);
            HSSFSheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();
            if (rowIterator.hasNext()) {
                Row headers = rowIterator.next();
                Iterator<Cell> cellIterator = headers.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            head.add(cell.getNumericCellValue() + "");
                            break;
                        case STRING:
                            head.add(cell.getStringCellValue());
                            break;
                    }
                }
            }
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                List<String> temp = new ArrayList<>();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            temp.add(cell.getNumericCellValue() + "");
                            break;
                        case STRING:
                            temp.add(cell.getStringCellValue());
                            break;
                    }
                }
                list.add(temp);
            }
            file.close();
            request.setAttribute("list", list);
            request.setAttribute("tblHead", head);
            request.getRequestDispatcher("Part5.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }
    }

}
