package dguerrar.test.blueliv.modules;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * generic module in order to make 'stuff' common for other classes
 * 
 * @author dguerra2
 *
 */
public abstract class GenericModule implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -992263912516657546L;
	
	/**
	 * 
	 * this way, only have to define the logger here and extends in other classes
	 */
	protected Logger log = LoggerFactory.getLogger(getLogClass());
	protected abstract Class<?> getLogClass();





}
