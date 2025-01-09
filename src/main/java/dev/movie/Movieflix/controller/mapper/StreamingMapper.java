package dev.movie.Movieflix.controller.mapper;

import dev.movie.Movieflix.controller.request.StreamingRequest;
import dev.movie.Movieflix.controller.response.StreamingResponse;
import dev.movie.Movieflix.entity.Streaming;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamingMapper {
    public static Streaming toStreaming(StreamingRequest streamingRequest){
        return Streaming
                .builder()
                .name(streamingRequest.name())
                .build();
    }

    public static StreamingResponse toStreamingResponse(Streaming streaming){
        return StreamingResponse
                .builder()
                .id(streaming.getId())
                .name(streaming.getName())
                .build();
    }
}
