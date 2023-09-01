package com.bing.utils;

import java.util.Collection;
import java.util.Iterator;

public class CollUtil {


	/**
	 * 加入全部
	 *
	 * @param <T>        集合元素类型
	 * @param collection 被加入的集合 {@link Collection}
	 * @param iterable   要加入的内容{@link Iterable}
	 * @return 原集合
	 */
	public static <T> Collection<T> addAll(Collection<T> collection, Iterable<T> iterable) {
		if (iterable == null) {
			return collection;
		}
		return addAll(collection, iterable.iterator());
	}

	/**
	 * 加入全部
	 *
	 * @param <T>        集合元素类型
	 * @param collection 被加入的集合 {@link Collection}
	 * @param iterator   要加入的{@link Iterator}
	 * @return 原集合
	 */
	public static <T> Collection<T> addAll(Collection<T> collection, Iterator<T> iterator) {
		if (null != collection && null != iterator) {
			while (iterator.hasNext()) {
				collection.add(iterator.next());
			}
		}
		return collection;
	}
}
