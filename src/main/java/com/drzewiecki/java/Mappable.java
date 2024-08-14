package com.drzewiecki.java;

import java.util.Map;

public interface Mappable {

    String b = "ds";

    <K,V> Map<K,V> map(V object);
}
