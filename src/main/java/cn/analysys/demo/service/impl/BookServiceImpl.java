package cn.analysys.demo.service.impl;

import cn.analysys.demo.bookdao.BookMapper;
import cn.analysys.demo.entity.Book;
import cn.analysys.demo.service.IBookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> selectPage(int pagenum) {
        List<Book> books = bookMapper.selectList(null);
        PageHelper.startPage(pagenum, 5);
        PageInfo pageInfo = new PageInfo(books, 10);
        return pageInfo.getList();
    }

    @Override
    public int deleteById(int id) {
        return bookMapper.deleteById(id);
    }

    @Override
    public int insret(Book book) {
        return bookMapper.insert(book);
    }


    @Override
    @Transactional //设置book书小于0则手动回滚事务
    public int update(Book book) {
        int i = bookMapper.updateById(book);
        try {
            if (book.getBookCounts() < 0) {
                throw new RuntimeException();
            }
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            i = 0;
        }finally {
            return i;
        }
    }

    @Override
    public Book selectById(int id) {
        return bookMapper.selectById(id);
    }
}
