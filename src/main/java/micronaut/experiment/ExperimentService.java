package micronaut.experiment;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

import javax.inject.Singleton;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

@Singleton
public final class ExperimentService {

    ExecutorService executor = Executors.newFixedThreadPool(5);

    Scheduler scheduler = Schedulers.from(executor);

    public Single<Product> getProduct(final String id) {

        return Single.just(id)
                .subscribeOn(scheduler)
                .map(i -> loadProduct(i).get());
    }

    private Supplier<Product> loadProduct(final String id) {
        return () -> {
            System.out.println("Load start thread=" + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {}
            System.out.println("Load complete thread=" + Thread.currentThread().getId());

            return new Product("some-id", "some-name", 1000);
        };
    }
}
