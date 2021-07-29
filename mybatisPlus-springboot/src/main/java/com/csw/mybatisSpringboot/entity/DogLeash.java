package com.csw.mybatisSpringboot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@TableName("DogLeash")
public class DogLeash implements Serializable {
    @TableField("id")
    private String id;
    @TableField("color")
    private String color;
    @TableField("variety")
    private String variety;
    @TableField("dogId")
    private String dogId;
    /*多表联查需要*/
    @TableField(exist = false)
    private Dog dog;/*一条狗链对应一条狗*/
}
