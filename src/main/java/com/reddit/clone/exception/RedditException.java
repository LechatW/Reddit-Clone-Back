package com.reddit.clone.exception;

public class RedditException extends RuntimeException {

    public RedditException(String message, Exception exception) {
        super(message, exception);
    }

    public RedditException(String exMessage) {
        super(exMessage);
    }

}
