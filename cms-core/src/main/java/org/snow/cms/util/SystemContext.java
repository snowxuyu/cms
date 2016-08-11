package org.snow.cms.util;

public class SystemContext {
    public static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();

    public static ThreadLocal<Integer> pageOffset = new ThreadLocal<Integer>();

    public static ThreadLocal<String> sort = new ThreadLocal<String>();

    public static ThreadLocal<String> order = new ThreadLocal<String>();

    public static ThreadLocal<String> realPath = new ThreadLocal<String>();

    public static String getRealPath() {
        return (String) realPath.get();
    }

    public static void setRealPath(String _realPath) {
        realPath.set(_realPath);
    }

    public static Integer getPageSize() {
        return (Integer) pageSize.get();
    }

    public static void setPageSize(Integer _pageSize) {
        pageSize.set(_pageSize);
    }

    public static Integer getPageOffset() {
        return (Integer) pageOffset.get();
    }

    public static void setPageOffset(Integer _pageOffset) {
        pageOffset.set(_pageOffset);
    }

    public static String getSort() {
        return (String) sort.get();
    }

    public static void setSort(String _sort) {
        sort.set(_sort);
    }

    public static String getOrder() {
        return (String) order.get();
    }

    public static void setOrder(String _order) {
        order.set(_order);
    }

    public static void removePageSize() {
        pageSize.remove();
    }

    public static void removePageOffset() {
        pageOffset.remove();
    }

    public static void removeSort() {
        sort.remove();
    }

    public static void removeOrder() {
        order.remove();
    }

    public static void removeRealPath() {
        realPath.remove();
    }
}
