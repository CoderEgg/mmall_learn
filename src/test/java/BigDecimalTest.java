import org.junit.Test;

import java.math.BigDecimal;

public class BigDecimalTest {

    @Test
    public void test1(){
        /*
            数据精度丢失演示
            利用BigDecimal解决
         */
        System.out.println(0.05+0.01);
        System.out.println(1.0-0.42);
        System.out.println(4.143*100);
        System.out.println(123.3/100);
    }
    @Test
    public void test2(){
        //还是会丢失精度
        BigDecimal b1 = new BigDecimal(0.05);
        BigDecimal b2 = new BigDecimal(0.01);
        System.out.println(b1.add(b2));
    }
    @Test
    public void test3(){
        /*
            利用String构造器不会丢失精度
         */
        BigDecimal b1 = new BigDecimal("0.05");
        BigDecimal b2 = new BigDecimal("0.01");
        System.out.println(b1.add(b2));
    }
}
