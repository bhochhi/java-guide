package hello.world.micronaunt;


import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.validation.Validated;
import io.reactivex.Single;

import javax.validation.constraints.NotBlank;

@Controller
@Validated
public class HelloWorldController {


    @Get("/hello/{name}")
    public Single<String> hello(@NotBlank String name){
        return Single.just("Hello "+name+"!!");
    }

}
