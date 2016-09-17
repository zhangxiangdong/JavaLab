package me.zhang.test;

import java.util.regex.Pattern;

/**
 * Created by Zhang on 2016/3/1 下午 3:17 .
 */
public class Re {
    public static void main(String[] args) {
////        Matcher matcher = Pattern.compile("\\(#.*?\\)+|[\\w\\s]+|[^\\w\\s]+", Pattern.UNICODE_CHARACTER_CLASS).matcher("#@我是话题#sd\t呵#ddd#呵\nfd(#@%糖)j\r#我不要是话题##我不是####话题#skdf\n你好(#啤###酒)j\fkj");
//        Matcher matcher = Pattern.compile("\\(#[^)]+\\)+|[\\w\\s]+|[^\\w\\s]+", Pattern.UNICODE_CHARACTER_CLASS).matcher("#@我是话题#sd\t呵#d(#很惊讶)dd#呵\nfd(#(糖)j\r#我不要是话题#(#((()))(糖)#我不是####话题#skdf\n你好(#啤酒)j\fkj");
//        while (matcher.find()) {
//            System.out.println(matcher.group());
//            System.out.println("**************************************");
//        }
//
//        System.out.println(Arrays.toString("a;b;c;d".split("(?<=;)")));
//        System.out.println(Arrays.toString("a;b;c;d".split("(?=;)")));
//        System.out.println(Arrays.toString("a;b;c;d".split("((?<=;)|(?=;))")));

        String contents = "#@我是话题#sd\t(#很惊讶)呵#d(#很惊讶)dd#呵\nfd(#(糖)j\r#我不要是话题#(#糖)(()))()#我不(#\tt)是####话(#)(#很惊讶)题#skdf\n你好(#啤酒)j\fkj";
        Pattern pattern = Pattern.compile("(?<=(\\(#[^(^).]{1,10}\\)))|(?=(\\(#[^(^).]{1,10}\\)))");
//        Pattern pattern = Pattern.compile("\\(#([^)]+)\\)");
//        Pattern pattern = Pattern.compile("(?<=(\\(#.{1,5}\\)))");
//        Pattern pattern = Pattern.compile("(?=(\\(#.{1,5}\\)))");
        String[] result = pattern.split(contents);
//        String[] result = "some@domain.com".split("(?=[@.])|(?<=[@.])");
        for (String res : result) {
            System.out.println(res);
            System.out.println("*******************************");
        }

    }
}
