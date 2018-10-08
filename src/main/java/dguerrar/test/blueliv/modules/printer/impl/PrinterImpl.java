package dguerrar.test.blueliv.modules.printer.impl;

import java.util.Collections;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.devtools.common.options.OptionsParser;

import dguerrar.test.blueliv.domain.Person;
import dguerrar.test.blueliv.modules.GenericModule;
import dguerrar.test.blueliv.modules.printer.Printer;

public class PrinterImpl extends GenericModule implements Printer {

	private static final Logger logger = LoggerFactory.getLogger(PrinterImpl.class);

	private static volatile Printer instance;

	public static Printer getInstance() {
		if (instance == null) {
			instance = new PrinterImpl();
		}

		return instance;
	}

	private PrinterImpl() {
		super();
	}

	public void printPeople(Set<Person> set) {
		if (null != set && Boolean.FALSE == set.isEmpty()) {
			for (Person p : set) {
				System.out.print(p);
			}
		}

	}

	public void printArgsInfo(OptionsParser parser) {

		if (null != parser) {
			System.out.println("Error parsing arguments. Please revise the correct syntax.");
			System.out.println("Usage: java -jar server.jar OPTIONS");
			System.out.println(
					parser.describeOptions(Collections.<String, String>emptyMap(), OptionsParser.HelpVerbosity.LONG));

		}

	}

	@Override
	protected Class<?> getLogClass() {
		return PrinterImpl.class;
	}

}
