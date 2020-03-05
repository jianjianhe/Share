package com.zhy.mapper;

import com.zhy.model.Article;
import com.zhy.model.Goods;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GoodsMapper {
    @Select("select s_Goods from s_Goods order by id desc")
    List<Goods> findAllGoods();

    @Insert("insert into s_Goods(userId,goodsName,goodsDes,goodsUnit,goodsPic,goodsPrice,goodsCreateTime,goodsStartTime,goodsEndTime,status) " +
            "values(#{userId},#{goodsName},#{goodsDes},#{goodsUnit},#{goodsPic},#{goodsPrice},#{goodsCreateTime},#{goodsStartTime},#{goodsEndTime},#{status})")
    void save(Goods goods);

    @Update("update s_Goods set goodsName=#{goodsName},goodsDes=#{goodsDes},goodsUnit=#{goodsUnit},goodsPic=#{goodsPic},goodsPrice=#{goodsPrice},goodsCreateTime=#{goodsCreateTime},goodsEndTime=#{goodsEndTime},status=#{status} where id=#{id}")
    void updateArticleById(Goods goods);

    @Select("select * from s_Goods where id=#{id}")
    Goods getGoodsById(int id);
}
