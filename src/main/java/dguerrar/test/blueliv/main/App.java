package dguerrar.test.blueliv.main;

import java.util.Arrays;
import java.util.Collections;

import com.google.devtools.common.options.OptionsParser;

import dguerrar.test.blueliv.args.ArgumentsOptions;
import dguerrar.test.blueliv.constants.ReaderOptions;
import dguerrar.test.blueliv.dto.ArgumentsDTO;
import dguerrar.test.blueliv.dto.FileReaderDTO;
import dguerrar.test.blueliv.modules.manager.ArgumentsValidator;
import dguerrar.test.blueliv.modules.manager.FileReader;
import dguerrar.test.blueliv.modules.manager.impl.FileReaderImpl;
import dguerrar.test.blueliv.modules.printer.Printer;
import dguerrar.test.blueliv.modules.printer.impl.PrinterImpl;
import dguerrar.test.blueliv.modules.validators.impl.ArgumentsValidatorImpl;


/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("args" + Arrays.toString(args));
		ArgumentsDTO argDto= new ArgumentsDTO(args);
		
		ArgumentsValidator validador= ArgumentsValidatorImpl.getInstance();
		argDto=validador.validate(argDto);

		if (Boolean.FALSE== argDto.isResult()) {
			System.exit(-1);//return error
		}
		

		System.out.format("Starting Blueliv test application FILE: %s SEARCH: %s \n", argDto.getFileReaderDTO().getFileName(), argDto.getFileReaderDTO().getOptionSelected().name(), argDto.getFileReaderDTO().getValue());
		
		
		FileReader reader= FileReaderImpl.getInstance();
		Printer p= PrinterImpl.getInstance();
		p.printPeople(reader.readAndProcessFile(argDto.getFileReaderDTO()));
		
		
	}

}
