package com.findmore.serverapp.service;

import com.findmore.serverapp.entity.Sample;
import com.findmore.serverapp.repository.SampleRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class SampleServiceImpl implements SampleService {

    private static final String NOT_FOUND_MESSAGE_NUMBER = "Sample resource identified by %d was not found.";
    private static final String NOT_FOUND_MESSAGE_STRING = "Sample resource identified by %s was not found.";
    private static final String NOT_FOUND_MESSAGE_NULL = "Identifier for the sample resource was not provided";
    private final SampleRepository repository;

    public SampleServiceImpl(SampleRepository repository) { this.repository = repository; }

    @Override
    public List<Sample> getAll() {
        return repository.findAll();
    }

    @Override
    public Sample getById(long id) {
        Optional<Sample> opt = repository.findById(id);
        if(opt.isEmpty()) throw new EntityNotFoundException(String.format(NOT_FOUND_MESSAGE_NUMBER, id));
        return opt.get();
    }

    @Override
    public Sample getByName(String name) {
        Sample sample = repository.retrieveByName(name);
        if(sample == null) throw new EntityNotFoundException(String.format(NOT_FOUND_MESSAGE_STRING, name));
        return sample;
    }

    @Override
    public Sample create(Sample sample) {
        return repository.save(sample);
    }

    @Override
    public Sample update(Sample sample) {
        return repository.save(sample);
    }

    @Override
    public Sample partialUpdate(long id, Sample sample) {
        if(sample == null) throw new EntityNotFoundException(NOT_FOUND_MESSAGE_NULL);
        Sample reference = repository.getReferenceById(id);
        return repository.save(reference.partialUpdate(sample));
    }

    @Override
    public Sample deleteById(long id) {
        Optional<Sample> sample = repository.findById(id);
        if(sample.isEmpty()) throw new EntityNotFoundException(String.format(NOT_FOUND_MESSAGE_NUMBER, id));
        repository.deleteById(id);
        return sample.get();
    }

    @Override
    public Sample delete(Sample sample) {
        repository.delete(sample);
        return sample;
    }
}
