public class Main {
    public static void main(String[] args) {
        System.out.println("=== Viajes Andinos: paquetes vendidos ===");

        PaqueteViaje p1 = new PaqueteViaje.Builder()
                .destino("Cartagena").noches(4)
                .conVuelo()
                .conHotel("Decameron")
                .conDesayuno()
                .conTour("Islas del Rosario")
                .build();

        // Solo hotel + seguro: ahora se arma indicando unicamente lo que incluye
        PaqueteViaje p2 = new PaqueteViaje.Builder()
                .destino("Villa de Leyva").noches(2)
                .conHotel("Posada del Sol")
                .conSeguro()
                .build();

        System.out.println(p1);
        System.out.println(p2);

        // El asesor se olvido el destino -> se rechaza al construir
        try {
            PaqueteViaje p3 = new PaqueteViaje.Builder()
                    .noches(3)
                    .conTour("Cafe en Salento")
                    .build();
            System.out.println(p3);
        } catch (IllegalArgumentException e) {
            System.out.println("Paquete 3 RECHAZADO: " + e.getMessage());
        }

        // Otro asesor digito 0 noches -> se rechaza al construir
        try {
            PaqueteViaje p4 = new PaqueteViaje.Builder()
                    .destino("San Andres").noches(0)
                    .build();
            System.out.println(p4);
        } catch (IllegalArgumentException e) {
            System.out.println("Paquete 4 RECHAZADO: " + e.getMessage());
        }

        System.out.println();
        System.out.println("ESPERADO -> p1 y p2 se construyen leyendo claramente que incluyen,");
        System.out.println("            p3 y p4 se RECHAZAN al construirse (sin destino / 0 noches)");
    }
}
