package es.ufv.dis.final22.back.grc;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;


public class EscribirPDF {

    public void escribirPDF(ArrayList<Producto> lista){
        try{

            Document doc = new Document(PageSize.A4, 50, 50, 100, 72);

            for (Producto i : lista) {
                try {
                    PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("productos/" + i.getNombre() + ".pdf"));
                } catch (DocumentException ex) {
                    throw new RuntimeException(ex);
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                doc.open();
                String text = i.toString();
                Paragraph p = new Paragraph(text);
                p.setAlignment(Element.ALIGN_JUSTIFIED);

                try {
                    doc.add(p);
                } catch (DocumentException e) {
                    throw new RuntimeException(e);
                }

                doc.close();
            }


        }
        catch(Exception ex){
            ex.toString();
        }
    }
    
    
}
