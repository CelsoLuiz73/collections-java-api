package main.java.list.operacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> itemList;

    public CarrinhoDeCompras() {
        this.itemList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        Item item = new Item(nome, preco, quantidade);
        this.itemList.add(item);
    }

    public void removerItem(String nome) {
        List<Item> removerItem = new ArrayList<>();
        if (!itemList.isEmpty()) {
            for (Item i : itemList) {
                if (i.getNome().equalsIgnoreCase(nome)) {
                    removerItem.add(i);
                }
            }
            itemList.removeAll(removerItem);

        } else {
            System.out.println("A lista está vazia!");
        }
    }

    public int obterNumeroTotalItens() {
        return itemList.size();
    }

    public void obterDescricaoItens() {
        System.out.println(itemList);
    }

    public double calcularValorTotal() {
        double valorTotal = 0d;
        if (!itemList.isEmpty()) {
            for (Item i : itemList) {
                double valorItem = i.getQuantidade() * i.getPreco();
                valorTotal = valorTotal + valorItem;
            }
            return valorTotal;

        } else {
            throw new RuntimeException("A lista está vazia");
        }
    }



    public static void main(String[] args) {
        // Criando uma instância do carrinho de compras
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        // Exibindo os itens no carrinho (antes de adicioná-los)
        System.out.println("Total de iten(s) no carrinho: " + carrinhoDeCompras.obterNumeroTotalItens());

        // Adicionando itens no carrinho
        carrinhoDeCompras.adicionarItem("celular", 900.00, 1);
        carrinhoDeCompras.adicionarItem("TV LED 40", 1900.00, 2);
        carrinhoDeCompras.adicionarItem("Vídeo Game PS5", 3000.00, 3);

        // Exibindo descrição dos itens adicionados no carrinho
        carrinhoDeCompras.obterDescricaoItens();

        // Removendo um item do carrinho
        carrinhoDeCompras.removerItem("celular");

        // Exibindo itens atualizados no carrinho
        System.out.println("Total de iten(s) no carrinho: " + carrinhoDeCompras.obterNumeroTotalItens());

        System.out.println("Valor total: " +carrinhoDeCompras.calcularValorTotal());




    }
}
