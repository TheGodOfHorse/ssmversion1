package com.dqdwd.service.impl;

import com.dqdwd.mapper.ProductInfoMapper;
import com.dqdwd.mapper.ProductTypeMapper;
import com.dqdwd.pojo.ProductInfo;
import com.dqdwd.pojo.ProductInfoExample;
import com.dqdwd.pojo.ProductType;
import com.dqdwd.pojo.ProductTypeExample;
import com.dqdwd.service.ProductInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
    private ProductInfoMapper productInfoMapper;
    @Autowired
    private ProductTypeMapper productTypeMapper;
    //获取全部商品
    @Override
    public List<ProductInfo> getAll() {
       return productInfoMapper.selectByExample(new ProductInfoExample());
    }

    //分页查询
    @Override
    public PageInfo splitPage(int pageNum, int pageSize) {
        //使用了这个方法mybatis后面的第一个查询语句就会使用这个分页
         PageHelper.startPage(pageNum, pageSize);
        ProductInfoExample example=new ProductInfoExample();
        example.setOrderByClause("p_id desc");
        List<ProductInfo> list = productInfoMapper.selectByExample(example);
        PageInfo<ProductInfo> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
    //添加商品
    @Override
    public void addProductInfo(ProductInfo productInfo) {
        productInfoMapper.insert(productInfo);
    }
}
