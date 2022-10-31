package com.findmore.serverapp.controller;

import com.findmore.serverapp.common.Uris;
import com.findmore.serverapp.entity.Sample;
import com.findmore.serverapp.service.SampleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Pattern;

/**
 * This class is annotated with @Controller (thorough the @RestController annotation) and this tells the Spring
 * Framework that the instantiated object of this class is to be associated with a URI path template.
 *
 * This class defines the Controller that will handle the HTTP Requests that start with the path /api/sample.
 * This is defined by the annotation @RequestMapping(value="") that receives the path that is to route this controller.
 *
 * The annotation @RestController is used to allow the handlers to return different types than ResponseEntity.
 * With this annotation the return types of:
 *  - String maps to text/plain
 *  - Object maps to application/json
 */

@RestController
@RequestMapping(Uris.API.SAMPLE.PATH)
public class SampleController {

    /**
     * This is the service that executes the business logic associated with this controller.
     * This service is injected in the controller at runtime through the constructor.
     */
    private final SampleService service;
    private final Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public SampleController(SampleService service) { this.service = service; }

    /**
     * The methods that are annotated with @RequestMapping or its sub-annotations are called handler methods.
     * This handler method executes the specific service method that contains the business logic attached to the
     * GET /api/sample HTTP Request.
     * @return This method returns a List of Sample objects that will then be transformed into a json payload.
     * The default transformation for a List is to a Json Array.
     */
    @GetMapping
    public List<Sample> getAllSamples() { return service.getAll(); }

    @PostMapping
    public Sample createSample(@RequestBody Sample sample) { return service.create(sample); }

    /**
     * This is the handler method that contains the business logic attached to the GET /api/sample/{id} HTTP Request.
     * This method receives a String that is injected by the Spring Framework with the specific value of {id} present in
     * the HTTP Request.
     * @param id The identifier of the Sample or the name of the Sample.
     * @return This method returns the Sample that was found with the specific id parameter.
     * Throws EntityNoFoundException in case that there is no Sample with the specified id or named with the specified id.
     */
    @GetMapping(Uris.API.SAMPLE.SAMPLE_ID.ENDPOINT)
    public Sample getSampleById(@PathVariable String id) { return pattern.matcher(id).matches() ? service.getById(Long.parseLong(id)) : service.getByName(id); }

    @PutMapping
    public Sample updateSample(@RequestBody Sample sample) { return service.update(sample); }

    @PatchMapping(Uris.API.SAMPLE.SAMPLE_ID.ENDPOINT)
    public Sample partialUpdateSample(@PathVariable long id, @RequestBody Sample sample) { return service.partialUpdate(id, sample); }

    @DeleteMapping(Uris.API.SAMPLE.SAMPLE_ID.ENDPOINT)
    public Sample deleteSampleById(@PathVariable long id) { return service.deleteById(id); }

    @DeleteMapping
    public Sample deleteSample(@RequestBody Sample sample) { return service.delete(sample); }
}
