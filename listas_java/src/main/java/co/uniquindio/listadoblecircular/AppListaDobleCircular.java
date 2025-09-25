package co.uniquindio.listadoblecircular;

public class AppListaDobleCircular {
    public static void main(String[] args) {
        ListaDobleCircular<Integer> lista = new ListaDobleCircular<>();

        // Agregar elementos
        lista.agregarInicio(10);
        lista.agregarInicio(5);
        lista.agregarFinal(20);
        lista.agregarEn(15, 2);

        System.out.println("Lista después de agregar elementos:");
        lista.imprimir();

        // Obtener y mostrar elemento en índice 2
        System.out.println("Elemento en índice 2: " + lista.obtener(2));

        // Modificar elemento en índice 1
        lista.modificar(1, 12);
        System.out.println("Lista después de modificar índice 1 a 12:");
        lista.imprimir();

        // Eliminar primero
        lista.eliminarInicio();
        System.out.println("Lista después de eliminar el primero:");
        lista.imprimir();

        // Eliminar último
        lista.eliminarFinal();
        System.out.println("Lista después de eliminar el último:");
        lista.imprimir();

        // Eliminar en posición 1
        lista.eliminarEn(1);
        System.out.println("Lista después de eliminar índice 1:");
        lista.imprimir();

        // Imprimir tamaño actual
        System.out.println("Tamaño actual de la lista: " + lista.size());

        // Probar iterador
        System.out.println("Iterando sobre la lista:");
        for (Integer val : lista) {
            System.out.println(val);
        }

        // Borrar lista
        lista.borrarLista();
        System.out.println("Lista después de borrar:");
        lista.imprimir();
    }
}

