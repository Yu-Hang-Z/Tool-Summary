package zyh.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author by zhangyuhang
 * @Classname User
 * @Description TODO
 * @Date 2022/5/21 23:24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;

    private String name;
}
