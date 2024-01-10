package com.ecommercebe.project.Entity.Request;

import lombok.Data;
import java.util.List;

@Data
public class ProductSearchQuery {
 private String value;
 private List<Long> idList;
}
