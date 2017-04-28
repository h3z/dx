import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Streams;
import com.hzzz.data.CommodityQuery;
import com.hzzz.data.FakeData;
import com.hzzz.model.Category;
import com.hzzz.model.Commodity;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by hzzzxc on 2017/4/28.
 */
public class QueryTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testQueryCategoryTree() {
        List<Category> categories = CommodityQuery.queryCommmodityCategory("1");
        assertTrue(!categories.isEmpty());
        assertTrue(!categories.get(0).getParentCategory().isPresent());
        for (int i = 1; i < categories.size(); i++) {
            assertTrue(categories.get(i).getParentCategory().get() == categories.get(i - 1));
        }
    }

    @Test
    public void testQueryByMinCategory() {
        List<Commodity> commodities = CommodityQuery.queryByCategory(Category.MACBOOKS);
        assertTrue(commodities.size() == 2);
        commodities.forEach(commodity -> assertTrue(commodity.getCategory() == Category.MACBOOKS));
    }

    @Test
    public void testQueryByParentCategory() {
        List<Commodity> commodities = CommodityQuery.queryByCategory(Category.COMPUTER);
        assertTrue(commodities.size() == 4);
        commodities.forEach(commodity ->
                assertTrue(CommodityQuery.queryCommmodityCategory(commodity.getId()).contains(Category.COMPUTER)));
    }

    @Test
    public void testQueryByRootCategory() {
        List<Commodity> commodities = CommodityQuery.queryByCategory(Category.ELECTRONIC);
        assertTrue(commodities.size() == 4);
        commodities.forEach(commodity ->
                assertTrue(CommodityQuery.queryCommmodityCategory(commodity.getId()).get(0) == Category.ELECTRONIC));
    }

    @Test
    public void testQueryWithNotExistedCommodity() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("can not find the commodity, id: [error id]");
        CommodityQuery.queryCommmodityCategory("error id");
    }
}
