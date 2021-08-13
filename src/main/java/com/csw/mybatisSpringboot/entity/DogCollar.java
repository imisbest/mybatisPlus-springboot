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
@TableName("DogCollar")
public class DogCollar implements Serializable {/*狗项圈表，和狗链表是多对多的关系*/
    @TableField("id")
    private String id;
    @TableField("modle")
    private String model;
    /*多表联查需要，一个狗圈对应多个狗链*/
    @TableField(exist = false)
    private List<DogLeash> dogLeashLists;
}
