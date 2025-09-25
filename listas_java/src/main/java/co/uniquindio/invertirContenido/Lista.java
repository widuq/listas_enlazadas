package co.uniquindio.invertirContenido;

public class Lista <T>{
    Node<T> nodo;
    public void insertar(T dato) {
        Node<T> nuevo = new Node<>(dato);
        if (nodo == null) {
            nodo = nuevo;
        } else {
            Node<T> temp = nodo;
            while (((Node<T>) temp).siguiente != null) {
                temp = ((Node<T>) temp).siguiente;
            }
            temp.siguiente = nuevo;
        }
    }
    public Node<T> invertir(Node<T> actual, Node<T> anterior) {
        if (actual == null) {
            return anterior;
        }
        Node<T> siguiente= actual.siguiente;
        actual.siguiente = anterior;
        return invertir(actual.siguiente, anterior);
    }
    public void invertir (){
        if(nodo == null || nodo.siguiente == null) {
            return;
        }
        nodo = invertir(nodo, null);
    }
    public void imprimir() {
        if (nodo == null) {
            System.out.println("La lista está vacía");
            return;
        }
        Node<T> actual = nodo;
        while (actual != null) {
            System.out.print(actual.dato);
            if (actual.siguiente != null) {
                System.out.print(" -> ");
            }
            actual = actual.siguiente;
        }
        System.out.println();
    }
    public Lista<T> invertirNueva() {
        Lista<T> invertida = new Lista<>();
        invertirRecursivoNueva(this.nodo, invertida);
        return invertida;
    }

    // Método recursivo auxiliar
    private void invertirRecursivoNueva(Node<T> actual, Lista<T> invertida) {
        if (actual == null) return;
        invertirRecursivoNueva(actual.siguiente, invertida);
        invertida.insertar(actual.dato); // inserta en la nueva lista durante la "vuelta"
    }

}
