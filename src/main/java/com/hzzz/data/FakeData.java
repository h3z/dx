package com.hzzz.data;

import com.google.common.collect.ImmutableList;
import com.hzzz.model.Category;
import com.hzzz.model.Commodity;

import java.util.List;

/**
 * Created by hzzzxc on 2017/4/28.
 */
public class FakeData {
    public static final List<Commodity> fakeCommodities = ImmutableList.of(
            new Commodity("1", "Apple MacBook Air MJVE2LL/A 13-inch Laptop", Category.MACBOOKS, "1.49kg"),
            new Commodity("2", "Apple MacBook Pro", Category.MACBOOKS, "3.3kg"),
            new Commodity("3", "lenovo Air", Category.LENOVO, "10.0mm-15.0mm"),
            new Commodity("4", "DELL 7000 R1605S", Category.DELL, null));
}
