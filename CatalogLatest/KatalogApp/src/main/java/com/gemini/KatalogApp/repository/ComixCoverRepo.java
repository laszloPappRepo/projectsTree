package com.gemini.KatalogApp.repository;

import com.gemini.KatalogApp.model.ComixCover;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ComixCoverRepo extends CrudRepository<ComixCover, Long> {
    List<ComixCover> findAllByTitleIsContaining(String title);
    @Query(value = "SELECT * FROM catalog.comix_cover ORDER BY (title) ASC", nativeQuery = true)
    List<ComixCover> orderedByTitleAsc();
    @Query(value = "SELECT * FROM catalog.comix_cover ORDER BY (title) DESC", nativeQuery = true)
    List<ComixCover> orderedByTitleDesc();

    @Query(value = "SELECT * FROM catalog.comix_cover", nativeQuery = true)List<ComixCover> listAll();

    @Query(value = "SELECT * FROM catalog.comix_cover WHERE publisher IS LIKE (publisher)", nativeQuery = true)
    List<ComixCover> findAllByPublisher(String publisher);
    //@Query(value = "SELECT cover FROM catalog.comix_cover", nativeQuery = true) List<Byte[]> getAllCovers();
}
