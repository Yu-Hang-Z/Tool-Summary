package zyh.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void pageUtilTest(){
        List<User> users = structuralData();
        List<User> filterUsers = PageUtil.getPageSizeDataForRelations(users,10,11);
        filterUsers.forEach(System.out::println);
    }

    private List<User> structuralData(){
        List<User> userList = new ArrayList<>();
        for (int i = 0; i <= 100; i++){
            userList.add(new User(i,"用户" + i));
        }
        return userList;
    }

}
