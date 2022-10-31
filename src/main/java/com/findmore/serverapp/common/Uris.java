package com.findmore.serverapp.common;

import org.springframework.stereotype.Component;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.util.HashMap;

/**
 * This class is an auxiliary class to help organize the endpoints.
 * All the endpoints are statically stored in the singleton reference object created by the spring framework.
 * The spring framework creates a single reference of this object because of the annotation @Component.
 *
 * For each '/' in the URL a static class is created for symbolizing that endpoint
 * Each static class requires:
 *  - String ENDPOINT -> defines the specific resource
 *  - String PATH -> defines the entire path to the specific resource
 *
 * If the complete path contains any path variable then is required the make(...) function.
 * This function receives all the necessary variables to complete the path in the specific type.
 * This function then return the full path with all the path variables override by the specific parameter.
 */

@Component
public class Uris {

    public static class API {
        public static final String ENDPOINT = "/api";
        public static final String PATH = "/api";
        public static URI make() { return URI.create(PATH); }

        public static class SAMPLE {
            public static final String ENDPOINT = "/sample";
            public static final String PATH = API.PATH + ENDPOINT;
            public static URI make() { return URI.create(PATH); }

            public static class SAMPLE_ID {
                public static final String ENDPOINT = "/{id}";
                public static final String PATH = SAMPLE.PATH + ENDPOINT;
                private static final UriTemplate TEMPLATE = new UriTemplate(PATH);
                public static URI make(Object id) { return TEMPLATE.expand(new HashMap<>() {{ put("id", id.toString()); }}); }
            }
        }
    }
}
