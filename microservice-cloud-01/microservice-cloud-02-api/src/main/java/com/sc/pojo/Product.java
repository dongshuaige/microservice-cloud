package com.sc.pojo;


import lombok.*;

import java.io.Serializable;

/**
 * @author java
 * @create 2019-07-22 18:02
 * @desc 商品实体类
 * @ClassName
 **/

@Data //get set tostring...
@NoArgsConstructor//无参构造函数
@AllArgsConstructor//有参构造函数
public class Product implements Serializable {
    private  Long	pid;	//主键
    private  String	productName;	//产品名称
    // 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
    private  String	dbSource;
    
}
