package dguerrar.test.blueliv;



import java.io.File;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import dguerrar.test.blueliv.constants.ReaderOptions;
import dguerrar.test.blueliv.domain.Person;
import dguerrar.test.blueliv.dto.FileReaderDTO;
import dguerrar.test.blueliv.modules.manager.FileReader;
import dguerrar.test.blueliv.modules.manager.impl.FileReaderImpl;
import dguerrar.test.blueliv.modules.printer.Printer;
import dguerrar.test.blueliv.modules.printer.impl.PrinterImpl;
import junit.framework.Assert;

public class OK_Test_Reader {
	private static  String URI;
	
	
	@Before
	public void tearUp() {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("blueliv_test.txt").getFile());
		URI=file.getAbsolutePath();
	}
	
	
	@Test
	public void testReadAndProcessFileCities() {

		FileReaderDTO dto= new FileReaderDTO(URI, ReaderOptions.CITY,"BARCELONA");
		
		FileReader reader= FileReaderImpl.getInstance();
		Set<Person> set=reader.readAndProcessFile(dto);
		Assert.assertTrue(Boolean.FALSE==set.isEmpty());
		
		Printer p= PrinterImpl.getInstance();
		p.printPeople(set);
		
	}
	
	@Test
	public void testReadAndProcessFileID() {
		FileReaderDTO dto= new FileReaderDTO(URI, ReaderOptions.ID,"54808168L");
		
		FileReader reader= FileReaderImpl.getInstance();
		Set<Person> set=reader.readAndProcessFile(dto);
		Assert.assertTrue(Boolean.FALSE==set.isEmpty());
		
		Printer p= PrinterImpl.getInstance();
		p.printPeople(set);
	}

}
