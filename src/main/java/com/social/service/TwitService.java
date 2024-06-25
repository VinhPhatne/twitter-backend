package com.social.service;

import com.social.exception.TwitException;
import com.social.exception.UserException;
import com.social.model.Twit;
import com.social.model.User;
import com.social.request.TwitReplyRequest;
import com.social.request.TwitReplyRequest;

import java.util.List;

public interface TwitService {

    public Twit createTwit(Twit req, User user)throws UserException;

    public List<Twit> findAllTwit();

    public Twit retwit(Long twitId, User user)throws UserException, TwitException;

    public Twit findById(Long twitId) throws TwitException;

    public void deleteTwitById(Long twitId, Long userId) throws TwitException, UserException;

    public Twit removeFromRetwit(Long twitId, User userId) throws TwitException, UserException;

    public Twit createdReply(TwitReplyRequest req, User user) throws TwitException;

    public List<Twit> getUserTwit(User user);

    public List<Twit> findByLikesContainsUser(User user);
}
