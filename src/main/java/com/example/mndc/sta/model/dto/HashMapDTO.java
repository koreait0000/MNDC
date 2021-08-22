package com.example.mndc.sta.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HashMapDTO<K,V> {
    private K key;
    private V value;

}
