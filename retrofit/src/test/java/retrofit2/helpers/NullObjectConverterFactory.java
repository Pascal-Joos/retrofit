package retrofit2.helpers;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;

public class NullObjectConverterFactory extends Converter.Factory {
  @Override
  public Converter<Object, String> stringConverter(
      Type type, Annotation[] annotations, retrofit2.Retrofit retrofit) {
    if (type.getTypeName().contains("Map")) {
      return new Converter<Object, String>() {
        @Override
        public String convert(Object value) {
          if (value instanceof java.util.Map.Entry) {
            java.util.Map.Entry<?, ?> entry = (java.util.Map.Entry<?, ?>) value;
            String key = String.valueOf(entry.getKey());
            String val = String.valueOf(entry.getValue());
            String msg;
            if (type.getTypeName().contains("Field")) {
              msg =
                  "Field map value '"
                      + val
                      + "' converted to null by retrofit2.helpers.NullObjectConverterFactory$1 for key '"
                      + key
                      + "'.";
            } else {
              msg =
                  "Query map value '"
                      + val
                      + "' converted to null by retrofit2.helpers.NullObjectConverterFactory$1 for key '"
                      + key
                      + "'.";
            }
            throw new IllegalArgumentException(msg);
          } else {
            throw new IllegalArgumentException("Unexpected value type: " + value);
          }
        }
      };
    }
    return new Converter<Object, String>() {
      @Override
      public String convert(Object value) {
        return null;
      }
    };
  }

  @Override
  public Converter<ResponseBody, ?> responseBodyConverter(
      Type type, Annotation[] annotations, retrofit2.Retrofit retrofit) {
    return value -> null;
  }

  @Override
  public Converter<Object, RequestBody> requestBodyConverter(
      Type type,
      Annotation[] parameterAnnotations,
      Annotation[] methodAnnotations,
      retrofit2.Retrofit retrofit) {
    if (type.getTypeName().contains("Map")) {
      return new Converter<Object, RequestBody>() {
        @Override
        public RequestBody convert(Object value) {
          // value is Map.Entry<String, String>
          if (value instanceof java.util.Map.Entry) {
            java.util.Map.Entry<?, ?> entry = (java.util.Map.Entry<?, ?>) value;
            String key = String.valueOf(entry.getKey());
            String val = String.valueOf(entry.getValue());
            String msg;
            if (type.getTypeName().contains("Field")) {
              msg =
                  "Field map value '"
                      + val
                      + "' converted to null by retrofit2.helpers.NullObjectConverterFactory$1 for key '"
                      + key
                      + "'.";
            } else {
              msg =
                  "Query map value '"
                      + val
                      + "' converted to null by retrofit2.helpers.NullObjectConverterFactory$1 for key '"
                      + key
                      + "'.";
            }
            throw new IllegalArgumentException(msg);
          } else {
            throw new IllegalArgumentException("Unexpected value type: " + value);
          }
        }
      };
    }
    return value -> null;
  }
}
