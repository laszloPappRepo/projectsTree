package com.gemini.KatalogApp.service;

import com.gemini.KatalogApp.model.CollectionEntity;
import com.gemini.KatalogApp.repository.ComixCoverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImageHandlingService {

    @Autowired
    ComixCoverRepo comixCoverRepo;

    public List<CollectionEntity> createCollectionEntityListFromDB() throws IOException {
        //CollectionEntity collectionEntity = new CollectionEntity();
        List<CollectionEntity> entitiesFromDB = new ArrayList<>();

        for (int i = 0; i < comixCoverRepo.listAll().size(); i++) {
            InputStream in = new ByteArrayInputStream(comixCoverRepo.listAll().get(i).getCover());
            BufferedImage bImageFromConvert = ImageIO.read(in);
            //collectionEntity.setCover(bImageFromConvert);
            //collectionEntity.setTitle(comixCoverRepo.listAll().get(i).getTitle());
            entitiesFromDB.add(new CollectionEntity(comixCoverRepo.listAll().get(i).getTitle(), bImageFromConvert));
        }
        for (int i = 0; i < entitiesFromDB.size(); i++) {
            System.out.println(entitiesFromDB.get(i).getTitle());
        }
        return entitiesFromDB;
    }
}
