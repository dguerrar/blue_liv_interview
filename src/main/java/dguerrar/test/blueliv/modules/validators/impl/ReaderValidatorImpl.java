package dguerrar.test.blueliv.modules.validators.impl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dguerrar.test.blueliv.dto.FileReaderDTO;
import dguerrar.test.blueliv.modules.GenericModule;
import dguerrar.test.blueliv.modules.validators.ReaderValidator;

public class ReaderValidatorImpl extends GenericModule implements ReaderValidator {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6384660328628487898L;

	private static final Logger logger = LoggerFactory.getLogger(ReaderValidatorImpl.class);

	private static volatile ReaderValidator instance;

	public static ReaderValidator getInstance() {
		if (instance == null) {
			instance = new ReaderValidatorImpl();
		}

		return instance;
	}
	
	
	private ReaderValidatorImpl() {
		super();
	}


	@Override
	protected Class<?> getLogClass() {
		// TODO Auto-generated method stub
		return ReaderValidatorImpl.class;
	}

	public boolean validateArgs(FileReaderDTO dto)  {
		logger.debug("-->validateArgs ( dto: {}",dto);
		
		Path p = Paths.get(dto.getFileName());
		boolean exists = Files.exists(p);
		logger.debug("<--validateArgs (ret: {}",exists);
		return exists;
	}

}
