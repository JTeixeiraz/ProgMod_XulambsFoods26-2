import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PizzaTest {

    Pizza pizza;
    int ingredientesPadrao;

    @BeforeEach 
    public void setUp(){
        ingredientesPadrao = 4;
        pizza = new Pizza(ingredientesPadrao);
    }


    @Test
    public void adicionaIngredientesCorretamente(){
        //Act
        int quantos = 
            pizza.adicionarIngredientes(4);

        //Assert
        assertEquals(8, quantos);
    }

    @Test
    public void naoAdicionarIngredientesNegativos(){
        //Act
        int quantos = 
            pizza.adicionarIngredientes(-5);

        //Assert
        assertEquals(4, quantos);
    }

    @Test
    public void naoAdicionarIngredientesEmExcesso(){
        //Act
        int quantos = 
            pizza.adicionarIngredientes(7);

        //Assert
        assertEquals(4, quantos);
    }

    @Test
    public void calcularValorDaPizzaComAdicionais(){
        //Act
        double valor = 
            pizza.valorFinal();

        //Assert
        assertEquals(49, valor, 0.01);
    }
    
    @Test
    public void calcularValorDaPizzaSemAdicionais(){
        //Arrange
        Pizza pizzaVazia = new Pizza();
        
        //Act
        double valor = 
            pizzaVazia.valorFinal();

        //Assert
        assertEquals(29, valor, 0.01);
    }

    @Test 
    public void cupomContemDetalhamento(){
        //Act
        String cupom = pizza.gerarCupom();

        //assert
        assertTrue(
            cupom.contains("4 ingredientes") &&
            cupom.contains("29,00") &&
            cupom.contains("20,00") &&
            cupom.contains("49,00")
        );
    }
}
