package com.example.BaiCuoiMon.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public interface UploadService {
    File save(MultipartFile file, String folder);
}
