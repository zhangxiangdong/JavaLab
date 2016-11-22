package com.zhang.factory.abs2;

/**
 * Created by zhangxiangdong on 2016/11/22.
 */
public interface KingdomFactory {

    Castle createCastle();

    King createKing();

    Army createArmy();

}
