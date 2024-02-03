import org.example.AnalizeTools.Analizerv2;
import org.example.AnalizeTools.PrepareExpression;
import org.example.Models.*;
import org.example.Models.MathMethod.GammaFunc;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Analizerv2Test {

    private Analizerv2 ib;
    private List<Operation> operations;

    private GammaFunc gamma = new GammaFunc();

    private void prepare(){
        operations = new ArrayList<>();
        operations.add(new ModelFactorial());
        operations.add(new ModelSquare());
        operations.add(new ModelDivitev2());
        operations.add(new ModelMultiplyv2());
        operations.add(new ModelPlusv2());
        operations.add(new ModelMinusv2());

        ib = new Analizerv2(operations);
    }

    @Test
    void A_simpleOperation1() {
        prepare();

        PrepareExpression prepare = new PrepareExpression("5.2+3*1.5/0.5");
        List<String> exArr = prepare.decompose();

        double result = Double.parseDouble(ib.analize(exArr).get(0));
        double test = 5.2 + 3.0 * 1.5 / 0.5;

        Assertions.assertEquals(result, test);
    }

    @Test
    void A_simpleOperation2() {
        prepare();

        PrepareExpression prepare = new PrepareExpression("10.5/5.0/5.0/5.0");
        List<String> exArr = prepare.decompose();

        double result = Double.parseDouble(ib.analize(exArr).get(0));
        double test = 10.5 / 5.0 / 5.0 / 5.0;

        Assertions.assertEquals(result, test);
    }

    @Test
    void A_simpleOperation3() {
        prepare();

        PrepareExpression prepare = new PrepareExpression("5.5/2.1*23.6");
        List<String> exArr = prepare.decompose();

        double result = Double.parseDouble(ib.analize(exArr).get(0));
        double test = 5.5 / 2.1 * 23.6;

        Assertions.assertEquals(result, test);
    }

    @Test
    void A_simpleOperation4() {
        prepare();

        PrepareExpression prepare = new PrepareExpression("10.5*2.1+2+5");
        List<String> exArr = prepare.decompose();

        double result = Double.parseDouble(ib.analize(exArr).get(0));
        double test = 10.5 * 2.1 + 2.0 + 5.0;

        Assertions.assertEquals(result, test);
    }

    @Test
    void A_simpleOperation5() {
        prepare();

        PrepareExpression prepare = new PrepareExpression("10.5+2+2+5");
        List<String> exArr = prepare.decompose();

        double result = Double.parseDouble(ib.analize(exArr).get(0));
        double test = 10.5 + 2.0 + 2.0 + 5.0;

        Assertions.assertEquals(result, test);
    }

    @Test
    void A_simpleOperation6() {
        prepare();

        PrepareExpression prepare = new PrepareExpression("5.5!+2");
        List<String> exArr = prepare.decompose();

        double result = Double.parseDouble(ib.analize(exArr).get(0));
        double test = gamma.gamma(5.5 + 1) + 2.0;

        Assertions.assertEquals(result, test, 0.00001);
    }

    @Test
    void A_simpleOperation7() {
        prepare();

        PrepareExpression prepare = new PrepareExpression("sqrt15.4+0.2!");
        List<String> exArr = prepare.decompose();

        double result = Double.parseDouble(ib.analize(exArr).get(0));
        double test = Math.sqrt(15.4) + gamma.gamma(0.2 + 1.0);

        Assertions.assertEquals(result, test);
    }

    @Test
    void A_HardOperation() {
        prepare();

        PrepareExpression prepare = new PrepareExpression("(2+5)*7");
        List<String> exArr = prepare.decompose();

        double result = Double.parseDouble(ib.analize(exArr).get(0));
        double test = (2+5)*7;
        Assertions.assertEquals(result, test);

        prepare = new PrepareExpression("7*(2+5)");
        exArr = prepare.decompose();

        result = Double.parseDouble(ib.analize(exArr).get(0));
        Assertions.assertEquals(result, test);
    }

    @Test
    void A_HardOperation1() {
        prepare();

        PrepareExpression prepare = new PrepareExpression("(2+5)*(5+2)*(5/2)");
        List<String> exArr = prepare.decompose();

        double result = Double.parseDouble(ib.analize(exArr).get(0));
        double test = (2.0+5.0)*(5.0+2.0)*(5.0/2.0);
        Assertions.assertEquals(result, test);
    }

    @Test
    void A_HardOperation2() {
        prepare();

        PrepareExpression prepare = new PrepareExpression("(2+5*(1+3))+2");
        List<String> exArr = prepare.decompose();

        double result = Double.parseDouble(ib.analize(exArr).get(0));
        double test = (2+5*(1+3))+2;
        Assertions.assertEquals(result, test);
    }

    @Test
    void A_HardOperation3() {
        prepare();

        PrepareExpression prepare = new PrepareExpression("((5/2)+(1*(1+1)))+2");
        List<String> exArr = prepare.decompose();

        double result = Double.parseDouble(ib.analize(exArr).get(0));
        double test = ((5.0/2.0)+(1.0*(1.0+1.0)))+2.0;
        Assertions.assertEquals(result, test);
    }

    @Test
    void A_HardOperation4() {
        prepare();

        PrepareExpression prepare = new PrepareExpression("((5!+2)+(sqrt14*2))+2");
        List<String> exArr = prepare.decompose();

        double result = Double.parseDouble(ib.analize(exArr).get(0));
        double test = ((GammaFunc.gamma(5.0 + 1.0) + 2.0) + (Math.sqrt(14.0) * 2.0)) + 2.0;
        Assertions.assertEquals(result, test);
    }

    @Test
    void A_HardOperation5() {
        prepare();

        PrepareExpression prepare = new PrepareExpression("sqrt((12+2)*1)");
        List<String> exArr = prepare.decompose();

        double result = Double.parseDouble(ib.analize(exArr).get(0));
        double test = Math.sqrt((12+2)*1);
        Assertions.assertEquals(result, test);
    }

    @Test
    void A_HardOperation6() {
        prepare();

        PrepareExpression prepare = new PrepareExpression("((12+2)*1)!");
        List<String> exArr = prepare.decompose();

        double result = Double.parseDouble(ib.analize(exArr).get(0));
        double test =GammaFunc.gamma(((12+2)*1) + 1.0);
        Assertions.assertEquals(result, test);
    }

    @Test
    void A_HardOperation7() {
        prepare();

        PrepareExpression prepare = new PrepareExpression("((5*3)!+sqrt(22*12))!");
        List<String> exArr = prepare.decompose();

        double result = Double.parseDouble(ib.analize(exArr).get(0));
        double test =  GammaFunc.gamma((GammaFunc.gamma((5*3) + 1.0) + Math.sqrt(22*12)) + 1.0);
        Assertions.assertEquals(result, test);
    }
}

