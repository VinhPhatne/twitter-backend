package com.social.service;

import com.social.exception.TwitException;
import com.social.exception.UserException;
import com.social.model.Like;
import com.social.model.Twit;
import com.social.model.User;
import com.social.repository.LikeRepository;
import com.social.repository.TwitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImplementation implements LikeService{

    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private TwitService twitService;
    @Autowired
    private TwitRepository twitRepository;

    @Override
    public Like likeTwit(Long twitId, User user) throws UserException, TwitException {
        Like isLikeExist =likeRepository.isLikeExist(user.getId(), twitId);

        if(isLikeExist!=null) {
            likeRepository.deleteById(isLikeExist.getId());
            return isLikeExist;
        }
        Twit twit = twitService.findById(twitId);

        Like like = new Like();
        like.setTwit(twit);
        like.setUser(user);

        Like savedLike = likeRepository.save(like);

        twit.getLikes().add(savedLike);
        twitRepository.save(twit);

        return savedLike;
    }

    @Override
    public List<Like> getAllLikes(Long twitId) throws TwitException {
        Twit twit = twitService.findById(twitId);

        List<Like> likes = likeRepository.findByTwitId(twitId);
        return likes;
    }
}
