package com.multi.oompadataarticle.domain.article.ctr;

import com.multi.oompadataarticle.domain.article.model.ArticleReqDto;
import com.multi.oompadataarticle.domain.article.service.ArticleService;
import com.multi.oompaglobal.res.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping
    public ResponseDto<Long> create(@RequestBody ArticleReqDto reqDto) {

        Long articleIdx = articleService.create(reqDto);

        return ResponseDto.success(articleIdx);

    }
}
