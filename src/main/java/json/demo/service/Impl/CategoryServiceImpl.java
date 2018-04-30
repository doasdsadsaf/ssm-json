package json.demo.service.Impl;

import json.demo.dao.CategoryMapper;
import json.demo.entity.Category;
import json.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 或 on 2018/4/29.
 */
@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public Category getCategory(int id) {
        return categoryMapper.selectByPrimaryKey( id );
    }
}
