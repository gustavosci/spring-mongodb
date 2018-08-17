package br.com.springmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.springmongo.entity.Post;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    // ?0 = primeiro parametro. se fosse o segundo, seria ?1, e assim por diante
    // options 'i' indica que é para ignorar case
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> findByTitleUsingQueryNative(final String text);

    List<Post> findByTitleContainingIgnoreCase(final String text);
}
