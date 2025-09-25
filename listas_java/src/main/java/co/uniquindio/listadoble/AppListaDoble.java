package co.uniquindio.listadoble;

public class AppListaDoble {
    public static void main(String[] args) {
        ListaDoble<Integer> lista = new ListaDoble<>();

        // 1. AgregarInicio
        lista.agregarInicio(10);
        lista.agregarInicio(5);

        // 2. AgregarFinal
        lista.agregarFinal(20);

        // 3. AgregarEn (índice 2)
        lista.agregarEn(15, 2);

        System.out.println("Lista después de agregar elementos:");
        lista.imprimir();

        // 4. Obtener (índice 2)
        System.out.println("Elemento en índice 2: " + lista.obtener(2));

        // 5. ObtenerNodo (índice 1)
        System.out.println("Nodo en índice 1: " + lista.obtenerNodo(1).getDato());

        // 6. ObtenerPosicionNodo (dato 15)
        System.out.println("Posición del dato 15: " + lista.obtenerPosicionNodo(15));

        // 7. Modificar (índice 1 a 12)
        lista.modificar(1, 12);
        System.out.println("Lista después de modificar índice 1 a 12:");
        lista.imprimir();

        // 8. EliminarInicio
        lista.eliminarInicio();
        System.out.println("Lista después de eliminar el primero:");
        lista.imprimir();

        // 9. EliminarFinal
        lista.eliminarFinal();
        System.out.println("Lista después de eliminar el último:");
        lista.imprimir();

        // 10. EliminarEn (índice 1)
        lista.eliminarEn(1);
        System.out.println("Lista después de eliminar índice 1:");
        lista.imprimir();

        // 11. Size (tamaño)
        System.out.println("Tamaño actual de la lista: " + lista.size());

        // 12. EstaVacia
        System.out.println("¿Lista vacía?: " + lista.estaVacia());

        // 13. IndiceValido (comprobar índice 0 y 5)
        System.out.println("Índice 0 válido? " + lista.indiceValido(0));  // true o false
        System.out.println("Índice 5 válido? " + lista.indiceValido(5));  // false

        // 14. BorrarLista
        lista.borrarLista();
        System.out.println("Lista después de borrar:");
        lista.imprimir();
        System.out.println("¿Lista vacía?: " + lista.estaVacia());

        // 15. OrdenarLista (agrego valores desordenados primero)
        lista.agregarFinal(50);
        lista.agregarFinal(10);
        lista.agregarFinal(30);
        lista.agregarFinal(20);
        lista.agregarFinal(40);

        System.out.println("Lista desordenada:");
        lista.imprimir();

        lista.ordenarLista();

        System.out.println("Lista ordenada:");
        lista.imprimir();

        // 16. Iterador (recorrer lista)
        System.out.println("Iterando sobre la lista con for-each:");
        for (Integer val : lista) {
            System.out.println(val);
        }

        // 17. toString
        System.out.println("toString(): " + lista.toString());

        System.out.println(lista.obtenerNodo(0).getAnterior());
    }
}
