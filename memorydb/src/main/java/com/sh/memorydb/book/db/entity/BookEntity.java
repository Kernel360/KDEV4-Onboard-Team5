package com.sh.memorydb.book.db.entity;

import com.sh.memorydb.entity.Entity;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookEntity extends Entity {
    private String title;
    private String category;
    private BigDecimal amount;
}
