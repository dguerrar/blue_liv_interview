package dguerrar.test.blueliv.dto;

import dguerrar.test.blueliv.constants.ReaderOptions;
/***
 * store the data to read and search criteria
 * @author dguerra2
 *
 */
public class FileReaderDTO extends GenericDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1743627655253870110L;
	
	private String fileName;
	private ReaderOptions optionSelected;
	private String value;
	
	public String getFileName() {
		return fileName;
	}

	public ReaderOptions getOptionSelected() {
		return optionSelected;
	}


	public String getValue() {
		return value;
	}

	public FileReaderDTO(String fileName, ReaderOptions optionSelected, String value) {
		super();
		this.fileName = fileName;
		this.optionSelected = optionSelected;
		this.value = value;
	}

	

}
