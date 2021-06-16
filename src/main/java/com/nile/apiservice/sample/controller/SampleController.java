package com.nile.apiservice.sample.controller;

import java.util.List;

import com.nile.apiservice.sample.model.dto.SampleDTO;
import com.nile.apiservice.sample.service.SampleService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/**
 * https://alwaysone.tistory.com/
 */
@RestController
@RequestMapping("/v1/nileapi/sample")
@RequiredArgsConstructor
public class SampleController {

    private final SampleService sampleService;
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<SampleDTO> getSamples() {
        return this.sampleService.getSamples();
    }

    @GetMapping("/{sampleId}")
    @ResponseStatus(HttpStatus.OK)
    public SampleDTO getSample(@PathVariable long sampleId) {
        return this.sampleService.getSample(sampleId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SampleDTO addSample(
        @RequestBody SampleDTO sampleDTO
    ) {
        return this.sampleService.addSample(sampleDTO.getSampleTitle(), sampleDTO.getSampleContent());
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public SampleDTO updateSample(
        @PathVariable long sampleId,
        @RequestBody SampleDTO sampleDTO
    ) {
        return this.sampleService.updateSample(sampleId, sampleDTO.getSampleTitle(), sampleDTO.getSampleContent());
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteSample(@PathVariable long sampleId) {
        this.sampleService.deleteSample(sampleId);
    }
}
