package cn.analysys.demo;

import cn.analysys.demo.bookdao.BookMapper;
import cn.analysys.demo.entity.Book;
import cn.analysys.demo.entity.User;
import cn.analysys.demo.service.IBookService;
import cn.analysys.demo.service.IUserService;
import cn.analysys.demo.userdao.UserMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.sql.SQLException;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Autowired
    BookMapper bookMapper;

    @Autowired
    IUserService iUserService;

    @Autowired
    IBookService iBookService;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void set() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    void contextLoads() throws SQLException {
//        for (int i = 0; i < 500; i++) {
//            Book book = new Book();
//            book.setBookCounts((int) (Math.random()*200)+1);
//            if(i%2==0)
//                book.setBookName("JAVA"+ UUID.randomUUID().toString().substring(0,2));
//            else
//                book.setBookName("Python"+ UUID.randomUUID().toString().substring(0,2));
//            book.setDetail("Good"+ UUID.randomUUID().toString().substring(0,5));
//            //book.setDeleted(0);
//            iBookService.insret(book);
//        }
//        Book book = new Book();
//        book.setBookId(1);
//        book.setBookName("java");
//        book.setBookCounts(135);
//        book.setDetail("very");
//        iBookService.update(book);
        //iBookService.selectPage(1).forEach(System.out::println);
        Page<Book> page = new Page<>(1, 5);
        bookMapper.selectPage(page,null);
        page.getRecords().forEach(System.out::println);
    }


    @Test
    void test() {
        //userMapper.selectList(null).forEach(System.out::println);
        User admin = userMapper.login("admin", "123456");
        System.out.println(admin);
    }
}
