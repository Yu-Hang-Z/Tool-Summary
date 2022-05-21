package zyh.example.demo.mbg.model;

import java.io.Serializable;

public class TSensitiveWordType implements Serializable {
    /**
     * id
     *
     * @mbg.generated
     */
    private Long id;

    private String name;

    private String alias;

    private Integer enable;

    private Integer enabledelete;

    private static final long serialVersionUID = 1L;

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
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", alias=").append(alias);
        sb.append(", enable=").append(enable);
        sb.append(", enabledelete=").append(enabledelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}