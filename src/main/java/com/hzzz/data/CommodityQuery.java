package com.hzzz.data;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.hzzz.model.Category;
import com.hzzz.model.Commodity;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Created by hzzzxc on 2017/4/27.
 */
public class CommodityQuery {

    private static Set<Category> queryMinCategories(Optional<Category> parentCategory) {
        Set<Category> allCategories = ImmutableSet.copyOf(Category.values());
        if (!parentCategory.isPresent()) {
            return allCategories;
        }
        Set<Category> subCategories = allCategories.stream()
                .filter(category -> category.getParentCategory().orElse(null) == parentCategory.get())
                .collect(ImmutableSet.toImmutableSet());
        if (subCategories.isEmpty()) {
            return ImmutableSet.of(parentCategory.get());
        } else {
            return subCategories.stream()
                    .map(category -> queryMinCategories(Optional.of(category)))
                    .reduce((categories, categories2) -> ImmutableSet.<Category>builder().addAll(categories).addAll(categories2).build())
                    .orElseThrow(() -> new IllegalArgumentException("query error"));
        }
    }

    public static List<Commodity> queryByCategory(Category category) {
        Set<Category> minCategories = queryMinCategories(Optional.of(category));
        return FakeData.fakeCommodities.stream()
                .filter(commodity -> minCategories.contains(commodity.getCategory()))
                .collect(ImmutableList.toImmutableList());
    }

    public static List<Category> queryCommmodityCategory(String commodityId) {
        Commodity commodity = findById(commodityId);
        ImmutableList.Builder<Category> categoryBuilder = ImmutableList.builder();
        Category category = commodity.getCategory();
        while(category.getParentCategory().isPresent()) {
            categoryBuilder.add(category);
            category = category.getParentCategory().get();
        }
        categoryBuilder.add(category);
        return categoryBuilder.build().reverse();
    }


    public static Commodity findById(String id) {
        List<Commodity> commodities = FakeData.fakeCommodities.stream()
                .filter(commodity -> commodity.getId().equals(id))
                .collect(ImmutableList.toImmutableList());
        checkArgument(!commodities.isEmpty(), "can not find the commodity, id:", id);
        return Iterables.getOnlyElement(commodities);
    }
}
