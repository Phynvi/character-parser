package org.nikkii.chartool.charfile;

import org.nikkii.chartool.charfile.filter.Filter;
import org.nikkii.chartool.charfile.filter.Filters;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * A character file parser
 *
 * @author Nikki
 */
public final class CharacterFileParser {

	/**
	 * Parse a full character file
	 *
	 * @param file The file to parse
	 * @return The parsed CharacterFile instance
	 * @throws IOException
	 */
	public static CharacterFile parse(File file) throws IOException {
		return parse(new FileReader(file), Filters.ALL_FILTER);
	}

	/**
	 * Parse a character file, only using the specified sections
	 *
	 * @param file The file to parse
	 * @param sectionFilter The Filter class to use to decide which sections to load
	 * @return The parsed CharacterFile instance
	 * @throws IOException
	 */
	public static CharacterFile parse(File file, Filter<String> sectionFilter) throws IOException {
		return parse(new FileReader(file), sectionFilter);
	}


	/**
	 * Parse a full character file
	 *
	 * @param reader The reader to parse from
	 * @return The parsed CharacterFile instance
	 * @throws IOException
	 */
	public static CharacterFile parse(Reader reader) throws IOException {
		return parse(reader, Filters.ALL_FILTER);
	}

	/**
	 * Parse a character file from the specified Reader
	 *
	 * @param reader        The reader to wrap in a BufferedReader
	 * @param sectionFilter The Filter class to use to decide which sections to load
	 * @return The parsed CharacterFile instance
	 * @throws IOException If an error occurred while parsing
	 */
	public static CharacterFile parse(Reader reader, Filter<String> sectionFilter) throws IOException {
		CharacterFile cf = new CharacterFile();
		Section current = null;

		try (BufferedReader bufferedReader = new BufferedReader(reader)) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				line = line.trim();

				// Check if the line is just whitespace
				if (line.isEmpty()) continue;

				// Check if line is a section
				if (line.charAt(0) == '[') {
					// Get section name
					String sectionName = line.substring(1, line.lastIndexOf(']'));

					// Break parsing on EOF
					if (sectionName.equals("EOF")) {
						break;
					}

					// 'End' the current section
					if (current != null) {
						current = null;
					}

					// Check if we want this section
					if (sectionFilter.accept(sectionName)) {
						cf.addSection(current = new Section(sectionName));
					}
				} else if (current != null) {
					int idx = line.indexOf('=');
					if (idx == -1) {
						current.addValue(line, "true");
					} else {
						String key = line.substring(0, idx).trim();
						String value = line.substring(idx + 1).trim();
						current.addValue(key, value);
					}
				}
			}
		}
		return cf;
	}
}
