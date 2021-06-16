package com.nile.apiservice.sample.controller;

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
    public String getSamples() {
        this.sampleService.getSamples();
        return "Sample List !";
    }

    @GetMapping("/{sampleId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String getSample(@PathVariable long sampleId) {
        this.sampleService.getSample(sampleId);
        return "Sample Info !";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String addSample(
        @RequestBody SampleDTO sampleDTO
    ) {
        this.sampleService.addSample(sampleDTO.getSampleTitle(), sampleDTO.getSampleContent());
        return "Sample Add !";
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String updateSample(
        @PathVariable long sampleId,
        @RequestBody SampleDTO sampleDTO
    ) {
        this.sampleService.updateSample(sampleId, sampleDTO.getSampleTitle(), sampleDTO.getSampleContent());
        return "Sample Update !";
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String deleteSample(@PathVariable long sampleId) {
        this.sampleService.deleteSample(sampleId);
        return "Sample Delete !";
    }
}
