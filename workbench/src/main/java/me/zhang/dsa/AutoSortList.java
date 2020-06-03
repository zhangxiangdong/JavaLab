package me.zhang.dsa;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Zhang on 8/27/2017 1:04 PM.
 */
public interface AutoSortList<E> extends List<E> {

    /**
     * Returns the last (highest) element currently in this set.
     *
     * @return the last (highest) element currently in this set
     * @throws NoSuchElementException if this set is empty
     */
    E last();

    /**
     * Retrieves and removes the last (highest) element,
     * or returns {@code null} if this set is empty.
     *
     * @return the last element, or {@code null} if this set is empty
     */
    E pollLast();

}
