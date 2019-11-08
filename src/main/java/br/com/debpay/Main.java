package br.com.debpay;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.net.URI;

/**
 * Main class.
 */
public class Main {
    // Base URI the Grizzly HTTP server will listen on
    static final String BASE_URI = "http://localhost:8080/debpay/";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     *
     * @return Grizzly HTTP server.
     */
    static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        final ResourceConfig rc = new ResourceConfig().packages("br.com.debpay.Controllers");
        rc.register(new CORSFilter());

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    /**
     * Main method.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
        System.in.read();
        server.stop();
    }

    /* Used for tests purposes only - Should be disabled or better implemented on the future*/
    @Provider
    public static class CORSFilter implements ContainerResponseFilter {

        @Override
        public void filter(ContainerRequestContext request,
                           ContainerResponseContext response) throws IOException {
            response.getHeaders().add("Access-Control-Allow-Origin", "*");
            response.getHeaders().add("Access-Control-Allow-Headers",
                    "origin, content-type, accept, authorization");
            response.getHeaders().add("Access-Control-Allow-Credentials", "true");
            response.getHeaders().add("Access-Control-Allow-Methods",
                    "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        }
    }
}

