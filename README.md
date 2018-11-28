
# Diseño de sistemas - 2018
# Contexto general

Sistema de gestión energética - SGE
PROBLEMÁTICA
El verano es la época del año con la mayor demanda energética y, a su vez, con la mayor tasa de cortes de suministro eléctrico. Ante la crisis energética generada por esta situación, el Gobierno debe recurrir a grandes importaciones de suministro eléctrico provenientes de Uruguay y especialmente de Brasil.
El 24 de febrero de 2017 se produjo el máximo histórico de consumo en la Ciudad de Buenos Aires. La temperatura fue de 33°C y se registraron 79.144 hogares sin luz. Una manera de mitigar el problema de los cortes de suministro eléctrico es a través de la eficiencia energética, un concepto que no significa privaciones ni sacrificios. En realidad, la eficiencia energética implica el aprovechamiento consciente de la energía disponible, sin afectar la calidad de vida de las personas.
En el ámbito hogareño, el uso eficiente de la energía permite disminuir el monto de las facturas sin pérdida de bienestar; pero eso no es todo: también podría mitigar los eventuales cortes de suministro eléctrico. Basta con realizar pequeñas modificaciones en nuestros hábitos diarios y tener en cuenta que, a la hora de hacer una compra o arreglo en el hogar, se debe pensar en la eficiencia energética y ahorro. Según números oficiales1, un hogar promedio que no esté preparado para usar la electricidad de manera eficiente consume a razón de un 50 % de kWh mensual más que una casa de las mismas características, pero adaptada en forma eficiente. Suponiendo un consumo energético equitativo entre los hogares, obtenemos un consumo mensual de 1020,7 kWh por hogar.
Con el fin de mitigar los cortes suministro eléctrico, se propone una reducción de un 40% de ese consumo mensual, estableciendo entonces 612,42 kWh como el máximo valor recomendable de consumo mensual para un hogar de C.A.B.A. durante los meses de verano.
1 http://www.telam.com.ar/notas/201702/180732-demanda-electricidad-record-historico-ola-calor-luz.html


SOLUCIÓN PROPUESTA
SGE será un sistema inspirado en la gestión energética de los clientes residenciales e industriales. El objetivo que busca este sistema para los clientes residenciales es que logren convertir su hogar en un “hogar eficiente”.
Cada cliente pertenece a una categoría específica según el consumo que éste genere de forma trimestral. A continuación se muestra, a modo informativo, una tabla con los tipos de categorías existentes a nivel general y el porcentaje de participación que tiene cada una de estas respecto del total del consumo:
Cada tres meses se deberá realizar una recategorización de clientes teniendo en cuenta el consumo, cuyo factor estará dado por los dispositivos (artefactos) que éstos disponen.
Existen dos tipos de dispositivos:
● Inteligente: cuentan con la posibilidad de conectarse a nuestro sistema e informar su consumo de forma instantánea. Además tienen la capacidad de guardar un log con los registros de consumo pertenecientes al último mes corriente.
● Estándar: son simples. No tienen la posibilidad de conectarse a nuestro sistema ni saber cuánta energía están consumiendo. El consumo por hora que generan éstos deberán ser ingresados por un administrador general del sistema, utilizando fuentes reales.
Si a los dispositivos estándar se les agrega un módulo que se conecta en paralelo con la red de 220V, tendrán la misma capacidad que un dispositivo inteligente. Para poder utilizar este módulo de igual forma que un dispositivo inteligente, el mismo deberá ser registrado en SGE, estableciendo cuál es el dispositivo estándar que está controlando.
Cada usuario que registre un nuevo dispositivo (ya sea inteligente o a través del módulo) sumará puntos, los cuales podrán ser canjeados en la empresa proveedora de energía eléctrica por distintas cosas (como por ejemplo rebajas en la factura).
La intención de saber los dispositivos con los que cuenta un usuario es para poder determinar la mejor combinación de uso de ellos para ahorrar energía y lograr tener un hogar eficiente.
Trabajo práctico anual 2018
Por otra parte, el sistema deberá mostrar en un mapa interactivo el consumo por zona geográfica. Cada zona geográfica agrupará a uno o más transformadores. El consumo total de una de estas zonas estará determinado por la sumatoria del consumo de cada uno de los transformadores que encierre. El ENRE nos enviará mensualmente un listado con los transformadores activos y a qué zona pertenece cada uno de éstos.
Los usuarios estarán conectados a un transformador en particular, dependiendo su posición geográfica.

# Tecnologías

● Java + Spark java
● Hmtl + Css 
● Javascript
● Handlebars.js
● Mysql
● Hibernate
● Junit
● Mockito



