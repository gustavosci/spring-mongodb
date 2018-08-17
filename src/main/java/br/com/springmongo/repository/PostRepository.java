package br.com.springmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.springmongo.entity.Post;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(final String text);

    // ?0 = primeiro parametro. se fosse o segundo, seria ?1, e assim por diante
    // options 'i' indica que é para ignorar case
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> findByTitleUsingQueryNative(final String text);

    // $gte = greater or equal | $ lte = less or equal
    @Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> fullSearch(final String text, final Date minDate, final Date maxDate);
}
