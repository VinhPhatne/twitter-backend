package com.social.service;

import com.social.exception.TwitException;
import com.social.exception.UserException;
import com.social.model.Like;
import com.social.model.User;

import java.util.List;

public interface LikeService {

    public Like likeTwit(Long twitId, User user) throws UserException, TwitException;

    public List<Like> getAllLikes(Long twitId) throws TwitException;
}
