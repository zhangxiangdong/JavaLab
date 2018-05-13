package me.zhang.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created by Zhang on 2018/5/13 14:06.
 */
@Documented // To make the information in @ClassPreamble appear in Javadoc-generated documentation
@Target({ElementType.TYPE})
public @interface ClassPreamble {

    String author();

    String date();

    int currentRevision() default 1;

    String lastModified() default "N/A";

    String lastModifiedBy() default "N/A";

    String[] reviewers();

}
