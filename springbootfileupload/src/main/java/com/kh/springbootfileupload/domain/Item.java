package com.kh.springbootfileupload.domain;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private int price;
    private String description;
    private MultipartFile picture; // <input type = "file" />
    private String pictureUrl;
}
