package dguerrar.test.blueliv.modules.manager.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dguerrar.test.blueliv.constants.ReaderOptions;
import dguerrar.test.blueliv.domain.Person;
import dguerrar.test.blueliv.dto.FileReaderDTO;
import dguerrar.test.blueliv.modules.GenericModule;
import dguerrar.test.blueliv.modules.manager.FileReader;
import dguerrar.test.blueliv.modules.validators.ReaderValidator;
import dguerrar.test.blueliv.modules.validators.impl.ReaderValidatorImpl;

public class FileReaderImpl extends GenericModule implements FileReader {

	private static final long serialVersionUID = 7349099902028049302L;

	private static final Logger logger = LoggerFactory.getLogger(FileReaderImpl.class);

	private static volatile FileReader instance;

	public static FileReader getInstance() {
		if (instance == null) {
			instance = new FileReaderImpl();
		}

		return instance;
	}

	private FileReaderImpl() {
		super();
	}

	@Override
	protected Class<?> getLogClass() {
		return FileReaderImpl.class;
	}

	public Set<Person> readAndProcessFile(FileReaderDTO dto) throws IllegalArgumentException {
		logger.debug("-->readAndProcessFile (dto: {})", dto);
		ReaderValidator validator = ReaderValidatorImpl.getInstance();
		if (Boolean.FALSE == validator.validateArgs(dto)) {
			throw new IllegalArgumentException("File does not exist");
		}

		Set<Person> set = new HashSet<Person>();

		LineIterator it = null;
		try {
			it = FileUtils.lineIterator(new File(dto.getFileName()), "UTF-8");
			while (it.hasNext()) {
				String line = it.nextLine();
				// PROCESS line oNLY on data line
				if (line.startsWith("D")) {
					// replace ; by -
					line = line.replace(';', ',');

					line = line.substring(1).trim();
					// split and get name and other info
					String split[] = line.split(",");
					if (split.length == 3) { //do not read erroneus lines
						if (dto.getOptionSelected() == ReaderOptions.CITY) {
							if (split[1].trim().equalsIgnoreCase(dto.getValue())) {// city
								Person p = new Person(split[0].trim(), split[2].replace("-", "").trim());
								if (Boolean.FALSE == set.contains(p)) {
									set.add(p);
								}
							}
						} else {
							if (split[2].replace("-", "").trim().equalsIgnoreCase(dto.getValue())) {// id
								Person p = new Person(split[1].trim());
								if (Boolean.FALSE == set.contains(p)) {
									set.add(p);
								}
							}
						}
					}
				}

			}
		} catch (IOException e) {
			logger.error("NON CONTROLLED ERROR READING FILE", e);
		} finally {
			if (null != it) {
				LineIterator.closeQuietly(it);
			}
		}

		logger.debug("<--readAndProcessFile (set: {})", set);
		return set;

	}

}
