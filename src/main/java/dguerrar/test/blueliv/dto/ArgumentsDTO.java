package dguerrar.test.blueliv.dto;

import com.google.devtools.common.options.OptionsParser;

import dguerrar.test.blueliv.args.ArgumentsOptions;
/***
 * stores the args
 * @author dguerra2
 *
 */
public class ArgumentsDTO extends GenericDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7773541121080138050L;
	private String [] args;
	private FileReaderDTO fileReaderDTO;
	private boolean result;
	
	/**
	 * @return the args
	 */
	public String[] getArgs() {
		return args;
	}
	public ArgumentsDTO(String[] args) {
		super();
		this.args = args;
	}
	/**
	 * @return the fileReaderDTO
	 */
	public FileReaderDTO getFileReaderDTO() {
		return fileReaderDTO;
	}
	/**
	 * @param fileReaderDTO the fileReaderDTO to set
	 */
	public void setFileReaderDTO(FileReaderDTO fileReaderDTO) {
		this.fileReaderDTO = fileReaderDTO;
	}
	/**
	 * @return the result
	 */
	public boolean isResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(boolean result) {
		this.result = result;
	}


	
	
	
	

}
