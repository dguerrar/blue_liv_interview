package dguerrar.test.blueliv.modules.printer;

import java.util.Set;

import com.google.devtools.common.options.OptionsParser;

import dguerrar.test.blueliv.domain.Person;

public interface Printer {
	/***
	 * print info related to Persons
	 * @param set
	 */
	public void printPeople(Set<Person> set);
	
	/***
	 * print info related to parser and params
	 * @param parser
	 */
	public void printArgsInfo(OptionsParser parser);
	

}
