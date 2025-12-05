package retrofit2.helpers;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;

public class NonMatchingConverterFactory extends Converter.Factory {
  public boolean called = false;

  @Override
  public Converter<ResponseBody, ?> responseBodyConverter(
      Type type, Annotation[] annotations, retrofit2.Retrofit retrofit) {
    called = true;
    return null;
  }

  @Override
  public Converter<?, RequestBody> requestBodyConverter(
      Type type,
      Annotation[] parameterAnnotations,
      Annotation[] methodAnnotations,
      retrofit2.Retrofit retrofit) {
    called = true;
    return null;
  }
}
