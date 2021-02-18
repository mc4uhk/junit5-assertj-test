package hk.mc4u.junit5test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test06 {

	@Test
	public void test01() throws Exception {
		marshal() ;
		log.info("{}",unmarshall());
	}
	
	

	public void marshal() throws JAXBException, IOException {
	    Book book = new Book();
	    book.setId(1L);
	    book.setName("Book1");
	    book.setAuthor("Author1");
	    book.setDate(new Date());

	    JAXBContext context = JAXBContext.newInstance(Book.class);
	    Marshaller mar= context.createMarshaller();
	    mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	    mar.marshal(book, new File("./book.xml"));
	}
	
	public Book unmarshall() throws JAXBException, IOException {
	    JAXBContext context = JAXBContext.newInstance(Book.class);
	    return (Book) context.createUnmarshaller()
	      .unmarshal(new FileReader("./book.xml"));
	}	
}
