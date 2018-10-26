package mx.com.elektra.bancadigital.elektra.api;

import io.reactivex.Observable;
import mx.com.elektra.bancadigital.elektra.api.request.LogInRequest;
import mx.com.elektra.bancadigital.elektra.api.response.LogInResponse;
import mx.com.elektra.bancadigital.elektra.api.response.ProductsResponse;
import mx.com.elektra.bancadigital.elektra.core.content.Constants;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface UserEndPoint {

    @POST(Constants.LOGIN_END_POINT)
    Observable<LogInResponse> attemptLogin(@Body LogInRequest request);

    @GET(Constants.PRODUCTS_END_POINT)
    Observable<ProductsResponse> getProducts(@Header("Authorization") String token);
}
