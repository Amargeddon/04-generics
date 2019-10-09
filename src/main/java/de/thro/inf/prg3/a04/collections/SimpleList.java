package de.thro.inf.prg3.a04.collections;

public interface SimpleList<T> extends Iterable<T> {
	/**
	 * Add a given object to the back of the list.
	 */
	void add(T item);

	default void addDefault(Class<T> clazz){
		try {
			this.add(clazz.newInstance());
		}catch(Exception e){
			e.getMessage().toString();
		}
	}
	/**
	 * @return current size of the list
	 */
	int size();

	/**
	 * Generate a new list using the given filter instance.
	 * @return a new, filtered list
	 */
	default SimpleList<T> filter(SimpleFilter<T> filter){
		SimpleList<T> result;
		try {
			result = (SimpleList<T>) getClass().newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			result = new SimpleListImpl<>();
		}
		for(T o : this){
			if(filter.include(o)){
				result.add(o);
			}
		}
		return result;
	}
}
