package com.huzh.first.repository;

import com.huzh.first.domain.Boy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoyRepository extends JpaRepository<Boy,Integer> {
    public List<Boy> findByName(String name);
    public Boy findOneByName(String name);
}
