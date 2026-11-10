# Ejercicio 4 — Viajes Andinos

Programación 1 · Universidad Libre · Docente: Andrés Castaño

## Cómo ejecutarlo

```bash
javac -d out src/*.java
java -cp out Main
```

## Qué hace

Arma paquetes de viaje con destino y número de noches obligatorios, y con vuelo, hotel, desayuno, tour y seguro opcionales.

## Qué se resolvió

- **Antes:** `PaqueteViaje` tenía cuatro constructores sobrecargados y un setter por atributo. Era difícil saber cuál usar, y se podían crear paquetes incompletos o inválidos (sin destino o con 0 noches).
- **Ahora:** se aplicó **Builder**. Cada paquete se arma indicando solo lo que incluye (`conHotel(...)`, `conSeguro()`, ...). `PaqueteViaje` quedó **inmutable** (campos `final` y sin setters), y `build()` rechaza con una excepción los paquetes sin destino o con menos de 1 noche
