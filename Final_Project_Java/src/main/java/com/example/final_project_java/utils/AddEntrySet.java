package com.example.final_project_java.utils;

import java.util.*;

public class AddEntrySet<K,V> extends AbstractSet<Map.Entry<K, V>> {
    private final Map<K, V> map;

    public AddEntrySet(Map<K, V> map) {
        this.map = map;
    }
    @Override
    public Iterator<Map.Entry<K, V>> iterator() {
        return map.entrySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean add(Map.Entry<K, V> kvEntry) {
        V value = kvEntry.getValue();
        return !Objects.equals(value, map.put(kvEntry.getKey(), value));
    }

    public Map<K, V> getMap() {
        return map;
    }

}