package com.kickoffs.HotelBooking_API.repository;

import com.kickoffs.HotelBooking_API.models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, String> {
    //Add the required annotations to make the Owner Repository
}
