package org.nikkii.chartool.charfile;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a CharacterFile
 *
 * @author Nikki
 */
public final class CharacterFile {
	/**
	 * A map of names -> sections
	 */
	private Map<String, Section> sections = new HashMap<>();

	/**
	 * Add a section, converting the name to lower case to make it easier to look up
	 *
	 * @param section The section to add
	 */
	public void addSection(Section section) {
		sections.put(section.getName().toLowerCase(), section);
	}

	/**
	 * Get a section, converting the name to lower case like above to make it easier to look up
	 *
	 * @param name The section name
	 * @return The section
	 */
	public Section getSection(String name) {
		return sections.get(name.toLowerCase());
	}

	/**
	 * Get all current sections
	 *
	 * @return The section value collection from the map
	 */
	public Collection<Section> getSections() {
		return sections.values();
	}

	@Override
	public String toString() {
		return "CharacterFile [sections=" + sections + "]";
	}
}
