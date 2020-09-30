package com.reddit.clone.dto;

import com.reddit.clone.model.VoteType;

public class VoteDto {

    public VoteDto() {}

    public VoteDto(VoteType voteType, Long postId) {
        this.voteType = voteType;
        this.postId = postId;
    }

    private VoteType voteType;
    private Long postId;

    public VoteType getVoteType() {
        return voteType;
    }

    public void setVoteType(VoteType voteType) {
        this.voteType = voteType;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
