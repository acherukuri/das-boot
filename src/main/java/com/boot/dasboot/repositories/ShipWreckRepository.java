package com.boot.dasboot.repositories;

import com.boot.dasboot.models.Shipwreck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipWreckRepository extends JpaRepository<Shipwreck, Long> {
}
