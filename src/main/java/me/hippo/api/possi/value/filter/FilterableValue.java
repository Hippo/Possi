package me.hippo.api.possi.value.filter;

import me.hippo.api.possi.value.Value;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Hippo
 * @version 3.0.0, 4/2/20
 * @since 3.0.0
 *
 * A {@link Value} object that allows filtration.
 *
 * @param <T>  The type of the value.
 */
public abstract class FilterableValue<T> implements Value<T> {

    /**
     * The serial id.
     * @see Serializable
     */
    private static final long serialVersionUID = 1L;

    /**
     * A {@link List} off all the <tt>filters</tt>.
     */
    private final List<Predicate<T>> filters;

    /**
     * Constructs a new <tt>FilterableValue</tt> with no <tt>filters</tt>.
     */
    public FilterableValue() {
        this.filters = new ArrayList<>();
    }

    /**
     * Adds a <tt>filter</tt>.
     *
     * @param filter  The filter to add.
     */
    public void addFilter(Predicate<T> filter) {
        filters.add(filter);
    }

    /**
     * Checks if <tt>value</tt> passes all the <tt>filters</tt>.
     *
     * @param value  The value to check.
     * @return  If the value passes.
     */
    public boolean passesFilters(T value) {
        for (Predicate<T> filter : filters) {
            if (!filter.test(value)) {
                return false;
            }
        }
        return true;
    }
}
