package com.reddit.clone.service;

import com.reddit.clone.dto.VoteDto;
import com.reddit.clone.exception.PostNotFoundException;
import com.reddit.clone.exception.RedditException;
import com.reddit.clone.model.Post;
import com.reddit.clone.model.Vote;
import com.reddit.clone.model.VoteType;
import com.reddit.clone.repository.PostRepository;
import com.reddit.clone.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoteService {

    private final VoteRepository voteRepository;
    private final PostRepository postRepository;
    private final AuthService authService;

    @Autowired
    public VoteService(VoteRepository voteRepository, PostRepository postRepository, AuthService authService) {
        this.voteRepository = voteRepository;
        this.postRepository = postRepository;
        this.authService = authService;
    }

    public void vote(VoteDto voteDto) {
        Post post = postRepository.findById(voteDto.getPostId())
                .orElseThrow(() -> new PostNotFoundException(voteDto.getPostId().toString()));

        Optional<Vote> voteByPostAndUser = voteRepository.findTopByPostAndUserOrderByVoteIdDesc(post, authService.getCurrentUser());

        if(voteByPostAndUser.isPresent() &&
                voteByPostAndUser.get().getVoteType().equals(voteDto.getVoteType())) {
            throw new RedditException("You already have " + voteDto.getVoteType() + "'d for this post");
        }
        if(VoteType.UPVOTE.equals(voteDto.getVoteType())) {
            post.setVoteCount(post.getVoteCount() + 1);
        } else {
            post.setVoteCount(post.getVoteCount() - 1);
        }

        voteRepository.save(mapToVote(voteDto, post));
        postRepository.save(post);
    }

    private Vote mapToVote(VoteDto voteDto, Post post) {
        Vote vote = new Vote();
        vote.setVoteType(voteDto.getVoteType());
        vote.setPost(post);
        vote.setUser(authService.getCurrentUser());

        return vote;
    }
}
