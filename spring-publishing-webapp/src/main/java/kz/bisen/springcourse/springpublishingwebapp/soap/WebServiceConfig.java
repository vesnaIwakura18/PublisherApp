package kz.bisen.springcourse.springpublishingwebapp.soap;

import kz.bisen.springcourse.springpublishingwebapp.dto.builder.impl.DefaultBookDtoBuilder;
import kz.bisen.springcourse.springpublishingwebapp.repository.BookRepository;
import kz.bisen.springcourse.springpublishingwebapp.soap.builder.SoapBookBuilder;
import kz.bisen.springcourse.springpublishingwebapp.soap.impl.SoapBookService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class WebServiceConfig {
    private final Bus bus;

    public WebServiceConfig(Bus bus, BookRepository repository, SoapBookBuilder builder) {
        this.bus = bus;
        this.repository = repository;
        this.builder = builder;
    }

    private final BookRepository repository;

    private final SoapBookBuilder builder;

    @Bean
    public Endpoint bookEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new SoapBookService(repository, builder));
        endpoint.publish("/book");

        return endpoint;
    }
}
