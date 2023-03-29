package com.example.applicationcontext.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * 测试事件
 * source参数表示事件最初发生的对象或与事件相关的对象（永远不为null）。
 * 传入的对象会成为事件的源，即事件最初发生的对象或与事件相关的对象。在事件处理过程中，可以通过getSource()方法获取事件的源对象。因此，传入不同的对象作为source参数会影响事件的处理结果。
 * @author maonengneng
 * @date 2023/03/29
 */
@Getter
@Setter
public class TestEvent extends ApplicationEvent {

    private String message;
    private String time;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public TestEvent(Object source) {
        super(source);
    }


}
