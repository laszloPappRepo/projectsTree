package com.gemini.KatalogApp.repository;

import com.gemini.KatalogApp.model.ComixCover;
import org.springframework.data.repository.CrudRepository;

public interface ComixCoverRepo extends CrudRepository<ComixCover, Long> {

    //@Query(value = "SELECT * FROM catalog.comix_cover", nativeQuery = true)List<ComixCover> listAll();
    //@Query(value = "SELECT cover FROM catalog.comix_cover", nativeQuery = true) List<Byte[]> getAllCovers();
}
