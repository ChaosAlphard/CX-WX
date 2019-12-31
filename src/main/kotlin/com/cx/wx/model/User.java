package com.cx.wx.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Accessors(chain = true)
public class User {
    private String openid;
    private String name;
    private String avatar;
    private String formid;
    private String unionid;
}
