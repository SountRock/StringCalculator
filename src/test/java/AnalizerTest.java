import org.example.AnalizeTools.Analizer;
import org.example.AnalizeTools.Analizer1;
import org.example.Models.ModelDivite;
import org.example.Models.ModelMultiply;
import org.example.Models.ModelOperation;
import org.example.Models.ModelPlus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AnalizerTest {

    private Analizer ib;
    private Analizer1 ib1;
    private List<ModelOperation> operations;

    private void prepare(){
        operations = new ArrayList<>();
        operations.add(new ModelDivite());
        operations.add(new ModelMultiply());
        operations.add(new ModelPlus());

        ib = new Analizer(operations);
    }

    private void prepare1(){
        operations = new ArrayList<>();
        operations.add(new ModelDivite());
        operations.add(new ModelMultiply());
        operations.add(new ModelPlus());

        ib1 = new Analizer1(operations);
    }

    @Test
    void A_simpleOperation(){
        prepare();

        String expr = "5.2*7/2+2/5";
        double result = Double.parseDouble(ib.analize(expr).get(0));
        double test = 5.2*7.0/2.0+2.0/5.0;

        Assertions.assertEquals(result, test);
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

        String expr = "10.5/5/5/5";
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

        String expr = "10.5*2+2+5";
        double result = Double.parseDouble(ib.analize(expr).get(0));
        double test = 10.5 * 2.0 + 2.0 + 5.0;

        Assertions.assertEquals(result, test);
    }

    @Test
    void A1_simpleOperation(){
        prepare1();

        String expr = "5.2*7/2+2/5";
        double result = Double.parseDouble(ib1.analize(expr).get(0));
        double test = 5.2*7.0/2.0+2.0/5.0;

        Assertions.assertEquals(result, test);
    }

    ////////////////////////////////////////////////////////////////////////////
    @Test
    void A1_simpleOperation1() {
        prepare1();

        String expr = "5.2+3*1.5/0.5";
        double result = Double.parseDouble(ib1.analize(expr).get(0));
        double test = 5.2 + 3.0 * 1.5 / 0.5;

        Assertions.assertEquals(result, test);
    }

    @Test
    void A1_simpleOperation2() {
        prepare1();

        String expr = "10.5/5.0/5.0/5.0";
        double result = Double.parseDouble(ib1.analize(expr).get(0));
        double test = 10.5 / 5.0 / 5.0 / 5.0;

        Assertions.assertEquals(result, test);
    }

    @Test
    void A1_simpleOperation3() {
        prepare1();

        String expr = "10.5*2*2*5";
        double result = Double.parseDouble(ib1.analize(expr).get(0));
        double test = 10.5 * 2.0 * 2.0 * 5.0;

        Assertions.assertEquals(result, test);
    }

    @Test
    void A1_simpleOperation4() {
        prepare1();

        String expr = "10.5+2+2+5";
        double result = Double.parseDouble(ib1.analize(expr).get(0));
        double test = 10.5 + 2.0 + 2.0 + 5.0;

        Assertions.assertEquals(result, test);
    }

    @Test
    void A1_simpleOperation5() {
        prepare1();

        String expr = "10.5*2+2+5";
        double result = Double.parseDouble(ib1.analize(expr).get(0));
        double test = 10.5 * 2.0 + 2.0 + 5.0;

        Assertions.assertEquals(result, test);
    }
    ////////////////////////////////////////////////////////////////////////////

    @Test
    void A1_HardOperation() {
        prepare1();
        String expr = "(2+5)*7";
        System.out.println(ib1.analize(expr));
        System.out.println("Over");

    }
}
