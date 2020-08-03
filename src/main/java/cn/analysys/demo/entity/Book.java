package cn.analysys.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data@AllArgsConstructor@NoArgsConstructor
public class Book implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer bookId;
    private String bookName;
    private Integer bookCounts;
    private String detail;

}
