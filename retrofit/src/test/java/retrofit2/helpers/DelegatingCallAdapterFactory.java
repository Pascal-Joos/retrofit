package retrofit2.helpers;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;

public class DelegatingCallAdapterFactory extends CallAdapter.Factory {
  public boolean called = false;

  @Override
  public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
    called = true;
    return null;
  }
}
