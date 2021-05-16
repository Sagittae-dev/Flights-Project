package com.example.smart4aviation.smart4aviation.repositories;

import com.example.smart4aviation.smart4aviation.models.Baggage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaggageRepository extends JpaRepository<Baggage, Integer> {
}
