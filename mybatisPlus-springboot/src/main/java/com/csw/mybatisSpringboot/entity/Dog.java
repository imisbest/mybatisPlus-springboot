package com.csw.mybatisSpringboot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@TableName("dog")
public class Dog implements Serializable {
    @TableField("id")
    private String id;
    @TableField("name")
    private String name;
    @TableField("age")
    private Integer age;
    /*多表联查需要，一条狗对应多个狗链*/
    @TableField(exist = false)
    private List<DogLeash> DogLeashLists;


}
