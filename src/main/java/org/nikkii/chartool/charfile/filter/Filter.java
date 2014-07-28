package org.nikkii.chartool.charfile.filter;

/**
 * A basic Filter, this is pretty standard across everything which uses a Filter.
 *
 * @author Nikki
 */
public interface Filter<T> {

	/**
	 * Check whether we should accept the specified object
	 *
	 * @param t The object to check
	 * @return true, if it's a good value
	 */
	public boolean accept(T t);
}
