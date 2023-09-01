package com.bing.controller;


import com.bing.dao.DimRepository;
import com.bing.dao.InfoRepository;
import com.bing.entity.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("info")
public class JPAController {

    @Autowired
    private InfoRepository infoRepository;

    @Autowired
    private DimRepository dimRepository;
    @PostMapping("/insert")
    public String insert(@RequestBody Info user) {
        Info save = infoRepository.save(user);
        return save.toString();

    }

    @PostMapping("/update")
    public String update(@RequestBody Info user) {

        return infoRepository.save(user).toString();
    }

    @GetMapping("/getOne")
    public Info getOne(@RequestParam Integer id) {
        return infoRepository.getById(id);
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        infoRepository.deleteById(id);
        return Boolean.TRUE.toString();
    }


    @GetMapping("/custom")
    public List<Info> custom(@RequestParam Integer id,String direction,String orderBy) {
        Sort.Direction sortDirection = Sort.Direction.ASC;
        if ("DESC".equals(direction)) {
            sortDirection = Sort.Direction.DESC;
        }
        Sort sort = Sort.by(sortDirection, orderBy);
        return infoRepository.findAll(sort);
    }



    @GetMapping("/dimCustom")
    public List<Info> dim(@RequestParam Integer id,String direction,String orderBy) {
        Sort.Direction sortDirection = Sort.Direction.ASC;
        if ("DESC".equals(direction)) {
            sortDirection = Sort.Direction.DESC;
        }
        Sort sort = Sort.by(sortDirection, orderBy);
        return infoRepository.findAll(sort);
    }

}
