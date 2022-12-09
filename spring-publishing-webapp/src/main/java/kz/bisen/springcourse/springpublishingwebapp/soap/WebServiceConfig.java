package kz.bisen.springcourse.springpublishingwebapp.soap;

import kz.bisen.springcourse.springpublishingwebapp.dto.builder.impl.DefaultBookDtoBuilder;
import kz.bisen.springcourse.springpublishingwebapp.repository.BookRepository;
import kz.bisen.springcourse.springpublishingwebapp.soap.impl.SoapBookService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class WebServiceConfig {
    private final Bus bus;

    public WebServiceConfig(Bus bus, BookRepository repository, DefaultBookDtoBuilder dtoBuilder) {
        this.bus = bus;
        this.repository = repository;
        this.dtoBuilder = dtoBuilder;
    }

    private final BookRepository repository;

    private final DefaultBookDtoBuilder dtoBuilder;

    @Bean
    public Endpoint bookEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new SoapBookService(repository, dtoBuilder));
        endpoint.publish("/book");

        return endpoint;
    }
}
