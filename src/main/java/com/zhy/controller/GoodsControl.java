package com.zhy.controller;

import com.zhy.aspect.annotation.PermissionCheck;
import com.zhy.component.StringAndArray;
import com.zhy.constant.CodeType;
import com.zhy.model.Article;
import com.zhy.model.ArticleLikesRecord;
import com.zhy.model.Goods;
import com.zhy.service.ArchiveService;
import com.zhy.service.GoodsService;
import com.zhy.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
@Slf4j
public class GoodsControl {
    @Autowired
    GoodsService goodsService;

    /**
     * 发表博客
     * @param principal 当前登录用户
     * @param goods 商品
     * @param request httpServletRequest
     * @return
     */
    @PostMapping(value = "/addGoods", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String publishArticle(@AuthenticationPrincipal Principal principal,
                                 Goods goods,
                                 HttpServletRequest request){
        if(principal == null){
            request.getSession().setAttribute("goods", goods);
            return JsonResult.fail(CodeType.USER_NOT_LOGIN).toJSON();
        }
        TimeUtil timeUtil = new TimeUtil();
        String id = request.getParameter("id");
        String nowDate = timeUtil.getFormatDateForThree();
        //修改商品
        if(!StringUtil.BLANK.equals(id) && id != null){
            goods.setId(Integer.parseInt(id));
            goods.setUpdateTime(nowDate);
            DataMap data = goodsService.updateGoodsById(goods);
            return JsonResult.build(data).toJSON();
        }

//        goods.setUserId();
//        goods.setGoodsCreateTime(nowDate);
        goods.setUpdateTime(nowDate);

        DataMap data = goodsService.insertGoods(goods);
        return JsonResult.build(data).toJSON();
    }
}
