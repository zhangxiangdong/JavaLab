package me.zhang.designPatterns.mediator;

/**
 * Created by zhangxiangdong on 2017/2/22.
 * <p>
 * Abstract Mediator
 */
public interface Mediator {

    void registerView(BtnView v);

    void view();

    void registerSearch(BtnSearch s);

    void search();

    void registerBook(BtnBook b);

    void book();

    void registerDisplay(LblDisplay d);

}
