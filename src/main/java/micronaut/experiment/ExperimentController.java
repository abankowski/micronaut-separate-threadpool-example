package micronaut.experiment;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.reactivex.Single;

import javax.inject.Inject;

@Controller("/experiment")
public class ExperimentController {

    @Inject
    ExperimentService service;

    @Get("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Single<Product> getProduct(String id) {
        return service.getProduct(id);
     }
}
