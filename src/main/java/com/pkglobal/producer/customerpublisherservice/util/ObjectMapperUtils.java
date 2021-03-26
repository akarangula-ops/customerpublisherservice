package com.pkglobal.producer.customerpublisherservice.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ObjectMapperUtils {

  private static final Logger log = LoggerFactory.getLogger(ObjectMapperUtils.class);

  private static ObjectMapper objectMapper;

  private ObjectMapperUtils()  {

  }

  public static String returnJsonFromObject(Object object) {
    objectMapper = new ObjectMapper();
    String jsonReponse = "";
    try {
      jsonReponse = objectMapper.writeValueAsString(object);
    } catch (JsonProcessingException jsonProcessingException) {
      log.debug("failed converting object to json");
    }
    return jsonReponse;
  }
}
