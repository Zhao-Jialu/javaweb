package com.service;

import com.mapper.BrandMapper;
import com.pojo.Brand;
import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 查询所有
     * @return
     */
    public List<Brand> selectAll(){
        //获取sqlSession
        SqlSession sqlSession = factory.openSession();

        //获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //调用方法
        List<Brand> brands = mapper.selectALL();

        sqlSession.close();

        return brands;
    }

    /**
     * 添加
     * @param brand
     */

    public void add(Brand brand){
        //获取sqlSession
        SqlSession sqlSession = factory.openSession();

        //获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.add(brand);
        sqlSession.commit();
        sqlSession.close();

    }


    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Brand selectById(int id){
        //获取sqlSession
        SqlSession sqlSession = factory.openSession();

        //获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //调用方法
        Brand brand = mapper.selectById(id);

        sqlSession.close();

        return brand;
    }


    /**
     * 修改
     * @param brand
     */
    public void update(Brand brand){
        //获取sqlSession
        SqlSession sqlSession = factory.openSession();

        //获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.update(brand);
        sqlSession.commit();
        sqlSession.close();

    }

    /**
     * 删除
     * @param id
     */
    public void delete(int id){
        //获取sqlSession
        SqlSession sqlSession = factory.openSession();

        //获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.delete(id);
        sqlSession.commit();
        sqlSession.close();

    }
}
