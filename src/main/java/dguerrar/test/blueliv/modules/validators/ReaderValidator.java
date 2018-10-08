package dguerrar.test.blueliv.modules.validators;

import dguerrar.test.blueliv.dto.FileReaderDTO;

public interface ReaderValidator {

	/***
	 * validate the arguments using the google parser
	 * @param dto
	 * @return
	 */
	public boolean validateArgs(FileReaderDTO dto) ;
	
}
