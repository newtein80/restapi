package com.nile.apiservice.sample.service;

import com.nile.apiservice.sample.model.entity.Sample;
import com.nile.apiservice.sample.repository.SampleRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SampleService {
    private final SampleRepository sampleRepository;

    public void getSamples() {
        this.sampleRepository.findAll();    
    }

    public void getSample(long sampleId) {
        this.sampleRepository.findById(sampleId);
    }

    public void addSample(String sampleTitle, String sampleContent) {
        this.sampleRepository.save(new Sample());
    }

    public void updateSample(long sampleId, String sampleTitle, String sampleContent) {
        this.sampleRepository.findById(sampleId);
    }

    public void deleteSample(long sampleId) {
        this.sampleRepository.deleteById(sampleId);
    }

}
