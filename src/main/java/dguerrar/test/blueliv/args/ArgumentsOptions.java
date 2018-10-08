package dguerrar.test.blueliv.args;

import com.google.devtools.common.options.Option;
import com.google.devtools.common.options.OptionsBase;

public class ArgumentsOptions extends OptionsBase {

	@Option(name = "help", abbrev = 'h', help = "Prints usage info.", defaultValue = "true")
	public boolean help;

	@Option(name = "FILE", abbrev = 'f', help = "The file to read", category = "startup", defaultValue = "")
	public String file;

	@Option(name = "CITY", abbrev = 'c', help = "The City to find people.", category = "startup", defaultValue = "")
	public String city;

	@Option(name = "ID", abbrev = 'i', help = "The ID of the person to find.", category = "startup", defaultValue = "")
	public String id;

}
