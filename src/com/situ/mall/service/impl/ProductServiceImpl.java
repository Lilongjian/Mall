package com.situ.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.situ.mall.common.ServerResponse;
import com.situ.mall.entity.Product;
import com.situ.mall.entity.User;
import com.situ.mall.mapper.ProductMapper;
import com.situ.mall.mapper.UserMapper;
import com.situ.mall.service.IProductService;
import com.situ.mall.service.IUserService;
import com.situ.mall.util.MD5Util;
@Service
public class ProductServiceImpl implements IProductService{
    @Autowired
    private ProductMapper productMapper;
	@Override
	public ServerResponse<List<Product>> pageList(Integer page, Integer limit,Product product) {
		PageHelper.startPage(page, limit);
 		//数据data
 		List<Product> list = productMapper.pageList(product);
 		//count
 		/*Integer count = (int) ((Page)list).getTotal();*/
 		Integer count = (int) ((Page) list).getTotal();
 		//第二种：用PageInfo对结果进行包装
 		/* PageInfo pageInfo = new PageInfo(list);
 		 Integer count = (int) pageInfo.getTotal();*/
 		return ServerResponse.createSuccess("查询成功", count, list);
	}
	@Override
	public ServerResponse deleteById(Integer id) {
		int count = productMapper.deleteByPrimaryKey(id);
		if (count > 0) {
			return ServerResponse.createSuccess("删除成功");
		}
		return ServerResponse.createError("删除失败");
	}
	@Override
	public ServerResponse deleteAll(String ids) {
		String[] idsArray = ids.split(",");
	    int count = productMapper.deleteAll(idsArray);
	    if(count == idsArray.length){
	    	return ServerResponse.createSuccess("批量删除成功");
	    }
		return ServerResponse.createError("批量删除失败");
	}

}
