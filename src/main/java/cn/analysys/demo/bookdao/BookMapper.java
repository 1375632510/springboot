package cn.analysys.demo.bookdao;

import cn.analysys.demo.entity.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("masterDataSource")
public interface BookMapper extends BaseMapper<Book> {

}
