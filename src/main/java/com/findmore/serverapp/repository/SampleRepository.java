package com.findmore.serverapp.repository;

import com.findmore.serverapp.entity.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * The implementation for this interface is automatically generated by the Spring Data library.
 */

@Repository
public interface SampleRepository extends JpaRepository<Sample, Long> {

    /**
     * Constructs a method that executes the sql query annotated on @Query.
     * @param name The name of the Sample to retrieve.
     * @return Returns the Sample object if exists and null if not exists.
     */
    @Query("SELECT f FROM Sample f WHERE LOWER(f.sampleName) = LOWER(:name)")
    Sample retrieveByName(@Param("name") String name);

    /**
     * Constructs a method that executes the same as the previous one but with more performance and less error-prone.
     * This way we can safely construct a method that queries the database without construct the actual sql query.
     * @param sampleName The name of the Sample to retrieve.
     * @return Returns the Sample object if exists and null if not exists.
     */
    Sample findSampleBySampleName(String sampleName);
}