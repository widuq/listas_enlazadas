package co.uniquindio.listasimplecircular;

public class AppListaCircular {
    public static void main(String[] args) {
        ListaSimpleCircular<Integer> lista = new ListaSimpleCircular<>();
        lista.agregarInicio(1);
        lista.agregarInicio(8);
        lista.agregarFinal(3);
        lista.agregarEn(99,1);
        lista.agregarFinal(4);
        lista.agregarInicio(5);
        lista.imprimirLista();

        lista.ordenarLista();
        System.out.println();
        lista.imprimirLista();

        System.out.println("valor del nodo 1 es: " + lista.obtenerValorNodo(1));
        System.out.println(lista.toString());
        System.out.println(lista.obtenerValorNodo(0));

        lista.eliminarPrimero();
        System.out.println(lista.toString());

        lista.eliminarUltimo();
        System.out.println(lista.toString());

        lista.eliminarEn(1);
        lista.imprimirLista();

        lista.modificarNodo(1, 7);
        System.out.println(lista.toString());

        ListaSimpleCircular<String> lista2 = new ListaSimpleCircular<>();
        lista2.agregarFinal("a");
        Nodo<String> nodoA = lista2.obtenerNodo(0); // Obtener nodo
        System.out.println("Valor del nodo A es: " + nodoA.getDato());

        lista2.agregarFinal("b");
        lista2.agregarFinal("c");
        System.out.println(lista2.toString());
        System.out.println(lista2.obtenerPosicionNodo("f"));
    }
}
