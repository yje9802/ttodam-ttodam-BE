package com.ttodampartners.ttodamttodam.domain.bookmark.repository;

import com.ttodampartners.ttodamttodam.domain.bookmark.entity.BookmarkEntity;
import com.ttodampartners.ttodamttodam.domain.post.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookmarkRepository extends JpaRepository<BookmarkEntity, Long> {
    List<BookmarkEntity> findByUserId(Long userId);
    List<BookmarkEntity> findByPost_PostId(Long postId);

}