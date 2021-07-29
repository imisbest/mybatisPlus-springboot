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
@TableName("CollarLeash")
public class CollarLeash implements Serializable {
    @TableField("id")
    private String id;
    @TableField("cid")
    private String cid;
    @TableField("lid")
    private String lid;
}
