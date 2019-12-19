package com.demo.validate;

import com.fasterxml.jackson.databind.JsonNode;

public class Client {
    public static void main(String[] args) {

        JsonNode jsonNodeFromFile = SchemaValidator.getJsonNodeFromFile(
                Client.class.getClassLoader().getResource("schema-validator.json").getPath());
        System.out.println(jsonNodeFromFile);

        String json = "{\"foo\":{\"type\":\"123\"}}";
        JsonNode jsonNode = SchemaValidator.getJsonNodeFromString(json);
        System.out.println(jsonNode);

        System.out.println(SchemaValidator.validateJsonByFgeByJsonNode(jsonNode, jsonNodeFromFile));


    }
}
