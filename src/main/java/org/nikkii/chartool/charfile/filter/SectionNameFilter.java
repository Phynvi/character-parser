package org.nikkii.chartool.charfile.filter;

import java.util.LinkedList;
import java.util.List;

/**
 * A filter class which only accepts specific sections
 *
 * @author Nikki
 */
public final class SectionNameFilter implements Filter<String> {
	/**
	 * The list of sections
	 */
	private final List<String> list;

	/**
	 * Construct a new filter with the specified names
	 *
	 * @param names The names to filter
	 */
	public SectionNameFilter(String... names) {
		list = new LinkedList<>();

		// Populate our name list
		for (String name : names) {
			list.add(name.toLowerCase());
		}
	}

	@Override
	public boolean accept(String s) {
		return list.contains(s.toLowerCase());
	}
}
