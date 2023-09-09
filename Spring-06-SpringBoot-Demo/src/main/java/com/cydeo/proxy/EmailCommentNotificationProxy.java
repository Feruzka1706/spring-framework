package com.cydeo.proxy;

import com.cydeo.entity.Comment;
import org.springframework.stereotype.Component;

//@Component("EmailCommentNotificationProxy")
@Component
//@Primary
//@Qualifier("Email")
public class EmailCommentNotificationProxy implements CommentNotificationProxy{
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending notification for comment : "+comment.getText());
    }

}
