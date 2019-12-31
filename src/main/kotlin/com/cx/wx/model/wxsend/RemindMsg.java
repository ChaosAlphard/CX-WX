package com.cx.wx.model.wxsend;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class RemindMsg {
    private Val thing1;
    private Val date2;

    public Val getThing1() {
        return thing1;
    }

    public RemindMsg setThing1(Val thing1) {
        this.thing1 = thing1;
        return this;
    }

    public Val getDate2() {
        return date2;
    }

    public RemindMsg setDate2(Val date2) {
        this.date2 = date2;
        return this;
    }
}
