package co.uniquindio.listasimplecircular;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaSimpleCircular<T extends Comparable<T>> implements Iterable<T> {

    private Nodo<T> firstNode;
    private int size;

    public ListaSimpleCircular() {
        this.firstNode = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Nodo<T> actual = firstNode;
        for (int i = 0; i < index; i++) {
            actual = actual.getSiguiente();
        }
        return actual.getDato();
    }

    public void agregarFinal(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);

        if (size == 0) {
            firstNode = nuevoNodo;
            nuevoNodo.setSiguiente(firstNode);
        } else {
            Nodo<T> actual = firstNode;
            while (actual.getSiguiente() != firstNode) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
            nuevoNodo.setSiguiente(firstNode);
        }

        size++;
    }

    public void agregarInicio(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);

        if (size == 0) {
            firstNode = nuevoNodo;
            nuevoNodo.setSiguiente(firstNode);
        } else {
            Nodo<T> actual = firstNode;
            while (actual.getSiguiente() != firstNode) {
                actual = actual.getSiguiente();
            }
            nuevoNodo.setSiguiente(firstNode);
            actual.setSiguiente(nuevoNodo);
            firstNode = nuevoNodo;
        }

        size++;
    }

    public void agregarEn(T dato, int indice) {
        if (indice < 0 || indice > size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
        }

        if (indice == 0) {
            agregarInicio(dato);
            return;
        }

        if (indice == size) {
            agregarFinal(dato);
            return;
        }

        Nodo<T> actual = firstNode;
        for (int i = 0; i < indice - 1; i++) {
            actual = actual.getSiguiente();
        }

        Nodo<T> nuevoNodo = new Nodo<>(dato);
        nuevoNodo.setSiguiente(actual.getSiguiente());
        actual.setSiguiente(nuevoNodo);

        size++;
    }

    public T eliminarPrimero() {
        if (size == 0) {
            throw new NoSuchElementException("La lista está vacía");
        }

        T dato = firstNode.getDato();

        if (size == 1) {
            firstNode = null;
        } else {
            Nodo<T> ultimo = firstNode;
            while (ultimo.getSiguiente() != firstNode) {
                ultimo = ultimo.getSiguiente();
            }
            firstNode = firstNode.getSiguiente();
            ultimo.setSiguiente(firstNode);
        }

        size--;
        return dato;
    }

    public T eliminarUltimo() {
        if (size == 0) {
            throw new NoSuchElementException("La lista está vacía");
        }

        if (size == 1) {
            return eliminarPrimero();
        }

        Nodo<T> actual = firstNode;
        while (actual.getSiguiente().getSiguiente() != firstNode) {
            actual = actual.getSiguiente();
        }

        T dato = actual.getSiguiente().getDato();
        actual.setSiguiente(firstNode);
        size--;

        return dato;
    }

    public T eliminarEn(int indice) {
        if (indice < 0 || indice >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
        }

        if (indice == 0) {
            return eliminarPrimero();
        }

        Nodo<T> actual = firstNode;
        for (int i = 0; i < indice - 1; i++) {
            actual = actual.getSiguiente();
        }

        T dato = actual.getSiguiente().getDato();
        actual.setSiguiente(actual.getSiguiente().getSiguiente());
        size--;

        return dato;
    }

    public T obtenerValorNodo(int indice) {
        if (!indiceValido(indice)) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
        }

        Nodo<T> actual = firstNode;
        for (int i = 0; i < indice; i++) {
            actual = actual.getSiguiente();
        }

        return actual.getDato();
    }

    public Nodo<T> obtenerNodo(int index) {
        if (!indiceValido(index)) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        Nodo<T> actual = firstNode;
        for (int i = 0; i < index; i++) {
            actual = actual.getSiguiente();
        }
        return actual;
    }

    public int obtenerPosicionNodo(T dato) {
        Nodo<T> actual = firstNode;
        int posicion = 0;

        if (size == 0) return -1;

        do {
            if (actual.getDato().equals(dato)) {
                return posicion;
            }
            actual = actual.getSiguiente();
            posicion++;
        } while (actual != firstNode);

        return -1;
    }

    public boolean indiceValido(int indice) {
        return indice >= 0 && indice < size;
    }

    public void modificarNodo(int posicion, T nuevoDato) {
        if (!indiceValido(posicion)) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        Nodo<T> actual = firstNode;
        for (int i = 0; i < posicion; i++) {
            actual = actual.getSiguiente();
        }

        actual.setDato(nuevoDato);
    }

    public void borrarLista() {
        firstNode = null;
        size = 0;
    }

    public void ordenarLista() {
        if (firstNode == null || firstNode.getSiguiente() == firstNode) {
            return;
        }

        boolean cambiado;
        do {
            cambiado = false;
            Nodo<T> actual = firstNode;

            for (int i = 0; i < size - 1; i++) {
                Nodo<T> siguiente = actual.getSiguiente();

                if (actual.getDato().compareTo(siguiente.getDato()) > 0) {
                    T temp = actual.getDato();
                    actual.setDato(siguiente.getDato());
                    siguiente.setDato(temp);
                    cambiado = true;
                }

                actual = actual.getSiguiente();
            }
        } while (cambiado);
    }

    public void imprimirLista() {
        if (size == 0) {
            System.out.println("Lista vacía");
            return;
        }

        Nodo<T> actual = firstNode;
        do {
            System.out.print(actual.getDato() + " -> ");
            actual = actual.getSiguiente();
        } while (actual != firstNode);

        System.out.println("(vuelve al inicio)");
    }

    public boolean estaVacia() {
        return size == 0;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Nodo<T> actual = firstNode;
            private int contador = 0;

            @Override
            public boolean hasNext() {
                return contador < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                T dato = actual.getDato();
                actual = actual.getSiguiente();
                contador++;
                return dato;
            }
        };
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";

        StringBuilder sb = new StringBuilder("[");
        Nodo<T> actual = firstNode;

        for (int i = 0; i < size; i++) {
            sb.append(actual.getDato());
            if (i < size - 1) {
                sb.append(", ");
            }
            actual = actual.getSiguiente();
        }

        sb.append("]");
        return sb.toString();
    }
}
