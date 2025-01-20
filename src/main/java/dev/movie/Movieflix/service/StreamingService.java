package dev.movie.Movieflix.service;

import dev.movie.Movieflix.entity.Streaming;
import dev.movie.Movieflix.repository.StreamingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StreamingService {

    private StreamingRepository repository;

    public StreamingService(StreamingRepository repository) {
        this.repository = repository;
    }

    public List<Streaming> getAll(){
        return repository.findAll();
    }

    public Optional<Streaming> getById(Long id){
        return repository.findById(id);
    }

    public Streaming save(Streaming streaming){
        return repository.save(streaming);
    }

    public void deleteStreaming(Long id){
        repository.deleteById(id);
    }
}
