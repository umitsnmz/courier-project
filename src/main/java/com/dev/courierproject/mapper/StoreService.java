package com.dev.courierproject.mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
public class StoreService {
    private final ObjectMapper objectMapper;

    public StoreService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<Map<String, Object>> getStores() throws IOException {
        // JSON dosyasını oku
        ClassPathResource resource = new ClassPathResource("stores.json");
        List<Map<String, Object>> stores = objectMapper.readValue(resource.getInputStream(), new TypeReference<List<Map<String, Object>>>() {});
        return stores;
    }
}
