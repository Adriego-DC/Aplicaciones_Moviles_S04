package com.example.quizziz

data class Pregunta(
    val texto: String,
    val respuestas: List<String>,
    val indiceCorrecto: Int
)

object BaseDeDatosQuizzes {
    val quizzes: Map<String, List<Pregunta>> = mapOf(
        "1111" to listOf(
            Pregunta("¿Qué lenguaje se usa principalmente en Android Studio?", listOf("Kotlin", "Swift", "JavaScript", "Python"), 0),
            Pregunta("¿Qué archivo contiene los permisos en una app Android?", listOf("AndroidManifest.xml", "MainActivity.kt", "build.gradle", "styles.xml"), 0),
            Pregunta("¿Qué método se ejecuta al iniciar una actividad?", listOf("onStart()", "onCreate()", "onResume()", "onPause()"), 1),
            Pregunta("¿Cuál es el archivo de diseño por defecto en una actividad?", listOf("activity_main.xml", "main.xml", "design.xml", "layout_main.xml"), 0),
            Pregunta("¿Qué componente se usa para listas de elementos?", listOf("RecyclerView", "TextView", "Button", "EditText"), 0),
            Pregunta("¿Cuál es el contenedor de vistas más flexible?", listOf("LinearLayout", "FrameLayout", "ConstraintLayout", "TableLayout"), 2),
            Pregunta("¿Cómo se llama el archivo de configuración de dependencias?", listOf("gradle.build", "build.gradle", "dependencies.xml", "config.gradle"), 1),
            Pregunta("¿Qué clase representa una pantalla en Android?", listOf("Fragment", "Layout", "Intent", "Activity"), 3),
            Pregunta("¿Qué se usa para navegar entre actividades?", listOf("Intent", "Fragment", "Bundle", "Service"), 0),
            Pregunta("¿Qué método cierra una actividad?", listOf("finish()", "end()", "close()", "exit()"), 0),
            Pregunta("¿Qué widget se usa para ingresar texto?", listOf("TextView", "Label", "EditText", "TextBox"), 2),
            Pregunta("¿Para qué sirve el archivo strings.xml?", listOf("Guardar estilos", "Guardar cadenas de texto", "Guardar layouts", "Guardar imágenes"), 1),
            Pregunta("¿Cómo se llama el emulador de Android Studio?", listOf("VirtualBox", "Genymotion", "AVD", "Simulator"), 2),
            Pregunta("¿Qué es un Fragment?", listOf("Una vista reutilizable", "Una actividad secundaria", "Una variable", "Una animación"), 0),
            Pregunta("¿Qué herramienta se usa para diseñar interfaces en Android Studio?", listOf("Code Editor", "Design Editor", "Visual Studio", "Layout Inspector"), 1)
        )
    )
}
