package dguerrar.test.blueliv.modules.validators.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.devtools.common.options.OptionsParser;

import dguerrar.test.blueliv.args.ArgumentsOptions;
import dguerrar.test.blueliv.constants.ReaderOptions;
import dguerrar.test.blueliv.dto.ArgumentsDTO;
import dguerrar.test.blueliv.dto.FileReaderDTO;
import dguerrar.test.blueliv.modules.GenericModule;

import dguerrar.test.blueliv.modules.manager.ArgumentsValidator;
import dguerrar.test.blueliv.modules.printer.Printer;
import dguerrar.test.blueliv.modules.printer.impl.PrinterImpl;

public class ArgumentsValidatorImpl extends GenericModule implements ArgumentsValidator{


	
	private static final Logger logger = LoggerFactory.getLogger(ArgumentsValidatorImpl.class);

	private static volatile ArgumentsValidator instance;

	public static ArgumentsValidator getInstance() {
		if (instance == null) {
			instance = new ArgumentsValidatorImpl();
		}

		return instance;
	}
	
	
	private ArgumentsValidatorImpl() {
		super();
	}
	

	@Override
	protected Class<?> getLogClass() {
		return ArgumentsValidatorImpl.class;
	}

	public ArgumentsDTO validate(ArgumentsDTO dto) {
		
		boolean ret= true;
		OptionsParser parser = OptionsParser.newOptionsParser(ArgumentsOptions.class);
		parser.parseAndExitUponError(dto.getArgs());
		
		ArgumentsOptions options = parser.getOptions(ArgumentsOptions.class);
		if (options.file.isEmpty() 
				|| (!options.file.isEmpty() && options.id.isEmpty() && options.city.isEmpty())
				|| (!options.file.isEmpty() && !options.city.isEmpty() && !options.id.isEmpty()) )
				 {
			Printer p=PrinterImpl.getInstance();
			
			p.printArgsInfo(parser);
			ret=false;
			
		}else {
			FileReaderDTO frdto= new FileReaderDTO(options.file,(options.city.isEmpty()? ReaderOptions.ID:ReaderOptions.CITY),(options.city.isEmpty()? options.id:options.city));
			dto.setFileReaderDTO(frdto);
		}
		dto.setResult(ret);
		return dto;
	}



}
