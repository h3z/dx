package com.hzzz.model;

import com.google.common.base.Strings;

import javax.annotation.Nullable;

import java.util.Optional;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.Objects.requireNonNull;

/**
 * Created by hzzzxc on 2017/4/27.
 */
public class Commodity {
    private final String id;
    private final String name;
    private final String description;
    private final Category category;

    public Commodity(String id, String name, Category category, @Nullable String description) {
        checkArgument(!Strings.isNullOrEmpty(id), "id is null or empty");
        checkArgument(!Strings.isNullOrEmpty(name), "name is null or empty");
        this.id = id;
        this.name = name;
        this.category = requireNonNull(category, "category is null");
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }
}
