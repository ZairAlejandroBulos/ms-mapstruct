# MapStruct

[MapStruct](https://mapstruct.org/) es una biblioteca de generación de código para mapeo de objetos en Java. Permite generar automáticamente implementaciones de mappers (mapeadores) basados en interfaces definidas por el usuario. Estos mappers se utilizan para convertir objetos de un tipo a otro de manera eficiente y sin errores.

## Dependencies

### Gradle

```build.gradle
dependencies {
    ...
    implementation 'org.mapstruct:mapstruct:1.5.5.Final'

    annotationProcessor 'org.mapstruct:mapstruct-processor:1.5.5.Final'
}
```

### Maven

```pom.xml
...
<properties>
    <org.mapstruct.version>1.5.5.Final</org.mapstruct.version>
</properties>
...
<dependencies>
    <dependency>
        <groupId>org.mapstruct</groupId>
        <artifactId>mapstruct</artifactId>
        <version>${org.mapstruct.version}</version>
    </dependency>
</dependencies>
...
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.8.1</version>
            <configuration>
                <source>1.8</source>
                <target>1.8</target>
                <annotationProcessorPaths>
                    <path>
                        <groupId>org.mapstruct</groupId>
                        <artifactId>mapstruct-processor</artifactId>
                        <version>${org.mapstruct.version}</version>
                    </path>
                </annotationProcessorPaths>
            </configuration>
        </plugin>
    </plugins>
</build>
...
```

## Documentación

📕 [Reference Guide](https://mapstruct.org/documentation/stable/reference/html/) <br/>
:octocat: [GitHub](https://github.com/mapstruct/mapstruct)

## Configuración IntelliJ IDEA

1. Abre la configuración del proyecto en IntelliJ IDEA.
2. Navega hasta `"Build, Execution, Deployment"` (Compilación, ejecución, implementación) y selecciona `"Compiler"` (Compilador).
3. En la pestaña `"Annotation Processors"` (Procesadores de anotaciones), marca la casilla `"Enable annotation processing"` (Habilitar procesamiento de anotaciones).
4. Haz clic en "OK" para guardar la configuración.

Con esta configuración, IntelliJ IDEA utilizará el procesador de anotaciones de MapStruct durante la compilación para generar automáticamente las implementaciones de los mappers.

### Plugin

Para IntelliJ, existe el complemento [MapStruct IntelliJ](https://plugins.jetbrains.com/plugin/10036-mapstruct-support) que ofrece asistencia en proyectos que utilizan MapStruct. Algunas características de este complemento incluyen:

- Completado de código en el destino, origen y expresiones.
- Ir a la declaración de propiedades en el destino y origen.
- Buscar usos de propiedades en el destino y origen.
- Soporte para refactorización.
- Errores y correcciones rápidas.
