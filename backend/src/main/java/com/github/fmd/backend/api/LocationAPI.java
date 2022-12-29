package com.github.fmd.backend.api;

import com.github.fmd.backend.api.model.CreateLocationRequest;
import com.github.fmd.backend.api.model.LocationDescriptor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.net.URL;

@Tag(name = "Location and content management")
@RequestMapping("/api/v${api.version}")
public interface LocationAPI {
    @GetMapping("/location")
    @Operation(responses = {
        @ApiResponse(description = "OK", responseCode = "200"),
        @ApiResponse(description = "Not found", responseCode = "404")
    })
    Mono<LocationDescriptor> getLocationById(@RequestParam URL id, @RequestParam(required = false, defaultValue = "false") boolean embedContent);

    @PutMapping("/location")
    @Operation(responses = {
        @ApiResponse(description = "Created", responseCode = "201"),
        @ApiResponse(description = "Bad request (both content and contentId were provided)", responseCode = "400"),
        @ApiResponse(description = "Conflict (this location already exists)", responseCode = "409")
    })
    Mono<LocationDescriptor> createLocation(@RequestBody CreateLocationRequest body);


    @PostMapping("/location")
    @Operation(responses = {
        @ApiResponse(description = "OK", responseCode = "200"),
        @ApiResponse(description = "Created", responseCode = "201"),
        @ApiResponse(description = "Bad request (both content and contentId were provided)", responseCode = "400"),
    })
    Mono<LocationDescriptor> makeLocation(@RequestBody CreateLocationRequest body);

}
