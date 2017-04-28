package com.hzzz.application;

import com.google.common.collect.ImmutableSet;
import com.hzzz.model.Category;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Set;
import java.util.stream.Stream;

@Path("/allcategories")
public class ListAllCategories {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Set<String> getAllCategories() {
        return Stream.of(Category.values())
                .map(category -> String.format("category: %s, parent category: %s", category, category.getParentCategory().map(Enum::toString).orElse("")))
                .collect(ImmutableSet.toImmutableSet());
    }
}