package co.uniquindio.invertirContenido;

public class Main {
    public static void main(String[] args) {
        Lista<Integer> lista = new Lista<>();

        lista.insertar(10);
        lista.insertar(20);
        lista.insertar(30);
        lista.insertar(40);

        System.out.println("Lista original:");
        lista.imprimir();

        Lista<Integer> invertida = lista.invertirNueva();

        System.out.println("Lista invertida (nueva lista):");
        invertida.imprimir();
    }

}