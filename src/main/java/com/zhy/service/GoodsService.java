package com.zhy.service;

import com.zhy.model.Article;
import com.zhy.model.Goods;
import com.zhy.utils.DataMap;
import org.springframework.transaction.annotation.Transactional;

public interface GoodsService {
    /**
     * 添加商品
     * @param goods
     * @return
     */

    DataMap insertGoods(Goods goods);

    /**
     * 修改商品
     * @return
     */
    @Transactional
    DataMap updateGoodsById(Goods goods);
}
