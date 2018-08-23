package com.gemini.KatalogApp.repository;

import com.gemini.KatalogApp.model.ComixCover;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ComixCoverRepo extends CrudRepository<ComixCover, Long> {

    @Query(value = "SELECT * FROM catalog.comix_cover", nativeQuery = true)List<ComixCover> listAll();

}
