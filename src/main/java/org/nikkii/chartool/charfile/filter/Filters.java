package org.nikkii.chartool.charfile.filter;

/**
 * A class containing usual filters
 *
 * @author Nikki
 */
public final class Filters {

	/**
	 * A filter which accepts all sections.
	 */
	public static final Filter<String> ALL_FILTER = new Filter<String>() {
		@Override
		public boolean accept(String s) {
			return true;
		}
	};
}
