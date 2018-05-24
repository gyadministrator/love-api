package com.gy.love.loveapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gy.love.loveapi.annotation.CurrentUser;
import com.gy.love.loveapi.entity.LoveDesire;
import com.gy.love.loveapi.entity.LoveUser;
import com.gy.love.loveapi.entity.Page;
import com.gy.love.loveapi.mapper.LoveDesireMapper;
import com.gy.love.loveapi.service.DesireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

@Service
public class DesireServiceImpl implements DesireService {
    @Autowired
    private LoveDesireMapper loveDesireMapper;

    @Override
    public LoveDesire findById(Integer id) {
        return loveDesireMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Map<String, Object>> findAllByPage(Page page) {
        PageHelper.startPage(page.getPage(), page.getPageSize());

        List<Map<String, Object>> list = new ArrayList<>();
        List<LoveDesire> all = loveDesireMapper.findAllByPage(page);
        for (int i = 0; i < all.size(); i++) {
            Map<String, Object> map = new HashMap<>();
            LoveDesire loveDesire = all.get(i);
            Date endDate = loveDesire.getEndDate();
            try {
                int num = daysBetween(new Date(), endDate);
                map.put("num", num);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            map.put("desire", loveDesire);
            list.add(map);
        }

        PageInfo<Map<String, Object>> result = new PageInfo<>(list);
        return result;
    }

    @Override
    public void add(LoveDesire loveDesire, @CurrentUser LoveUser loveUser) {
        loveDesire.setIsSuccess(false);
        loveDesire.setUserId(loveUser.getId());
        loveDesireMapper.insertSelective(loveDesire);
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException calendar 对日期进行时间操作
     *                        getTimeInMillis() 获取日期的毫秒显示形式
     */
    public static int daysBetween(Date smdate, Date bdate) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days));
    }
}
