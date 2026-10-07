import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoTest {
    
    Pedido pedido;
    Pizza pizzaVazia;

    @BeforeEach 
    public void setUp(){
        pedido = new Pedido();
        pizzaVazia = new Pizza();
        pedido.adicionarPizza(pizzaVazia);
    }



    @Test 
    public void validarPrecoAPagarCorretamente(){
        double quantidadeDoObj = pizzaVazia.valorFinal();

        double valorDoObjFinal =  pedido.precoAPagar();

        assertEquals(quantidadeDoObj, valorDoObjFinal, 0.1);
    }


    @Test 
    public void validarPrecoAPagarComDuasPizzas(){
        Pizza novaPizza = new Pizza();

        pedido.adicionarPizza(novaPizza);

        double valoresDasPizzas = pizzaVazia.valorFinal() + novaPizza.valorFinal();

        double valorDoPedido = pedido.precoAPagar();

        assertEquals(valoresDasPizzas, valorDoPedido, 0.1);
    }

    @Test 
    public void validarRelatorioComStatusFechado(){
        pedido.fecharPedido();

        String relatorio = pedido.relatorio();


        boolean tem = relatorio.contains("fechado");

        assertEquals(true, tem);
    }


    @Test
    public void naoAdicionaPizzaEmPedidoFechado(){
        //Arrange
        pedido.fecharPedido();

        //Act
        int quantidade = pedido.adicionarPizza(new Pizza());
    
        //Assert
        assertEquals(1, quantidade);
    }

    @Test 
    public void adicionaPizzasEmPedidoAberto(){
        pedido.adicionarPizza(pizzaVazia);
        int quantidade = pedido.adicionarPizza(new Pizza());
        assertEquals(3, quantidade);
    }
}
