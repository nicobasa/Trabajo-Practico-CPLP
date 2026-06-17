# Grupo O - TP ANTLR

## Integrantes
- Nicolas Ariel Basalo - 46358143
- Candela Fernandez - 43405646

## Variante asignada
Variante 2: `for`, iteracion con variable de control.

## Descripcion del lenguaje
Lenguaje imperativo simple implementado con ANTLR4. Soporta:

- Variables tipadas: `int`, `real`, `string`, `bool`.
- Declaracion de variables con o sin inicializacion.
- Asignacion de valores.
- Expresiones aritmeticas, relacionales y logicas.
- Comentarios de linea `//` y comentarios multilínea `/* ... */`.
- Impresion por consola con `println`.
- Condicional `if-else`.
- Iteracion `for` con variable de control.

## Ejemplo

```smp
program miprograma {
    var x : int = 0;

    for (var i : int = 0; i < 5; i = i + 1) {
        x = x + i;
        println x;
    }
}
```

## Validaciones semanticas incluidas

- Uso de variables no declaradas.
- Redeclaracion de variables.
- Asignaciones incompatibles con el tipo declarado.
- Operaciones invalidas entre tipos no compatibles.
- Division por cero.
- Condiciones de `if` y `for` obligatoriamente booleanas.
