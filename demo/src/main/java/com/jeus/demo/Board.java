package com.jeus.demo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// lombok annotation
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "content")
// @EqualsAndHashCode(of = {"boardNo","title"})
@Data
public class Board {
    // 맴버 변수
    private int boardNo;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
}
