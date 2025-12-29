package com.thejoa.boot001.myjpa1;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository  extends JpaRepository<Post, Long> {}
