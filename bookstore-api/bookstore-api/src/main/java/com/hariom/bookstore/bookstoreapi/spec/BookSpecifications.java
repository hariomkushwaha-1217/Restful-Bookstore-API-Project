package com.hariom.bookstore.bookstoreapi.spec;

import org.springframework.data.jpa.domain.Specification;
import com.hariom.bookstore.bookstoreapi.model.Book;
import jakarta.persistence.criteria.JoinType;
import java.math.BigDecimal;
import java.time.LocalDate;

public class BookSpecifications {
    public static Specification<Book> titleContains(String text) {
        return (root, query, cb) -> text == null ? null : cb.like(cb.lower(root.get("title")), "%" + text.toLowerCase() + "%");
    }
    public static Specification<Book> authorNameEquals(String name) {
        return (root, query, cb) -> {
            if (name == null) return null;
            var join = root.join("author", JoinType.LEFT);
            return cb.equal(cb.lower(join.get("name")), name.toLowerCase());
        };
    }
    public static Specification<Book> priceBetween(BigDecimal min, BigDecimal max) {
        return (root, query, cb) -> {
            if (min == null && max == null) return null;
            if (min != null && max != null) return cb.between(root.get("price"), min, max);
            if (min != null) return cb.greaterThanOrEqualTo(root.get("price"), min);
            return cb.lessThanOrEqualTo(root.get("price"), max);
        };
    }
    public static Specification<Book> publishedBetween(LocalDate after, LocalDate before) {
        return (root, query, cb) -> {
            if (after == null && before == null) return null;
            if (after != null && before != null) return cb.between(root.get("publishedDate"), after, before);
            if (after != null) return cb.greaterThanOrEqualTo(root.get("publishedDate"), after);
            return cb.lessThanOrEqualTo(root.get("publishedDate"), before);
        };
    }
}
