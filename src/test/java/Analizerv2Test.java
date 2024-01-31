import org.example.AnalizeTools.Analizerv2;
import org.example.Models.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Analizerv2Test {

    private Analizerv2 ib;
    private List<Operation> operations;

    private void prepare(){
        operations = new ArrayList<>();
        operations.add(new ModelDivitev2());
        operations.add(new ModelMultiplyv2());
        operations.add(new ModelPlusv2());
        operations.add(new ModelMinusv2());

        ib = new Analizerv2(operations);
    }

    @Test
    void A_simpleOperation1() {
        prepare();

        String expr = "5.2+3*1.5/0.5";
        double result = Double.parseDouble(ib.analize(expr).get(0));
        double test = 5.2 + 3.0 * 1.5 / 0.5;

        Assertions.assertEquals(result, test);
    }

    @Test
    void A_simpleOperation2() {
        prepare();

        String expr = "10.5/5.0/5.0/5.0";
        double result = Double.parseDouble(ib.analize(expr).get(0));
        double test = 10.5 / 5.0 / 5.0 / 5.0;

        Assertions.assertEquals(result, test);
    }

    @Test
    void A_simpleOperation3() {
        prepare();

        String expr = "10.5*2*2*5";
        double result = Double.parseDouble(ib.analize(expr).get(0));
        double test = 10.5 * 2.0 * 2.0 * 5.0;

        Assertions.assertEquals(result, test);
    }

    @Test
    void A_simpleOperation4() {
        prepare();

        String expr = "10.5+2+2+5";
        double result = Double.parseDouble(ib.analize(expr).get(0));
        double test = 10.5 + 2.0 + 2.0 + 5.0;

        Assertions.assertEquals(result, test);
    }

    @Test
    void A_simpleOperation5() {
        prepare();

        String expr = "10.5+2+2+5";
        double result = Double.parseDouble(ib.analize(expr).get(0));
        double test = 10.5 + 2.0 + 2.0 + 5.0;

        Assertions.assertEquals(result, test);
    }

    @Test
    void A_HardOperation() {
        prepare();

        String expr = "(2+5)*7";
        double result = Double.parseDouble(ib.analize(expr).get(0));
        double test = (2+5)*7;
        Assertions.assertEquals(result, test);

        expr = "7*(2+5)";
        result = Double.parseDouble(ib.analize(expr).get(0));
        Assertions.assertEquals(result, test);
    }

    @Test
    void A_HardOperation1() {
        prepare();

        String expr = "(2+5)*(5+2)*(5/2)";
        double result = Double.parseDouble(ib.analize(expr).get(0));
        double test = (2.0+5.0)*(5.0+2.0)*(5.0/2.0);
        Assertions.assertEquals(result, test);
    }

    @Test
    void A_HardOperation2() {
        prepare();

        String expr = "(2+5*(1+3))+2";
        double result = Double.parseDouble(ib.analize(expr).get(0));
        double test = (2+5*(1+3))+2;
        Assertions.assertEquals(result, test);
    }

    @Test
    void A_HardOperation3() {
        prepare();
        String expr = "((5/2)+(1*(1+1)))+2";
        double result = Double.parseDouble(ib.analize(expr).get(0));
        double test = ((5.0/2.0)+(1.0*(1.0+1.0)))+2.0;
        Assertions.assertEquals(result, test);
    }
}

