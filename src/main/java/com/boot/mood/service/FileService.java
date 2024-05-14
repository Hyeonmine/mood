package com.boot.mood.service;




import com.boot.mood.entity.FileEntity;
import com.boot.mood.repository.FileRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class FileService {

    @Value("${fileLocation}")
    private String fileLocation;
    private final FileRepository fileRepository;

    public Long saveFile(MultipartFile files) throws IOException {
        if(files.isEmpty()){
            return null;
        }
        // 원래 파일 이름 추출
        String fileOrigin = files.getOriginalFilename();

        // 파일 이름으로 쓸 uuid 생성
        String uuid = UUID.randomUUID().toString();

        // 확장자 추출(ex : .png)
        String extension = fileOrigin.substring(fileOrigin.lastIndexOf("."));

        // uuid와 확장자 결합
        String fileName = uuid + extension;

        // 파일을 불러올 때 사용할 파일 경로
        String fileUrl = fileLocation + fileName;

        // 파일 엔티티 생성
        FileEntity file = FileEntity.builder()
                .fileOrigin(fileOrigin)
                .fileName(fileName)
                .fileUrl(fileUrl)
                .build();

        // 실제로 로컬에 uuid를 파일명으로 저장
        files.transferTo(new File(fileUrl));

        // 데이터베이스에 파일 정보 저장
        FileEntity savedFile = fileRepository.save(file);

        return savedFile.getFno();

    }
 }
