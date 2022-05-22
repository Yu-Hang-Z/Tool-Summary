package com.example.zyh.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author baomidou
 * @since 2022-05-22
 */
@TableName("t_sensitive_word_type")
@ApiModel(value = "SensitiveWordType对象", description = "")
public class SensitiveWordType implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("别名")
    private String alias;

    @ApiModelProperty("是否启用")
    private Integer enable;

    private Integer enabledelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }
    public Integer getEnabledelete() {
        return enabledelete;
    }

    public void setEnabledelete(Integer enabledelete) {
        this.enabledelete = enabledelete;
    }

    @Override
    public String toString() {
        return "SensitiveWordType{" +
            "id=" + id +
            ", name=" + name +
            ", alias=" + alias +
            ", enable=" + enable +
            ", enabledelete=" + enabledelete +
        "}";
    }
}
