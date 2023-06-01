package com.kreitek.demo.infrastructura.specs;


import com.kreitek.demo.domain.entity.Item;
import com.kreitek.demo.infrastructura.specs.shared.EntitySpecification;
import com.kreitek.demo.infrastructura.specs.shared.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;
import java.util.List;

public class ItemSpecification extends EntitySpecification<Item> implements Specification<Item> {


    public ItemSpecification(List<SearchCriteria> criteria) {
        this.criteria = criteria;
    }



}