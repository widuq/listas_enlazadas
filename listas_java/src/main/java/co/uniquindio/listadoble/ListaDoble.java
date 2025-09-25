package co.uniquindio.listadoble;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaDoble<T extends Comparable<T>> implements Iterable<T> {

    private NodoDoble<T> primero;
    private NodoDoble<T> ultimo;
    private int size;

    public ListaDoble() {
        primero = null;
        ultimo = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean estaVacia() {
        return size == 0;
    }

    public void agregarInicio(T dato) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(dato);

        if (estaVacia()) {
            primero = ultimo = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(primero);
            primero.setAnterior(nuevoNodo);
            primero = nuevoNodo;
        }
        size++;
    }

    public void agregarFinal(T dato) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(dato);

        if (estaVacia()) {
            primero = ultimo = nuevoNodo;
        } else {
            ultimo.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(ultimo);
            ultimo = nuevoNodo;
        }
        size++;
    }

    public void agregarEn(T dato, int indice) {
        if (!indiceValidoParaAgregar(indice)) {
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

        NodoDoble<T> actual = primero;
        for (int i = 0; i < indice - 1; i++) {
            actual = actual.getSiguiente();
        }

        NodoDoble<T> nuevoNodo = new NodoDoble<>(dato);
        NodoDoble<T> siguiente = actual.getSiguiente();

        actual.setSiguiente(nuevoNodo);
        nuevoNodo.setAnterior(actual);

        nuevoNodo.setSiguiente(siguiente);
        siguiente.setAnterior(nuevoNodo);

        size++;
    }

    public T eliminarInicio() {
        if (estaVacia()) {
            throw new NoSuchElementException("Lista vacía");
        }

        T dato = primero.getDato();

        if (size == 1) {
            primero = ultimo = null;
        } else {
            primero = primero.getSiguiente();
            primero.setAnterior(null);
        }

        size--;
        return dato;
    }

    public T eliminarFinal() {
        if (estaVacia()) {
            throw new NoSuchElementException("Lista vacía");
        }

        T dato = ultimo.getDato();

        if (size == 1) {
            primero = ultimo = null;
        } else {
            ultimo = ultimo.getAnterior();
            ultimo.setSiguiente(null);
        }

        size--;
        return dato;
    }

    public T eliminarEn(int indice) {
        if (!indiceValido(indice)) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        if (indice == 0) {
            return eliminarInicio();
        }

        if (indice == size - 1) {
            return eliminarFinal();
        }

        NodoDoble<T> actual = primero;
        for (int i = 0; i < indice; i++) {
            actual = actual.getSiguiente();
        }

        T dato = actual.getDato();
        NodoDoble<T> anterior = actual.getAnterior();
        NodoDoble<T> siguiente = actual.getSiguiente();

        anterior.setSiguiente(siguiente);
        siguiente.setAnterior(anterior);

        size--;
        return dato;
    }

    public T obtener(int indice) {
        if (!indiceValido(indice)) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        NodoDoble<T> actual = primero;
        for (int i = 0; i < indice; i++) {
            actual = actual.getSiguiente();
        }

        return actual.getDato();
    }

    public NodoDoble<T> obtenerNodo(int indice) {
        if (!indiceValido(indice)) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        NodoDoble<T> actual = primero;
        for (int i = 0; i < indice; i++) {
            actual = actual.getSiguiente();
        }
        return actual;
    }

    public int obtenerPosicionNodo(T dato) {
        NodoDoble<T> actual = primero;
        int posicion = 0;

        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                return posicion;
            }
            actual = actual.getSiguiente();
            posicion++;
        }

        return -1; // No encontrado
    }

    public boolean indiceValido(int indice) {
        return indice >= 0 && indice < size;
    }

    private boolean indiceValidoParaAgregar(int indice) {
        // Para agregar, índice puede ser == size
        return indice >= 0 && indice <= size;
    }

    public void modificar(int indice, T nuevoDato) {
        if (!indiceValido(indice)) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        NodoDoble<T> actual = primero;
        for (int i = 0; i < indice; i++) {
            actual = actual.getSiguiente();
        }

        actual.setDato(nuevoDato);
    }

    public void borrarLista() {
        primero = null;
        ultimo = null;
        size = 0;
    }

    public void ordenarLista() {
        if (primero == null || primero.getSiguiente() == null) {
            return;
        }

        boolean cambiado;
        do {
            cambiado = false;
            NodoDoble<T> actual = primero;

            while (actual.getSiguiente() != null) {
                NodoDoble<T> siguiente = actual.getSiguiente();

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

    public void imprimir() {
        NodoDoble<T> actual = primero;
        System.out.print("null <-> ");
        while (actual != null) {
            System.out.print(actual.getDato() + " <-> ");
            actual = actual.getSiguiente();
        }
        System.out.println("null");
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private NodoDoble<T> actual = primero;

            @Override
            public boolean hasNext() {
                return actual != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T dato = actual.getDato();
                actual = actual.getSiguiente();
                return dato;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        NodoDoble<T> actual = primero;
        while (actual != null) {
            sb.append(actual.getDato());
            if (actual.getSiguiente() != null) {
                sb.append(", ");
            }
            actual = actual.getSiguiente();
        }
        sb.append("]");
        return sb.toString();
    }
}
