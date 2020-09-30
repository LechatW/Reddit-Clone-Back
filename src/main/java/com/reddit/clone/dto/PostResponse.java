package com.reddit.clone.dto;

public class PostResponse {

    public PostResponse() {}

    public PostResponse(Long id, String postName, String url, String description, String userName, String subredditName, Integer voteCount, Integer commentCount, String duration, boolean upVote, boolean downVote) {
        this.id = id;
        this.postName = postName;
        this.url = url;
        this.description = description;
        this.userName = userName;
        this.subredditName = subredditName;
        this.voteCount = voteCount;
        this.commentCount = commentCount;
        this.duration = duration;
        this.upVote = upVote;
        this.downVote = downVote;
    }

    private Long id;
    private String postName;
    private String url;
    private String description;
    private String userName;
    private String subredditName;
    private Integer voteCount;
    private Integer commentCount;
    private String duration;
    private boolean upVote;
    private boolean downVote;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSubredditName() {
        return subredditName;
    }

    public void setSubredditName(String subredditName) {
        this.subredditName = subredditName;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public boolean isUpVote() {
        return upVote;
    }

    public void setUpVote(boolean upVote) {
        this.upVote = upVote;
    }

    public boolean isDownVote() {
        return downVote;
    }

    public void setDownVote(boolean downVote) {
        this.downVote = downVote;
    }
}
