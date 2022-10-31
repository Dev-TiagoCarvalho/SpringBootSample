package com.findmore.serverapp.service;

import com.findmore.serverapp.entity.Sample;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SampleService {
    List<Sample> getAll();
    Sample getById(long id);
    Sample getByName(String name);
    Sample create(Sample sample);
    Sample update(Sample sample);
    Sample partialUpdate(long id, Sample sample);
    Sample deleteById(long id);
    Sample delete(Sample sample);
}
