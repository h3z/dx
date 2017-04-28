package com.hzzz.application;

import com.hzzz.data.CommodityQuery;
import com.hzzz.model.Category;
import com.hzzz.model.Commodity;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/category/{category}")
public class QueryCommodities {

    @GET
	@Produces(MediaType.APPLICATION_JSON)
    public List<Commodity> getCommodities(@PathParam("category") String category) {
		try {
			Category categoryEnum = Category.valueOf(category);
			return CommodityQuery.queryByCategory(categoryEnum);
		} catch (IllegalArgumentException exception) {
			throw new BadRequestException("no such category");
		}
	}
}