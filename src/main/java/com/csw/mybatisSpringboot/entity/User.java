package com.csw.mybatisSpringboot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@TableName("t_user")
public class User {
    @TableField("user_id")
    private String userId;
    @TableField("username")
    private String username;
    @TableField("pass_word")
    private String passWord;
}
