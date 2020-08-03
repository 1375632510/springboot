package cn.analysys.demo.controller;

import cn.analysys.demo.entity.Book;
import cn.analysys.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class BookController {

    @Autowired
    private IBookService iBookService;

    @RequestMapping("/allBook/{pagenum}")
    public String getBook(@PathVariable("pagenum")int pagenum, Model model){
        List<Book> books = iBookService.selectPage(pagenum);
        model.addAttribute("books",books);
        return "allbook";
    }



    @RequestMapping("/updatebook")
    public String updateBook(Book book){
        System.out.println(book);
        System.out.println(iBookService.update(book));
        return "redirect:/allBook/1";
    }

    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id")int id){
        iBookService.deleteById(id);
        return "redirect:/allBook/1";
    }

    @RequestMapping("/insertbook")
    public String insertBook(Book book){
        iBookService.insret(book);
        return "redirect:/allBook/1";
    }

    @RequestMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id")int id,Model model){
        Book book = iBookService.selectById(id);
        model.addAttribute("book",book);
        return "updatebook";
    }

    @RequestMapping("/toAdd")
    public String toADD(){
        return "addbook";
    }
}
