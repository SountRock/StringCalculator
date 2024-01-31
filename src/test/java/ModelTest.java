import org.example.Models.ModelOperation;
import org.example.Models.ModelPower;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ModelTest {
    private ModelOperation model;

    @Test
    void modelPower(){
        model = new ModelPower();

        Assertions.assertTrue(model.isThisOperation("pow"));

        double result = Double.parseDouble(model.operation("4pow3"));
        Assertions.assertEquals(result, 64);

        result = Double.parseDouble(model.operation("5pow2"));
        Assertions.assertEquals(result, 25);

        result = Double.parseDouble(model.operation("3pow9"));
        Assertions.assertEquals(result, 19_683);
    }

    @Test
    void modelPower1(){
        model = new ModelPower();
        double result = Double.parseDouble(model.operation("25pow3"));

        Assertions.assertEquals(result, 15_625);
    }

    @Test
    void modelPower2(){
        model = new ModelPower();
        double result = Double.parseDouble(model.operation("2pow2pow2"));

        Assertions.assertEquals(result, 16);
    }

    @Test
    void modelPower3(){
        model = new ModelPower();
        double result = Double.parseDouble(model.operation("2.5pow5"));

        Assertions.assertEquals(result, 97.65625);
    }

    @Test
    void modelPower4(){
        model = new ModelPower();
        double result = Double.parseDouble(model.operation("2.5pow0.2"));

        double test = Math.pow(2.5,0.2);

        Assertions.assertEquals(result, test,0.001);
    }

    @Test
    void modelPower5(){
        model = new ModelPower();
        double result = Double.parseDouble(model.operation("2.5pow2.2"));

        Assertions.assertEquals(result, 7.507,0.001);
    }

    @Test
    void modelPower6(){
        model = new ModelPower();
        double result = Double.parseDouble(model.operation("2.5pow-2"));

        Assertions.assertEquals(result, 0.16,0.01);
    }

    @Test
    void modelPower7(){
        model = new ModelPower();
        double result = Double.parseDouble(model.operation("10pow-1.4"));

        Assertions.assertEquals(result, 0.0398,0.0001);
    }

}
