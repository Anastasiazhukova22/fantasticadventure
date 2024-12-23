package org.example.controllers;


import org.example.dto.ArtistContentDto;
import org.example.mappers.ArtistMapper;
import org.example.models.ArtistContent;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ArtistController {

    List<ArtistContent> contentList = new ArrayList<>();


    @PostMapping("/content/add")
    public String addContent(@RequestBody ArtistContentDto artistContent) {
        ArtistContent contentmodel = ArtistMapper.map(artistContent);
        contentList.add(contentmodel); //перенести в grpc

        System.out.println(artistContent);
        return "На сайт добавлен новый материал c id" + contentmodel.contentId();
    }

    @GetMapping("/content/get")
    public ArtistContent getcontent(Integer contentId) {

        return contentList.stream().filter(c ->contentId.equals(c.contentId())).findAny().get();
    }
}

