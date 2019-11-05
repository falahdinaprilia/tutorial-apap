package apap.tutorial.gopud.service;

import apap.tutorial.gopud.rest.Setting;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;

@Service
@Transactional
public class ChefRestServicecImpl implements ChefRestService {
    private final WebClient webClient;

    @Override
    public Mono<String> getChef(String chefName) {
        return this.webClient.get().uri(Setting.chefUrl + "nama=" + chefName)
                .retrieve().bodyToMono(String.class);

    }

    public ChefRestServicecImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.chefUrl).build();
    }
}
