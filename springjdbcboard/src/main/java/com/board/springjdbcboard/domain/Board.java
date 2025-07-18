package com.board.springjdbcboard.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Board {
    private int boardNo;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
}