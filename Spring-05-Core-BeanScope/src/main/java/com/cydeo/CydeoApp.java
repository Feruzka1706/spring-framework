package com.cydeo;

import com.cydeo.config.ProjectConfig;
import com.cydeo.entity.Comment;
import com.cydeo.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//Runner class always has to be under main package folder
public class CydeoApp {
    public static void main(String[] args) {

        Comment comment = new Comment();
        comment.setAuthor("Johnson");
        comment.setText("Spring Framework");

        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        /*
        CommentService commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);

        CommentService cs1 = context.getBean(CommentService.class);

        CommentService cs2 = context.getBean(CommentService.class);

        System.out.println(cs1); //memory location of object
        System.out.println(cs2); //memory location of object

         */

    }

}
