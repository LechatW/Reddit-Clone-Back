package com.reddit.clone.service;

import com.reddit.clone.dto.SubredditDto;
import com.reddit.clone.exception.RedditException;
import com.reddit.clone.mapper.SubredditMapper;
import com.reddit.clone.model.Subreddit;
import com.reddit.clone.repository.SubredditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubredditService {

    private final SubredditRepository subredditRepository;
    private final SubredditMapper subredditMapper;
    private final AuthService authService;

    @Autowired
    public SubredditService(SubredditRepository subredditRepository, SubredditMapper subredditMapper, AuthService authService) {
        this.subredditRepository = subredditRepository;
        this.subredditMapper = subredditMapper;
        this.authService = authService;
    }

    @Transactional
    public void save(SubredditDto subredditDto) {
        Subreddit subreddit = subredditMapper.mapToEntity(subredditDto, authService.getCurrentUser());

        subredditRepository.save(subreddit);
    }

    @Transactional(readOnly = true)
    public List<SubredditDto> getAllSubreddits() {
        return subredditRepository.findAll()
                .stream()
                .map(subredditMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public SubredditDto getSubreddit(Long id) {
        Subreddit subreddit = subredditRepository.findById(id)
                .orElseThrow(() -> new RedditException("No subreddit found with ID - " + id));
        return subredditMapper.mapToDto(subreddit);
    }
}
