package hk.mc4u.junit5test;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test04 {

	public void createPdf(String dest) throws Exception {
		//removed itext dependancy
        //Initialize PDF writer
//        PdfWriter writer = new PdfWriter(dest);
//
//        //Initialize PDF document
//        PdfDocument pdf = new PdfDocument(writer);
//        pdf.setDefaultPageSize(PageSize.A4);
//        
//        // Initialize document
//        Document document = new Document(pdf);
//        //Add paragraph to the document
//        document.add(new Paragraph("Hello World!"));
//        
//        
//        PdfCanvas canvas = new PdfCanvas(pdf.getFirstPage());
//        for(int x=0; x<=550 ; x+=50) {
//            for(int y=0; y<=800 ; y+=50) {
//            	
//        canvas.beginText().setFontAndSize(
//                PdfFontFactory.createFont(FontConstants.HELVETICA), 12)
//                .moveText(x, y)
//                .showText(String.format("%d,%d", x,y))
//                .endText();
//            }        
//        }
//        //Close document
//        document.close();
    }

	@Test
	public void test01() throws Exception {
		createPdf("/home/edmund/temp/temp.pdf");
	}

}
