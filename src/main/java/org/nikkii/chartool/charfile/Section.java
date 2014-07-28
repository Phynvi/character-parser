package org.nikkii.chartool.charfile;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Represents a section in a character file
 *
 * Example: [SECTION NAME]
 *
 * @author Nikki
 */
public final class Section {
	/**
	 * The section name
	 */
	private final String name;

	/**
	 * The section values.
	 * Values can have the same key and multiple values, so this wraps a List
	 */
	private final Map<String, List<String>> values = new HashMap<>();

	/**
	 * Construct a new Section
	 *
	 * @param name The section name
	 */
	public Section(String name) {
		this.name = name;
	}

	/**
	 * Add a value to this section
	 *
	 * @param key The value key
	 * @param value The value
	 */
	public void addValue(String key, String value) {
		List<String> l = values.get(key);
		if (l == null) {
			values.put(key, l = new LinkedList<>());
		}
		l.add(value);
	}

	/**
	 * Get the values in this section
	 *
	 * @return The value map
	 */
	public Map<String, List<String>> getValues() {
		return values;
	}

	/**
	 * Get a list of values for the specified key
	 *
	 * @param key The value key
	 * @return The value
	 */
	public List<String> getValue(String key) {
		return values.get(key);
	}

	/**
	 * Get the section name
	 * @return The section name
	 */
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Section [name=" + name + ", values=" + values + "]";
	}
}
