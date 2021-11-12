import com.dqdwd.pojo.ProductInfo;
import com.dqdwd.pojo.ProductType;
import com.dqdwd.service.ProductInfoService;
import com.dqdwd.service.ProductTypeService;
import com.dqdwd.service.impl.ProductInfoServiceImpl;
import com.dqdwd.service.impl.ProductTypeServiceImpl;
import org.junit.Test;

import java.util.List;

public class ListenerTest {
    @Test
    public void test(){
        ProductTypeService productTypeService=new ProductTypeServiceImpl();
        List<ProductType> typeAll = productTypeService.getTypeAll();
        for(ProductType type:typeAll){
            System.out.println(type);
        }
    }
    @Test
    public void test1(){
        ProductInfoService productTypeService=new ProductInfoServiceImpl();
        List<ProductInfo> typeAll = productTypeService.getAll();
        for(ProductInfo type:typeAll){
            System.out.println(type);
        }
    }
}
