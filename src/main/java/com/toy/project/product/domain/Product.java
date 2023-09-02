package com.toy.project.product.domain;


import com.toy.project.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue
    private long prod_id;//PK

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_num")
    private Member member;//fk

    @Column(name = "prod_name", nullable = false)
    private String prod_name; //상품명

    @Column(name = "kind_num", nullable = false)
    private int kind_num;//상품번호

    @Column(name = "cost", nullable = false)
    private int cost;//원가

    @Column(name = "price", nullable = false)
    private int price;//판매가

    @Column(name = "profit", nullable = false)
    private int profit;//순수익

    @Column(name = "image", nullable = false)
    @ColumnDefault("0")
    private int image = 0;//사진 유무 있으면 1

    @Column(name = "description", nullable = false)
    private String description;//판매내용

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "reg_date")
    private Date reg_date = new Date();

    @Column(name = "status", nullable = false)
    @ColumnDefault("1")
    private int status = 1;//품절 or 상품 내릴시 0
}
