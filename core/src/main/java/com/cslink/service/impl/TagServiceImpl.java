package com.cslink.service.impl;

import com.cslink.domain.Tag;
import com.cslink.mapper.TagMapper;
import com.cslink.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements ITagService {

    @Autowired
    TagMapper tagMapper;
    @Override
    public List<Tag> getTagList() {
        return tagMapper.queryTagList();
    }
}
