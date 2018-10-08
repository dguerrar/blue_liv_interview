package dguerrar.test.blueliv.modules.manager;


import java.util.Set;

import dguerrar.test.blueliv.domain.Person;
import dguerrar.test.blueliv.dto.FileReaderDTO;

public interface FileReader {
	/***
	 * read the file and do the search
	 * 
	 * @param dto
	 * @return
	 * @throws IllegalArgumentException
	 */
	public Set<Person> readAndProcessFile(FileReaderDTO dto) throws IllegalArgumentException;

}
