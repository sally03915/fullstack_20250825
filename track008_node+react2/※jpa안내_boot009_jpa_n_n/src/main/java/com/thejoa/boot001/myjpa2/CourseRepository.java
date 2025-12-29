package com.thejoa.boot001.myjpa2;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository  extends JpaRepository<Course, Long> {}
