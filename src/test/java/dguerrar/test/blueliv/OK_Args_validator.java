package dguerrar.test.blueliv;

import org.junit.Test;

import dguerrar.test.blueliv.dto.ArgumentsDTO;
import dguerrar.test.blueliv.modules.manager.ArgumentsValidator;
import dguerrar.test.blueliv.modules.validators.impl.ArgumentsValidatorImpl;
import junit.framework.Assert;

public class OK_Args_validator {
	
	
	@Test
	public void testGoodARgsCity() {
		String []args= new String[] {"-f", "c:\temp\blueliv_text.txt", "-c", "CARTAGENA"};
		ArgumentsDTO argDto= new ArgumentsDTO(args);
		
		ArgumentsValidator validador= ArgumentsValidatorImpl.getInstance();
		argDto=validador.validate(argDto);
		
		Assert.assertTrue(argDto.isResult());
		
		
	}
	
	@Test
	public void testGoodARgsID() {
		String []args= new String[] {"-f", "c:\temp\blueliv_text.txt", "-i", "25384390A"};
		ArgumentsDTO argDto= new ArgumentsDTO(args);
		
		ArgumentsValidator validador= ArgumentsValidatorImpl.getInstance();
		argDto=validador.validate(argDto);
		
		Assert.assertTrue(argDto.isResult());
		
		
	}
	

}
