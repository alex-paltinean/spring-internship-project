package com.accenture.springcore.service;

import com.accenture.springcore.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository<T extends BaseEntity, ID> extends JpaRepository<T, ID> {
}
