package com.kh.springbootfileupload.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kh.springbootfileupload.domain.Item;
import com.kh.springbootfileupload.service.ItemMapperService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/item")
@MapperScan(basePackages = "com.kh.springbootfileupload.mapper")
public class ItemController {
    @Autowired
    private ItemMapperService itemService;

    // 저장장소 경로설정
    @Value("${upload.path}")
    private String uploadPath;

    // 자료 리스트 화면 요청
    @GetMapping(value = "/list")
    public String list(Model model) throws Exception {
        List<Item> itemList = itemService.list();
        model.addAttribute("itemList", itemList);
        return "item/list";
    }

    // 자료 입력 화면 요청
    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("item", new Item());
        return "item/register";
    }

    // 자료 입력 내용 저장(파일을 외부 저장소에 저장완료 후 DB 저장)
    @PostMapping("/register")
    public String register(Item item, Model model) throws Exception {
        MultipartFile file = item.getPicture();

        log.info("originalName: " + file.getOriginalFilename());
        log.info("size: " + file.getSize());
        log.info("contentType: " + file.getContentType());

        // uploadFile(String originalName, byte[] fileData) 구조임
        // 업로드된 파일을 외부저장소에 저장하고, 그 저장된 파일명을 리턴함수다.
        // 절대중복되지 않는 파일명_kkk.jpg, _kkk.jpg
        String createdFileName = uploadFile(file.getOriginalFilename(), file.getBytes());
        item.setPictureUrl(createdFileName);
        itemService.create(item);
        model.addAttribute("msg", "등록이 완료되었습니다.");

        return "item/success";
    }

    // 외부 저장소 자료 업로드 파일명 생성 후 저장
    private String uploadFile(String originalName, byte[] fileData) throws Exception {
        UUID uid = UUID.randomUUID();
        String createdFileName = uid.toString() + "_" + originalName;
        File target = new File(uploadPath, createdFileName);
        // 원본파일을 대상파일에 복사해주는 함수
        FileCopyUtils.copy(fileData, target);
        return createdFileName;
    }

    // 수정 내용 화면 요청
    @GetMapping("/modify")
    public String modifyForm(Item item, Model model) throws Exception {
        Item _item = itemService.read(item);
        model.addAttribute("item", _item);
        return "item/modify";
    }

    // 수정내용 저장 요청
    @PostMapping("/modify")
    public String modify(Item item, Model model) throws Exception {
        MultipartFile file = item.getPicture();

        if (file != null && file.getSize() > 0) {
            Item oldItem = itemService.read(item);
            // 기존 외부 저장소 파일 삭제
            String oldPitureUrl = oldItem.getPictureUrl();
            // 파일로 인식되는 객체가 되는 순간.
            deleteFile(oldPitureUrl);

            log.info("originalName: " + file.getOriginalFilename());
            log.info("size: " + file.getSize());
            log.info("contentType: " + file.getContentType());
            String createdFileName = uploadFile(file.getOriginalFilename(), file.getBytes());
            item.setPictureUrl(createdFileName);
        }
        itemService.update(item);
        model.addAttribute("msg", "수정이 완료되었습니다.");
        return "item/success";
    }

    // 삭제 화면 요청
    @GetMapping("/remove")
    public String removeForm(Item item, Model model) throws Exception {
        Item _item = itemService.read(item);
        model.addAttribute("item", _item);
        return "item/remove";
    }

    // 삭제 내용 저장
    @PostMapping("/remove")
    public String remove(Item item, Model model) throws Exception {
        Item oldItem = itemService.read(item);
        String oldPitureUrl = oldItem.getPictureUrl();
        boolean flag = deleteFile(oldPitureUrl);
        if (flag) {
            itemService.delete(item);
            model.addAttribute("msg", "삭제가 완료되었습니다.");
        } else {
            model.addAttribute("msg", "외부저장소 삭제 문제 발생했습니다.");
        }
        return "item/success";
    }

    private boolean deleteFile(String fileName) throws Exception {
        if (fileName.contains("..")) {
            throw new IllegalArgumentException("잘못된 경로 입니다.");
        }
        File file = new File(uploadPath, fileName);

        return (file.exists()) ? (file.delete()) : (false);
    }

    @ResponseBody
    @RequestMapping("/display")
    public ResponseEntity<byte[]> displayFile(Item item) throws Exception {
        InputStream in = null;
        ResponseEntity<byte[]> entity = null;
        Item _item = itemService.getPicture(item);
        String fileName = _item.getPictureUrl();
        log.info("FILE NAME: " + fileName);
        try {
            // uuid_kkk.jpg => "jpg"
            String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
            MediaType mType = getMediaType(formatName);
            HttpHeaders headers = new HttpHeaders();

            in = new FileInputStream(uploadPath + File.separator + fileName);

            if (mType != null) {
                headers.setContentType(mType);
            }

            entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
        } finally {
            in.close();
        }
        return entity;
    }

    // 멀티 미디어 타입을 리턴 "jpg" => MediaType.IMAGE_JPG
    private MediaType getMediaType(String formatName) {
        if (formatName != null) {
            if (formatName.equals("JPG")) {
                return MediaType.IMAGE_JPEG;
            }

            if (formatName.equals("GIF")) {
                return MediaType.IMAGE_GIF;
            }

            if (formatName.equals("PNG")) {
                return MediaType.IMAGE_PNG;
            }
        }

        return null;
    }

}
