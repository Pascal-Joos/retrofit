package retrofit2.helpers;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;

public class ObjectInstanceConverterFactory extends Converter.Factory {
  public static final Object VALUE = new Object();

  @Override
  public Converter<ResponseBody, ?> responseBodyConverter(
      Type type, Annotation[] annotations, retrofit2.Retrofit retrofit) {
    if (type.getTypeName().startsWith("java.util.Optional")) {
      return value -> java.util.Optional.of(VALUE);
    }
    return value -> VALUE;
  }

  @Override
  public Converter<Object, RequestBody> requestBodyConverter(
      Type type,
      Annotation[] parameterAnnotations,
      Annotation[] methodAnnotations,
      retrofit2.Retrofit retrofit) {
    return value -> RequestBody.create(null, new byte[0]);
  }
}
