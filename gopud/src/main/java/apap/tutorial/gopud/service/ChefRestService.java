package apap.tutorial.gopud.service;

import reactor.core.publisher.Mono;

public interface ChefRestService {
    Mono<String> getChef(String chefName);
}
