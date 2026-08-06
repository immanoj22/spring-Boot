package com.springdata.springDataJpa_01.Repository;

import com.springdata.springDataJpa_01.Entity.JobApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobAppllicationRespository extends JpaRepository<JobApplicationEntity,Long> {

    @Query(value = "select * from jobs limit :limit offset :offset",nativeQuery = true)
    public List<JobApplicationEntity> findAllJobs(@Param("limit") int limit,@Param("offset") int offset);

    @Query("select j from JobApplicationEntity j " +
            "where lower(j.companyName) like lower(concat(:value, '%'))")
    List<JobApplicationEntity> searchValue(@Param("value") String value);
}
