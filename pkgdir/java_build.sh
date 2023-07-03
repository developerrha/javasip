#!/bin/bash
# -*- ENCODING: UTF-8 -*-
echo "Compilando paquetes"
javac -cp mysql-connector-java-8.0.11.jar CargarClase.java graficos/GuiUser.java control/Controller.java modelo/*.java -d ./dist/
echo "Generando JAR"
cd dist/
jar -cmf META-INF/MANIFEST.MF java_clases.jar pkgdir/CargarClase.class pkgdir res/*.png
echo "Ejecutando aplicacion"
java -jar java_clases.jar
cd ..
exit
