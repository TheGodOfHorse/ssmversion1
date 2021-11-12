package com.dqdwd.service;

import com.dqdwd.pojo.ProductInfo;
import com.dqdwd.pojo.ProductType;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ProductInfoService {
   public List<ProductInfo> getAll();
   public PageInfo splitPage(int pageNum,int pageSize);
   public void addProductInfo(ProductInfo productInfo);

}
