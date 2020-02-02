package com.drzewiecki.bank.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UidService {

    public static String generateUid(Class type) {
        String prefix = type.getSimpleName().substring(0, 6);
        String fullUid = UUID.randomUUID().toString().toUpperCase();
        return prefix + "-" + fullUid.substring(30);
    }
}
