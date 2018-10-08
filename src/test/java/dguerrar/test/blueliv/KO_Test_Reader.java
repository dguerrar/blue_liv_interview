package dguerrar.test.blueliv;

import java.util.Set;

import org.junit.Test;

import dguerrar.test.blueliv.constants.ReaderOptions;
import dguerrar.test.blueliv.dto.FileReaderDTO;
import dguerrar.test.blueliv.modules.manager.FileReader;
import dguerrar.test.blueliv.modules.manager.impl.FileReaderImpl;


public class KO_Test_Reader {
	@Test(expected = IllegalArgumentException.class)
	public void testReadAndProcessFileCities() {
		FileReaderDTO dto= new FileReaderDTO("c:/tesmp/blueliv_test.txt", ReaderOptions.CITY,"BARCELONA");
		
		FileReader reader= FileReaderImpl.getInstance();
		Set<?> set=reader.readAndProcessFile(dto);

	
	}
}
