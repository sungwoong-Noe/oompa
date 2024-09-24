package com.multi.oompadataarticle.domain.article.ctr;

import com.multi.oompadataarticle.domain.article.model.ArticleReqDto;
import com.multi.oompadataarticle.domain.article.service.ArticleService;
import com.multi.oompaglobal.res.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping("/article")
    public ResponseDto<Long> create(@RequestBody ArticleReqDto reqDto) {

        Long articleIdx = articleService.create(reqDto);

        return ResponseDto.success(articleIdx);

    }
}
