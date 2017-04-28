package com.hzzz.application;

import com.hzzz.data.CommodityQuery;
import com.hzzz.model.Category;
import com.hzzz.model.Commodity;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Path("/commodity/{commodityId}")
public class QueryCategories {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> getCategories(@PathParam("commodityId") String commodityId) {
        try {
            return CommodityQuery.queryCommmodityCategory(commodityId);
        } catch (IllegalArgumentException exception) {
            throw new BadRequestException("no such commodity");
        }
    }
}