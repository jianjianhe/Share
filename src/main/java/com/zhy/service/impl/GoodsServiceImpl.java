package com.zhy.service.impl;

import com.zhy.constant.CodeType;
import com.zhy.constant.SiteOwner;
import com.zhy.mapper.GoodsMapper;
import com.zhy.model.Article;
import com.zhy.model.Goods;
import com.zhy.service.GoodsService;
import com.zhy.utils.DataMap;
import com.zhy.utils.StringUtil;
import com.zhy.utils.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public DataMap insertGoods(Goods goods) {
        Map<String, Object> dataMap = new HashMap<>(4);
        try {
            goodsMapper.save(goods);
            dataMap.put("userId",goods.getUserId());
            return DataMap.success().setData(dataMap);
        } catch (Exception e){
            log.error("publish article [{}] exception", goods.getGoodsName(), e);
            return DataMap.fail(CodeType.PUBLISH_ARTICLE_EXCEPTION);
        }
    }

    @Override
    public DataMap updateGoodsById(Goods goods) {
//        Goods a = goodsMapper.getGoodsById(goods.getId());

        goodsMapper.updateArticleById(goods);
        Map<String, Object> dataMap = new HashMap<>(4);
        dataMap.put("userId",goods.getUserId());

        return DataMap.success().setData(dataMap);
    }
}
