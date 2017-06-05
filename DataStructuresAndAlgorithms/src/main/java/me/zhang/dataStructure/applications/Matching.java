package me.zhang.dataStructure.applications;

import me.zhang.dataStructure.ArrayStack;
import me.zhang.dataStructure.Stack;

/**
 * Created by zhangxiangdong on 2017/6/5.
 */
public class Matching {

    public boolean isMatch(String expression) {
        final String opening = "({[";
        final String closing = ")}]";
        final Stack<Character> container = new ArrayStack<>();
        for (char c : expression.toCharArray()) {
            if (opening.indexOf(c) != -1) {
                container.push(c);
            } else if (closing.indexOf(c) != -1) {
                if (container.isEmpty()) {
                    return false;
                }
                if (opening.indexOf(container.pop()) != closing.indexOf(c)) {
                    return false;
                }
            }
        }
        return container.isEmpty();
    }

}
