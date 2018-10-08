package dguerrar.test.blueliv;

import org.junit.Test;

import dguerrar.test.blueliv.dto.ArgumentsDTO;
import dguerrar.test.blueliv.modules.manager.ArgumentsValidator;
import dguerrar.test.blueliv.modules.validators.impl.ArgumentsValidatorImpl;
import junit.framework.Assert;

public class KO_Validator_args {

	
	
	@Test
	public void KOtestGoodARgsCity() {
		String []args= new String[] {"-f", "c:\temp\blueliv_text.txt", "-c", ""};
		ArgumentsDTO argDto= new ArgumentsDTO(args);
		
		ArgumentsValidator validador= ArgumentsValidatorImpl.getInstance();
		argDto=validador.validate(argDto);
		
		Assert.assertFalse(argDto.isResult());
		
		
	}
	
	
	@Test
	public void KOtestGoodARgsID() {
		String []args= new String[] {"-f", "c:\temp\blueliv_text.txt", "-i", ""};
		ArgumentsDTO argDto= new ArgumentsDTO(args);
		
		ArgumentsValidator validador= ArgumentsValidatorImpl.getInstance();
		argDto=validador.validate(argDto);
		
		Assert.assertFalse(argDto.isResult());
		
		
	}
	
	
	
	@Test
	public void KOtestGoodARgsALL() {
		String []args= new String[] {"-f", "c:\temp\blueliv_text.txt", "-i", "ass","-c","ssdsd"};
		ArgumentsDTO argDto= new ArgumentsDTO(args);
		
		ArgumentsValidator validador= ArgumentsValidatorImpl.getInstance();
		argDto=validador.validate(argDto);
		
		Assert.assertFalse(argDto.isResult());
		
		
	}
	
}
