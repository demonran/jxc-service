package com.demonran.portal.jxc.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author 01182799
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pagination<T> {
    private Integer totalPages;
    private Integer totalSize;
    private Integer currentPage;
    private Integer pageSize;
    /**
     * 业务对象
     */
    private List<T> content;

    public static Pagination of(Page page) {
        return Pagination.builder()
                .totalPages(page.getTotalPages())
                .totalSize((int)page.getTotalElements())
                .currentPage(page.getNumber())
                .pageSize(page.getSize())
                .content(page.getContent())
                .build();

    }

}
