package com.dqdwd.service.impl;

import com.dqdwd.mapper.ProductTypeMapper;
import com.dqdwd.pojo.ProductType;
import com.dqdwd.pojo.ProductTypeExample;
import com.dqdwd.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("ProductTypeServiceImpl")
public class ProductTypeServiceImpl implements ProductTypeService {
    @Autowired
    private ProductTypeMapper productTypeMapper;
    @Override
    public List<ProductType> getTypeAll() {
        return productTypeMapper.selectByExample(new ProductTypeExample());
    }
}
