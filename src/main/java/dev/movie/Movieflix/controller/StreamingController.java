package dev.movie.Movieflix.controller;


import dev.movie.Movieflix.controller.mapper.StreamingMapper;
import dev.movie.Movieflix.controller.request.StreamingRequest;
import dev.movie.Movieflix.controller.response.StreamingResponse;
import dev.movie.Movieflix.entity.Streaming;
import dev.movie.Movieflix.service.StreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/movieflix/streaming")
public class StreamingController {

    @Autowired
    private StreamingService streamingService;

    @GetMapping
    public ResponseEntity<List<StreamingResponse>> getAllStreaming(){
        List<Streaming> streamings = streamingService.getAll();
        if(streamings.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        List<StreamingResponse> responseList = streamings.stream()
                .map(StreamingMapper::toStreamingResponse)
                .toList();

        return ResponseEntity.ok(responseList);
    }

    @PostMapping
    public ResponseEntity<StreamingResponse> saveStreaming(@RequestBody StreamingRequest request){
        Streaming newStreaming = StreamingMapper.toStreaming(request);
        Streaming savedStreaming = streamingService.save(newStreaming);
        return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.toStreamingResponse(savedStreaming));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByid(@PathVariable long id){
        return streamingService.getById(id)
                .map(streaming -> ResponseEntity
                        .ok(StreamingMapper.toStreamingResponse(streaming)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        streamingService.deleteStreaming(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}
