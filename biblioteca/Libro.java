package biblioteca;

public class Libro {
    private final String titulo;
    private final String autor;
    private final String isbn;
    private int copiasDisponibles;
    private double precioReposicion;

    public Libro(String titulo, String autor, String isbn, int copiasDisponibles, double precioReposicion) {
        if (titulo == null || titulo.isBlank()) {
            titulo = "Sin titulo";
            System.out.println("Titulo invalido, se uso \"Sin titulo\" por defecto.");
        }
        if (autor == null || autor.isBlank()) {
            autor = "Autor desconocido";
            System.out.println("Autor invalido, se uso \"Autor desconocido\" por defecto.");
        }
        if (isbn == null || isbn.isBlank()) {
            isbn = "ISBN pendiente";
            System.out.println("ISBN invalido, se uso \"ISBN pendiente\" por defecto.");
        }
        if (copiasDisponibles < 0) {
            copiasDisponibles = 0;
            System.out.println("Copias disponibles invalidas, se uso 0 por defecto.");
        }

        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.copiasDisponibles = copiasDisponibles;

        this.precioReposicion = 15000.0;
        if (!setPrecioReposicion(precioReposicion)) {
            System.out.println("Precio de reposicion invalido, se uso $15000.0 por defecto.");
        }
    }

    public Libro(String titulo, String autor, String isbn) {
        this(titulo, autor, isbn, 1, 15000.0);
    }

    public boolean prestar() {
        if (copiasDisponibles <= 0) {
            System.out.println("Error: no hay copias disponibles de \"" + titulo + "\" para prestar.");
            return false;
        }
        copiasDisponibles--;
        System.out.println("Prestamo registrado: \"" + titulo + "\". Copias disponibles: " + copiasDisponibles);
        return true;
    }

    public void devolver() {
        copiasDisponibles++;
        System.out.println("Devolucion registrada: \"" + titulo + "\". Copias disponibles: " + copiasDisponibles);
    }

    public boolean setPrecioReposicion(double precio) {
        if (precio <= 0) {
            return false;
        }
        double precioAnterior = this.precioReposicion;
        this.precioReposicion = precio;
        System.out.println("Precio de reposicion actualizado de \"" + titulo + "\": $" + precioAnterior + " -> $" + this.precioReposicion);
        return true;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getCopiasDisponibles() {
        return copiasDisponibles;
    }

    public double getPrecioReposicion() {
        return precioReposicion;
    }

    public void mostrarFicha() {
        System.out.println("=== Ficha de libro ===");
        System.out.println("Titulo:  " + titulo);
        System.out.println("Autor:   " + autor);
        System.out.println("ISBN:    " + isbn);
        System.out.println("Copias disponibles: " + copiasDisponibles);
        System.out.println("Precio de reposicion: $" + precioReposicion);
        System.out.println("=======================");
    }
}
