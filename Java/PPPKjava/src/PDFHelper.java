import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PDFHelper {


    private static EntityManagerFactory emf;

    public static String[][] append(String[][] a, String[][] b) {

        String[][] result = new String[a.length + b.length][];

        System.arraycopy(a, 0, result, 0, a.length);

        System.arraycopy(b, 0, result, a.length, b.length);
        return result;

    }


    public void PDFwriter(int id) {


        final String[][][] content = {{{"IDPutniNalog", "DatumOdlaska", "DatumDolaska",
                "BrojSati", "BrojDnevnica", "IznosDnevnice", "Opis"}}};

        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
            EntityManager em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();

            Session session = em.unwrap(Session.class);
            session.doWork(new Work() {

                @Override
                public void execute(Connection con) throws SQLException {
                    // do something useful
                    try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM PutniNalog WHERE IDPutniNalog"+"=" + id)) {
                        ResultSet rec = stmt.executeQuery();
                        while (rec.next()) {
                            String[][] data = {{rec.getString("IDPutniNalog")
                                    , rec.getString("DatumOdlaska")
                                    , rec.getString("DatumDolaska")
                                    , rec.getString("BrojSati")
                                    , rec.getString("BrojDnevnica")
                                    , rec.getString("IznosDnevnice")
                                    , rec.getString("Opis")}};

                            content[0] = append(content[0], data);
                        }
                    }
                }
            });

            em.getTransaction().commit();
            em.close();

       } catch (Exception e) {

            e.printStackTrace();

        }

        try {

            PDDocument doc = new PDDocument();
            PDPage page = new PDPage();
            doc.addPage(page);
            PDPageContentStream contentStream =
                    new PDPageContentStream(doc, page);

// Create a new font object selecting one of the PDF base fonts
            PDFont font = PDType1Font.HELVETICA_BOLD;

// Define a text content stream using the selected font, moving the cursor and drawing the text "Hello World"

            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.moveTextPositionByAmount(30, 700);
            contentStream.drawString("Izvjestaj putnog naloga");
            contentStream.endText();


            drawTable(page, contentStream, 690, 30, content[0]);
            contentStream.close();

// Save the results and ensure that the document is properly closed:
            doc.save("F:\\Documents\\Projektonž\\MVC-and-Java\\Java\\PPPKjava\\src\\PutniNalog.pdf");
            doc.close();
            System.out.println("PDF Created Done.");

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public static void drawTable(PDPage page,
                                 PDPageContentStream contentStream, float y, float margin,
                                 String[][] content) throws IOException {

        final int rows = content.length;
        final int cols = content[0].length;
        final float rowHeight = 20f;
        final float tableWidth = page.getMediaBox().getWidth() - (2 * margin);
        final float tableHeight = rowHeight * rows;
        final float colWidth = tableWidth / (float) cols;
        final float cellMargin = 2f;


// draw the rows
        float nexty = y;
        for (int i = 0; i <= rows; i++) {
            contentStream.drawLine(margin, nexty, margin + tableWidth, nexty);
            nexty -= rowHeight;
        }


// draw the columns
        float nextx = margin;
        for (int i = 0; i <= cols; i++) {
            contentStream.drawLine(nextx, y, nextx, y - tableHeight);
            nextx += colWidth;

        }

// now add the text

        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 6);
        float textx = margin + cellMargin;
        float texty = y - 15;
        for (int i = 0; i < content.length; i++) {
            for (int j = 0; j < content[i].length; j++) {
                String text = content[i][j];
                contentStream.beginText();
                contentStream.moveTextPositionByAmount(textx, texty);
                contentStream.drawString(text);
                contentStream.endText();
                textx += colWidth;

            }
            texty -= rowHeight;
            textx = margin + cellMargin;

        }

    }
}



