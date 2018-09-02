package mx.iteso.tarea1;

public class Alumno {
    private String nombre;
    private String telefono;
    private String escolaridad;
    private String genero;
    private String libroFavorito;
    private boolean isDeportivo;

    public Alumno(String nombre, String telefono, String escolaridad, String genero, String libroFavorito, boolean isDeportivo) {
        setAlumno(nombre, telefono, escolaridad, genero, libroFavorito, isDeportivo);
    }

    public void setAlumno(String nombre, String telefono, String escolaridad, String genero, String libroFavorito, boolean isDeportivo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.escolaridad = escolaridad;
        this.genero = genero;
        this.libroFavorito = libroFavorito;
        this.isDeportivo = isDeportivo;
    }

    @Override
    public String toString() {
        String val = String.format("Nombre: %s\nTelefono: %s\nEscolaridad: %s\nGenero: %s\n", nombre
        , telefono, escolaridad, genero);
        if (libroFavorito != null) {
            val += String.format("Libro Favorito: %s\n", libroFavorito);
        }

        val += String.format("Practica Deporte: %s", isDeportivo?"Si":"No");
        return val;
    }
}
