package com.practice.practice_jooq.stats;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StatsRepository extends JpaRepository<StatsSalesByCategory, String>, StatsRepositoryJooq{

}
