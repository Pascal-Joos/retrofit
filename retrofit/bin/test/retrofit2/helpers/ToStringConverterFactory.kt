package retrofit2.helpers

import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

open class ToStringConverterFactory : Converter.Factory() {
    override fun responseBodyConverter(
        type: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<okhttp3.ResponseBody, *>? {
        return Converter<okhttp3.ResponseBody, String> { value -> value.string() }
    }

    override fun requestBodyConverter(
        type: Type,
        parameterAnnotations: Array<Annotation>,
        methodAnnotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<*, okhttp3.RequestBody>? {
        return Converter<String, okhttp3.RequestBody> { value -> okhttp3.RequestBody.create(null, value) }
    }
 
}
